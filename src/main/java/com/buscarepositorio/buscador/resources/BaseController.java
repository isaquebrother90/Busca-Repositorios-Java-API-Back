package com.buscarepositorio.buscador.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.buscarepositorio.buscador.entities.RepositorioEntity;
import com.buscarepositorio.buscador.services.RepositoriosResponseApi;

public abstract class BaseController extends BaseService {

	@Autowired
	private BaseService service;

	private RestTemplate template = new RestTemplate();

	private String baseUrl = "https://api.github.com/search/repositories?q=language:java&sort=stars&page=1";

	@GetMapping
	public ResponseEntity<?> getRepositorios() {
		RepositoriosResponseApi response = template.getForEntity(baseUrl, RepositoriosResponseApi.class).getBody();
		return new ResponseEntity<>(service.salvarRepositorios(response), HttpStatus.OK);

	}

	@GetMapping("/pageable") // Listar todas entidades com paginação
	ResponseEntity<Page<RepositorioEntity>> index(RepositorioEntity filter, @PageableDefault Pageable pageable) {
		Page<RepositorioEntity> entities = service.getAllPageable(filter, pageable);
		return ResponseEntity.ok(entities);
	}

}
