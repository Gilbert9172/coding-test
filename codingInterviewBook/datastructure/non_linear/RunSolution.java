package datastructure.non_linear;

import datastructure.non_linear.graph.CombinationSum;

import java.util.List;

public class RunSolution {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] combinations = {2, 3, 5};
        List<List<Integer>> answer = combinationSum.combinationSum(combinations, 8);
        for (List<Integer> integerList : answer) {
            System.out.println(integerList.size());
        }
    }
}
