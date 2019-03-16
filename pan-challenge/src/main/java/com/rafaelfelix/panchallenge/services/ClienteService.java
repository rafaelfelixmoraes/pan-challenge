package com.rafaelfelix.panchallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelfelix.panchallenge.domains.Cliente;
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
		Cliente newCliente = this.find(cliente.getId());
		updateData(newCliente, cliente);
		return repo.saveAndFlush(newCliente);
	}
	
	private void updateData(Cliente newCliente, Cliente oldCliente) {
		newCliente.setNome(oldCliente.getNome());
		newCliente.setEmail(oldCliente.getEmail());
	}

}
