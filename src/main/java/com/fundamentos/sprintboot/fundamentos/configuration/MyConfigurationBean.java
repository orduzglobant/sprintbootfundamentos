package com.fundamentos.sprintboot.fundamentos.configuration;

import com.fundamentos.sprintboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        //return new MyBeanImplement();
        return new MyBeanTwoImplement();
    }

    @Bean
    public MyOperation beanOperationSum(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyBeanLlave beanOperationLlave(){
        return new MyBeanLlaveImplement();
    }

    @Bean
    public MyBeanCar beanOperationCar (MyBeanLlave myBeanLlave){
        return new MyBeanCarImplement(myBeanLlave);
    }
}
