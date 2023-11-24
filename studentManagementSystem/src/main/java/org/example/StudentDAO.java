package org.example;
import org.example.DatabaseConnector;
import org.example.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentDAO {
	private Connection connection;

	/** @description: 与数据库进行交互
	 * 数据库账号：root
	 * 		密码：root
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
	public void addStudent(Student student) {
		String query = "INSERT INTO students (studentId, name, gender, birthdate, address, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, student.getStudentId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getBirthdate());
			preparedStatement.setString(5, student.getAddress());
			preparedStatement.setString(6, student.getPhoneNumber());
			//执行此PreparedStatement对象中的 SQL 语句
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/** @description: 查询
	 * @param: org.example.Student
	 * @return: org.example.Student
	 * @author: IhaveBB
	 * @date: 2023/11/24
	 */
	public Student searchStudent(String string) throws SQLException {
		String studentName;
		long studentId;
		Student student = new Student();
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
			student.setStudentId(resultSet.getLong("studentId"));
			student.setName(resultSet.getString("name"));
			student.setGender(resultSet.getString("gender"));
			student.setBirthdate(resultSet.getString("birthdate"));
			student.setAddress(resultSet.getString("address"));
			student.setPhoneNumber(resultSet.getString("phoneNumber"));
		}
		return student;
	}

	/** @description: 通过matches方法判断String类型的数值中，时候只包含数字。
	 * @param: String
	 * @return: boolean
	 * @author: IhaveBB
	 * @date: 2023/11/24
	 */
	public boolean isNumber(String str){

		return str.matches("//d+");
	}

	// 其他操作方法，如根据学号检索学生信息等
}
//CREATE TABLE IF NOT EXISTS students (
//    studentId INT PRIMARY KEY AUTO_INCREMENT,
//    name VARCHAR(50) NOT NULL,
//    gender VARCHAR(10) NOT NULL,
//    birthdate DATE,
//    address VARCHAR(100),
//    phoneNumber VARCHAR(15)
//);