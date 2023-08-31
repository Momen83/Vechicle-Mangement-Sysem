package com.kidsonthegenius.fleetapp.controllers;

import java.util.Optional;

import com.kidsonthegenius.fleetapp.models.Country;
import com.kidsonthegenius.fleetapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CountryController {
	
	@Autowired private CountryService countryService;
	
	//Get All Countrys
	@GetMapping("countries")
	public String findAll(Model model){		
		model.addAttribute("countries", countryService.findAll());
		return "country";
	}	
	
	@RequestMapping("countries/findById") 
	@ResponseBody
	public Optional<Country> findById(Integer id)
	{
		return countryService.findById(id);
	}
	
	//Add Country
	@PostMapping(value="countries/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}	
	
	@RequestMapping(value="countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}

	@RequestMapping(value = "countries/showAddForm")
	public String showFormForAdd(Model theModel){
		// create model attribute to bind form data
		Country theCountry  = new Country();
		theModel.addAttribute("country",theCountry);

		return "country-form";
	}
	@PostMapping("/save/country")
	public String saveEmployee(@ModelAttribute("country") Country theCountry){
		countryService.save(theCountry);
		// use redirect to prevent duplicate submission
		return "redirect:/countries";
	}
	@GetMapping("/country/showFormForUpdate")
	public String showFormForAdd(@RequestParam("countryId") int theId, Model theModel){

		Optional<Country> theCountry = countryService.findById(theId);
		// set employee in the model to prepopulate the form
		theModel.addAttribute("country",theCountry);
		// send over our form
		return "country-form";
	}
	@GetMapping("/country/delete")
	public String deleteCountry(@RequestParam("countryId") int theId, Model theModel){

		countryService.delete(theId);
		// send over our form
		return "redirect:/countries";
	}
}
