package com.nicebao.gui;

import com.nicebao.student.Student;
import com.nicebao.jdbc.StudentDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddStudentGUI extends JFrame {
	private JTextField studentIdField, nameField, genderField, birthdateField, addressField, phoneNumberField;
	private JRadioButton maleRadioButton, femaleRadioButton;
	public AddStudentGUI() {
		setTitle("学生-新增");
		setSize(400, 400);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel(new GridLayout(7, 2));

		JLabel studentIdLabel = new JLabel("学号:");
		studentIdField = new JTextField();
		panel.add(studentIdLabel);
		panel.add(studentIdField);

		JLabel nameLabel = new JLabel("姓名:");
		nameField = new JTextField();
		panel.add(nameLabel);
		panel.add(nameField);

		// 创建单选按钮组
		JLabel genderLabel = new JLabel("性别:");
		ButtonGroup genderGroup = new ButtonGroup();
		//添加男女的选项
		JPanel genderPanel = new JPanel(new GridLayout(1, 2));
		maleRadioButton = new JRadioButton("男");
		femaleRadioButton = new JRadioButton("女");

		genderGroup.add(maleRadioButton);
		genderGroup.add(femaleRadioButton);

		genderPanel.add(maleRadioButton);
		genderPanel.add(femaleRadioButton);

		panel.add(genderLabel);
		panel.add(genderPanel); // 将性别选项添加到主面板中

		JLabel birthdateLabel = new JLabel("生日:(输入格式 -> 年/月/日)");
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
				StudentDAO studentDAO = new StudentDAO();
				// 获取用户输入的信息

				//处理学号非数字问题
				long studentId;
				if(studentDAO.isNumber(studentIdField.getText())){
					 studentId = Long.parseLong(studentIdField.getText());
				}else{
					JOptionPane.showMessageDialog(null, "学号只可输入数字", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String name = nameField.getText();
				String gender ;
				if (maleRadioButton.isSelected()) {
					gender = "男";
				} else if (femaleRadioButton.isSelected()) {
					gender = "女";
				} else {
					gender = "";
				}

				//处理日期格式错误输入问题
				String birthdate = Student.fixBirthdate(birthdateField.getText());

				String address = addressField.getText();
				String phoneNumber = phoneNumberField.getText();

				// 创建学生对象
				Student student = new Student(studentId, name, gender, birthdate, address, phoneNumber);

				// 调用StudentDAO来添加学生信息到数据库
				try {
					studentDAO.addStudent(student);
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}

				// 清空文本框
				studentIdField.setText("");
				nameField.setText("");
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
