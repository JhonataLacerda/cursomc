package com.teste.cursommc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.teste.cursommc.domain.Categoria;
import com.teste.cursommc.repositories.CategoriaRepository;
import com.teste.cursommc.services.exceptions.DataIntegrityException;
import com.teste.cursommc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado! id"+id+", Tipo"+ Categoria.class.getName()));
	}
	
	public List<Categoria> todos(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	public Categoria update(Categoria obj) {
		buscar(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
		categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categória que possui produtos");
		}
	}
}
