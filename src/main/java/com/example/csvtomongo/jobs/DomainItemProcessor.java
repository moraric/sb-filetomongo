package com.example.csvtomongo.jobs;

import com.example.csvtomongo.data.Entrada;
import com.example.csvtomongo.model.Direccion;
import com.example.csvtomongo.model.Domain;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

// import java.time.LocalDateTime;
// import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
// import java.util.Locale;


public class DomainItemProcessor implements ItemProcessor<Entrada, Domain> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Domain process(final Entrada entrada) throws Exception {
        //prueba ocupando mongoTemplate
        final String name = entrada.getName();
        
        // List<Domain> dominios = mongoTemplate.findAll(Domain.class, "domain");
        Query query = new Query(Criteria.where("name").is(name));
        // List<Domain> dominios = mongoTemplate.find(query, Domain.class);
        // System.out.println("Listando contenido de domain filtrado MongoDB ->");
        // for(Domain dominio: dominios){
        //     System.out.println(dominio);
        // }
        Domain dominio = mongoTemplate.findOne(query, Domain.class);
        if(dominio == null){

            final int num = entrada.getNum();
            final Date fecha = entrada.getFecha();
            final Date hoy = new Date();
            final List<String> telefono = entrada.getTelefono();

            final Direccion direccion = new Direccion();
            direccion.setCalle(entrada.getCalle());
            direccion.setColonia(entrada.getColonia());

            final Domain domain = new Domain(num, name, fecha, direccion, hoy, telefono);
            
            return domain;
        }
        else {
            if(dominio.getName().equalsIgnoreCase("facebook.com")){
                Update update = new Update();
                update.set("num", entrada.getNum());
            
            // mongoTemplate.findAndModify(query, update, Domain.class);
                mongoTemplate.updateFirst(query, update, Domain.class);
            }

            return null;
        }

        
        // final Date fecAux = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("1900/01/01");
        
        // if(entrada.getFecha().compareTo(fecAux) == 0){
        //     System.out.println("La fecha debe ser nula");
        //     final Date fechaC = null;
        // }    
        // else{
        //     System.out.println("La fecha se va a guardar en la coleccion");    
        //     final Date fecha = entrada.getFecha();
        // }
        // final Date fecha = fechaC;
        
        
        // final LocalDateTime hoy = LocalDateTime.now();
        
        // System.out.println("hoy -> " + hoy);

    }
    
}