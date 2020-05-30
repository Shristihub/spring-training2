package com.bookapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@GetMapping("/greet")
	public String sayHello(Model model) {
		// service
		model.addAttribute("message","Welcome to MVC");
		return "hello";
	}
	@GetMapping("/hi")
	public String sayHi(ModelMap model) {
		// service
		model.addAttribute("message","Using Model map");
		return "hello";
	}
	
	@GetMapping("/welcome")
	public ModelAndView sayWelcome() {
		ModelAndView modelView = new ModelAndView("hello", "message","Using Model and View" );
		return modelView;
		
	}
}








