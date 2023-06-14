package com.tecsup.petclinic.webs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tecsup.petclinic.mapper.OwnerMapper;

import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
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
	
	@PostMapping("/owners")
	@ResponseStatus(HttpStatus.CREATED)
	Owner create (@RequestBody OwnerTO newOwner){
		Owner owner = new Owner();
		owner.setFirstName(newOwner.getFirstName());
		owner.setLastName(newOwner.getLastName());
		owner.setAddress(newOwner.getAddress());
		owner.setCity(newOwner.getCity());
		owner.setTelephone(newOwner.getTelephone());
		
		return ownerService.create(owner);
		
	}
	
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
