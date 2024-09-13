package level2;

import java.util.HashMap;

/**
 * 프로그래머스
 * 해시(Lv.2)
 * 위장
 */
public class quiz42578 {

    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        HashMap<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 1)+ 1);
        }

        Integer answer = 1;
        for (Integer value : clothesMap.values()) {
            answer *= value;
        }

        System.out.println(answer-1);
    }
}
