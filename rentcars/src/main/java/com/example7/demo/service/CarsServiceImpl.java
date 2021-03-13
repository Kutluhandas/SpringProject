package com.example7.demo.service;

import java.util.List;
import java.util.Optional;

import com.example7.demo.domainobject.CarsDO;
import com.example7.demo.repository.CarsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public CarsDO createCars(CarsDO cars) {

      return carsRepository.save(cars);

    }

    @Override
    public CarsDO updateCars(CarsDO cars) {
    
      Long carsId = cars.getId();
      Optional<CarsDO> presentCars = carsRepository.findById(carsId);
      if (presentCars.isPresent()){
        presentCars.get().setColor(cars.getColor());
        presentCars.get().setModelyear(cars.getModelyear());
        carsRepository.save(presentCars.get());
        return presentCars.get();
      }

      return null;
    }

    @Override
    public void deleteCars(Long carsId) {
        Optional<CarsDO> presentcars = carsRepository.findById(carsId);
        if (presentcars.isPresent()){
          carsRepository.deleteById(carsId);
        }
      }

    @Override
    public CarsDO getCars(Long carsId) {
      Optional<CarsDO> presentCars = carsRepository.findById(carsId);
      if (presentCars.isPresent()) {
          return presentCars.get();
      }
      return null;
  }

    @Override
    public List<CarsDO> getAllCars() {

      return carsRepository.findAll();

    }
    
}
