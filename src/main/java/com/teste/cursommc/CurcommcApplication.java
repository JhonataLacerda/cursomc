package com.teste.cursommc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.cursommc.domain.Categoria;
import com.teste.cursommc.domain.Cidade;
import com.teste.cursommc.domain.Estado;
import com.teste.cursommc.domain.Produto;
import com.teste.cursommc.repositories.CategoriaRepository;
import com.teste.cursommc.repositories.CidadeRepository;
import com.teste.cursommc.repositories.EstadoRepository;
import com.teste.cursommc.repositories.ProdutoRepository;

@SpringBootApplication
public class CurcommcApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CurcommcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Ferramentas");
		Produto p1 = new Produto(null,"Mouse",30.90);
		Produto p2 = new Produto(null,"Impressora", 100.00);
		Produto p3 = new Produto(null,"Computador",900.00);
		cat1.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1,cat2));
		p3.setCategorias(Arrays.asList(cat1));
		Estado est1 = new Estado(null,"São Paulo");
		Estado est2 = new Estado(null,"Minas Gerais");
		Estado est3 = new Estado(null,"Bahia");
		Cidade cid1 = new Cidade(null,"São Paulo",est1);
		Cidade cid2 = new Cidade(null,"Belo horizonte",est2);
		Cidade cid3 = new Cidade(null,"Salvador",est3);
		Cidade cid4 = new Cidade(null,"Campinas",est1);
		est1.setCidades(Arrays.asList(cid1,cid4));
		est2.setCidades(Arrays.asList(cid2));
		est3.setCidades(Arrays.asList(cid3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3,cid4));
		
		
	}
}
