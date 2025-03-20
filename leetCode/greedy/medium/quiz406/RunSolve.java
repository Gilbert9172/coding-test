package greedy.medium.quiz406;

public class RunSolve {
    public static void main(String[] args) {
        QueueReconstructionByHeight solution = new QueueReconstructionByHeight();
        int[][] persons = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        solution.reconstructQueue(persons);
    }
}
