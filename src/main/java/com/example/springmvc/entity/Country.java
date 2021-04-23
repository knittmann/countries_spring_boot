package com.example.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@NotBlank
	@Size(min = 4, max = 60)
	String name;
	
	@Digits(integer = 10, fraction = 0)
	@Positive
	int population;
	
	@NotBlank
	@Size(min = 3, max = 60)
	String capitol;
	
	public Country() {
		
	}
	
	public Country(String countryName, int population, String capitol) {
		this.name = countryName;
		this.population = population;
		this.capitol = capitol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String countryName) {
		this.name = countryName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCapitol() {
		return capitol;
	}

	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", population=" + population + ", capitol=" + capitol + "]";
	}
	
	

}
