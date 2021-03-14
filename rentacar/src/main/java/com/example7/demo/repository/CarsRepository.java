package com.example7.demo.repository;

import com.example7.demo.domainobject.CarsDO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<CarsDO, Long> {

}
