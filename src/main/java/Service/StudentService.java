package Service;

import Dao.Model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentsByRoll(long studentRoll);

    List<Student> getStudentsByStream(String studentStream);

    int createOrUpdate(Student newStudent);

}
