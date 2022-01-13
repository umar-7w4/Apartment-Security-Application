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
/*
 
 {
 	"name" : "Shift_1",
 	"time" : "10:30",
 	"date" : "2021-12-22"
 	
 }
 
 */


@Entity
public class GuardShift{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guardShiftId;
	private String name;
	private String time;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "guards_traning_id", referencedColumnName = "guardsTraningId")
	private GuardsTraning guardsTraning;
	
	public GuardShift() {
		super();
	}

	public GuardShift(int guardShiftId, String name, String time, LocalDate date, GuardsTraning guardsTraning) {
		super();
		this.guardShiftId = guardShiftId;
		this.name = name;
		this.time = time;
		this.date = date;
		this.guardsTraning = guardsTraning;
	}

	public int getGuardShiftId() {
		return guardShiftId;
	}

	public void setGuardShiftId(int guardShiftId) {
		this.guardShiftId = guardShiftId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public GuardsTraning getGuardsTraning() {
		return guardsTraning;
	}

	public void setGuardsTraning(GuardsTraning guardsTraning) {
		this.guardsTraning = guardsTraning;
	}	
	
}
