package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentGUI extends JFrame {
	private JTextField studentIdField, nameField, genderField, birthdateField, addressField, phoneNumberField;

	public AddStudentGUI() {
		setTitle("学生-新增");
		setSize(500, 600);

		JPanel panel = new JPanel(new GridLayout(7, 2));

		JLabel studentIdLabel = new JLabel("学号:");
		studentIdField = new JTextField();
		panel.add(studentIdLabel);
		panel.add(studentIdField);

		JLabel nameLabel = new JLabel("姓名:");
		nameField = new JTextField();
		panel.add(nameLabel);
		panel.add(nameField);

		JLabel genderLabel = new JLabel("性别:");
		genderField = new JTextField();
		panel.add(genderLabel);
		panel.add(genderField);

		JLabel birthdateLabel = new JLabel("生日:");
		birthdateField = new JTextField();
		panel.add(birthdateLabel);
		panel.add(birthdateField);

		JLabel addressLabel = new JLabel("住址:");
		addressField = new JTextField();
		panel.add(addressLabel);
		panel.add(addressField);

		JLabel phoneNumberLabel = new JLabel("手机号:");
		phoneNumberField = new JTextField();
		panel.add(phoneNumberLabel);
		panel.add(phoneNumberField);

		JButton confirmBtn = getjButton();

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 关闭窗口
			}
		});
		panel.add(confirmBtn);
		panel.add(cancelBtn);
		add(panel);
	}

	private JButton getjButton() {
		JButton confirmBtn = new JButton("提交");
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取用户输入的信息
				long studentId = Long.parseLong(studentIdField.getText());
				String name = nameField.getText();
				String gender = genderField.getText();
				String birthdate = birthdateField.getText();
				String address = addressField.getText();
				String phoneNumber = phoneNumberField.getText();

				// 创建学生对象
				Student student = new Student(studentId, name, gender, birthdate, address, phoneNumber);

				// 调用StudentDAO来添加学生信息到数据库
				StudentDAO studentDAO = new StudentDAO();
				studentDAO.addStudent(student);

				// 清空文本框
				studentIdField.setText("");
				nameField.setText("");
				genderField.setText("");
				birthdateField.setText("");
				addressField.setText("");
				phoneNumberField.setText("");
			}
		});
		return confirmBtn;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AddStudentGUI().setVisible(true);
			}
		});
	}
}
