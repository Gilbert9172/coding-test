package toss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quiz01 {

    public static void main(String[] args) {

        String s = "1234";

        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            String sub = s.substring(i, i + 3);
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(0) == sub.charAt(2) && sub.charAt(1) == sub.charAt(2)) {
                subList.add(Integer.parseInt(sub));
            }
        }

        int answer;

        if (subList.isEmpty()) {
            answer = -1;
        } else answer = Collections.max(subList);


        System.out.println(answer);
    }
}
