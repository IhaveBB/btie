package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViewStudentGUI extends JFrame {

	public ViewStudentGUI() {
		setTitle("查看学生信息");
		setSize(400, 300);

		JPanel panel = new JPanel(new BorderLayout());

		//显示查询结果
		JTextArea displayArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(displayArea);

		//单独用一个流面板存放查询操作
		JPanel searchPanel = new JPanel(new FlowLayout());
		JLabel searchLabel = new JLabel("输入ID或学号:");
		JTextField searchField = new JTextField(15);
		JButton searchBtn = new JButton("查询");
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchInput = searchField.getText();
				StudentDAO studentDAO = new StudentDAO();
				try {
					Student student = studentDAO.searchStudent(searchInput);
					if (student != null) {
						displayArea.setText("查询结果：" + student.toString());
					} else {
						displayArea.setText("未找到匹配学生信息");
					}
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		searchPanel.add(searchLabel);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);



		//新建一个流面板存储学生信息操作界面
		JPanel btnPanel = new JPanel(new FlowLayout());
		JButton modifyBtn = new JButton("修改");
		JButton deleteBtn = new JButton("删除");
		JButton addNewBtn = new JButton("添加");
		btnPanel.add(modifyBtn);
		btnPanel.add(deleteBtn);
		btnPanel.add(addNewBtn);

		panel.add(searchPanel, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(btnPanel, BorderLayout.SOUTH);

		add(panel);
		//查
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ViewStudentGUI().setVisible(true);
			}
		});
	}




}

