package com.teste.cursommc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.cursommc.domain.Categoria;
import com.teste.cursommc.domain.Cidade;
import com.teste.cursommc.domain.Cliente;
import com.teste.cursommc.domain.Endereco;
import com.teste.cursommc.domain.Estado;
import com.teste.cursommc.domain.Produto;
import com.teste.cursommc.domain.enums.TipoCliente;
import com.teste.cursommc.repositories.CategoriaRepository;
import com.teste.cursommc.repositories.CidadeRepository;
import com.teste.cursommc.repositories.ClienteRepository;
import com.teste.cursommc.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
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
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","41672214890", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Jhonata Lacerda", "jhonata.5000@gmailc.om", "4338882328", TipoCliente.PESSOAJURIDICA);
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, cid2);
		Endereco e2 = new Endereco(null, "Rua Leia Maria Ximendes da Silva", "333", "casa", "Padroeira", "06162340", cli2, cid1);
		Endereco e3 = new Endereco(null, "Rua Amores", "200", "casa", "fevereiro", "08932450", cli2, cid3);
		cli1.setEnderecos(Arrays.asList(e1));
		cli2.setEnderecos(Arrays.asList(e2,e3));
		cli1.getTelefones().addAll(Arrays.asList("98432448","92343992"));
		cli2.getTelefones().addAll(Arrays.asList("964488532","978324885"));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3,cid4));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		
	}
}
