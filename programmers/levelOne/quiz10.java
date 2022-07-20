package levelOne;

import java.util.HashMap;

/**
 * 완주하지 못한 선수
 */
public class quiz10 {

    static String answer;
    static HashMap<String, Integer> playerMap = new HashMap<>();

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        for (String player : participant) {
            playerMap.put(player, playerMap.getOrDefault(player,0) + 1);
        }

        for (String player : completion) {
            playerMap.put(player, playerMap.get(player) - 1);
        }

        System.out.println(failedPlayer());
    }

    public static String failedPlayer() {
        for (String s : playerMap.keySet()) {
            if (playerMap.get(s) != 0) {
                answer = s;
            }
        }
        return answer;
    }
}
