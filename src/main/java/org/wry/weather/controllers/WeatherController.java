package org.wry.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wry.weather.services.WeatherService;


@RestController
public class WeatherController {
	
	long pid = ProcessHandle.current().pid();
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping(path = "/weather")
	public ResponseEntity<String> getWeather() {
		return new ResponseEntity<String>(weatherService.getCurrentWeather(), weatherService.getCurrentWeather().contains("SUNNY")? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/lowpressure")
	public ResponseEntity<String> lowpressure() {
		weatherService.lowpressure();
		return new ResponseEntity<String>("[pid:" + pid + "]   " + "LOW PRESSURE IS ON", HttpStatus.OK);
	}
	
	@PostMapping(path = "/highpressure")
	public ResponseEntity<String> highpressure() {
		weatherService.highpressure();
		return new ResponseEntity<String>("[pid:" + pid + "]   " + "HIGH PRESSURE IS ON", HttpStatus.OK);
	}
}
