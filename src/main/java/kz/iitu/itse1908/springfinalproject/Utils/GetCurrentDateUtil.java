package kz.iitu.itse1908.springfinalproject.Utils;

public class GetCurrentDateUtil {
    public static String getCurrentDateInStringFormat(){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String dateOfCreation = date.toString();
        return dateOfCreation;
    }
}
