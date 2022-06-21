package com.fundamentos.sprintboot.fundamentos.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println(myOperation.sum(1));
        System.out.println("Hola desde la implementacion de un bean con dependencia");

        log.info("Hemos ingresado al metodo printWithDependency");

        log.debug("el numero enviado como parametro es :"+1);


    }
}
