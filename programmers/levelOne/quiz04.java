package levelOne;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2020 카카오 인턴십
 * 키패드 누르기
 */
public class quiz04 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "left";

        Map<String, Integer> handMap = new HashMap<>();
        handMap.put("L", 10);
        handMap.put("R", 12);

        List<String> resultList = new ArrayList<>();
        for (int num : numbers) {

            if (num == 0) {
                num += 11;
            }

            if (num == 1 || num == 4 || num == 7) {
                handMap.put("L", num);
                resultList.add("L");
            }

            else if (num == 3 || num == 6 || num == 9) {
                handMap.put("R", num);
                resultList.add("R");
            }

            else {
                int leftPosition = handMap.get("L");
                int rightPosition = handMap.get("R");

                int leftMoveCount = moveDistance(num, leftPosition);
                int rightMoveCount = moveDistance(num, rightPosition);

                String nearHand = shortestDistance(leftMoveCount, rightMoveCount, hand);

                if (nearHand == hand) {
                    handMap.put(String.valueOf(hand.toUpperCase().charAt(0)), num);
                    resultList.add(String.valueOf(hand.toUpperCase().charAt(0)));
                } else {
                    handMap.put(nearHand, num);
                    resultList.add(nearHand);
                }
            }
        }

        System.out.println(resultList.stream().collect(Collectors.joining()));
    }

    public static int moveDistance(int target, int positionNum) {
        int quotientLeft = Math.abs(target - positionNum) / 3;
        int remainderLeft = Math.abs(target - positionNum) % 3;
        int moveCount = quotientLeft + remainderLeft;
        return moveCount;
    }

    public static String shortestDistance(int leftMoveCount, int rightMoveCount, String hand) {
        if (leftMoveCount > rightMoveCount) {
            return "R";
        } else if (leftMoveCount < rightMoveCount) {
            return "L";
        } else {
            return hand;
        }
    }
}


// 현재 0일 때가 문제