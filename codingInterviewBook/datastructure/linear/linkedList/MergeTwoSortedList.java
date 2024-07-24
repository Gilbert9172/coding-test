package datastructure.linear.linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode#21
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {

        // create Test Case
        ListNode node1_3 = new ListNode(4, null);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode node1_1 = new ListNode(1, node1_2);

        ListNode node2_3 = new ListNode(4, null);
        ListNode node2_2 = new ListNode(3, node2_3);
        ListNode node2_1 = new ListNode(1, node2_2);

        // O(nlogn)
        List<ListNode> nodeList = new ArrayList<>();
        List<ListNode> mergedNodeList = addNodeRecursively(
                node2_1,
                addNodeRecursively(node1_1, nodeList)
        );
        mergedNodeList.sort(Comparator.comparing(nodes -> nodes.val));
        for (int i = 0; i < mergedNodeList.size() -1 ; i++) {
            mergedNodeList.get(i).next = mergedNodeList.get(i+1);
        }
        mergedNodeList.getLast().next = null;
        System.out.println(mergedNodeList.getFirst());

        // O(n)
        ListNode node = mergeTwoLists(node1_1, node2_1);
        System.out.println(node);
    }


    public static List<ListNode> addNodeRecursively(ListNode node, List<ListNode> nodeList) {
        ListNode defaultNode = node;
        if (defaultNode.next != null) {
            defaultNode = defaultNode.next;
            addNodeRecursively(defaultNode, nodeList);
        }
        nodeList.add(node);
        return nodeList;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
