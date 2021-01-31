package com.buscarepositorio.buscador.services;

import java.util.List;

import com.buscarepositorio.buscador.entities.Repositorios;

public class RepositoriosResponseApi {

	private List<Repositorios> items; // RECEBE UMA LISTA DE ITENS COMO REPOSTA DA API

	public List<Repositorios> getItems() {
		return items;
	}

	public void setItems(List<Repositorios> items) {
		this.items = items;
	}

}
