package regex;

import java.util.regex.Pattern;

public class regexPractice {

    public static void main(String[] args) {

        String pattern = "[2]{4,6}";
        String pattern1 = "^[0-9]*$";
        String pattern2 = ".+";
        String pattern3 = ".*";
        String pattern4 = ".?";
        String pattern5 = "[\\d]+";
        String pattern6 = "[\\%]";

        String str = "2222222";
        String str1 = "123";
        String str2 = "..";
        String str3 = "..";
        String str4 = "..";
        String str5 = "12";
        String str6 = "%";

        boolean result = Pattern.matches(pattern, str);
        boolean result1 = Pattern.matches(pattern1, str1);
        boolean result2 = Pattern.matches(pattern2, str2);
        boolean result3 = Pattern.matches(pattern3, str3);
        boolean result4 = Pattern.matches(pattern4, str4);
        boolean result5 = Pattern.matches(pattern5, str5);
        boolean result6 = Pattern.matches(pattern6, str6);


        System.out.println("result = " + result);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
        System.out.println("result5 = " + result5);
        System.out.println("result6 = " + result6);

    }


}
