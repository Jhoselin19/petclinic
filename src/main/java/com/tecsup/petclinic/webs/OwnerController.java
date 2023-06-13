package com.tecsup.petclinic.webs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.mapper.OwnerMapper;
import com.tecsup.petclinic.services.OwnerService;
import com.tecsup.petclinic.services.OwnerServiceImpl;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class OwnerController {
	
	static final Logger log = LogManager.getLogger(OwnerServiceImpl.class);

	//@Autowired
	private OwnerService ownerService;

	//@Autowired
	private OwnerMapper mapper;

	
	public OwnerController(OwnerService ownerService, OwnerMapper mapper) {
		this.ownerService = ownerService;
		this.mapper = mapper;
	}

	/**
	 * Find pet by id
	 *
	 * @param id
	 * @return
	 * @throws PetNotFoundException
	 */
	@GetMapping(value = "/owners/{id}")
	ResponseEntity<OwnerTO> findById(@PathVariable Integer id) {

		OwnerTO ownerTO = null;

		try {
			Owner owner = ownerService.findById(id);
			ownerTO = this.mapper.toOwnerTO(owner);

		} catch (OwnerNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ownerTO);

	}

}
