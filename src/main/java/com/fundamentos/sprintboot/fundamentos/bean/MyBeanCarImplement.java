package com.fundamentos.sprintboot.fundamentos.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanCarImplement implements MyBeanCar{

    private MyBeanLlave myBeanLlave;

    @Autowired
    public MyBeanCarImplement(MyBeanLlave myBeanLlave) {
        this.myBeanLlave = myBeanLlave;
    }

    @Override
    public String encender() {
        myBeanLlave.girarLLave();
        return "Encender carro automaticamente";
    }

    @Override
    public void moverce() {

    }
}
