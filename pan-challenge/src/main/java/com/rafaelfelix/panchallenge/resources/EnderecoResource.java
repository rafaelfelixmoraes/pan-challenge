package com.rafaelfelix.panchallenge.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.rafaelfelix.panchallenge.dto.CidadeDTO;
import com.rafaelfelix.panchallenge.dto.EnderecoDTO;
import com.rafaelfelix.panchallenge.dto.EstadoDTO;

/**
 * Classe de controle dos serviços relacionados a Endereço
 * 
 * @author rafaelfelixmoraes
 *
 */

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoResource.class);
	
	private static RestTemplate template = new RestTemplate();
	private static final String cepPublicAPI = "https://viacep.com.br/ws/{cep}/json";
	private static final String estadoPublicAPI = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
	private static final String cidadePublicAPI = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/{id}/municipios";
	
	/**
	 * Método que realiza a pesquisa de um endereço através do CEP
	 * 
	 * @param cep O Cep do endereço a ser pesquisado
	 * @return {@link HttpStatus}: <b><i>OK(200)</i></b> com o objeto {@link EnderecoDTO}
	 */
	@GetMapping(value = "/{cep}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findAddressByCep(@PathVariable String cep) {
		// URI (URL) parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("cep", cep);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(cepPublicAPI);
		
		EnderecoDTO endereco = new EnderecoDTO();
		try {
			ResponseEntity<EnderecoDTO> response = template.getForEntity(builder.buildAndExpand(uriParams).toUri(), EnderecoDTO.class);
			endereco = response.getBody();
		} catch(HttpServerErrorException ex) {
			LOGGER.error("Causa: ".concat(ex.getCause().toString()).concat(". Detalhe: ").concat(ex.getMessage()));
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao tentar chamar a API pública");
		}
		return ResponseEntity.ok(endereco);
	}
	
	/**
	 * Método que retorna todos os estados ordenadosde forma Ascendente, com SP e RJ no topo
	 * 
	 * @return {@link HttpStatus}: <b><i>OK(200)</i></b> com uma lista contendo objetos {@link EstadoDTO}
	 */
	@GetMapping(value = "/estados", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> listAllStates() {
		List<EstadoDTO> estadoList = new ArrayList<>();
		List<EstadoDTO> sortedList = new ArrayList<>();
		try {
			ResponseEntity<List<EstadoDTO>> response = template.exchange(estadoPublicAPI, HttpMethod.GET, null, new ParameterizedTypeReference<List<EstadoDTO>>(){});
			estadoList = response.getBody();
		} catch(HttpServerErrorException ex) {
			LOGGER.error("Causa: ".concat(ex.getCause().toString()).concat(". Detalhe: ").concat(ex.getMessage()));
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao tentar chamar a API pública");
		}
		sortedList = customSortList(estadoList);
		return ResponseEntity.ok(sortedList);
	}
	
	/**
	 * Método que retorna os municipios de um determinado Estado
	 * 
	 * @param id O ID do estado
	 * @return {@link HttpStatus}: <b><i>OK(200)</i></b> com uma lista contendo objetos {@link CidadeDTO}
	 */
	@GetMapping(value = "/estado/{id}/municipios", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findCitiesByStateId(@PathVariable Integer id) {
		// URI (URL) parameters
		Map<String, Integer> uriParams = new HashMap<String, Integer>();
		uriParams.put("id", id);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(cidadePublicAPI);
		
		List<CidadeDTO> cidades = new ArrayList<>();
		try {
			ResponseEntity<List<CidadeDTO>> response = template.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<CidadeDTO>>(){});
			cidades = response.getBody();
		} catch(HttpServerErrorException ex) {
			LOGGER.error("Causa: ".concat(ex.getCause().toString()).concat(". Detalhe: ").concat(ex.getMessage()));
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao tentar chamar a API pública");
		}
		return ResponseEntity.ok(cidades);
	}
	
	/**
	 * Método que ordena uma lista de Estados em ordem alfabética, com SP e RJ no topo.
	 * 
	 * @param listToOrder A lista a ser ordenada
	 * @return Uma lista de Estados em ordem Alfabética, com SP e RJ no topo.
	 */
	private List<EstadoDTO> customSortList(List<EstadoDTO> listToOrder) {
		List<EstadoDTO> newList = new ArrayList<>();
		
		// Ordena a lista em ordem descendente para obter SP e RJ, nessa ordem
		Collections.sort(listToOrder, (list1,list2) -> list2.getNome().compareTo(list1.getNome()));
		for(EstadoDTO estado : listToOrder) {
			if(estado.getId() == 33 || estado.getId() == 35) {
				newList.add(estado);
			}
		}
		Collections.sort(listToOrder);
		newList.addAll(listToOrder);
		
		return newList;
	}

}
