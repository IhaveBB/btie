package com.nicebao.j20241103.state2;

/**
 * @name: Context
 * @author: IhaveBB
 * @date: 2024-10-31 20:38
 **/
public class Context {
	private TrafficLightState state;

	public TrafficLightState getState() {
		return state;
	}
	public void setState(TrafficLightState state) {
		this.state = state;
	}

	public void print() {
		state.print();
	}
	public void switchButton() {
		state.switchButton();
	}

	public Context() {
		this.state = new GreenState(this);
	}
}
