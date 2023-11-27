package com.nicebao;

import com.nicebao.gui.MainGUI;
import com.nicebao.jdbc.DatabaseConnector;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		DatabaseConnector.createTable();
		MainGUI mainGUI = new MainGUI();
		mainGUI.setVisible(true);
	}
}
