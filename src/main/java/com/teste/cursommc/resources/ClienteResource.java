package com.teste.cursommc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cursommc.domain.Cliente;
import com.teste.cursommc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id){
		Cliente cliente =  clienteService.buscar(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@RequestMapping
	public ResponseEntity<List<Cliente>> todos(){
		List<Cliente> clientes = clienteService.todos();
		return ResponseEntity.ok().body(clientes);
	}
}
