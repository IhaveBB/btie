package com.nicebao.autolockrecorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by IhaveBB on 2024/8/12 16:44
 * @author IhaveBB
 */
public class exitProcess {
	public static boolean exitProcess(String programName) {
			// 使用ProcessBuilder来执行tasklist命令
			ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
			Process process = null;
			try {
				process = processBuilder.start();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				boolean isProgramRunning = false;

				String line;
				while ((line = reader.readLine()) != null) {
					if (line.contains(programName)) {
						System.out.println("该程序正在运行！");
						isProgramRunning = true;
					}
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		return false;
	}
}
