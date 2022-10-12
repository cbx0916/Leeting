package com.company;

public class Rotate_List {
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return null;
        ListNode dummyhead = head;
        int length = 1;
        while (dummyhead.next!=null){
            ++length;
            dummyhead = dummyhead.next;
        }
        dummyhead.next = head;
        int n = length - k % length;
        for (int i=0;i<n;i++){
            dummyhead = dummyhead.next;
        }
        ListNode newhead = dummyhead.next;
        dummyhead.next = null;
        return newhead;
    }
}
