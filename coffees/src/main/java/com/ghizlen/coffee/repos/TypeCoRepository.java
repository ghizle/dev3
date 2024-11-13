package com.ghizlen.coffee.repos;

import com.ghizlen.coffee.entities.TypeCo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "typ")
@CrossOrigin(origins ="http://localhost:4200/") //pour autoriser angular 
public interface TypeCoRepository extends JpaRepository<TypeCo, Long>
{
}
