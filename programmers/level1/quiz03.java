package level1;

import java.util.Arrays;

/****************************************
 * 2021 카카오 채용연계형 인턴십
 * 숫자 문자열과 영단어 (Lv.1)
 ****************************************
 * 주요 메서드
 * - replace();
 * - stream().foreach();
 ****************************************/
public class quiz03 {

    public static void main(String[] args) {
        String s = "one4seveneight";
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < num.length; i++) {
            s = s.replace(num[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);
        Arrays.asList(answer).stream().forEach((a)-> System.out.println(a));
    }
}