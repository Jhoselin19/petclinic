package com.tecsup.petclinic.services;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {
	
	static final Logger log = LogManager.getLogger(OwnerServiceTest.class);
	

	@Autowired
	
	private OwnerService ownerService;
	
	@Test
	public void testFindOwnerById() {

		Integer ID = 1;
		String NAME = "George";
		Owner owner = null;
		
		try {
			
			owner = this.ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			
			fail(e.getMessage());
		}
		log.info(owner.toString());

		assertEquals(NAME, owner.getFirstName());
		//Si no coinciden, el test fallará.
	}
   	

   	@Test
	public void testFindOwnerByLastName() {

		String LAST_NAME = "Franklin";
		int SIZE_EXPECTED = 1;
		
		List<Owner> owners = this.ownerService.findByLastName(LAST_NAME);
		assertEquals(SIZE_EXPECTED, owners.size());

	}
   	
   	@Test
	public void testCreateOwner() {
	    String OWNER_NAME = "Maria";
	    String OWNER_LASTNAME = "Vargas";
	    String ADDRESS = "Avenida 123";
	    String CITY = "Lima";
	    String TELEPHONE = "987654321";

	    Owner owner = new Owner(OWNER_NAME, OWNER_LASTNAME, ADDRESS, CITY, TELEPHONE);
	    Owner ownerCreated = this.ownerService.create(owner);
	    log.info("OWNER CREATED: " + ownerCreated.toString());

	    assertNotNull(owner.getId());
	    assertEquals(OWNER_NAME, owner.getFirstName());
	    assertEquals(OWNER_LASTNAME, owner.getLastName());
	    assertEquals(ADDRESS, owner.getAddress());
	    assertEquals(CITY, owner.getCity());
	    assertEquals(TELEPHONE, owner.getTelephone());
	}
	
	
	
	@Test
	
	public void testUpdateOwner(){
		
		String OWNER_NAME = "George";
		String OWNER_LASTNAME = "Franklin";
		String ADRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		String TELEPHONE = "6085551023";
		
		String UP_OWNER_NAME = "George2";
		String UP_OWNER_LASTNAME = "Franklin2";
		String UP_ADRESS = "112 W. Liberty St.";
		String UP_CITY = "Madison2";
		String UP_TELEPHONE = "6085551023";
		
		Owner owner=new Owner(OWNER_NAME,OWNER_LASTNAME,ADRESS,CITY,TELEPHONE);
		
		// ------------ Create ---------------

        log.info(">" + owner);
        Owner ownerCreated = this.ownerService.create(owner);
        log.info(">>" + ownerCreated);

        // ------------ Update ---------------

        // Preparando la data para actualizar
        ownerCreated.setFirstName(UP_OWNER_NAME);
        ownerCreated.setLastName(UP_OWNER_LASTNAME);
        ownerCreated.setAddress(UP_ADRESS);
        ownerCreated.setCity(UP_CITY);
        ownerCreated.setTelephone(UP_TELEPHONE);

        // Ejecutar update
        Owner upgradeOwner = this.ownerService.update(ownerCreated);
        log.info(">>>>" + upgradeOwner);

        //            EXPECTATIVA        ACTUAL
        assertEquals(UP_OWNER_NAME, upgradeOwner.getFirstName());
        assertEquals(UP_OWNER_LASTNAME, upgradeOwner.getLastName());
        assertEquals(UP_ADRESS, upgradeOwner.getAddress());
        assertEquals(UP_CITY, upgradeOwner.getCity());
        assertEquals(UP_TELEPHONE, upgradeOwner.getTelephone());
	}	
	
	@Test
	public void testDeleteOwnerFirstName() {
	    String first_name = "Maria";
	

	    // ------------ Create ---------------

	    Owner owner = new Owner();
	    owner = this.ownerService.create(owner);
	    log.info("" + owner);

	    // ------------ Delete ---------------

	    try {
	        this.ownerService.delete(owner.getFirstName());
	    } catch (OwnerNotFoundException e) {
	        fail(e.getMessage());
	    }

	    // ------------ Validation ---------------

	    try {
	        this.ownerService.findById(owner.getId());
	        fail("Propietario con ID = " + owner.getId() + " no ha sido eliminado");
	    } catch (OwnerNotFoundException e) {
	        // Propietario eliminado correctamente
	    }
	}

	@Test
	public void testDeleteOwner() {
	    int id = 13;

	    // ------------ Delete ---------------

	    try {
	        ownerService.delete(id);
	    } catch (OwnerNotFoundException e) {
	        fail(e.getMessage());
	    }

	    // ------------ Validation ---------------

	    try {
	        ownerService.findById(id);
	        fail("Propietario con id = " + id + " no ha sido eliminado");
	    } catch (OwnerNotFoundException e) {
	        
	    }
	}
 
}
