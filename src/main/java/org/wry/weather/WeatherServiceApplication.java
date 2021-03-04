package org.wry.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WeatherServiceApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter("app.pid"));
		springApplication.run(args);
	}
}
