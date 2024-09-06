package com.nicebao.autolockrecorder;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Silent Monitoring App");
		primaryStage.setIconified(true);
		primaryStage.setOnCloseRequest(e -> System.exit(0));
		primaryStage.show();

		ActivityRecorder recorder = new ActivityRecorder();
		recorder.startRecording();

		InactivityMonitor monitor = new InactivityMonitor();
		monitor.start();
		// 根据需求，检测特定窗口或其他条件来启动监控
		String windowTitle = WindowDetector.getActiveWindowTitle();
		if (windowTitle.equals("DesiredWindowName")) {
			// 启动监控
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
