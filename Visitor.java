package com.cg.asm.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitorId;
	private String name;
	private String ownerName;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "flat_id", referencedColumnName = "flatId")
	private Flat flat;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "guards_traning_id", referencedColumnName = "guardsTraningId")
	private GuardsTraning guardsTraning;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String arrivalTime;
	private String departureTime;
	
	public Visitor() {
		super();
	}
	
	public Visitor(int visitorId, String name, String ownerName, Flat flat, GuardsTraning guardsTraning, LocalDate date,
			String arrivalTime, String departureTime) {
		super();
		this.visitorId = visitorId;
		this.name = name;
		this.ownerName = ownerName;
		this.flat = flat;
		this.guardsTraning = guardsTraning;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public GuardsTraning getGuardsTraning() {
		return guardsTraning;
	}

	public void setGuardsTraning(GuardsTraning guardsTraning) {
		this.guardsTraning = guardsTraning;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	

}
