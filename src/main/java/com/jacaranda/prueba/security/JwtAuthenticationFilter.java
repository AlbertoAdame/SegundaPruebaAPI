package com.jacaranda.prueba.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacaranda.prueba.model.Users;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
// Creamos un objeto para almacenar las credenciales del usuario que está en el token
		LoginCredential loginCredential = new LoginCredential();
		try {
// Mapeamos el json a la clase loginCredential
			loginCredential = new ObjectMapper().readValue(request.getReader(), LoginCredential.class);
			UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
					loginCredential.getUsername(), loginCredential.getPassword(), Collections.emptyList());
			return getAuthenticationManager().authenticate(usernamePat);
		} catch (Exception e) {
		} 
		UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
				loginCredential.getUsername(),
				loginCredential.getPassword(),
				Collections.emptyList());
				return getAuthenticationManager().authenticate(usernamePat);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		Users user = (Users) authResult.getPrincipal();
		String token = JwtUtils.generateToken(user.getUsername(), user.getEmail(), user.getRole());
		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();
		super.successfulAuthentication(request, response, chain, authResult);
	}
}
