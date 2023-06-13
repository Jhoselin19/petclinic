package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

public interface OwnerService {
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	void delete(Integer id) throws OwnerNotFoundException;
	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(Integer id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param first_name
	 * @return
	 */
	List<Owner> findByFirstName(String firstName);
	
	/**
	 * 
	 * @param last_name
	 * @return
	 */
	List<Owner> findByLastName(String lastName);
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	List<Owner> findByAddress(String address);

	/**
	 * 
	 * @param citiy
	 * @return
	 */
	List<Owner> findByCity(String city);
	
	/**
	 * 
	 * @param telephone
	 * @return
	 */
	List<Owner> findByTelephone(String telephone);

	/**
	 *
	 * @return
	 */
	List<Owner> findAll();

}