package com.jacaranda.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.prueba.model.Element;
import com.jacaranda.prueba.service.ElementService;

@RestController
public class ElementController {
	
	@Autowired
	ElementService service;
	
	@GetMapping("/element")
	public List<Element> findAll(){
		return service.getElements();
	}
	
	@GetMapping("/element/{id}")
	public Element findById(@PathVariable Integer id){
		return service.getElement(id);
	}
	
	@PostMapping("/element")
	public ResponseEntity<?> add(@RequestBody Element element){
		Element elemento = service.save(element);
		return ResponseEntity.status(HttpStatus.CREATED).body(elemento);
		
	}
	
	@PutMapping("/element/{id}")
	public Element edit(@RequestBody Element element, @PathVariable Integer id){
		if(service.getElement(id)!=null) {
			element.setId(id);
			return service.save(element);
		}
		else {
			return null;
		}
		
	}
	
	@DeleteMapping("/element/{id}")
	public Element del(@PathVariable Integer id) {
		if (service.getElement(id) != null) {
			Element elemento = service.getElement(id);
			service.delete(elemento);
			return elemento;
		} else {
			return null;
		}
	}
}
