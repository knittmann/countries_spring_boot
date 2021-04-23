package com.example.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmvc.entity.Country;
import com.example.springmvc.repo.CountryRepo;

@Service
public class CountryService {
	
	@Autowired
	CountryRepo repo;
	
	public List<Country> getAllCountries() {
		return repo.findAll();
	}
	
	public Country getCountryById(Long id) {
		return repo.findById(id).get();
	}
	
	public void addNewCountry(Country country) {
//		Country c = repo.getOne(country.getId());
//		c.setId(country.getId());
//		c.setName(country.getName());
//		c.setCapitol(country.getCapitol());
//		c.setPopulation(country.getPopulation());
		repo.save(country);
	}
	
	public void deleteCountryById(Long id) {
		repo.deleteById(id);
	}
	
	public void updateCountryPopulation(Country country) {
		Country c = repo.getOne(country.getId());
		c.setPopulation(country.getPopulation());
		repo.save(country);
	}
}
