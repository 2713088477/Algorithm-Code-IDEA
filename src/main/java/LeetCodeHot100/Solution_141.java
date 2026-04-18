package LeetCodeHot100;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//测试链接:https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked
public class Solution_141 {
    
    public boolean hasCycle(ListNode head) {
        ListNode phead = new ListNode();
        phead.next = head;
        ListNode fast = phead.next,slow=phead;
        if(fast==null) return false;
        while(fast!=slow){
            if(fast==null || fast.next==null) return false;
            fast = fast.next.next;
            if(slow==null) return false;
            slow = slow.next;
        }
        return true;
    }
}
