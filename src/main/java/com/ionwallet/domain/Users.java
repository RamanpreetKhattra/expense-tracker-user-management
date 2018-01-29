package com.ionwallet.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ionwallet.expensemgrutility.converters.LocalDateTimeAttributeConverter;


@Entity
@Table(name="USERS")
public class Users extends AbstractEntity{

	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
	private int userId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="DOB" , columnDefinition = "DATETIME")
	@Convert(converter=LocalDateTimeAttributeConverter.class)
	private LocalDateTime dob;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="STATUS")
	private String status;
	
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(name="USER_ROLE_MAPPING",
			   joinColumns={@JoinColumn(name="USER_ID")},
			   inverseJoinColumns={@JoinColumn(name="ROLE_ID")}
	)
	private List<Roles> roles=new ArrayList<>();
	
	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
