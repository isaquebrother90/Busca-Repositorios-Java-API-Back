package com.buscarepositorio.buscador.repositories;

import org.springframework.stereotype.Repository;

import com.buscarepositorio.buscador.resources.BaseRepository;

//@Repository
//public interface RepositoriosRepository extends JpaRepository<RepositorioEntity, Integer> { // RESPONSÁVEL PELO CRUD NA
																							// TABELA NO BANCO DE DADOS,
																							// RECEBE DE BASESERVICE E
@Repository																							// EXECUTA
public interface RepositoriosRepository extends BaseRepository {
	

}
