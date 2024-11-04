package com.nicebao.j20241103.state2;

/**
 * @name: RedState
 * @author: IhaveBB
 * @date: 2024-10-31 20:41
 **/
public class RedState extends TrafficLightState{
	public RedState(Context trafficLight) {
		super(trafficLight);
		super.name="红灯";
	}

	@Override
	public void switchButton() {
		System.out.println("信号灯变为黄色。");
		super.context.setState(new YellowState(context));
	}
}
