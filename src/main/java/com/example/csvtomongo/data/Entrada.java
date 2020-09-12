package com.example.csvtomongo.data;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class Entrada {

    private int num;
    private String name;
    private Date fecha;
    private String calle;
    private String colonia;
    private List<String> telefono;
    
}