package com.ghizlen.coffee.entities;


import java.util.Date;
//import java.util.List;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Coffee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCoffee;
	


	private String nomCoffee;
	private int prixCoffee;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date dateFabrication;

	@ManyToOne
	private TypeCo typeCo;

//	 @OneToOne
//	 private Image image;

	 @OneToMany (mappedBy = "coffee")
	 private List<Image> images;

	 private String imagePath;



	public Coffee() {
		super();
	}

	public Coffee( String nomCoffee,int prixCoffee, Date dateFabrication) {
		super();

		this.nomCoffee = nomCoffee;
		this.prixCoffee = prixCoffee;
		this.dateFabrication = dateFabrication;
	}

	public Long getIdCoffee() {
		return idCoffee;
	}
	public void setIdCoffee(Long idCoffee) {
		this.idCoffee = idCoffee;
	}
	public String getNomCoffee() {
		return nomCoffee;
	}
	public void setNomCoffee(String nomCoffee) {
		this.nomCoffee = nomCoffee;
	}


	public int getPrixCoffee() {
		return prixCoffee;
	}
	public void setPrixCoffee(int prixCoffee) {
		this.prixCoffee = prixCoffee;
	}
	public Date getDateFabrication() {
		return dateFabrication;
	}
	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}


	@Override
	public String toString() {
		return "Coffee [idCoffee=" + idCoffee  +
				", prixCoffee="	+ prixCoffee +
				", nomCoffee="	+ nomCoffee +
				", dateFabrication=" + dateFabrication + "]";
	}

	public TypeCo getTypeCo() {
		return typeCo;
	}

	public void setTypeCo(TypeCo typeCo) {
		this.typeCo = typeCo;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
		
	
		
}
