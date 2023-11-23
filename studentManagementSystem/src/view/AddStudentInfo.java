package view;

import view.Student;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddStudentInfo extends JFrame implements ActionListener {
	JTextField idField, nameField, sexField, birthdayField, addressField, phoneField, dataIdField;
	JButton addButton;

	public AddStudentInfo() {
		setTitle("添加学生信息");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		add(panel);
		placeComponents(panel);

		setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel idLabel = new JLabel("学号:");
		idLabel.setBounds(30, 20, 80, 25);
		panel.add(idLabel);

		idField = new JTextField(20);
		idField.setBounds(120, 20, 200, 25);
		panel.add(idField);

		// Add other labels and text fields for name, sex, birthday, address, phone, dataId as per your requirement

		addButton = new JButton("添加");
		addButton.setBounds(150, 220, 100, 25);
		addButton.addActionListener(this);
		panel.add(addButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			// Fetch values from text fields
			String id = idField.getText();
			// Fetch other student information similarly

			// Create a Student object using the entered information
			Student student = new Student(id, /*other info*/);

			// Save student data to a file
			saveStudentToFile(student);

			JOptionPane.showMessageDialog(this, "学生信息已添加！");
		}
	}

	private void saveStudentToFile(Student student) {
		try (FileWriter writer = new FileWriter("student_data.txt", true)) {
			// Append student data to the file
			writer.write(student.toString() + "\n");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "保存学生信息出错：" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(AddStudentInfo::new);
	}
}
