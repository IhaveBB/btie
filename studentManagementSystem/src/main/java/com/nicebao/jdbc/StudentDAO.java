package com.nicebao.jdbc;
import com.nicebao.student.Student;
import javafx.scene.input.DataFormat;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
	private Connection connection;

	/** @description: 与数据库进行交互
	 * 		url:mysql.sqlpub.com:3306
	 * 		账号：awfdgesw
	 * 		密码：aa6e90fa392cf0d9
	 * 		数据库名：student1125
	 * 		表明：students
	 * 		端口：3306
	 * 		地址：127.0.0.1
	 * 		版本：Mysql 5.7
	 * @param:
	 * @return:
	 * @author: IhaveBB
	 * @date: 2023/11/24
	 */
	public StudentDAO() {
		try {
			connection = DatabaseConnector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** @description: 添加学生信息
	 * @param: void
	 * @return: void
	 * @author: IhaveBB
	 * @date: 2023/11/24
	 */
	public void addStudent(Student student) throws SQLException {
		String query = "INSERT INTO students (studentId, name, gender, birthdate, address, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, student.getStudentId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getGender());
		preparedStatement.setString(4, student.getBirthdate());
		preparedStatement.setString(5, student.getAddress());
		preparedStatement.setString(6, student.getPhoneNumber());
		//执行此PreparedStatement对象中的 SQL 语句
		preparedStatement.executeUpdate();

	}


	/** @description: 查询
	 * @param: org.example.Student
	 * @return: org.example.Student
	 * @author: IhaveBB
	 * @date: 2023/11/24
	 */
	public List searchStudent(String string) throws SQLException {
		String studentName;
		long studentId;
		List<Student> students = new ArrayList<Student>();
		//判断输入信息是学号还是姓名？
		if(isNumber(string)){
			studentId = Long.parseLong(string);
			//更新初始值，方便与数据库交互
			studentName = null;
		}else{
			studentName = string;
			//更新初始值，方便与数据库交互
			studentId = -1;
		}
		String query = "SELECT * FROM students WHERE name = ? OR studentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, studentName);
		preparedStatement.setLong(2, studentId);

		//在此 PreparedStatement 对象中执行 SQL 查询，并返回 ResultSet 查询生成的对象。
		//ResultSet表示数据库结果集的数据表，通常通过执行查询数据库的语句来生成。
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Student student = new Student();
			student.setStudentId(resultSet.getLong("studentId"));
			student.setName(resultSet.getString("name"));
			student.setGender(resultSet.getString("gender"));
			student.setBirthdate(resultSet.getString("birthdate"));
			student.setAddress(resultSet.getString("address"));
			student.setPhoneNumber(resultSet.getString("phoneNumber"));
			students.add(student);
		}
		return students;
	}

	/** @description: 通过matches方法判断String类型的数值中，是否只包含数字。
	 * @param: String
	 * @return: boolean
	 * @author: IhaveBB
	 * @date: 2023/11/24
	 */
	public boolean isNumber(String str){
		//记住是反斜杠！
		return str.matches("\\d+");
	}


	/** @description: 查找全部学生信息,然后存放在一个链表中
			* @param: void
			* @return: java.util.List<org.example.Student>
			* @author: IhaveBB
			* @date: 2023/11/25
			*/
	public List<Student> getAllStudent() throws SQLException {
		List<Student> students = new ArrayList<>();
		String query = "SELECT * FROM students";
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()){
			Student student = new Student();
			student.setStudentId(resultSet.getLong("studentId"));
			student.setName(resultSet.getString("name"));
			student.setGender(resultSet.getString("gender"));
			student.setBirthdate(resultSet.getString("birthdate"));
			student.setAddress(resultSet.getString("address"));
			student.setPhoneNumber(resultSet.getString("phoneNumber"));
			students.add(student);
		}
		return students;
	}
	/** @description: 删除操作
			* @param: long
			* @return: void
			* @author: IhaveBB
			* @date: 2023/11/25
			*/
	public void deleteStudent(long studentId) throws SQLException {
		String query = "DELETE FROM students WHERE studentId = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, studentId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** @description: 更新数据库数据
			* @param: Student
			* @return: void
			* @author: IhaveBB
			* @date: 2023/11/25
			*/
	public void updateStudent(Student student) throws SQLException {
		String query = "UPDATE students SET name = ?, gender = ?, birthdate = ?, address = ?, phoneNumber = ? WHERE studentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, student.getName());
		preparedStatement.setString(2, student.getGender());
		preparedStatement.setString(3, student.getBirthdate());
		preparedStatement.setString(4, student.getAddress());
		preparedStatement.setString(5, student.getPhoneNumber());
		preparedStatement.setLong(6, student.getStudentId());
		preparedStatement.executeUpdate();
	}
	
	/** @description: 导出学生数据，使用CSV格式来存储
			* @param: void
			* @return: void
			* @author: IhaveBB
			* @date: 2023/11/25
			*/
	public void exportStudents() throws SQLException, IOException {
		String query = "select * from students";
		// 创建 CSV 文件并写入数据
		File file = new File("students.csv");
		Writer writer = new FileWriter(file);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()){
			long studentId = resultSet.getLong("studentId");
			String name = resultSet.getString("name");
			String gender = resultSet.getString("gender");
			String birthdate = resultSet.getString("birthdate");
			String address = resultSet.getString("address");
			String phoneNumber = resultSet.getString("phoneNumber");
			writer.write(studentId + "," + name + "," + gender + "," + birthdate + "," + address + "," + phoneNumber + "\n");
		}
		writer.close();
		System.out.println("文件已成功导出");
		String exportPath = file.getAbsolutePath();
		JOptionPane.showMessageDialog(null, "文件已成功导出至:\n" + exportPath);
	}


	/** @description: 导入文件
			* @param: 文件路径
			* @return: void
			* @author: IhaveBB
			* @date: 2023/11/25
			*/
	public void importStudent(java.io.File fileToImport) throws FileNotFoundException, SQLException {
		String insertQuery = "INSERT INTO students (studentId, name, gender, birthdate, address, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

		File file = new File(String.valueOf(fileToImport));
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] data = line.split(",");
			long studentId = Long.parseLong(data[0]);
			String name = data[1];
			String gender = data[2];
			String birthdate = data[3];
			String address = data[4];
			String phoneNumber = data[5];

			// 插入到数据库中
			preparedStatement.setLong(1, studentId);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, gender);
			preparedStatement.setString(4, birthdate);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, phoneNumber);
			preparedStatement.executeUpdate();
			System.out.println("CSV文件数据成功导入到数据库！");
		}
	}

}

