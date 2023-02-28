package com.example.MyObjective2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class MyObjective2Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MyObjective2Application.class)
				.web(WebApplicationType.NONE).run();
		String input;
		boolean status = true;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter a TC number (for exit enter exit or EXIT):");
		input = scanner.next();

		while (status){
			if (input.equalsIgnoreCase("exit")){
				status = false;
			}
			else {
				Controller controller = new Controller();
				System.out.println(controller.checkTCNumber(input));
				input = scanner.next();
			}
		}
		SpringApplication.exit(ctx, () -> 0);
	}
}
