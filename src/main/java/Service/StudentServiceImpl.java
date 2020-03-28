package Service;

import Dao.Model.Student;
import Dao.StudentDao;
import Dao.StudentDaoImpl;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDaoObj;

    public StudentServiceImpl() {
        studentDaoObj = new StudentDaoImpl();
    }

    public List<Student> getAllStudents() {
        return studentDaoObj.getAllStudents();
    }

    public Student getStudentsByRoll(long studentRoll) {
        return studentDaoObj.getStudentsByRoll(studentRoll);
    }

    public List<Student> getStudentsByStream(String studentStream) {
        return studentDaoObj.getStudentsByStream(studentStream);
    }

    public int createOrUpdate(Student newStudent) {
        Student students = studentDaoObj.getStudentsByRoll(newStudent.getRollNo());
        if (students != null) {
            return studentDaoObj.updateStudent(newStudent);
        } else {
            return studentDaoObj.createStudents(newStudent);
        }
    }
}
