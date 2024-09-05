package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {

    public SecondBean(PrototypeBean prototypeBean) {
        System.out.println("Второй bean создан!!");
        System.out.println("Прототип bean 2 = " + prototypeBean.toString());
    }

}
