package greedy.gasStation;

public class RunSolve {
    public static void main(String[] args) {
        V2 v1 = new V2();
        int[] gas = {1,2,3,4,5,5,70};
        int[] cost = {2,3,4,3,9,6,2};
        int answer = v1.canCompleteCircuit(gas, cost);
        System.out.println(answer);

        int[] gas2 = {1, 2, 3, 4, 5};
        int[] cost2 = {3, 4, 5, 1, 2};
        int answer2 = v1.canCompleteCircuit(gas2, cost2);
        System.out.println(answer2);

        int[] gas3 = {2, 3, 4};
        int[] cost3 = {3, 4, 3};
        int answer3 = v1.canCompleteCircuit(gas3, cost3);
        System.out.println(answer3);

        int[] gas4 = {3, 3, 4};
        int[] cost4 = {3, 4, 4};
        int answer4 = v1.canCompleteCircuit(gas4, cost4);
        System.out.println(answer4);
    }
}
