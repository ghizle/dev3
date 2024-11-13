package com.ghizlen.coffee.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeCo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCo;
    private String prixCo;
    private String infoCo;

    @OneToMany(mappedBy = "typeCo")
    @JsonIgnore
    private List<Coffee> coffees;

    public TypeCo() {
        super();
    }

    public Long getIdCo() {
        return idCo;
    }

    public void setIdCo(Long idCo) {
        this.idCo = idCo;
    }

    public String getPrixeCo() {
        return prixCo;
    }

    public void setPrixCo(String prixCo) {
        this.prixCo = prixCo;
    }

    public String getInfoCo() {
        return infoCo;
    }

    public void setInfoCo(String infoCo) {
        this.infoCo = infoCo;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }
}