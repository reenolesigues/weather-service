package org.wry.weather.services;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	private String currentWeather = "SUNNY";
	
	public String getCurrentWeather() {
		long pid = ProcessHandle.current().pid();
		return "[pid:" + pid + "]   " + currentWeather;
	}
	
	public void lowpressure() {
		currentWeather = "RAINY";
	}
	
	public void highpressure() {
		currentWeather = "SUNNY";
	}
}
