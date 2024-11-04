package com.nicebao.state2;

import com.nicebao.state2.GreenState;
import com.nicebao.state2.RedState;
import com.nicebao.state2.YellowState;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLightGUI extends Application {
	private Circle redLight;
	private Circle yellowLight;
	private Circle greenLight;
	private Context context;

	@Override
	public void start(Stage primaryStage) {
		context = new Context();

		redLight = createLight(Color.RED);
		yellowLight = createLight(Color.YELLOW);
		greenLight = createLight(Color.GREEN);

		Button switchButton = new Button("Switch Light");
		switchButton.setOnAction(e -> {
			context.switchButton();
			updateLights();
		});

		VBox vbox = new VBox(10, redLight, yellowLight, greenLight, switchButton);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20));
		vbox.setStyle("-fx-background-color: white;");

		Scene scene = new Scene(vbox, 200, 400);
		primaryStage.setTitle("Traffic Light");
		primaryStage.setScene(scene);
		primaryStage.show();

		updateLights();
	}

	private Circle createLight(Color color) {
		Circle circle = new Circle(40);
		circle.setFill(Color.LIGHTGRAY);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(2);
		return circle;
	}

	private void updateLights() {
		redLight.setFill(context.getState() instanceof RedState ? Color.RED : Color.LIGHTGRAY);
		yellowLight.setFill(context.getState() instanceof YellowState ? Color.YELLOW : Color.LIGHTGRAY);
		greenLight.setFill(context.getState() instanceof GreenState ? Color.GREEN : Color.LIGHTGRAY);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
