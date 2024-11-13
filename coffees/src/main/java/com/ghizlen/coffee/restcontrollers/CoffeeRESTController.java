package com.ghizlen.coffee.restcontrollers;

import java.util.List;


import com.ghizlen.coffee.entities.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.ghizlen.Coffees.dto.Coffee;
import com.ghizlen.coffee.service.CoffeeService;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200")

public class CoffeeRESTController {
@Autowired
CoffeeService coffeeService;

//@RequestMapping(method = RequestMethod.GET)
//public List<Coffee> getAllCoffees() {
//return coffeeService.getAllCoffees();
//}

@RequestMapping(path="all",method =RequestMethod.GET)
public List<Coffee> getAllCoffees() {
return coffeeService.getAllCoffees();
}
@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
public Coffee getCoffeeById(@PathVariable("id") Long id) {
return coffeeService.getCoffee(id);
}
@RequestMapping(path="/addCoff",method = RequestMethod.POST)
public Coffee createCoffee(@RequestBody Coffee coffee) {
return coffeeService.saveCoffee(coffee);
}
@RequestMapping(path="/updateCoff",method = RequestMethod.PUT)
public Coffee updateCoffee(@RequestBody Coffee coffee) {
return coffeeService.updateCoffee(coffee);
}
@RequestMapping(value="/delCoff/{id}",method = RequestMethod.DELETE)
public void deleteCoffee(@PathVariable("id") Long id)
{
coffeeService.deleteCoffeeById(id);
}
@RequestMapping(value="/Cofftyp/{idTyp}",method = RequestMethod.GET)
public List<Coffee> getCoffeesByTypId(@PathVariable("idTyp") Long idTyp) {
return coffeeService.findByTypeCoIdC(idTyp);
}

}
