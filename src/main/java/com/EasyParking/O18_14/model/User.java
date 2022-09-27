package com.EasyParking.O18_14.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;

@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "users") // para que el nombre sea diferente al de la clase
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String username;


    @NotNull
    @Column(nullable = false)
    private String password;

    //@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
    //private List<Parqueadero> listParqueaderos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	/*public List<Parqueadero> getListParqueaderos() {
		return listParqueaderos;
	}

	public void setListParqueaderos(List<Parqueadero> listParqueaderos) {
		this.listParqueaderos = listParqueaderos;
	}
    */

}
