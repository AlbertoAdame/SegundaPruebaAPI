package com.jacaranda.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.prueba.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {
	List<Users> findByEmail(String email);
}
