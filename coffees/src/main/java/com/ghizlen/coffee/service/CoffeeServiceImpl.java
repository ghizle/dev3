package com.ghizlen.coffee.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.TypeCo;
import com.ghizlen.coffee.repos.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghizlen.coffee.repos.CoffeeRepository;
import com.ghizlen.coffee.repos.TypeCoRepository;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    TypeCoRepository typeCoRepository;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Coffee saveCoffee(Coffee p) {
        return coffeeRepository.save(p);
    }

    @Override
    public Coffee updateCoffee(Coffee p) {
        return coffeeRepository.save(p);
    }

    @Override
    @Transactional
    public void deleteCoffee(Coffee p) {
        // Delete related images first
        imageRepository.deleteById(p.getIdCoffee());
        // Then delete the coffee
        coffeeRepository.delete(p);
    }

    @Override
    @Transactional
    public void deleteCoffeeById(Long id) {
        // Delete the image before deleting the product
        Coffee p = getCoffee(id);
        try {
            Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + p.getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        coffeeRepository.deleteById(id);
    }

    @Override
    public Coffee getCoffee(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    @Override
    public Page<Coffee> getAllCoffeesParPage(int page, int size) {
        return coffeeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Coffee> findByIdCoffee(String idCoffee) {
        return coffeeRepository.findByIdCoffee(1L);
    }

    @Override
    public List<Coffee> findByfindBynomPrix(String nomCoffee,int PrixCoffee) {
        return coffeeRepository.findBynomPrix( nomCoffee ,PrixCoffee);
    }

    @Override
    public List<Coffee> findByTypeCo(TypeCo typeCo) {
        return coffeeRepository.findByTypeCo(typeCo);
    }

    @Override
    public List<Coffee> findByTypeCoIdC(Long id) {
        return coffeeRepository.findByTypeCoIdCo(id);
    }

    @Override
    public List<Coffee> findByOrderByIdCoAsc() {
        return coffeeRepository.findByOrderByIdCoffeeAsc();
    }

    @Override
    public List<Coffee> trierCoffeesIdPrix() {
        return coffeeRepository.trierCoffeesIdPrix();
    }

    @Override
    public List<TypeCo> getAllTypeCos() {
        return typeCoRepository.findAll();
    }
}