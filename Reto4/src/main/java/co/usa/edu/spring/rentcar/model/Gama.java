/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Andre
 */
@Entity
@Table(name="gama")
public class Gama implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Integer idGama;
    
    @Column(length = 45, nullable = false)
    private String name;
    @Column(length = 250, nullable = false)
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "gama")
    @JsonIgnoreProperties("gama")
    private List<Car> cars;

    public Gama() {
        super();
    }
    
    public Gama(Integer idGama, String name, String description, List<Car> cars) {
        this.idGama = idGama;
        this.name = name;
        this.description = description;
        this.cars = cars;
    }

    public Integer getIdGama() {
        return idGama;
    }

    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Gama{" + "idGama=" + idGama + ", name=" + name + ", description=" + description + ", cars=" + cars + '}';
    }
    
}
