package com.codingexercise.state;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.codingexercise.state.controller.StateController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StateController.class, secure = false)
@ComponentScan(basePackages = "com.codingexercise.state")
public class StateMicroserviceTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetStatesByName() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/states/Colorado");
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("id", is(6)))
									   .andExpect(jsonPath("country", is("USA")))
									   .andExpect(jsonPath("name", is("Colorado")))
									   .andExpect(jsonPath("abbr", is("CO")))
									   .andExpect(jsonPath("area", is("103642SKM")))
									   .andExpect(jsonPath("largest_city", is("Denver")))
									   .andExpect(jsonPath("capital", is("Denver")));
	}

	@Test
	public void testGetAlabamaAndGeorgia() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/states/ag");
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("states.size()", is(2)));
	}

	@Test
	public void testGetAllStates() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/states");
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("states.size()", is(55)));
	}

}
