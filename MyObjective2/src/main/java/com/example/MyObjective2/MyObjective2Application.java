package com.example.MyObjective2;

import org.apache.catalina.connector.InputBuffer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@SpringBootApplication
public class MyObjective2Application {
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MyObjective2Application.class)
				.web(WebApplicationType.NONE).run();
		boolean status = true;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter a TC number (for exit enter exit or EXIT):");
		String input = scanner.nextLine();

		while (status){
			if (input.equalsIgnoreCase("exit")){
				status = false;
			}
			else {
				Controller controller = new Controller();
				System.out.println(controller.checkTCNumber(input));
				input = scanner.nextLine();
			}
		}
		SpringApplication.exit(ctx, () -> 0);
	}
}
