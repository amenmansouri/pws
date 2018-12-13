package com.project.company.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Voyager{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String firstname;
    private String lastname;
    private int num_pass;
    private String cevilty;
    private int tel;
    private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getNum_pass() {
		return num_pass;
	}
	public void setNum_pass(int num_pass) {
		this.num_pass = num_pass;
	}
	public String getCevilty() {
		return cevilty;
	}
	public void setCevilty(String cevilty) {
		this.cevilty = cevilty;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
