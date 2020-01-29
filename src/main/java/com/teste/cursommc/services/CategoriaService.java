package com.teste.cursommc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cursommc.domain.Categoria;
import com.teste.cursommc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria;
	}
}
