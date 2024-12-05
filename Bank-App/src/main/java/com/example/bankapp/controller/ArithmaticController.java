package com.example.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankapp.service.ArithmathicServicee;

@RestController
@RequestMapping("/exception")
public class ArithmaticController {

    @Autowired
    private ArithmathicServicee arithmathicServicee;


    @GetMapping("/{a}/{b}")
    public int getExceptionMessage(@PathVariable int a , @PathVariable int b)
    {
      return arithmathicServicee.aritMath(a, b);
  
    }
    
}
