package com.codingexercise.state.model;

import java.util.ArrayList;
import java.util.List;

public class States {
	
	private List<State> states = new ArrayList<>();
	
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	public void addState(State state) {
		this.states.add(state);
	}
	

	@Override
	public String toString() {
		return "States [states=" + states + "]";
	}
	
}
