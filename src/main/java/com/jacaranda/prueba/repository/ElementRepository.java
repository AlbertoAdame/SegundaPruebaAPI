package com.jacaranda.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.prueba.model.Element;

public interface ElementRepository extends JpaRepository<Element, Integer> {

}
