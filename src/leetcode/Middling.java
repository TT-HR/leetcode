package leetcode;

import java.util.Stack;

/**
 * @author yhr
 * @date 2023/6/26-11:20
 */
public class Middling {


    public static void main(String[] args) {
        Middling function = new Middling();

        ListNode listNode1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode listNode2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        function.addTwoNumbers(listNode1,listNode2);
    }

    /**
     *两数相加
     * 时间复杂度O(n)
     *
     * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cursor = node;
        int carry = 0;
        while (l1 != null || l2!= null || carry != 0){
            int node1 = l1 != null ? l1.val:0;
            int node2 = l2 != null ? l2.val:0;
            int count = node1 + node2 + carry;
            carry = count/10;

            ListNode nextNode = new ListNode(count%10);
            cursor.next = nextNode;
            cursor = nextNode;

            if (l1 != null ) l1 = l1.next;
            if (l2 != null ) l2 = l2.next;

        }
        return node.next;
    }
}
