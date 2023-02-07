package com.jacaranda.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.prueba.model.Element;
import com.jacaranda.prueba.repository.ElementRepository;

@Service
public class ElementService {
	
	@Autowired
	ElementRepository repository;
	
	public List<Element> getElements(){
		return repository.findAll();
	}
	
	public Element getElement(Integer id){
		return repository.findById(id).orElse(null);
	}
	
	public Element save(Element e){
		return repository.save(e);
	}
	
	public Element delete(Element e){
			repository.delete(e);
		return e;
	}

}
