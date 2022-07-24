package com.cognizant.calculatenetworth;

import com.cognizant.calculatenetworth.controller.StockController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc

@SpringBootTest
class CalculateNetworthApplicationTests {

	@Autowired
	private StockController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	public void testGetAllMutualFunds() throws Exception {
		ResultActions actions = mockMvc.perform(get("/NetWorth/mutualfunds"));
		actions.andExpect(status().isOk());

	}


	@Test
	public void testGetStcokName() throws Exception {
		ResultActions actions = mockMvc.perform(get("/NetWorth//pershare/Amazon"));
		actions.andExpect(status().isOk());

	}



	@Test
	public void testGetAllStocks() throws Exception {
		ResultActions actions = mockMvc.perform(get("/NetWorth/shares"));
		actions.andExpect(status().isOk());

	}

}
