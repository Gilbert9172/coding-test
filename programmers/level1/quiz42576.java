package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <h3>완주하지 못한 선수</h3><br>
 * [난이도] - Lv.1<br>
 * [작성일] - 2022.12.26<br>
 * [시간 복잡도] - <br>
 */
public class quiz42576 {

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println("answer1 = " + Solution1.solution(participant, completion));
        System.out.println("answer2 = " + Solution2.solution(participant, completion));

    }

    // HashMap
    static class Solution1 {

        public static String solution(String[] participant, String[] completion) {

            String answer = "";
            Map<String, Integer> pMap = new HashMap<>();

            for (String p : participant) {
                pMap.put(p, pMap.getOrDefault(p, 0) + 1);
            }

            for (String c : completion) {
                pMap.put(c, pMap.get(c) - 1);
            }

            for (String k : pMap.keySet()) {
                if (pMap.get(k).equals(1)) {
                    answer = k;
                }
            }
            return answer;
        }
    }

    // Stream API
    static class Solution2 {

        public static String solution(String[] participant, String[] completion) {

            Map<String, Long> pMap = Arrays.stream(participant)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            for (String c : completion) {
                long value = pMap.get(c) - 1;

                if (value == 0) {
                    pMap.remove(c);
                } else {
                    pMap.put(c, value);
                }
            }
            return pMap.keySet().iterator().next();
        }
    }

}
