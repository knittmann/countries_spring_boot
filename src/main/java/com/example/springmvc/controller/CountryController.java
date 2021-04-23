package com.example.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.entity.Country;
import com.example.springmvc.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService service;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Country> list = service.getAllCountries();
		model.addAttribute("countries", list);
		return "index";
	}
	
	@RequestMapping("/details/{id}")
	public ModelAndView getCountry(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("countrydetails");
		Country country = service.getCountryById(id);
		modelAndView.addObject("country", country);
		return modelAndView;
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView editCountryPopulation(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("editcountry");
		Country country = service.getCountryById(id);
		modelAndView.addObject("country", country);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCountry(@ModelAttribute("country") Country country) {
		service.updateCountryPopulation(country);
		return "redirect:/";
	}
	
	@GetMapping("/addcountry")
	public String addNewCountry(Model model) {
		Country country = new Country();
		model.addAttribute("newcountry", country);
		return "addcountry";
	}
	
	@PostMapping("/add")
	public String addCountry(@Valid @ModelAttribute("newcountry") Country country, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute(country);
			return "addcountry";
		} else {
			service.addNewCountry(country);
			return "redirect:/";
		}
	}
}
