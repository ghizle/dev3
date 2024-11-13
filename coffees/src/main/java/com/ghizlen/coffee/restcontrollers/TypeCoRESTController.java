package com.ghizlen.coffee.restcontrollers;

import java.util.List;
import java.util.Optional;

import com.ghizlen.coffee.entities.TypeCo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ghizlen.coffee.repos.TypeCoRepository;

@RestController
@RequestMapping("/api/typ")
@CrossOrigin("*")
public class TypeCoRESTController {

    @Autowired
    TypeCoRepository typeCoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TypeCo>> getAllCategories() {
        List<TypeCo> categories = typeCoRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TypeCo> getCategoryById(@PathVariable("id") Long id) {
        Optional<TypeCo> category = typeCoRepository.findById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TypeCo> createCategory(@RequestBody TypeCo category) {
        TypeCo createdCategory = typeCoRepository.save(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        if (typeCoRepository.existsById(id)) {
            typeCoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TypeCo> updateCategory(@PathVariable("id") Long id, @RequestBody TypeCo category) {
        if (typeCoRepository.existsById(id)) {
            category.setIdCo(id);  // Ensure the ID is set correctly
            TypeCo updatedCategory = typeCoRepository.save(category);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
