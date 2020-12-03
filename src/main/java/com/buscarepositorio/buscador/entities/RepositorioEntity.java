package com.buscarepositorio.buscador.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.buscarepositorio.buscador.resources.BaseEntity;

//ENTIDADE DO BANCO DE DADOS

@Entity
@Table(name = "repositorios")
public class RepositorioEntity extends BaseEntity {

	private String id;
	private String image;
	private String name;
	private int stars;
	private int forks;

	public RepositorioEntity(String id, String image, String name, int stars, int forks) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.stars = stars;
		this.forks = forks;
	}

	public RepositorioEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getForks() {
		return forks;
	}

	public void setForks(int forks) {
		this.forks = forks;
	}

}
