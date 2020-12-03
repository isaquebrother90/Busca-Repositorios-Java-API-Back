package com.buscarepositorio.buscador.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.buscarepositorio.buscador.entities.RepositorioEntity;

@Repository
public abstract interface BaseRepository extends JpaRepository<RepositorioEntity, Integer>{
	
}