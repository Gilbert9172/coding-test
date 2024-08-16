package datastructure.linear.hashMap;

import java.util.HashMap;
import java.util.Map;

public class UnCompletedPlayer {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String solution = solution(participant, completion);
        System.out.println(solution);
    }

    public static String solution(String[] participant, String[] completion) {
        // 1. create counter Map
        Map<String, Integer> players = new HashMap<>();
        for (String player : participant) {
            players.put(player, players.getOrDefault(player, 0) + 1);
        }
//        Map<String, Long> players = Arrays.stream(participant)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 2. for loop completion
        for (String completer : completion) {
            if (players.containsKey(completer)) {
                players.put(completer, players.get(completer) - 1);
            }
        }

        // 3. for loop map.keyset
        String answer = "";
        for (String player : players.keySet()) {
            if (players.get(player) > 0) {
                answer = player;
            }
        }
        return answer;
    }
}
