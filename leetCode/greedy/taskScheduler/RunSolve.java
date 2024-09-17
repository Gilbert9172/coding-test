package greedy.taskScheduler;

public class RunSolve {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};

        V1 v1 = new V1();
        int answer = v1.leastInterval(tasks, 2);
        System.out.println(answer);

        V2 v2 = new V2();
        int answerV2 = v2.leastInterval(tasks, 2);
        System.out.println(answerV2);

        V3 v3 = new V3();
        int answerV3 = v3.leastInterval(tasks, 2);
        System.out.println(answerV3);
    }
}
