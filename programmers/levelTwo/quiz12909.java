package levelTwo;

import java.util.*;

/**
 * https://conanglog.tistory.com/229
 */
public class quiz12909 {

    public static void main(String[] args) {
        Boolean answer = false;
        String s = ")()(";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) answer = true;
        System.out.println(answer);
    }
}
