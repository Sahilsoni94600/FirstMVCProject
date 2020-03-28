package Dao.Model;

import Dao.StudentDao;

import java.math.BigDecimal;
import java.util.Date;

public class Student {

    private String name;
    private long rollNo;
    private String stream;
    private BigDecimal yearlyFee;
    private Date dateOfJoining;

    public Student(String studentName, long studentRollNo, String studentStream, BigDecimal studentYearlyFee, Date studentDateOfJoining) {
        setName(studentName);
        setRollNo(studentRollNo);
        setStream(studentStream);
        setYearlyFee(studentYearlyFee);
        setDateOfJoining(studentDateOfJoining);
    }

    public Student () {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public long getRollNo() {
        return rollNo;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }

    public void setYearlyFee(BigDecimal yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public BigDecimal getYearlyFee() {
        return yearlyFee;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }
}
