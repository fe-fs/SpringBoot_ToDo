package com.example.springboot3todoaplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot3todoaplication.models.TodoItem;
import com.example.springboot3todoaplication.services.TodoItemServices;

import jakarta.validation.Valid;

@Controller
public class TodoFormController {

	@Autowired
	private TodoItemServices todoItemServices;
	
	@GetMapping("/create-todo")
	public String showCreateForm(TodoItem todoItem) {
		return "new-todo-item";
	}
	
	@PostMapping("/todo")
	public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
		TodoItem item = new TodoItem();
		item.setDescription(todoItem.getDescription());
		item.setIsComplete(todoItem.getIsComplete());
		
		todoItemServices.save(todoItem);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
		TodoItem todoItem = todoItemServices
				.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + "not found"));
	
		todoItemServices.delete(todoItem);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdadeForm(@PathVariable("id") Long id, Model model) {
		TodoItem todoItem = todoItemServices
				.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + "not found"));
	
		model.addAttribute("todo", todoItem);
		return "edit-todo-item";
	}
	
	@PostMapping("/todo/{id}")
	public String updadeTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
		TodoItem item = todoItemServices
				.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + "not found"));
	
		item.setDescription(todoItem.getDescription());
		item.setIsComplete(todoItem.getIsComplete());
		
		todoItemServices.save(item);
		return "redirect:/";
		
	}
	
	
	
}
