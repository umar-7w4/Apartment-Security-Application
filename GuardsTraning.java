package com.cg.asm.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/*
 
 {
 	"name" : "Training_1",
 	"mobileNo" : 9887879899,
 	"status" : "Active",
 	"timeing" : "10.45",
 	"date"  : "2021-11-09",
 	
 }
 
 */

@Entity
public class GuardsTraning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guardsTraningId;
	private String name;
	private String mobileNo;
	private String status;
	private String timeing;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@OneToMany(mappedBy = "guardsTraning", fetch = FetchType.EAGER )
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Visitor> visitors;
	
	@OneToMany(mappedBy = "guardsTraning", fetch = FetchType.EAGER )
	@Fetch(value = FetchMode.SUBSELECT)
	private List<GuardShift> guardShifts;

	@OneToMany(mappedBy = "guardsTraning", fetch = FetchType.EAGER )
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Security> securities;
	
	public GuardsTraning() {
		super();

	}

	public GuardsTraning(int guardsTraningId, String name, String mobileNo, String status, String timeing,
			LocalDate date, List<Visitor> visitors, List<GuardShift> guardShifts, List<Security> securities) {
		super();
		this.guardsTraningId = guardsTraningId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timeing = timeing;
		this.date = date;
		this.visitors = visitors;
		this.guardShifts = guardShifts;
		this.securities = securities;
	}


	public int getGuardsTraningId() {
		return guardsTraningId;
	}


	public void setGuardsTraningId(int guardsTraningId) {
		this.guardsTraningId = guardsTraningId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTimeing() {
		return timeing;
	}


	public void setTimeing(String timeing) {
		this.timeing = timeing;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public List<Visitor> getVisitors() {
		return visitors;
	}


	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}


	public List<GuardShift> getGuardShifts() {
		return guardShifts;
	}


	public void setGuardShifts(List<GuardShift> guardShifts) {
		this.guardShifts = guardShifts;
	}


	public List<Security> getSecurities() {
		return securities;
	}


	public void setSecurities(List<Security> securities) {
		this.securities = securities;
	}
	
}
