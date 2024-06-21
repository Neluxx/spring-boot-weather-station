package com.github.neluxx.weather_station.sensor_api;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SensorRepository {

    private List<Sensor> sensorData = new ArrayList<>();

    List<Sensor> findAll() {
        return sensorData;
    }

    Optional<Sensor> findById(Integer id) {
        return sensorData.stream().filter(sensor -> sensor.id().equals(id)).findFirst();
    }

    void create(Sensor sensor) {
        sensorData.add(sensor);
    }

    void update(Sensor sensor, Integer id) {
        Optional<Sensor> existingSensorData = findById(id);
        existingSensorData.ifPresent(value -> sensorData.set(sensorData.indexOf(value), sensor));
    }

    void delete(Integer id) {
        sensorData.removeIf(sensor -> sensor.id().equals(id));
    }

    @PostConstruct
    private void init() {
        sensorData.add(new Sensor(1, 23.4, 47.6, 1024.7, 517.8));
        sensorData.add(new Sensor(2, 20.1, 54.8, 1019.3, 687.6));
        sensorData.add(new Sensor(3, 27.5, 45.3, 1021.0, 421.9));
    }
}
