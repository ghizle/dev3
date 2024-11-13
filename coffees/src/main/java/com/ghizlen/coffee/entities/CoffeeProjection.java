package com.ghizlen.coffee.entities;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "prixCoff", types = { Coffee.class })
public interface CoffeeProjection {
	public String getPrixCoffn();

}
