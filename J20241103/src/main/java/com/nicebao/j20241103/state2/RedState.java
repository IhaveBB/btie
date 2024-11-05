package com.nicebao.j20241103.state2;

/**
 * @name: RedState
 * @author: IhaveBB
 * @date: 2024-10-31 20:41
 **/
public class RedState implements TrafficLightState{

	@Override
	public void switchButton(Context context) {
		System.out.println("信号灯变为黄色。");
		context.setState(new YellowState());
	}
}
