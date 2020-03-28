package Service;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtilityServiceImpl implements CommonUtilityService {

    public Date parseIntoDate(String studentDateOfJoining) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(studentDateOfJoining);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }

    public java.sql.Date parseIntoSqlDate (Date studentDateOfJoining) {
        java.sql.Date sqlDateOfJoining = new java.sql.Date(studentDateOfJoining.getTime());
        return sqlDateOfJoining;
    }
}
