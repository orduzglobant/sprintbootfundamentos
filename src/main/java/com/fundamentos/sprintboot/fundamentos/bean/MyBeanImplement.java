package com.fundamentos.sprintboot.fundamentos.bean;

public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde my implementacion propia del bean");
    }
}
