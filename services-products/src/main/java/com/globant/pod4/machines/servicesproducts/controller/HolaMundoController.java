package com.globant.pod4.machines.servicesproducts.controller;

import com.globant.pod4.machines.servicesproducts.persistence.crud.ProductCrudRepository;
import com.globant.pod4.machines.servicesproducts.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {

    @Autowired
    private ProductCrudRepository productCrudRepository;


    @GetMapping("/hola")
    public List<Product> saludar() {

        return (List<Product>) productCrudRepository.findAll();

        //return "Nunca pares de aprender! 🚀";
    }
}