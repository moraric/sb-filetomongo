package com.example.csvtomongo.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;


@Getter
public abstract class Llave {

    @Id
    private String id;
    
}
