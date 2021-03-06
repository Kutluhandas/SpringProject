package com.example7.demo;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example7.demo.domainobject.CarsDO;
import com.example7.demo.domainobject.EngineDO;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CarsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	
	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllCars() throws Exception{
			mockMvc.perform(get("/api/v3/cars")
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[*].id").exists())
						.andExpect(jsonPath("$[*].name").exists())
						.andExpect(jsonPath("$[*].color").exists())
						.andExpect(jsonPath("$[*].modelyear").exists());
								
	}
	@Test
	public void testGetCars() throws Exception {
		String carsId = "1";

		mockMvc.perform(get("/api/v3/cars/{carsId}", carsId)
						.accept(MediaType.APPLICATION_JSON))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.name").exists())
						.andExpect(jsonPath("$.color").exists())
						.andExpect(jsonPath("$.modelyear").exists());

	}

	@Test
	public void testCreateCars() throws Exception {
		CarsDO newCars = new CarsDO();
		newCars.setName("whitetiguanim");
		newCars.setColor("white");
		newCars.setModelyear("2021");
		EngineDO newEngine = new EngineDO();
		newEngine.setHorsepower("197");
		newEngine.setTorque("157");
		newEngine.setFueltype("diesel");
		newCars.setEngine(newEngine);


		mockMvc.perform(post("/api/v3/car")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newCars)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.name").exists())
						.andExpect(jsonPath("$.color").exists())
						.andExpect(jsonPath("$.modelyear").exists())
						.andExpect(jsonPath("$.engine").exists())
						.andExpect(jsonPath("$.engine.id").exists())
						.andExpect(jsonPath("$.engine.horsepower").exists())
						.andExpect(jsonPath("$.engine.torque").exists())
						.andExpect(jsonPath("$.engine.fueltype").exists())
						.andExpect(jsonPath("$.name").value("whitetiguanim"));

	}

	@Test
	public void testUpdateCars() throws Exception {
		CarsDO newCars = new CarsDO();
		newCars.setId(8L);
		newCars.setName("greytiguan");
		newCars.setColor("grey");
		newCars.setModelyear("2019");
		EngineDO newEngine = new EngineDO();
		newEngine.setHorsepower("177");
		newEngine.setTorque("143");
		newEngine.setFueltype("diesel");
		newCars.setEngine(newEngine);


		mockMvc.perform(put("/api/v3/car")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newCars)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.color").exists())
						.andExpect(jsonPath("$.modelyear").exists())
						.andExpect(jsonPath("$.engine").exists())
						.andExpect(jsonPath("$.engine.horsepower").exists())
						.andExpect(jsonPath("$.engine.torque").exists())
						.andExpect(jsonPath("$.engine.fueltype").exists());
	}

	@Test
	public void testDeleteCars() throws Exception {
		String customerId = "4";

		mockMvc.perform(delete("/api/v3/carsdelete/{carsId}", customerId)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
	}






	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}







}
