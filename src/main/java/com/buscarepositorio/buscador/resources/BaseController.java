package com.buscarepositorio.buscador.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.buscarepositorio.buscador.entities.RepositorioEntity;
import com.buscarepositorio.buscador.services.RepositoriosResponseApi;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public abstract class BaseController extends BaseService {

	@Autowired
	private BaseService service;

	private RestTemplate template = new RestTemplate();

	private String baseUrl = "https://api.github.com/search/repositories?q=language:java&sort=stars&page=1";

	@ApiOperation(value = "Retorna uma lista de repositórios sem paginação")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de repositórios sem paginação"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping
	public ResponseEntity<?> getRepositorios() {
		RepositoriosResponseApi response = template.getForEntity(baseUrl, RepositoriosResponseApi.class).getBody();
		return new ResponseEntity<>(service.salvarRepositorios(response), HttpStatus.OK);

	}

	@ApiOperation(value = "Retorna uma lista de repositórios com paginação")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de repositórios com paginação"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping("/pageable")
	ResponseEntity<Page<RepositorioEntity>> index(RepositorioEntity filter, @PageableDefault Pageable pageable) {
		Page<RepositorioEntity> entities = service.getAllPageable(filter, pageable);
		return ResponseEntity.ok(entities);
	}

}
