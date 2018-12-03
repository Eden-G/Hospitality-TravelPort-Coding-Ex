package com.codingexercise.state.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codingexercise.state.model.State;
import com.codingexercise.state.model.States;
import com.codingexercise.state.service.IStateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class StateController {
	
	@Autowired
	IStateService stateService;
	
	@ApiOperation(value = "Get Details of Alabama and Georgia")
	@GetMapping(value = "/states/ag", produces = MediaType.APPLICATION_JSON_VALUE)
	public States getSpecificStates() {
		
		return this.stateService.getAlabamaAndGeorgia();
	}
	
	@ApiOperation(value = "Get List of US States")
	@GetMapping(value = "/states", produces = MediaType.APPLICATION_JSON_VALUE)
	public States getStates() {
		
		return this.stateService.getAllStates();
	}
	
	@ApiOperation(value = "Get details of a state passed as path variable")
	@GetMapping(value = "/states/{stateName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public State getState(@PathVariable("stateName") String stateName) {
	
		return this.stateService.getStatesByName(stateName);
	}
	
}
