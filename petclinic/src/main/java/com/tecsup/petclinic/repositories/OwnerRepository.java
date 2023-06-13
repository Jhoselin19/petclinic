package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

@Repository
public interface OwnerRepository 
	extends CrudRepository<Owner, Integer> {

		// Fetch pets by fisrtname
		List<Owner> findByFirstName(String firstName);

		// Fetch pets by lastname
		List<Owner> findByLastName(String lastName);

		// Fetch pets by address
		List<Owner> findByAddress(String address);
		
		// Fetch pets by city
		List<Owner> findByCity(String city);
		
		// Fetch pets by telephone
		List<Owner> findByTelephone(String telephone);
		

		@Override
		List<Owner> findAll();
}
