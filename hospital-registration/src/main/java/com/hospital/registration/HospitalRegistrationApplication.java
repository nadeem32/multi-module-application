package com.hospital.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hospital.common", "com.hospital.registration"})
public class HospitalRegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalRegistrationApplication.class, args);
    }
}
