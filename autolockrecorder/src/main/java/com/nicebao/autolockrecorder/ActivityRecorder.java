package com.nicebao.autolockrecorder;


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

import java.util.logging.Logger;

/**
 * @author IhaveBB
 */
public class ActivityRecorder implements NativeKeyListener, NativeMouseListener {

	public void startRecording() {
		// 禁用JNativeHook的日志输出
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(java.util.logging.Level.OFF);

		try {
			GlobalScreen.registerNativeHook();
		} catch (Exception e) {
			e.printStackTrace();
		}

		GlobalScreen.addNativeKeyListener(this);
		GlobalScreen.addNativeMouseListener(this);
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// 记录键盘按键
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent e) {
		// 记录鼠标点击和坐标
		System.out.println("Mouse Clicked: " + e.getX() + ", " + e.getY());
	}

	// 实现其他必须的接口方法
}
