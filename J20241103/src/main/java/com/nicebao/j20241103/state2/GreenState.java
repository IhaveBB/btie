package com.nicebao.j20241103.state2;

/**
 * @author IhaveBB
 */
public class GreenState implements TrafficLightState {

	@Override
	public void switchButton(Context context) {
		System.out.println("信号灯变为红色。");
		context.setState(new RedState());
	}
}
