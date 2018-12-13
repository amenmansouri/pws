package com.project.company.Entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Aeroport{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String nom;
    @OneToMany(mappedBy = "aerodep", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Line> departLines;
    @OneToMany(mappedBy = "aeroarr", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Line> arrivedLines;
   
    public Set<Line> getDepartLines() {
		return departLines;
	}
	public void setDepartLines(Set<Line> departLines) {
		this.departLines = departLines;
	}
	public Set<Line> getArrivedLines() {
		return arrivedLines;
	}
	public void setArrivedLines(Set<Line> arrivedLines) {
		this.arrivedLines = arrivedLines;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
    }