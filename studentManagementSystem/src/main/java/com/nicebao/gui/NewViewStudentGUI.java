package com.nicebao.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.nicebao.student.Student;
import com.nicebao.jdbc.StudentDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewViewStudentGUI extends JFrame {
	private JTextField searchField;
	private JTable studentTable;
	private DefaultTableModel tableModel;
	private StudentDAO studentDAO;

	public NewViewStudentGUI() {
		setTitle("学生管理");
		setSize(600, 400);
		setLocationRelativeTo(null);
		studentDAO = new StudentDAO(); // 初始化 StudentDAO

		JPanel panel = new JPanel(new BorderLayout());

		//给搜索区域放到一个流面板中
		JPanel searchPanel = new JPanel(new FlowLayout());
		JLabel searchLabel = new JLabel("输入学生姓名或学号:");
		searchField = new JTextField(15);
		JButton searchBtn = new JButton("搜索");
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchInput = searchField.getText();
				try {
					List students = new ArrayList<Student>();
					// 检查是否有输入内容，若没有则查询所有学生信息
					if (searchInput.isEmpty()) {
						students = studentDAO.getAllStudent();
					} else {
						//这里返回值使用list的原因是单纯不想再创一个变量来存信息了
						students = studentDAO.searchStudent(searchInput);
					}
					displayStudents(students);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		searchPanel.add(searchLabel);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);


		tableModel = new DefaultTableModel();
		studentTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(studentTable);

		tableModel.setColumnIdentifiers(new String[]{"学号", "姓名", "性别", "生日", "住址", "手机号"});

		panel.add(searchPanel, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);

//=============================================修改和删除区域======================================================
		// 添加修改和删除按钮
		JButton modifyBtn = new JButton("修改");
		JButton deleteBtn = new JButton("删除");

		// 存放按钮
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(modifyBtn);
		buttonPanel.add(deleteBtn);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		//”修改“按钮时间
		//获取选中行的数据，然后创建一个新的窗口，在新的窗口中进行修改？
		modifyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();
				if(selectedRow == -1){
					JOptionPane.showMessageDialog(NewViewStudentGUI.this, "请选择要修改的行！");
				}else{
					// 获取选中行的数据，作为编辑区的默认数据
					long studentId = (long) studentTable.getValueAt(selectedRow, 0);
					String name = (String) studentTable.getValueAt(selectedRow, 1);
					//修改信息时，此处性别故意设置为输入框:)，-\‘ ’/-
					String gender = (String) studentTable.getValueAt(selectedRow, 2);
					String birthdate = (String) studentTable.getValueAt(selectedRow, 3);

					String address = (String) studentTable.getValueAt(selectedRow, 4);
					String phoneNumber = (String) studentTable.getValueAt(selectedRow, 5);

					// 创建一个新的对话框来编辑数据
					JFrame editFrame = new JFrame("编辑学生信息");
					JPanel editPanel = new JPanel(new GridLayout(7, 2));

					JLabel idLabel = new JLabel("学号:");
					JTextField idField = new JTextField(String.valueOf(studentId));
					//这里设置学号不可变！
					idField.setEditable(false);

					JLabel nameLabel = new JLabel("姓名:");
					JTextField nameField = new JTextField(name);

					JLabel genderLabel = new JLabel("性别:");
					JTextField genderField = new JTextField(gender);

					JLabel birthLabel = new JLabel("生日:");
					JTextField birthField = new JTextField(birthdate);

					JLabel addressLabel = new JLabel("住址:");
					JTextField addressField = new JTextField(address);

					JLabel phoneLabel = new JLabel("手机号:");
					JTextField phoneField = new JTextField(phoneNumber);

					JButton updateButton = new JButton("完成");
					updateButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {


							// 获取编辑后的新数据
							String updatedName = nameField.getText();
							String updatedGender = genderField.getText();

							//处理日期格式错误输入问题
							StudentDAO studentDAO = new StudentDAO();
							String updatedBirthdate = Student.fixBirthdate(birthField.getText());

							String updatedAddress = addressField.getText();
							String updatedPhone = phoneField.getText();

							// 更新表格中的数据(还可以不更新，直接再调用一次查询语句即可)
							studentTable.setValueAt(updatedName, selectedRow, 1);
							studentTable.setValueAt(updatedGender, selectedRow, 2);
							studentTable.setValueAt(updatedBirthdate, selectedRow, 3);
							studentTable.setValueAt(updatedAddress, selectedRow, 4);
							studentTable.setValueAt(updatedPhone, selectedRow, 5);

							//更新数据库汇总的数据
							Student updatedStudent = new Student(studentId, updatedName, updatedGender, updatedBirthdate, updatedAddress, updatedPhone);
							try {
								studentDAO.updateStudent(updatedStudent);
							} catch (SQLException ex) {
								throw new RuntimeException(ex);
							}
							editFrame.dispose();
						}
					});

					JButton cancelButton = new JButton("取消");
					cancelButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							editFrame.dispose(); // 取消编辑并关闭编辑框
						}
					});
					// 将编辑组件添加到面板中
					editPanel.add(idLabel);
					editPanel.add(idField);
					editPanel.add(nameLabel);
					editPanel.add(nameField);
					editPanel.add(genderLabel);
					editPanel.add(genderField);
					editPanel.add(birthLabel);
					editPanel.add(birthField);
					editPanel.add(addressLabel);
					editPanel.add(addressField);
					editPanel.add(phoneLabel);
					editPanel.add(phoneField);
					editPanel.add(updateButton);
					editPanel.add(cancelButton);
					editFrame.add(editPanel);
					editFrame.setSize(400, 300);
					editFrame.setVisible(true);
				}
			}
		});



		//“删除”按钮动作
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//选中删除行
				int selectedRow = studentTable.getSelectedRow();
				if(selectedRow == -1){
					JOptionPane.showMessageDialog(NewViewStudentGUI.this, "请选择要删除的行！");
				}else{
					int confirmDialog = JOptionPane.showConfirmDialog(NewViewStudentGUI.this, "确定要删除所选行吗？", "确认删除", JOptionPane.YES_NO_OPTION);
					if (confirmDialog == JOptionPane.YES_OPTION) {
						long studentId = (long) studentTable.getValueAt(selectedRow, 0);

						try {
							studentDAO.deleteStudent(studentId);
						} catch (SQLException ex) {
							throw new RuntimeException(ex);
						}
						List<Student> updatedStudents = null;
						try {
							updatedStudents = studentDAO.getAllStudent();
						} catch (SQLException ex) {
							throw new RuntimeException(ex);
						}
						displayStudents(updatedStudents);
					}
				}
			}
		});

		add(panel);
	}


	/** @description: 将学生信息添加到表格之中
			* @param: List
			* @return: void
			* @author: IhaveBB
			* @date: 2023/11/25
			*/
	private void displayStudents(List<Student> students) {
		tableModel.setRowCount(0); // 清空表格
		for (Student student : students) {
			Object[] rowData = {student.getStudentId(), student.getName(), student.getGender(), student.getBirthdate(), student.getAddress(), student.getPhoneNumber()};
			tableModel.addRow(rowData); // 添加每个学生信息到表格
		}
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new NewViewStudentGUI().setVisible(true);
			}
		});
	}
}
