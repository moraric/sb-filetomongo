package com.example.csvtomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Document(collection = "domain")
public class Domain {

    @Id
    private String id;
    private int num;
    private String name;
    private Date fecha;
    private Direccion direccion;
    private Date createdAt;
    private List<String> telefono;

    public Domain(int num, String name, Date fecha, Direccion direccion, Date createdAt, List<String> telefono) {
        this.num = num;
        this.name = name;
        this.fecha = fecha;
        this.direccion = direccion;
        this.createdAt = createdAt;
        this.telefono = telefono;
    }

    
}
