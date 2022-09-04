
package com.O1814.EasyParkingO18_14.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table
@Entity(name="parqueadero")
public class Parqueadero implements Serializable {
    @Id
    @Column(name="nit")
    private String nit;
     @Column(name="razon_social")
    private String razon_social;
     @Column(name="email")
    private String email;
     @Column(name="plaza_carro")
    private int plaza_carro;
     @Column(name="plaza_moto")
    private int plaza_moto;
     @ManyToOne
     @JoinColumn(name="codigo_usu")     
    private String codigo_uso;

    public Parqueadero(String nit, String razon_social, String email, int plaza_carro, int plaza_moto, String codigo_uso) {
        this.nit = nit;
        this.razon_social = razon_social;
        this.email = email;
        this.plaza_carro = plaza_carro;
        this.plaza_moto = plaza_moto;
        this.codigo_uso = codigo_uso;
    }

    public Parqueadero() {
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

    public int getPlaza_carro() {
        return plaza_carro;
    }

    public void setPlaza_carro(int plaza_carro) {
        this.plaza_carro = plaza_carro;
    }

    public int getPlaza_moto() {
        return plaza_moto;
    }

    public void setPlaza_moto(int plaza_moto) {
        this.plaza_moto = plaza_moto;
    }

    public String getCodigo_uso() {
        return codigo_uso;
    }

    public void setCodigo_uso(String codigo_uso) {
        this.codigo_uso = codigo_uso;
    }
    
}
