package level1;

import java.util.HashSet;
import java.util.Set;

/**
 * 알고리즘 : 해쉬
 * 포켓몬
 */

public class quiz07 {
    static int[] nums = {3, 1, 2, 3};
    static Set<Integer> types = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(quiz07.solution());
    }

    public static Integer solution() {
        arrayToSet(nums);
        return countPossibleTypes();
    }

    // int[] → HashSet<>
    public static void arrayToSet(int[] nums) {
        for (int num : nums) {
            types.add(num);
        }
    }

    // 최대 선택 종류 수.
    public static Integer countPossibleTypes() {
        int selectPocketmon = nums.length / 2;

        int answer = 0;
        if (selectPocketmon <= types.size()) {
            answer += selectPocketmon;
            return answer;
        }
        answer += types.size();
        return answer;
    }
}
