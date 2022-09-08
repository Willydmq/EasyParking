
package com.O1814.EasyParkingO18_14.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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


    //  @ManyToOne
    //  @JoinColumn(name="codigo_usu")
    
    public parqueadero (String nit, String razon_social, String email, String plaza_carro, 
    		String plaza_moto) {
    	this.nit = nit;
    	this.razon_social = razon_social;
    	this.email= email;
    	this.plaza_carro= plaza_carro;
    	this.plaza_moto= plaza_moto;
    	
        }

        public parqueadero() {
        }
        
        
        // getter and setter 

        public String getnit() {
    	return nit;
        }

        public void setnit(String nit) {
    	this.nit = nit;
        }

        public String getrazon_social() {
    	return razon_social;
        }

        public void setrazon_social(String razon_social) {
    	this.razon_social= razon_social;
        }
        
        public String getemail() {
        return email;
        }

        public void setemail(String email) {
        this.email = email;
        }
        
        public String getplaza_carro() {
        return plaza_carro;
        }

        public void setplaza_carro(String plazo_carro) {
        this.plaza_carro = plaza_carro;
        }
        
        public String getplaza_moto() {
        return plaza_moto;
        }

        public void setplaza_moto(String plazo_moto) {
        this.plaza_moto = plaza_moto;
        }
            
        
    
    
}








