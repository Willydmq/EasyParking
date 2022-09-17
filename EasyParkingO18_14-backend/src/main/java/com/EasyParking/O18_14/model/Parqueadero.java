package com.EasyParking.O18_14.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name="parqueadero")
public class Parqueadero implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
	private User user;
	
	@NotNull
    @Column(columnDefinition = "text")
	private String nit;
	
	@NotNull
    @Column(columnDefinition = "text")
	private String razon_social;
	
	@NotNull
    @Column(columnDefinition = "text")
	private String email;
	
	@NotNull
	@Column(name="plaza_carro",nullable = false)
	private Integer plaza_carro;
	
	@NotNull
	@Column(name="plaza_moto",nullable = false)
	private Integer plaza_moto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPlaza_carro() {
		return plaza_carro;
	}

	public void setPlaza_carro(Integer plaza_carro) {
		this.plaza_carro = plaza_carro;
	}

	public Integer getPlaza_moto() {
		return plaza_moto;
	}

	public void setPlaza_moto(Integer plaza_moto) {
		this.plaza_moto = plaza_moto;
	}
	
	
}
