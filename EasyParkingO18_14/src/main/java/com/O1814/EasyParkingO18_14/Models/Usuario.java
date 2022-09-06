package com.O1814.EasyParkingO18_14.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class usuario implements Serializable{
    @Id
    @Column(name = "codigo_usu")
    private String codigo_usu;
    
    @Column(name = "nombre_usu")
    private String nombre_usu;

    public usuario(String codigo_usu, String nombre_usu) {
	this.codigo_usu = codigo_usu;
	this.nombre_usu = nombre_usu;
    }

    public usuario() {
    }

    public String getCodigo_usu() {
	return codigo_usu;
    }

    public void setCodigo_usu(String codigo_usu) {
	this.codigo_usu = codigo_usu;
    }

    public String getNombre_usu() {
	return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
	this.nombre_usu = nombre_usu;
    }
    
    
}
