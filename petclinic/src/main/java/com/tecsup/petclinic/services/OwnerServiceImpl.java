package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService{
	
	static final Logger log = LogManager.getLogger(OwnerServiceImpl.class);
	
	OwnerRepository ownerRepository;

	public OwnerServiceImpl (OwnerRepository ownerRepository) {
		this. ownerRepository = ownerRepository;
	}


	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Integer id) throws OwnerNotFoundException {
		
		Owner owner = findById(id);
		ownerRepository.delete(owner);
		
	}
	
	@Override
	public void delete(String firstName) throws OwnerNotFoundException {
		
		List<Owner> owner = findByFirstName(firstName);
		ownerRepository.deleteAll(owner);
		
	}
	
	
	@Override
	public Owner findById(Integer id) throws OwnerNotFoundException {
		
		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
		
	}

	@Override
	public List<Owner> findByFirstName(String firstName) {
		
		List<Owner> owners = ownerRepository.findByFirstName(firstName);

		owners.stream().forEach(owner -> log.info("" + owner));

		return owners;
		
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		
		List<Owner> owners = ownerRepository.findByLastName(lastName);

		owners.stream().forEach(owner -> log.info("" + owner));

		return owners;
		
	}

	@Override
	public List<Owner> findByAddress(String address) {
		
		List<Owner> owners = ownerRepository.findByAddress(address);

		owners.stream().forEach(owner -> log.info("" + owner));

		return owners;
		
	}

	@Override
	public List<Owner> findByCity(String city) {
		
		List<Owner> owners = ownerRepository.findByCity(city);

		owners.stream().forEach(owner -> log.info("" + owner));

		return owners;
		
	}

	@Override
	public List<Owner> findByTelephone(String telephone) {
		
		List<Owner> owners = ownerRepository.findByTelephone(telephone);

		owners.stream().forEach(owner -> log.info("" + owner));

		return owners;
		
	}

	@Override
	public List<Owner> findAll() {
		return ownerRepository.findAll();
	}

}
