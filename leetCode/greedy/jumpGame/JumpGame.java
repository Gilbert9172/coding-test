package greedy.jumpGame;

/**
 * <a href="https://leetcode.com/problems/jump-game/?envType=problem-list-v2&envId=greedy&difficulty=MEDIUM">55. Jump Game</a>
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
