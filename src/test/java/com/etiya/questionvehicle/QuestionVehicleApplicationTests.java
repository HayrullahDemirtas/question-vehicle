package com.etiya.questionvehicle;

import com.etiya.questionvehicle.dto.LoginRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class QuestionVehicleApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllAdditionalProduct() throws Exception {
		mockMvc.perform(get("/api/v1/allAdditionalProducts")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].count").exists())
				.andExpect(jsonPath("$[*].price").exists())
				.andExpect(jsonPath("$[*].name").exists())
				.andExpect(jsonPath("$[*].description").exists())
				.andExpect(jsonPath("$[*].image").exists());

	}

	@Test
	public void testGetAllVehicles() throws Exception {
		mockMvc.perform(get("/api/v1/allVehicles")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].userName").exists())
				.andExpect(jsonPath("$[*].price").exists())
				.andExpect(jsonPath("$[*].year").exists())
				.andExpect(jsonPath("$[*].km").exists())
				.andExpect(jsonPath("$[*].brand").exists())
				.andExpect(jsonPath("$[*].model").exists())
				.andExpect(jsonPath("$[*].caseType").exists())
				.andExpect(jsonPath("$[*].fuel").exists())
				.andExpect(jsonPath("$[*].gear").exists())
				.andExpect(jsonPath("$[*].engine").exists())
				.andExpect(jsonPath("$[*].packageName").exists())
				.andExpect(jsonPath("$[*].image").exists())
				.andExpect(jsonPath("$[*].color").exists())
				.andExpect(jsonPath("$[*].additionalProducts").exists());

	}

	@Test
	public void testGetAllVehiclesByPersonId() throws Exception {
		Integer personId = 1;
		mockMvc.perform(get("/api/v1/vehicles?personId={personId}", personId)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].userName").exists())
				.andExpect(jsonPath("$[*].price").exists())
				.andExpect(jsonPath("$[*].year").exists())
				.andExpect(jsonPath("$[*].km").exists())
				.andExpect(jsonPath("$[*].brand").exists())
				.andExpect(jsonPath("$[*].model").exists())
				.andExpect(jsonPath("$[*].caseType").exists())
				.andExpect(jsonPath("$[*].fuel").exists())
				.andExpect(jsonPath("$[*].gear").exists())
				.andExpect(jsonPath("$[*].engine").exists())
				.andExpect(jsonPath("$[*].packageName").exists())
				.andExpect(jsonPath("$[*].image").exists())
				.andExpect(jsonPath("$[*].color").exists())
				.andExpect(jsonPath("$[*].additionalProducts").exists());

	}

	@Test
	public void testCheckLogin() throws Exception {
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		loginRequestDTO.setUserName("elif35");
		loginRequestDTO.setPassword("admin");

		mockMvc.perform(post("/api/v1/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(loginRequestDTO)))
				.andExpect(jsonPath("$.personId").exists())
				.andExpect(jsonPath("$.userType").value("admin"))
				.andExpect(jsonPath("$.loginCheck").value(true));
	}

	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
