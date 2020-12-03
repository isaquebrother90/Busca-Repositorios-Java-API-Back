package com.buscarepositorio.buscador.entities;

//ENTIDADE QUE RECEBE A RESPOSTA DA API ANTES DE PERSISTIR NO BANCO

public class Repositorios {

	private String id;
	private String name;
	private int forks_count;
	private int stargazers_count;
	private RepositoriosOwner repositoriosOwner;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getForks_count() {
		return forks_count;
	}

	public void setForks_count(int forks_count) {
		this.forks_count = forks_count;
	}

	public int getStargazers_count() {
		return stargazers_count;
	}

	public void setStargazers_count(int stargazers_count) {
		this.stargazers_count = stargazers_count;
	}

	public RepositoriosOwner getOwner() {
		return repositoriosOwner;
	}

	public void setOwner(RepositoriosOwner repositoriosOwner) {
		this.repositoriosOwner = repositoriosOwner;
	}

}
