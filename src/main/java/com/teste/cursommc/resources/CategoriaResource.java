package com.teste.cursommc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cursommc.domain.Categoria;
import com.teste.cursommc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria categoria = categoriaService.buscar(id);
		return  ResponseEntity.ok().body(categoria);
	}
	
	@RequestMapping
	public ResponseEntity<List<Categoria>> todos(){
		List<Categoria> categorias = categoriaService.todos();
		return ResponseEntity.ok().body(categorias);
	}
	
}
