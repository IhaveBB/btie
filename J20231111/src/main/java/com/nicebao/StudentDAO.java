package com.nicebao;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private static List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public void deleteStudent(String studentId) {
		students.removeIf(student -> student.getId().equals(studentId));
	}

	public void updateStudent(Student updatedStudent) {
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (student.getId().equals(updatedStudent.getId())) {
				students.set(i, updatedStudent);
				break;
			}
		}
	}
}
