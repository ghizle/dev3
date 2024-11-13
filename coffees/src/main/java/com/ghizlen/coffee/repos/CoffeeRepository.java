package com.ghizlen.coffee.repos;

import java.util.List;

import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.TypeCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rest")
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

	List<Coffee> findByIdCoffee(Long id);

	@Query("select a from Coffee a where a.nomCoffee like :nom and a.prixCoffee > :Prix")
	List<Coffee> findBynomPrix(@Param("nom") String nom ,@Param("Prix") int Prix);

	@Query("select p from Coffee p where p.typeCo = ?1")
	List<Coffee> findByTypeCo(TypeCo typeCo);

	List<Coffee> findByTypeCoIdCo(Long id);

	List<Coffee> findByOrderByIdCoffeeAsc();

	@Query("select a from Coffee a order by a.idCoffee ASC, a.prixCoffee DESC")
	List<Coffee> trierCoffeesIdPrix();
}