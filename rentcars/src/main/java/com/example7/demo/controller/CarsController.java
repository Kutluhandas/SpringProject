package com.example7.demo.controller;

import java.util.List;

import com.example7.demo.domainobject.CarsDO;
import com.example7.demo.service.CarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class CarsController {
    
    @Autowired
    private CarsService carsService;

    @PostMapping(path = "/car", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarsDO> createCars(@RequestBody CarsDO carsDO){
        CarsDO createdCars = carsService.createCars(carsDO);
        return new ResponseEntity<>(createdCars, HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/car", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarsDO> updateCars(@RequestBody CarsDO carsDO) {
        CarsDO updatedCars = carsService.updateCars(carsDO);
        return new ResponseEntity<>(updatedCars, HttpStatus.CREATED);
    }

    @GetMapping(path = "/cars/{carsId}")
    public ResponseEntity<CarsDO> getCars(@PathVariable(value = "carsId") Long carsId) {
        CarsDO cars = carsService.getCars(carsId);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping(path = "/cars")
    public ResponseEntity<List<CarsDO>> getAllCars() {
        List<CarsDO> allCars = carsService.getAllCars();
        return new ResponseEntity<>(allCars, HttpStatus.OK);
    }

    @DeleteMapping(path = "/carsdelete/{carsId}")
    public ResponseEntity<String> deleteCars(@PathVariable(value = "CarsId") Long carsId) {
        carsService.deleteCars(carsId);
        return new ResponseEntity<>("Car with id: " + carsId + " is removed.", HttpStatus.OK);
    }


}
