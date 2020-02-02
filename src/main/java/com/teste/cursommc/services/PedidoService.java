package com.teste.cursommc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cursommc.domain.Pedido;
import com.teste.cursommc.repositories.PedidoRepository;
import com.teste.cursommc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	
	@Autowired
	private PedidoRepository clienteRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> categoria = clienteRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado! id"+id+", Tipo"+ Pedido.class.getName()));
	}
	
	public List<Pedido> todos(){
		List<Pedido> pedidos = clienteRepository.findAll();
		return pedidos;
	}
}
