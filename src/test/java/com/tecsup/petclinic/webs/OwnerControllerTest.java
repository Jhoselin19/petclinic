package com.tecsup.petclinic.webs;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.domain.OwnerTO;

import lombok.extern.slf4j.Slf4j;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerTest {
	
	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	

	/**
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testFindOwnerOK() throws Exception {

		String first_name = "George";
		String last_name = "Franklin";
		String address = "110 W. Liberty St.";
		String city = "Madison";
		String telephone = "6085551023";
		

		mockMvc.perform(get("/owners/1")) 
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.firstName", is(first_name)))
				.andExpect(jsonPath("$.lastName", is(last_name)))
				.andExpect(jsonPath("$.address", is(address)))
				.andExpect(jsonPath("$.city", is(city)))
				.andExpect(jsonPath("$.telephone", is(telephone)));
	}
	/**
	 * @throws Exception
	 */
	
	@Test
	public void testCreateOwner() throws Exception{
		
	    String first_name = "Deysi";
	    String last_name = "Lloja";
	    String address = "Avenida 123";
	    String city = "Lima";
	    String telephone = "987654321";
	    
	   OwnerTO newOwnerTO = new OwnerTO();
	   newOwnerTO.setFirstName(first_name);
	   newOwnerTO.setLastName(last_name);
	   newOwnerTO.setAddress(address);
	   newOwnerTO.setCity(city);
	   newOwnerTO.setTelephone(telephone);
	   
	   mockMvc.perform(post("/owners")
			   
			   		.content(om.writeValueAsString(newOwnerTO))
			   		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	   		   
	   			.andDo(print())
	   			.andExpect(status().isCreated())
	   		   
	   			.andExpect(jsonPath("$.first_name", is(first_name)))
	   			.andExpect(jsonPath("$.last_name", is(last_name)))
	   			.andExpect(jsonPath("$.address", is(address)))
	   			.andExpect(jsonPath("$.city", is(city)))
	   		   	.andExpect(jsonPath("$.telephone", is(telephone)));
	}
}
	
	

