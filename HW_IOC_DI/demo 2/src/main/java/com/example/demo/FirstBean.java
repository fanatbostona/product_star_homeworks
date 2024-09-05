package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {
    private SecondBean secondBean;

    public FirstBean(PrototypeBean prototypeBean) {
        System.out.println("Первый bean создан!");
        System.out.println("Прототип bean 1 = " + prototypeBean.toString());
    }

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }

}
