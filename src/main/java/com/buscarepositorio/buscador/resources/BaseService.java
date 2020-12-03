package com.buscarepositorio.buscador.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.buscarepositorio.buscador.entities.RepositorioEntity;
import com.buscarepositorio.buscador.repositories.RepositoriosRepository;
import com.buscarepositorio.buscador.services.RepositoriosResponseApi;

@Service
public abstract class BaseService {

	@Autowired
	private RepositoriosRepository repository;

	public Page<RepositorioEntity> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public RepositorioEntity salvar(RepositorioEntity entity) {
		return repository.save(entity);
	}

	public List<RepositorioEntity> salvarRepositorios(RepositoriosResponseApi res) {

		List<RepositorioEntity> lista = new ArrayList<>();
		res.getItems().forEach(item -> {
			RepositorioEntity repositorio = new RepositorioEntity();
			repositorio.setForks(item.getForks_count());
			repositorio.setImage(item.getOwner().getAvatar_url());
			repositorio.setStars(item.getStargazers_count());
			repositorio.setName(item.getName());
			repositorio.setId(item.getId());
			lista.add(repository.save(repositorio));

		});
		return lista;

	}

	public Page<RepositorioEntity> getAllPageable(RepositorioEntity filter, Pageable pageable) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<RepositorioEntity> example = Example.of(filter, matcher);
		return repository.findAll(pageable);
	}

	public List<RepositorioEntity> getAll() {
		return repository.findAll();
	}

}
