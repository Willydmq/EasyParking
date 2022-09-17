package com.EasyParking.O18_14.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date; 
import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;

@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "products") // para que el nombre sea diferente al de la clase
public class Product implements Serializable{

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
    private String name;
    
    @NotNull
    @Min(0)
    @Column(columnDefinition="Decimal(10,4) default '0.0'",nullable = false)
    private Double price;
    
    
    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false, insertable = false, updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT NULL",nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
    
    @PreUpdate
    protected void onUpdate(){
        this.updateAt = new Date();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }



}
