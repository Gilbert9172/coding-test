import java.util.*;

/**
 * 직접 초대한 사람수 * 10
 * 내가 초대한 사람이 초다핸 사람 수 * 3
 * 내가 초대한 사람이 초대한 사람 수 * 1
 *
 * [초대자, 피초재자]
 * [[1, 2],
 * [1, 3],
 * [3, 4],
 * [4, 5],
 * [4, 6],
 * [4, 6]]
 */
public class quiz04 {


    static Map<Long, Long> answerMap = new HashMap<>();
    public static void main(String[] args) {
        Long[][] invitationPairs = {{1L, 2L},{1L, 3L},{3L, 4L},{4L, 5L},{4L, 6L},{4L, 7L}};

        Map<Long, Long> inviters = new HashMap<>();

        for (Long[] invitationPair : invitationPairs) {
            Long inviter = invitationPair[0];
            inviters.put(inviter, inviters.getOrDefault(inviter, 0L) + 1L);
        }


        for (Long inviter : inviters.keySet()) {
            // 직접 초대한 사람의 수
            Long directInvite = inviters.get(inviter);

            List<Long> lst = new ArrayList<>();
            for (Long[] invitationPair : invitationPairs) {
                if (invitationPair[0].equals(inviter)) {
                    lst.add(invitationPair[1]);
                }
            }

            // 내가 초대한 사람이 초대한 사람 수
            Long directInvite2 = 0L;
            for (Long aLong : lst) {
                directInvite2 += inviters.getOrDefault(aLong,0L);
            }

            // 내가 초대한 사람이 초대한 사람이 초대한 사람의 수
            List<Long> lst2 = new ArrayList<>();
            for (Long aLong : lst) {
                // 2,3이 초대한 사람을 찾는다.
                for (Long[] invitationPair : invitationPairs) {
                    if (invitationPair[0] == aLong) {
                        lst2.add(invitationPair[1]);
                    }
                }
            }
            // 그사람이 초대한 수를 찾는다.
            Long directInvite3 = 0L;
            for (Long aLong : lst2) {
                directInvite3 += inviters.getOrDefault(aLong,0L);
            }

            answerMap.put((directInvite*10) + (directInvite2*3) + directInvite3, inviter);
        }

        List<Long> ansList = new ArrayList<>();
        for (Long aLong : answerMap.keySet()) {
            ansList.add(aLong);
        }
        Collections.sort(ansList, Collections.reverseOrder());
        List<Long> answer = new ArrayList<>();
        for (int i = 0; i < ansList.size(); i++) {
            answer.add(answerMap.get(ansList.get(i)));
        }

        for (Long aLong : answer) {
            System.out.println(aLong);
        }
    }
}
