package com.example.csvtomongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CsvtomongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvtomongoApplication.class, args);
	}

}
