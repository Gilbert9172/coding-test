package datastructure.linear.array;

import java.util.ArrayDeque;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int answer = twoPointerSolve(height);
        System.out.println(answer);
        int answer2 = stackSolve(height);
        System.out.println(answer2);
    }

    public static int twoPointerSolve(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int leftMax = height[leftPointer];
        int rightMax = height[height.length - 1];
        int water = 0;

        while (leftPointer < rightPointer) {
            if (leftMax < rightMax) {
                leftPointer++;
                leftMax = Math.max(height[leftPointer], leftMax);
                water += leftMax - height[leftPointer];
            } else {
                rightPointer--;
                rightMax = Math.max(height[rightPointer], rightMax);
                water += rightMax - height[rightPointer];
            }
        }
        return water;
    }

    public static int stackSolve(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //스택에서 꺼낸다.
                Integer top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() -1;
                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];
                // 물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
            }
            // 진행하려면 현재 위치를 스택에 삽입
            stack.push(i);
        }
        return volume;
    }
}
