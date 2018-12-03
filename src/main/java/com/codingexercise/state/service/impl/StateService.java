package com.codingexercise.state.service.impl;

import java.io.IOException;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.codingexercise.state.model.State;
import com.codingexercise.state.model.States;
import com.codingexercise.state.service.IStateService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("stateService")
public class StateService implements IStateService {
	@Autowired
	RestTemplate restTemplate;

	private static final String STATES_URL = "http://services.groupkt.com/state/get/USA/all";

	@Override
	public States getAlabamaAndGeorgia() {

		ResponseEntity<String> eventsEntity = this.restTemplate.getForEntity(STATES_URL, String.class);
		String stateJson = eventsEntity.getBody();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(stateJson);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading array of objects
		JsonNode states = rootNode.path("RestResponse").path("result");
		Iterator<JsonNode> hitsElements = states.elements();
		States statesJavaObject = new States();
		while (hitsElements.hasNext()) {
			JsonNode myState = hitsElements.next();
			if (myState.path("name").asText().equalsIgnoreCase("Alabama")
					|| myState.path("name").asText().equalsIgnoreCase("Georgia")) {
				State state = new State(myState.path("id").asInt(), myState.path("country").asText(),
						myState.path("name").asText(), myState.path("abbr").asText(), myState.path("area").asText(),
						myState.path("largest_city").asText(), myState.path("capital").asText());
				statesJavaObject.addState(state);
			}

		}

		return statesJavaObject;
	}
	
	@Override
	public States getAllStates() {

		ResponseEntity<String> eventsEntity = this.restTemplate.getForEntity(STATES_URL, String.class);
		String stateJson = eventsEntity.getBody();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(stateJson);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading array of objects
		JsonNode states = rootNode.path("RestResponse").path("result");
		Iterator<JsonNode> hitsElements = states.elements();
		States statesJavaObject = new States();
		while (hitsElements.hasNext()) {
			JsonNode myState = hitsElements.next();
			State state = new State(myState.path("id").asInt(), myState.path("country").asText(),
					myState.path("name").asText(), myState.path("abbr").asText(), myState.path("area").asText(),
					myState.path("largest_city").asText(), myState.path("capital").asText());
			statesJavaObject.addState(state);

		}

		return statesJavaObject;
	}
	@Override
	public State getStatesByName(String state) {
		ResponseEntity<String> eventsEntity = this.restTemplate.getForEntity(STATES_URL, String.class);
		String stateJson = eventsEntity.getBody();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(stateJson);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading array of objects
		JsonNode states = rootNode.path("RestResponse").path("result");
		Iterator<JsonNode> hitsElements = states.elements();
		State stateObject = null;
		while (hitsElements.hasNext()) {
			JsonNode myState = hitsElements.next();
			if (myState.path("name").asText().equalsIgnoreCase(state)) {
				 stateObject = new State(myState.path("id").asInt(), myState.path("country").asText(),
						myState.path("name").asText(), myState.path("abbr").asText(), myState.path("area").asText(),
						myState.path("largest_city").asText(), myState.path("capital").asText());
			}

		}

		return stateObject;
	}

}
