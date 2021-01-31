package com.buscarepositorio.buscador.Builders;

import com.buscarepositorio.buscador.entities.RepositorioEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Builder;

@Builder
public class RepositorioEntityBuilder {
	
	@Builder.Default
	private String id = "1";

	@Builder.Default
	private String image;// ???????

	@Builder.Default
	private String name = "Jorge";

	@Builder.Default
	private int stars = 2345;

	@Builder.Default
	private int forks = 456;
	
	
	
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



	public RepositorioEntity toRepositorioEntity() {
		return new RepositorioEntity(id,
				image,
				name,
				stars,
				forks);
				
	}

}
