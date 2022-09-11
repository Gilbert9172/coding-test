package combination;

import java.util.Arrays;

/**
 * 중복 조합
 */
public class Comb2 {

    // 선택하고자 하는 대상 집합.
    static int[] target = new int[] { 1, 2, 3 };
    // 대상 숫자를 담아둘 배열.
    static int[] result = new int[2];

    public static void main(String[] args) {
        combination(0, 0, target.length, 2);
    }

    // 조합 메서드(cnt는 선택 횟수, idx는 다음 대상을 선택할때 집합에서 탐색을 시작할 인덱스).
    private static void combination(int cnt, int idx, int n, int r) {
        // 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        // 대상 집합을 주어진 인덱스부터 순회하며 숫자를 하나 선택한다.
        for (int i = idx; i < n; i++) {
            // 숫자를 담는다.
            result[cnt] = target[i];
            // 자신을 재귀 호출한다(자신의 수는 중복 선택이 가능하므로, 인덱스를 그대로 넘겨준다).
            combination(cnt + 1, i, n, r);
        }
    }
}
