package com.nicebao.gui;

import com.nicebao.gui.AddStudentGUI;
import com.nicebao.gui.NewViewStudentGUI;
import com.nicebao.jdbc.DatabaseConnector;
import com.nicebao.jdbc.StudentDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MainGUI extends JFrame {
	private StudentDAO studentDAO;

	public MainGUI() {
		setTitle("学生管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

		JButton addStudentBtn = new JButton("添加学生");
		addStudentBtn.addActionListener(e -> {
			AddStudentGUI addStudentGUI = new AddStudentGUI();
			addStudentGUI.setVisible(true);
		});

		JButton manageStudentBtn = new JButton("管理学生");
		manageStudentBtn.addActionListener(e -> {
			NewViewStudentGUI viewStudentGUI = new NewViewStudentGUI();
			viewStudentGUI.setVisible(true);
		});

		JButton importBtn = new JButton("导入学生");
		importBtn.addActionListener(e -> {
			studentDAO = new StudentDAO();

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("选择 CSV 文件");
			//弹出“打开文件”文件选择器对话框
			int userSelection = fileChooser.showOpenDialog(null);
			//JFileChooser.APPROVE_OPTION 选中
			//JFileChooser.CANCEL_OPTION  取消
			//...
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				java.io.File fileToImport = fileChooser.getSelectedFile();
				try {
					studentDAO.importStudent(fileToImport);
				} catch (FileNotFoundException | SQLException ex) {
					throw new RuntimeException(ex);

				}
			}
		});

		JButton exportBtn = new JButton("导出学生");
		exportBtn.addActionListener(e -> {
			studentDAO = new StudentDAO();
			try {
				studentDAO.exportStudents();
			} catch (SQLException | IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		panel.add(addStudentBtn);
		panel.add(manageStudentBtn);
		panel.add(importBtn);
		panel.add(exportBtn);

		add(panel);
	}

	public static void main(String[] args) throws SQLException {
		new MainGUI().setVisible(true);
	}
}
