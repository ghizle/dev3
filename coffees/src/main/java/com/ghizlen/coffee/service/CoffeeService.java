package com.ghizlen.coffee.service;

import java.util.List;


import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.TypeCo;
import org.springframework.data.domain.Page;

//import com.ghizlen.Coffees.dto.Coffee;


public interface CoffeeService {
Coffee saveCoffee(Coffee a);
Coffee getCoffee(Long id);
List<Coffee> getAllCoffees();


Coffee updateCoffee(Coffee a);
void deleteCoffee(Coffee a);
void deleteCoffeeById(Long id);



List<Coffee> findByIdCoffee(String idCoffee);

List<Coffee> findByfindBynomPrix ( String nomCoffee,int PrixCoffee);
List<Coffee> findByTypeCo (TypeCo typeCo);
List<Coffee> findByTypeCoIdC(Long id);
List<Coffee> findByOrderByIdCoAsc();
List<Coffee> trierCoffeesIdPrix();

Page<Coffee> getAllCoffeesParPage(int page, int size);

List<TypeCo> getAllTypeCos();

//Coffee convertEntityToDto (Coffee a);
//Coffee convertDtoToEntity(Coffee CoffeeDto);
}