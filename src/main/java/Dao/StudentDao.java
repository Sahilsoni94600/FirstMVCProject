package Dao;

import Dao.Model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudentsByRoll(long studentRoll);

    List<Student> getStudentsByStream(String studentStream);

    int createStudents(Student newStudent);

    int updateStudent(Student newStudent);
}
