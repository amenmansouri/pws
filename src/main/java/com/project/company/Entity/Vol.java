package com.project.company.Entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Vol{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private boolean type;//direct=0/indirect=1
    private Date departure;
    private Date arrival;
    private double economicPrice;
    private double busnessPrice;
    private int economicPlaceNumber;
    private int busnessPlaceNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "line_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Line line;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "vol")
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public double getEconomicPrice() {
		return economicPrice;
	}

	public void setEconomicPrice(double economicPrice) {
		this.economicPrice = economicPrice;
	}

	public double getBusnessPrice() {
		return busnessPrice;
	}

	public void setBusnessPrice(double busnessPrice) {
		this.busnessPrice = busnessPrice;
	}

	public int getEconomicPlaceNumber() {
		return economicPlaceNumber;
	}

	public void setEconomicPlaceNumber(int economicPlaceNumber) {
		this.economicPlaceNumber = economicPlaceNumber;
	}

	public int getBusnessPlaceNumber() {
		return busnessPlaceNumber;
	}

	public void setBusnessPlaceNumber(int busnessPlaceNumber) {
		this.busnessPlaceNumber = busnessPlaceNumber;
	}

	

    
}
