package com.banking.system.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="Cust_ID")
	private int customerid;
	
	@Column(name = "First_Name")
	private String firstname;
	
	@Column(name = "Middle_Name")
	private String middlename;
	
	@Column(name = "Last_Name")
	private String lastname;
	
	@Column(name = "DOB")
	private Date dateofbirth;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Contact")
	private String contact;
	
	@Column(name = "PAN")
	private String pan;
	
	@Column(name = "Nationality")
	private String nationality;
	
	@Column(name = "Salary")
	@Convert(converter = DefaultFloatConverter.class)
	private Float salary;

	@Column(name = "Street")
	private String street;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "Pin")
	private String pin;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Customer(int customerid, String firstname, String middlename, String lastname, Date dateofbirth,
			String gender, String email, String password, String contact, String pan, String nationality, float salary,
			String street, String city, String state, String pin) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.pan = pan;
		this.nationality = nationality;
		this.salary = salary;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
