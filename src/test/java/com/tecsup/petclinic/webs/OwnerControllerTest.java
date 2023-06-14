package com.tecsup.petclinic.webs;

import static org.hamcrest.CoreMatchers.is;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.domain.OwnerTO;

import lombok.extern.slf4j.Slf4j;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerTest {
	
	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testCreateOwner() throws Exception{
		
	    String first_name = "Deysi Rubi";
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
	   		   
	   			.andExpect(jsonPath("$.firstName", is(first_name)))
	   			.andExpect(jsonPath("$.lastName", is(last_name)))
	   			.andExpect(jsonPath("$.address", is(address)))
	   			.andExpect(jsonPath("$.city", is(city)))
	   		   	.andExpect(jsonPath("$.telephone", is(telephone)));
	}
}
	
	

