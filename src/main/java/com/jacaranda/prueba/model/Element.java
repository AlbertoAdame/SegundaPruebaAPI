package com.jacaranda.prueba.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Element {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private double age;
	private int stock;
	

	public Element(long id, String name, String description, double age, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.age = age;
		this.stock = stock;
	}



	public Element() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getAge() {
		return age;
	}



	public void setAge(double age) {
		this.age = age;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Element [id=" + id + ", name=" + name + ", description=" + description + ", age=" + age + ", stock="
				+ stock + "]";
	}



}
