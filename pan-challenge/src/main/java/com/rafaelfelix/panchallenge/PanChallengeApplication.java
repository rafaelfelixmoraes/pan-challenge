package com.rafaelfelix.panchallenge;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelfelix.panchallenge.domains.Cidade;
import com.rafaelfelix.panchallenge.domains.Cliente;
import com.rafaelfelix.panchallenge.domains.Endereco;
import com.rafaelfelix.panchallenge.domains.Estado;
import com.rafaelfelix.panchallenge.repositories.CidadeRepository;
import com.rafaelfelix.panchallenge.repositories.ClienteRepository;
import com.rafaelfelix.panchallenge.repositories.EnderecoRepository;
import com.rafaelfelix.panchallenge.repositories.EstadoRepository;

@SpringBootApplication
public class PanChallengeApplication implements CommandLineRunner{
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PanChallengeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "24721673000");
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Cliente cli2 = new Cliente(null, "José João da Silva", "josesilva@gmail.com", "11031614079");
		cli2.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38230834", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli2, cid2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		cli1.getEnderecos().addAll(Arrays.asList(end1));
		cli2.getEnderecos().addAll(Arrays.asList(end2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
	}

}
