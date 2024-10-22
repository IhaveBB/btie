package com.nicebao.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @name: OnlineUserListener
 * @author: IhaveBB
 * @date: 2024-10-20 12:32
 **/
@WebListener
public class OnlineUserListener implements HttpSessionListener {
	private static int onlineCount = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		onlineCount++;
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		onlineCount--;
	}

	public static int getOnlineCount() {
		return onlineCount;
	}
}
