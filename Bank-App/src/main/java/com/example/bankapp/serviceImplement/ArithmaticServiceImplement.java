package com.example.bankapp.serviceImplement;

import org.springframework.stereotype.Service;

import com.example.bankapp.service.ArithmathicServicee;
@Service
public class ArithmaticServiceImplement implements ArithmathicServicee {

    @Override
    public int aritMath(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new RuntimeException("Cannot divide by zero", e);
        }
    }
    
}
