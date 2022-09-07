
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


@Entity
@Table(name="parqueadero")
public class parqueaderoEntity implements Serializable {

    @Id
    @Column(name="nit")

    @Column(name="razon_social")

    @Column(name="email")

    @Column(name="plaza_carro")

    @Column(name="plaza_moto")


     @ManyToOne
     @JoinColumn(name="codigo_usu")

    }

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
    this.razon_social = razon_social;
}

public String getemail() {
    return email;
}

public void setemail(String email) {
    this.email = email;
}

public int getplaza_carro() {
    return plaza_carro;
}

public void setplaza_carro(int plaza_carro) {
    this.plaza_carro = plaza_carro;
}

public int getplaza_moto() {
    return plaza_moto;
}

public void setplaza_moto(int plaza_moto) {
    this.plaza_moto = plaza_moto;
}

public String getcodigo_uso() {
    return codigo_uso;
}

public void setcodigo_uso(String codigo_uso) {
    this.codigo_uso = codigo_uso;
}

// revisado y dado visto bueno