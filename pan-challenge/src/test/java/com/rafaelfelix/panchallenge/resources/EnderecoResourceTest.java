package com.rafaelfelix.panchallenge.resources;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnderecoResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAddressTest() throws Exception {
		String cep = "01310100";
		mockMvc.perform(get("/endereco/{cep}", cep))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.logradouro", equalTo("Avenida Paulista")))
			   .andExpect(jsonPath("$.bairro", equalTo("Bela Vista")))
			   .andExpect(jsonPath("$.localidade", equalTo("São Paulo")));
	}
}
