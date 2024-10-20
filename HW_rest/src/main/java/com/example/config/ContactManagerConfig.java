package com.example.config;


import com.example.manager.ContactDAO;
import com.example.manager.InMemoryContactDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactManagerConfig {

    @Bean
    public ContactDAO contactDAO() {
        return new InMemoryContactDAO();
    }

}
