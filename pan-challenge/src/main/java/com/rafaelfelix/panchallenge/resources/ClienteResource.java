package com.rafaelfelix.panchallenge.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelfelix.panchallenge.domains.Cliente;
import com.rafaelfelix.panchallenge.resources.exception.StandardError;
import com.rafaelfelix.panchallenge.resources.utils.BR;
import com.rafaelfelix.panchallenge.services.ClienteService;

/**
 * Classe de controle dos serviços
 * 
 * @author rafaelfelixmoraes
 *
 */

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	/**
	 * Método que realiza a pesquisa de um cliente através do <b>CPF</b>
	 * 
	 * @param cpf O cpf a ser pesquisado
	 * @return {@link HttpStatus}: <b><i>OK(200)</i></b> com o objeto {@link Cliente}, <b><i>BAD REQUEST(400)</i></b> caso o <b>CPF</b> esteja incorreto
	 */
	@GetMapping("/{cpf}")
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
		if(!BR.isValidCPF(cpf)) {
			return ResponseEntity.badRequest()
								 .body(new StandardError(HttpStatus.NOT_FOUND.value(), "CPF Inválido", new Date()));
		}
		Cliente obj = service.findByCpf(cpf);
		return ResponseEntity.ok(obj);
	}
	
	/*@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody EnderecoDTO enderecoDTO){
		Cliente cliente = service.fromDTO(clienteDTO);
		cliente.setId(id);
		cliente = service.update(cliente);
		return ResponseEntity.noContent().build();
	}*/

}
