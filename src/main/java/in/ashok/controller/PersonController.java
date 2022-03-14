package in.ashok.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashok.binding.Person;

@Controller
public class PersonController {
    
	@GetMapping("/person")
	public String loadPerson(Model model) {
		Person personObj = new Person();
		model.addAttribute("person", personObj);
		return "index";
	}
	
	@PostMapping("/savePerson")
	public String savePerson(@Valid Person person,BindingResult result, Model model) {
		System.out.println(person);
		if(result.hasErrors()) {
			return "index";
		}
		model.addAttribute("msg", person.getName()+",	Registered successfully!!");
		return "data";
	}
}
