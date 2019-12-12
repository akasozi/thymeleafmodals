package io.motionlab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import io.motionlab.model.Nationality;
import io.motionlab.service.NationalityService;

@Controller
public class HomeController {
	
	@Autowired
	private NationalityService nationalityService;

	@GetMapping("/nationalities")
	public String getAllNationalities(Model model) {
		model.addAttribute("nationalities", nationalityService.getAllNationalities());
		return "nationalities";
	}
	
	
	@GetMapping("/onenationality")
	public String showAddForm(Nationality nationality) {
		return "add-onenationality";
	}
	
	@PostMapping("/onenationality")
	public String save(Nationality nationality) {

		nationalityService.addNationality(nationality);
		//model.addAttribute("nationalities", nationalityService.getAllNationalities());
		return "redirect:/nationalities";
	}
	
	@GetMapping("/onenationality/{id}")
	@ResponseBody
	public Nationality getOneNationality(@PathVariable("id") int id,  Model model) {
		return nationalityService.getNationality(id);
	}
	
	@PostMapping("/save")
	public String saveNationality(Nationality nationality) {
		nationalityService.updateNationality(nationality);
		return "redirect:/nationalities";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteNationality(@PathVariable("id") int id, Model model) {
		
		Nationality nationality = nationalityService.getNationality(id);
		
		nationalityService.deleteNationality(id);
		model.addAttribute("nationalities", nationalityService.getAllNationalities());
		return "redirect:/nationalities";
	}
}
