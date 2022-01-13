package com.cg.asm.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/*
 
 {
 	"name" : "salary_1",
 	"amount" : 25000,
 	"status" : "Approved",
 	"date" : "2021-12-23"
 	
 }
 
 */

@Entity
public class GuardSalary { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guardSalaryId;
	private String name;
	private double amount;
	private String status;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@OneToOne
	@JoinColumn(name = "guards_traning_id", referencedColumnName = "guardsTraningId")
	private GuardsTraning guardsTraning;
	
	public GuardSalary() {
		super();
	}

	public GuardSalary(int guardSalaryId, String name, double amount, String status, LocalDate date,
			GuardsTraning guardsTraning) {
		super();
		this.guardSalaryId = guardSalaryId;
		this.name = name;
		this.amount = amount;
		this.status = status;
		this.date = date;
		this.guardsTraning = guardsTraning;
	}

	public int getGuardSalaryId() {
		return guardSalaryId;
	}

	public void setGuardSalaryId(int guardSalaryId) {
		this.guardSalaryId = guardSalaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
