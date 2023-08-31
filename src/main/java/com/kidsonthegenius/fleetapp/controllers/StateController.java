package com.kidsonthegenius.fleetapp.controllers;

import java.util.Optional;

import com.kidsonthegenius.fleetapp.models.Country;
import com.kidsonthegenius.fleetapp.models.State;
import com.kidsonthegenius.fleetapp.services.CountryService;
import com.kidsonthegenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;

	//Get All States
	@GetMapping("states")
	public String findAll(Model model) {
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "state";
	}

	@RequestMapping(value = "/states/showAddForm")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		State theState = new State();
		theModel.addAttribute("state", theState);
		theModel.addAttribute("country", countryService.findAll());
		return "state-form";
	}

	@PostMapping("/save/state")
	public String saveEmployee(@ModelAttribute("state") State theState) {
		stateService.save(theState);
		// use redirect to prevent duplicate submission
		return "redirect:/states";
	}

	@GetMapping("/state/showFormForUpdate")
	public String showFormForAdd(@RequestParam("stateId") int theId, Model theModel) {

		Optional<State> theState = stateService.findById(theId);
		// set employee in the model to prepopulate the form
		theModel.addAttribute("state", theState);
		// send over our form
		return "state-form";
	}

	@GetMapping("/state/delete")
	public String deleteCountry(@RequestParam("stateId") int theId, Model theModel) {

		stateService.delete(theId);
		// send over our form
		return "redirect:/states";
	}
}
