import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class charStudy {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        String name = "admin";
//
//        char character = name.charAt(0);
//        System.out.println("character = " + character);
//
//        int ascii = (int) character;
//        System.out.println("ascii = " + ascii);
//
//        byte[] bytes = name.getBytes("US-ASCII");
//        System.out.println("bytes = " + Arrays.toString(bytes));
//
//
//
//        System.out.println("Byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
//        System.out.println("Short: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
//        System.out.println("Int: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
//        System.out.println("Long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);

        // 2진수
        int var1 = 0b1011;
        System.out.println("var1 = " + var1);

        // 8진수
        int var2 = 013;
        System.out.println("var2 = " + var2);

        // 10진수
        int var3 = 1000;
        System.out.println("var3 = " + var3);

        char var3c = (char) var3;
        System.out.println("var3c = " + var3c);

        // 16진수
        int var4 = 0xB3C;
        System.out.println("var4 = " + var4);

        int var5 = 'A';
        System.out.println("var5 = " + var5);

        char c1 = 'A';
        char c2 = 65;
        char c3 = '\u0041';  // 16진수
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);

        byte b1 = 10;
        byte b2 = 20;
        int b3 = b1 + b2;
        System.out.println("b3 = " + b3);

    }
}
