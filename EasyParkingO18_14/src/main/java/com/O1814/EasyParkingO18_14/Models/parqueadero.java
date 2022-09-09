
package com.O1814.EasyParkingO18_14.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="parqueadero")

public class parqueadero implements Serializable {
	
	@Id
    @Column(name="nit")
    private String nit;

    @Column(name="razon_social")
    private String razon_social;

    @Column(name="email")
    private String email;

    @Column(name="plaza_carro")
    private String plaza_carro;

    @Column(name="plaza_moto")
    private String plaza_moto;

    @ManyToOne
    @JoinColumn(name="codigo_usu")
    private usuario codigo_usu;

	public parqueadero() {
		super();
	}

	public parqueadero(String nit, String razon_social, String email, String plaza_carro, String plaza_moto,
			usuario codigo_usu) {
		super();
		this.nit = nit;
		this.razon_social = razon_social;
		this.email = email;
		this.plaza_carro = plaza_carro;
		this.plaza_moto = plaza_moto;
		this.codigo_usu = codigo_usu;
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

	public String getPlaza_carro() {
		return plaza_carro;
	}

	public void setPlaza_carro(String plaza_carro) {
		this.plaza_carro = plaza_carro;
	}

	public String getPlaza_moto() {
		return plaza_moto;
	}

	public void setPlaza_moto(String plaza_moto) {
		this.plaza_moto = plaza_moto;
	}

	public usuario getCodigo_usu() {
		return codigo_usu;
	}

	public void setCodigo_usu(usuario codigo_usu) {
		this.codigo_usu = codigo_usu;
	}
    
}








