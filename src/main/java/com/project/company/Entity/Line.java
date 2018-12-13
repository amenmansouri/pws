package com.project.company.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class Line{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "aero_dep_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
    private Aeroport aerodep;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "aero_arr_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
    private Aeroport aeroarr;
    
    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "line")
   // @JsonIgnore
    private Set<Vol> vols = new HashSet<>();
    private String description;
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Vol> getVols() {
		return vols;
	}

	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}

	public Aeroport getAerodep() {
		return aerodep;
	}

	public void setAerodep(Aeroport aero_dep) {
		this.aerodep = aero_dep;
	}

	public Aeroport getAeroarr() {
		return aeroarr;
	}

	public void setAero_arr(Aeroport aero_arr) {
		this.aeroarr = aero_arr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


    
}

