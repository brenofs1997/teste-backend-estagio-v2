package com.api.testebackendoperationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TesteBackendOperationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteBackendOperationManagerApplication.class, args);
	}
	@GetMapping("/")
	public  String index(){

		return "OLA MUNDO";
	}
}
