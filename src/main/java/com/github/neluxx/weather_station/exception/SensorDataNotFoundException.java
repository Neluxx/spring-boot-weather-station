package com.github.neluxx.weather_station.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SensorDataNotFoundException extends RuntimeException {
    public SensorDataNotFoundException() {
        super("Sensor data not found!");
    }
}
