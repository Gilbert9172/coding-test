package levelOne;

import java.util.ArrayList;
import java.util.List;

public class quiz05 {
    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};


        int cnt = 0;
        List<Integer> trash = new ArrayList<>();
        if (trash.get(trash.size() - 1) == trash.get(trash.size() - 2)) {
            cnt += 2;
        }


        for (int move : moves) {

            int ind = move - 1;

            List<Integer> lst = new ArrayList<>();
            for (int[] subList : board) {
                int i = subList[ind];
                lst.add(i);
            }

            for (int j = 0; j < lst.size(); j++) {

                if (lst.get(j) > 0) {
                    int initialValue = lst.get(j);
                    lst.set(j, 0);

                    int test = 0;
                    board[j][ind] = test;
                    trash.add(initialValue);
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}
