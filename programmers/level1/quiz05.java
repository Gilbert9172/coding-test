package level1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 2019 카카오 개발자 겨울 인턴십
 * 크레인 인형 뽑기 게임 (Lv.1)
 */
public class quiz05 {

    public static Integer Solution() {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int cnt = 0;
        Stack<Integer> trash = new Stack<>();

        for (int move : moves) {

            if (trash.size() > 1) {
                if (trash.get(trash.size() - 1) == trash.get(trash.size() - 2)) {
                    trash.pop();
                    trash.pop();
                    cnt += 2;
                }
            }
            int ind = move - 1;

            ArrayList<Integer> lst = new ArrayList<>();
            for (int[] subList : board) {
                int i = subList[ind];
                lst.add(i);
            }

            for (int j = 0; j < lst.size(); j++) {
                if (lst.get(j) > 0) {
                    trash.push(lst.get(j));
                    board[j][ind] = 0;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(quiz05.Solution());
    }
}



