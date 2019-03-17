package com.rafaelfelix.panchallenge.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findClientByCpf() throws Exception {
		String cpf = "11031614079";
		mockMvc.perform(get("/clientes/{cpf}", cpf))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.id", equalTo(2)))
			   .andExpect(jsonPath("$.nome", equalTo("José João da Silva")))
			   .andExpect(jsonPath("$.cpf", equalTo(cpf)));
	}

}
