package com.rafaelfelix.panchallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelfelix.panchallenge.domains.Cidade;
import com.rafaelfelix.panchallenge.domains.Cliente;
import com.rafaelfelix.panchallenge.domains.Endereco;
import com.rafaelfelix.panchallenge.dto.DadosClienteDTO;
import com.rafaelfelix.panchallenge.repositories.ClienteRepository;
import com.rafaelfelix.panchallenge.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente findByCpf(String cpf) {
		Optional<Cliente> obj = repo.findByCpf(cpf);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Cpf: " + cpf + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional(readOnly = true)
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findAll(){
		List<Cliente> listObj = repo.findAll();
		if(listObj == null || listObj.isEmpty()) {
			throw new ObjectNotFoundException("Nenhum objeto encontrado!");
		}
		
		return listObj;
	}
	
	public Cliente update(Cliente cliente) {
		return repo.saveAndFlush(cliente);
	}
	
	public Cliente fromDTO(DadosClienteDTO objDTO) {
		Cidade cid = new Cidade(objDTO.getCidadeId(), null, null);
		Cliente cli = this.find(objDTO.getClienteId());
		
		for(Endereco endereco : cli.getEnderecos()) {
			endereco.setLogradouro(objDTO.getLogradouro());
			endereco.setNumero(objDTO.getNumero());
			endereco.setComplemeto(objDTO.getComplemeto());
			endereco.setBairro(objDTO.getBairro());
			endereco.setCep(objDTO.getCep());
			endereco.setCidade(cid);
			
		}
		
		return cli;
	}

}
