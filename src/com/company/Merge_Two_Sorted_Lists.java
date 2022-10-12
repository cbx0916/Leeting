package com.company;

import java.util.ArrayList;

public class Merge_Two_Sorted_Lists {
    static class Solution {
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

            public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                ListNode temp = new ListNode(0);
                ListNode thead = temp;

                while (list2!=null && list1!=null){
                    if(list1.val<=list2.val){
                        temp.next = list1;
                        list1 = list1.next;
                    }else{
                        temp.next = list2;
                        list2 = list2.next;
                    }
                    temp = temp.next;
                }
                    if (list1==null){
                        temp.next = list2;
                    }else {
                        temp.next = list1;
                    }

                return thead;
            }
            public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
                if(list1 == null) return list2;
                if(list2 == null) return list1;
                if(list1.val < list2.val){
                    list1.next = mergeTwoLists(list1.next, list2);
                    return list1;
                } else{
                    list2.next = mergeTwoLists(list1, list2.next);
                    return list2;
                }
            }

            public static void main(String[] args) {

            }
        }
    }
}
