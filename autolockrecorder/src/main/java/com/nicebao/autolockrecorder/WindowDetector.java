package com.nicebao.autolockrecorder;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class WindowDetector {

	public static String getActiveWindowTitle() {
		char[] buffer = new char[1024];
		WinDef.HWND hwnd = User32.INSTANCE.GetForegroundWindow();
		User32.INSTANCE.GetWindowText(hwnd, buffer, 1024);
		return Native.toString(buffer);
	}
}
