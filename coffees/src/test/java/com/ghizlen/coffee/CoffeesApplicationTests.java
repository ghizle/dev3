package com.ghizlen.coffee;

import java.util.Date;
import java.util.List;

import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.TypeCo;
import com.ghizlen.coffee.service.CoffeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ghizlen.coffee.repos.CoffeeRepository;

@SpringBootTest
class CoffeesApplicationTests {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeService coffeeService;

    @Test
    public void testCreateCoffee() {
        Coffee coff = new Coffee("niscafee",3000, new Date());
        coffeeRepository.save(coff);
    }

    @Test
    public void testFindCoffee() {
        Coffee a = coffeeRepository.findById(1L).get();
        System.out.println(a);
    }

    @Test
    public void testUpdateCoffee() {
        Coffee a = coffeeRepository.findById(1L).get();
        a.setPrixCoffee(1000);
        coffeeRepository.save(a);
    }

    @Test
    public void testDeleteCoffee() {
        coffeeRepository.deleteById(1L);
    }

    @Test
    public void testListerTousCoffees() {
        List<Coffee> coffs = coffeeRepository.findAll();
        for (Coffee a : coffs) {
            System.out.println(a);
        }
    }

    @Test
    public void testFindByNomCoffeeContains() {
        Page<Coffee> coffs = coffeeService.getAllCoffeesParPage(0, 2);
        System.out.println(coffs.getSize());
        System.out.println(coffs.getTotalElements());
        System.out.println(coffs.getTotalPages());
        coffs.getContent().forEach(a -> {
            System.out.println(a.toString());
        });
    }

    @Test
    public void testFindCoffeeById() {
        List<Coffee> coffs = coffeeRepository.findByIdCoffee(1L);
        for (Coffee a : coffs) {
            System.out.println(a);
        }
    }

    @Test
    public void testfindByTypeCo() {
        TypeCo cat = new TypeCo();
        cat.setIdCo(1L);
        List<Coffee> coffs = coffeeRepository.findByTypeCo(cat);
        for (Coffee a : coffs) {
            System.out.println(a);
        }
    }

    @Test
    public void findByTypeCoIdCo() {
        List<Coffee> coffs = coffeeRepository.findByTypeCoIdCo(1L);
        for (Coffee a : coffs) {
            System.out.println(a);
        }
    }

    @Test
    public void testfindByOrderByIdCoAsc() {
        List<Coffee> coffs = coffeeRepository.findByOrderByIdCoffeeAsc();
        for (Coffee a : coffs) {
            System.out.println(a);
        }
    }

    @Test
    public void testrierCoffeesIdPrix() {
        List<Coffee> coffs = coffeeRepository.trierCoffeesIdPrix();
        for (Coffee a : coffs) {
            System.out.println(a);
        }
    }
}