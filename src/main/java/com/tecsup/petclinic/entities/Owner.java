package com.tecsup.petclinic.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "owners")
@Data

public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String address;
	private String city;
	private String telephone;
	
	public Owner() {
	}

	public Owner(Integer id, String first_name, String last_name, String address, String city, String telephone) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner(String first_name, String last_name, String address, String city, String telephone) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
}