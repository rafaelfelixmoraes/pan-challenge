package com.rafaelfelix.panchallenge.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.rafaelfelix.panchallenge.dto.EnderecoDTO;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoResource.class);

	@GetMapping(value = "/{cep}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findAddress(@PathVariable String cep) {
		String cepPublicAPI = "https://viacep.com.br/ws/" + cep + "/json";
		EnderecoDTO endereco = new EnderecoDTO();
		try {
			RestTemplate template = new RestTemplate();
			ResponseEntity<EnderecoDTO> response = template.getForEntity(cepPublicAPI, EnderecoDTO.class);
			endereco = response.getBody();
		} catch(HttpServerErrorException ex) {
			LOGGER.error("Causa: ".concat(ex.getCause().toString()).concat(". Detalhe: ").concat(ex.getMessage()));
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao tentar chamar a API pública");
		}
		return ResponseEntity.ok(endereco);
	}

}
