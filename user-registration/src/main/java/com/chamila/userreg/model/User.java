package com.chamila.userreg.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;

private String country;

private String state;

private int phone;

@Embedded
@AttributeOverrides({
  @AttributeOverride( name = "address1", column = @Column(name = "address1")),
  @AttributeOverride( name = "address2", column = @Column(name = "address2")),
  @AttributeOverride( name = "city", column = @Column(name = "city")),
  @AttributeOverride( name = "zipcode", column = @Column(name = "zipcode"))
})
private Address address;

@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
@JoinColumn(name = "auth_user_id",referencedColumnName = "id")
private AuthUser auth_user_id;



public AuthUser getAuth_user_id() {
	return auth_user_id;
}

public void setAuth_user_id(AuthUser auth_user_id) {
	this.auth_user_id = auth_user_id;
}

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}




@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+" "+this.country+" "+this.state;
	}
}
