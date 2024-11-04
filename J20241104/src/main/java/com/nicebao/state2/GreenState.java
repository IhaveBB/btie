package com.nicebao.state2;

/**
 * @author IhaveBB
 */
public class GreenState extends TrafficLightState {
	public GreenState(Context context) {
		super(context);
		name="绿灯";
	}

	@Override
	public void switchButton() {
		System.out.println("信号灯变为红色。");
		super.context.setState(new RedState(context));
	}
}
