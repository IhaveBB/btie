package com.nicebao.state2;

/**
 * @name: YellowState
 * @author: IhaveBB
 * @date: 2024-11-04 20:31
 **/
public class YellowState extends TrafficLightState {
	public YellowState(Context context) {
		super(context);
		name="黄灯";
	}

	@Override
	public void switchButton() {
		System.out.println("信号灯变为绿色。");
		super.context.setState(new GreenState(context));
	}
}
