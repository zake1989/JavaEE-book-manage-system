/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author stephen
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Converter {

    public static String convertString(String password) {
        try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
    }
    
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
    
    public static String convertDate(Date d) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(d);
    }
    
    public static Date getExpectReturnDate(int i) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, i);
        return cal.getTime();
    }
}

