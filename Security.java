package com.cg.asm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
  
  {
  	"message" : "Thank you for service",
  	"alert" : "Thanking",
  	
  }
  
 */

@Entity
public class Security {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int securityId;
	private String message;
	private String alert;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "flat_id", referencedColumnName = "flatId")
	private Flat flat;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "guards_traning_id", referencedColumnName = "guardsTraningId")
	private GuardsTraning guardsTraning;
	
	public Security() {
		super();
	}

	public Security(int securityId, String message, String alert, Flat flat, GuardsTraning guardsTraning) {
		super();
		this.securityId = securityId;
		this.message = message;
		this.alert = alert;
		this.flat = flat;
		this.guardsTraning = guardsTraning;
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
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
	
	
}
