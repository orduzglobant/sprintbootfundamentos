package com.fundamentos.sprintboot.fundamentos.bean;

public class MyBeanLlaveImplement implements MyBeanLlave {
    @Override
    public void girarLLave() {
        System.out.println("Gira llave para encender el carro");
    }
}
