package com.bookmyappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.bookmyappointment")
public class BookMyAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyAppointmentApplication.class, args);
	}

}
