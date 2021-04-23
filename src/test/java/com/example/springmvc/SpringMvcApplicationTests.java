package com.example.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springmvc.entity.Country;
import com.example.springmvc.service.CountryService;

@SpringBootTest
class SpringMvcApplicationTests {

	@Autowired
	CountryService service;
	
	@Test
	void testGetAllCountries() {
		System.out.println("=== TEST getAllCountries SERVICE ===");
		List<Country> list = service.getAllCountries();
		System.out.println(list);
	}
	
//	@Test
//	void testCountryDefaultConstructor() {
//		System.out.println("=== TEST Country Default Constructor ===");
//		Country country = new Country();
//		service.addNewCountry(country);
//		System.out.println(service.getCountryById(country.getId()));
//	}

}
