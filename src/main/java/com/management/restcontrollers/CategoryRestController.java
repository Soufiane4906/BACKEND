package com.management.restcontrollers;

import com.management.entities.Category;
import com.management.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    // Correction de la route pour récupérer une catégorie par ID
    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryRepository.findById(id).orElse(null); // Utilisation de orElse pour éviter les erreurs si l'ID n'existe pas
    }
    //post
    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
    //put
    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
