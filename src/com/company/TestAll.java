package com.company;

import org.junit.Test;

import javax.smartcardio.CardNotPresentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 在public类里的方法为什么要加static才能被调用
 * static private 呵实例有什么区别
 */

public class TestAll {
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
    public void addAll(){
        System.out.println(3+2);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode header = temp;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1!=null)
            temp.next=l1;
        else
            temp.next=l2;
        return header.next;
    }
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<=l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
    public boolean hasCycle(Linked_List_Cycle.ListNode head) {
        return true;
    }
    public static List<Integer> partitionLabels(String s){
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int boundary = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            boundary = Math.max(boundary,last[curChar-'a']);
            cnt++;
            if (boundary == i){
                res.add(cnt);
                cnt = 0;
            }
        }
        return res;
    }
    public static int MinimumDomino(int[] tops,int[] bottoms){
        int n = tops.length;
        for (int a=0,b=0,i=0; i<n && (tops[i]==tops[0] || bottoms[i]==tops[0]);i++){
            if (tops[i] != tops[0]) a++;
            if (bottoms[i] != tops[0]) b++;
            if (i == n - 1) return Math.min(a,b);
        }
        for (int a=0,b=0,i=0; i<n && (tops[i]==bottoms[0] || bottoms[i]==bottoms[0]);i++){
            if (tops[i] != bottoms[0]) a++;
            if (bottoms[i] != bottoms[0]) b++;
            if (i == n-1) return Math.min(a,b);
        }
        return -1;
    }

    //冒泡 index out of boundary
    public static void bubbleSort(int[] arr) {
        if (arr.length < 2 || arr == null) return;
        for (int e = arr.length - 1; e > 0; e--)
            for (int i = 0; i < e; i++)
                if (arr[i+1] < arr[i])
                    swap(arr,i,i+1);
    }

    //选择 只有选择排序不能使用异或交换位次，因为会出现自己呵自己交换的情况
    public static void selectSort(int[] arr) {
        if (arr.length < 2 || arr == null) return;
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    //插入 1.i=1 2.j>=0
    public static void insertSort(int[] arr) {
        if (arr == null) return;
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j > 0 && (arr[j] > arr[j+1]); j--){
                swap(arr,j,j+1);
            }
        }
    }

    //归并 l < r ?
    public static void mergeSort(int[] arr) {
        if (arr == null) return;
        mergeSort(arr,0,arr.length - 1);
    }
    public static void mergeSort(int[] arr, int l,int r){
        if (l == r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r-l+1];
        int p1 = l, p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= r)
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid)
            help[i++] = arr[p1++];
        while (p2 <= r)
            help[i++] = arr[p2++];
        for (i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
    }


    //快排 l < r ?
    public static void quickSort(int[] arr) {
        if (arr.length < 2) return;
        quickSort(arr,0,arr.length - 1);
    }
    public static void quickSort(int[] arr,int l, int r){
        if (l < r){
            swap(arr,r,l + (int)Math.random() * (r-l+1));
            int[] tmp = partition(arr,l,r);
            quickSort(arr,l,tmp[0] - 1);
            quickSort(arr,tmp[1] + 1,r);
        }
    }
    public static int[] partition(int[] arr,int l,int r){
        int less = l - 1;   //小于等于区域的右边界
        int more = r;       //大于区域的左边界
        while (l < more) {
            if (arr[l] < arr[r])        //若小于，做三件事情 1.和小于区右边界下一个数做交换swap 2.小于区右扩less++ 3.下一个数l++
                swap(arr, l++, ++less);
            else if (arr[l] > arr[r])   //若大于，两件事 1.和大于区前一个数交换swap 2.大于区左扩more-- 3.l原地不变
                swap(arr, l, --more);
            else
                l++;
        }
        swap(arr,r,more);        //r位置上作为比较基准，介于less和more之间，放在more之前
        return new int[] {less - 1,more};
    }

    public static void QuickSort(int [] arr){
        if (arr.length < 2 ) return;
        QuickSort(arr,0,arr.length - 1);
    }
    public static void QuickSort(int[] arr, int l, int r){
        if (l < r){
            swap(arr,r,l + (l - r + 1)*(int)Math.random());
            int[] tmp = Partition(arr,l,r);
            QuickSort(arr,l,tmp[0] - 1);
            QuickSort(arr,tmp[1] + 1, r);
        }
    }
    public  static int[] Partition(int[] arr,int l ,int r){
        int less = l - 1;
        int more = r;
        while (l < more){
            if (arr[l] < arr[r])
                swap(arr,l++,++less);
            else if(arr[l] > arr[r])
                swap(arr,l,--more);
            else
                l++;
        }
        swap(arr,r,more);
        return  new int[] {less+1,more};

    }

    public static void swap_orgin(int[] arr,int i,int j){
        System.out.println("交换前："+arr[i]+"---"+arr[j]);
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        System.out.println("交换后："+arr[i]+"---"+arr[j]);
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {0,2,1,7,5,3,6,4,9,8,1,2,2,9,7,8,5,6};

        String s = "ababcbacadefegdehijhklij"; // 978
        //System.out.println(partitionLabels(s));

        int[] tops = {2,1,2,4,2,2}, bottoms = {5,2,6,2,3,2}; //2
        int[] tops2 = {3,5,1,2,3}, bottoms2 = {3,6,3,3,4}; //-1
        //System.out.println(MinimumDomino(tops2,bottoms2));

        //bubbleSort(arr);

        //insertSort(arr);

        //SelectSort(arr);

        //mergeSort(arr);
        quickSort(arr);

        System.out.println(Arrays.toString(arr));


    }
}
