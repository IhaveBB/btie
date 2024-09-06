package com.nicebao.autolockrecorder;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author IhaveBB
 */
public class InactivityMonitor {
	private static final long LOCK_TIME_MS = 5 * 60 * 1000;

	private Timer inactivityTimer;
	private long lastActivityTime;

	public InactivityMonitor() {
		inactivityTimer = new Timer(true);
		lastActivityTime = System.currentTimeMillis();
	}

	public void start() {
		inactivityTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					checkInactivity();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}, 0, 1000);
	}

	public void resetTimer() {
		lastActivityTime = System.currentTimeMillis();
	}

	private void checkInactivity() throws IOException {
		if (System.currentTimeMillis() - lastActivityTime > LOCK_TIME_MS) {
			lockScreen();
		}
	}

	private void lockScreen() throws IOException {
		// 调用Windows API进行锁屏
		Runtime.getRuntime().exec("rundll32.exe user32.dll,LockWorkStation");
	}
}
