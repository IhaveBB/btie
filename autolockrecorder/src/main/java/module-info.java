module com.nicebao.autolockrecorder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
	requires com.github.kwhat.jnativehook;
	requires com.sun.jna.platform;
	requires com.sun.jna;

	opens com.nicebao.autolockrecorder to javafx.fxml;
    exports com.nicebao.autolockrecorder;
}