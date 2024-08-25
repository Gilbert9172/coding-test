package datastructure.non_linear;

import datastructure.non_linear.graph.Subsets;

import java.util.List;

public class RunSolution {
    public static void main(String[] args) {
        int[] nums = {0};
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(nums);
        for (List<Integer> integerList : subsets1) {
            for (Integer i : integerList) {
                System.out.println(i);
            }
            System.out.println("=======");
        }
    }
}
