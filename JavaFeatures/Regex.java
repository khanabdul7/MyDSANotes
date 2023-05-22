package JavaFeatures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * W.A.P to validate a given SSN number and E-mail using regex. valid format for SSN: 123-85-3456
 * */
public class Regex {

    public static boolean validateSSN(String number){
        Pattern regex = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
        Matcher ssnMatcher = regex.matcher(number);
        return ssnMatcher.matches();
    }

    public static boolean validateMail(String address){
        Pattern regex = Pattern.compile("[a-zA-Z0-9_.]+@[a-zA-Z0-9.]+");
        Matcher mailMatcher = regex.matcher(address);
        return mailMatcher.matches();
    }
    public static void main(String[] args){
        System.out.println("SSN: "+validateSSN("456-78-1234"));
        System.out.println("E-Mail: "+validateMail("Tom_Jerry@infosys.com"));

    }
}
