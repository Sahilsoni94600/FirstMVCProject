package Dao;
import Dao.Model.Student;
import Service.CommonUtilityService;
import Service.CommonUtilityServiceImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private Connection con;

    public StudentDaoImpl () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB", "root", "Sahil@94600");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("Duplicates")
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Student");
            while (rs.next())
            {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setRollNo(rs.getLong(2));
                student.setStream(rs.getString(3));
                student.setYearlyFee(rs.getBigDecimal(4));
                student.setDateOfJoining(rs.getDate(5));

                students.add(student);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return students;
    }

    @SuppressWarnings("Duplicates")
    public Student getStudentsByRoll(long studentRoll) {
        Student students = new Student();
        String sqlQuery = "Select * from Student where RollNo =  '" + studentRoll + "'";

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next())
            {
                students.setName(rs.getString(1));
                students.setRollNo(rs.getLong(2));
                students.setStream(rs.getString(3));
                students.setYearlyFee(rs.getBigDecimal(4));
                students.setDateOfJoining(rs.getDate(5));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return students;
    }

    @SuppressWarnings("Duplicates")
    public List<Student> getStudentsByStream(String studentStream) {
        List<Student> students = new ArrayList<Student>();
        String sqlQuery = "Select * from Student where Stream = '" + studentStream + "'";

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setRollNo(rs.getLong(2));
                student.setStream(rs.getString(3));
                student.setYearlyFee(rs.getBigDecimal(4));
                student.setDateOfJoining(rs.getDate(5));

                students.add(student);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return students;
    }

    public int createStudents(Student newStudent) {
        CommonUtilityService commonUtilityServiceObj = new CommonUtilityServiceImpl();
        java.sql.Date sqlDateOfJoining = commonUtilityServiceObj.parseIntoSqlDate(newStudent.getDateOfJoining());
        int count = 0;
        try {

            PreparedStatement pdst = con.prepareStatement("INSERT into Student values (?, ?, ?, ?, ?)");
            pdst.setString(1, newStudent.getName());
            pdst.setLong(2, newStudent.getRollNo());
            pdst.setString(3, newStudent.getStream());
            pdst.setBigDecimal(4, newStudent.getYearlyFee());
            pdst.setDate(5, sqlDateOfJoining);

            count = pdst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public int updateStudent(Student newStduent) {

        int count = 0;
        CommonUtilityService commonUtilityServiceObj = new CommonUtilityServiceImpl();
        java.sql.Date sqlDateOfJoining = commonUtilityServiceObj.parseIntoSqlDate(newStduent.getDateOfJoining());
        String sqlQuery = "Update Student set Name = '" + newStduent.getName() + "', RollNo = '" + newStduent.getRollNo() + "', Stream = '" + newStduent.getStream() + "', YearlyFee = '" + newStduent.getYearlyFee() + "', DateOfJoining = '" + sqlDateOfJoining + "' where RollNo = '" + newStduent.getRollNo() +"'";
        try {

            PreparedStatement pdst = con.prepareStatement(sqlQuery);

            count = pdst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
}
