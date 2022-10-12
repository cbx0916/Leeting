package com.company;

public class Remove_Duplicates_from_Sorted_List_II {
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0,head);
        ListNode header = temp;

        while (head!=null){
            if (head.next!=null && head.val == head.next.val){
                while (head.next!=null && head.val == head.next.val){
                    head=head.next;
                }
                header.next = head.next;
            }else {
                header = header.next;
            }
            head = head.next;
        }
        return temp.next;
    }
}
