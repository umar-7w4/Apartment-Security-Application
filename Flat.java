package com.cg.asm.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/*
 {
 	"ownerName" : "Nikhil Daund",
 	"flatNo" : 101,
 	"floorNo" : 3,
 	"flatType" : "3bhk"
 }
 
 */

@Entity
public class Flat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flatId;
	private String ownerName;
	private int flatNo;
	private int floorNo;
	private String flatType;
	
	@OneToMany(mappedBy = "flat" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Visitor> visitors;
	
	@OneToMany(mappedBy = "flat" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Security> securities;
	
	public Flat() {
		super();
	}

	public Flat(int flatId, String ownerName, int flatNo, int floorNo, String flatType, List<Visitor> visitors,
			List<Security> securities) {
		super();
		this.flatId = flatId;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.floorNo = floorNo;
		this.flatType = flatType;
		this.visitors = visitors;
		this.securities = securities;
	}

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

	public List<Security> getSecurities() {
		return securities;
	}

	public void setSecurities(List<Security> securities) {
		this.securities = securities;
	}

}

/*
 
 DTO - Data transfer layer 
 
 DAO - Data access layer
 
 
 
 */

























