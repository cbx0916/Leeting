package com.company;

public class Linked_List_Cycle {
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
    public boolean hasCycle(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;
        while (pFast!=pSlow){
            if(pFast==null || pFast.next==null)    return false;
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return true;
    }
}
