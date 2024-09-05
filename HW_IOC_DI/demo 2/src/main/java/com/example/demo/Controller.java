package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private RequestScopeBean requestScopeBean;

    public Controller(RequestScopeBean requestScopeBean) {
        this.requestScopeBean = requestScopeBean;
    }

    @GetMapping("/")
    public String HW(){
        StringBuilder b = new StringBuilder();
        b.append("HW!\n\n");
        b.append("Первый вызов request bean'а: \n");
        b.append(requestScopeBean.toString());
        b.append("\n\n");
        b.append("Второй вызов request bean'а: \n");
        b.append(requestScopeBean.toString());
        b.append("\n");
        return b.toString();
    }
}
