package level1;

import java.util.*;

/**
 * 알고리즘 : 완전 탐색
 * 모의고사
 */
public class quiz08 {

    static List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    static List<Integer> second = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
    static List<Integer> third = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
    static List<Integer> studentsScore = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();


    public static void main(String[] args) {

        int[] answer = {1,3,2,4,2};

        scoreAnswers(answer, createAnswerSheet(answer, first));
        scoreAnswers(answer, createAnswerSheet(answer, second));
        scoreAnswers(answer, createAnswerSheet(answer, third));

        // 가장 많이 맞춘 사람의 index
        for (Integer integer : winner()) {
            System.out.println("integer = " + integer);
        }
    }

    public static List<Integer> createAnswerSheet(int[] answer, List<Integer> person) {
        List<Integer> personalAnsSheet = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            personalAnsSheet.add(person.get(i));
            person.add(person.get(i));

            if (personalAnsSheet.size() == answer.length) {
                break;
            }
        }
        return personalAnsSheet;
    }

    public static void scoreAnswers(int[] answer, List<Integer> answerSheet) {
        studentsScore.add(countAnswers(answer,answerSheet));
    }


    public static Integer countAnswers(int[] answer, List<Integer> answerSheet) {
        int correctAnswer = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answerSheet.get(i).equals(answer[i])) {
                correctAnswer ++;
            }
        }
        return correctAnswer;
    }

    public static List<Integer> winner() {
        Integer firstPlace = Collections.max(studentsScore);
        for (int i = 0; i < studentsScore.size(); i++) {
            if (firstPlace.equals(studentsScore.get(i))) {
                result.add(i+1);
            }
        }
        return result;
    }
}


