package com.example7.demo.datatransferobject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CarsDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private String name;
    private String color;
    private String modelyear;


    
}
