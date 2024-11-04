package com.nicebao.j20241103.state2;

/**
 * @name: TrafficLightState
 * @author: IhaveBB
 * @date: 2024-10-31 20:37
 **/
public abstract class TrafficLightState {
	protected Context context;
	protected String name;


	public TrafficLightState(Context context) {
		this.context = context;
	}

	public void print(){
		System.out.println("当前的状态是"+name);
		System.out.println("===================================");
	}

	public abstract void switchButton();

}
