package devsisters;

import java.util.Arrays;


public class Note3 {

    public static void main(String[] args) {
        Note3 note2 = new Note3();
        String[][] input = {{"cab"}, {"adaaa"}, {"e"}};
        int solution = note2.solution(input);
        System.out.println(solution);
    }

    public int solution(String[][] pouches) {
        int count = 0;

        for (String[] pouch : pouches) {
            if (isValidPouch(pouch)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValidPouch(String[] pouch) {
        if (pouch.length == 0) return false;

        String sortedBase = sortString(pouch[0]);

        for (String str : pouch) {
            if (!sortedBase.equals(sortString(str))) {
                return false;
            }
        }

        return true;
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
