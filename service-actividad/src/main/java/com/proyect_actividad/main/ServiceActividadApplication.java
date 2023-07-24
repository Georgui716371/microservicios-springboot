package com.proyect_actividad.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ServiceActividadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceActividadApplication.class, args);
    }

}
