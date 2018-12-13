package com.project.company.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
    public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "vol_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
  //  @JsonIgnore
    private	Vol vol;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "voyageur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
 //   @JsonIgnore
    private Voyager voyager;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Voyager getVoyager() {
		return voyager;
	}
	public void setVoyager(Voyager voyager) {
		this.voyager = voyager;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
}
