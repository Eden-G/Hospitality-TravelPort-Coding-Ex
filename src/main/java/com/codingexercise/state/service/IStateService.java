package com.codingexercise.state.service;

import com.codingexercise.state.model.State;
import com.codingexercise.state.model.States;

public interface IStateService {
	public States getAllStates();
	public States getAlabamaAndGeorgia();
	public State getStatesByName(String state);
}
