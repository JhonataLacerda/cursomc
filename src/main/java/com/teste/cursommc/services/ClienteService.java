package com.teste.cursommc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cursommc.domain.Cliente;
import com.teste.cursommc.repositories.ClienteRepository;
import com.teste.cursommc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository categoriaRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado! id"+id+", Tipo"+ Cliente.class.getName()));
	}
}
