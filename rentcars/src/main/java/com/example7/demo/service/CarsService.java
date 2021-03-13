package com.example7.demo.service;

import java.util.List;

import com.example7.demo.domainobject.CarsDO;


public interface CarsService {

    public CarsDO createCars(CarsDO cars);
    public CarsDO updateCars(CarsDO cars);
    public void deleteCars(Long carsId);
    public CarsDO getCars(Long carsId);
    public List<CarsDO> getAllCars();
    
}
