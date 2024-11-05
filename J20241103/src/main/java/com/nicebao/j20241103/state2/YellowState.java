package com.nicebao.j20241103.state2;

/**
 * @name: YellowState
 * @author: IhaveBB
 * @date: 2024-11-04 20:31
 **/
public class YellowState implements TrafficLightState {

	@Override
	public void switchButton(Context context) {
		System.out.println("信号灯变为绿色。");
		context.setState(new GreenState());
	}


}
