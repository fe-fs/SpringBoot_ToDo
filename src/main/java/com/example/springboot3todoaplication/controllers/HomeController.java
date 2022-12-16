package com.example.springboot3todoaplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot3todoaplication.services.TodoItemServices;

@Controller
public class HomeController {
	
	@Autowired
	private TodoItemServices todoItemServices;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("todoItems", todoItemServices.getAll());
		return modelAndView;
		
	}
	
}
