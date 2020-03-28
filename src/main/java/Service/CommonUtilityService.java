package Service;
import java.util.Date;
public interface CommonUtilityService {

    Date parseIntoDate (String studentDateOfJoining);
    java.sql.Date parseIntoSqlDate (Date studentDateOfJoining);
}
