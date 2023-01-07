package 문자열더하기;

public class StringPlus {

    public static void main(String[] args) {

        String a = "123";
        a = a.concat("456");
        System.out.println("a = " + a);

        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.append("456");
        System.out.println("sb = " + sb);

    }

}
