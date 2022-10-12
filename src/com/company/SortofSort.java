package com.company;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortofSort {
    //冒泡排序
    public static int[] BubbleSort(int arr[]){
        if (arr == null || arr.length < 2) return null;
        for (int e = arr.length - 1; e > 0; e--){
            for (int j = 0; j < e; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    public static void bubbleSort(int[] arr){
        if (arr.length < 2 || arr == null) return;
        for (int e = arr.length - 1; e > 0; e--)
            for (int i = 0; i < e; i++)
                if (arr[i] > arr[i + 1])
                    swap(arr,i,i+1);
    }

    //插入排序
    public static int[] insertionSort(int arr[]){
        if (arr == null || arr.length < 2)
            return null;
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                swap(arr,j,j+1);
            }
        }
        return arr;
    }
    public static void InsertSort(int[] arr){
        if (arr.length < 2 || arr == null)return;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i; j >= 0; j--)
                if (arr[j] > arr[j + 1])
                    swap(arr,j,j + 1);
    }


    //选择排序
    public static int[] selectionSort(int[] arr){
        if (arr==null||arr.length<2)
            return arr;
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr,i,minIndex);
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
    public static void SeletionSort(int[] arr){
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            swap(arr,i,minIndex);
        }

    }

    //归并排序
    public static void mergeSort(int[] arr){
        if (arr==null||arr.length<2)
            return ;
        mergeSort(arr,0,arr.length-1);
    }
    public static void mergeSort(int[] arr,int l, int r){
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] arr,int l,int mid, int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;

        while (p1<=mid && p2<=r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void MergeSort(int[] arr){
        if (arr == null || arr.length < 2) return;
        MergeSort(arr, 0, arr.length - 1);
    }
    public static void MergeSort(int[] arr, int l, int r){
        if (l == r) return;
        int mid = l + (r - l) / 2;
        MergeSort(arr,l,mid);
        MergeSort(arr,mid + 1, r);
        Merge(arr, l, mid, r);
    }
    public static void Merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r)
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid)
            help[i++] = arr[p1++];
        while (p2 <= r)
            help[i++] = arr[p2++];
        for (i = 0; i < help.length; i++)
            arr[l + i] = help[i];
    }


    //快排
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int l, int r){
        if (l < r) {
            swap(arr,l + (int)Math.random() * (r - l + 1),r);
            int[] tmp = partition(arr, l, r);
            quickSort(arr,l,tmp[0] - 1);
            quickSort(arr,tmp[1] + 1, r);
        }
    }
    public static int[] partition(int[] arr, int l, int r){
        int less = l-1; //小于等于区域的右边界
        int more = r;   //大于区域的做边界

        while (l < more){ //若小于，做三件事情 1.和小于区右边界下一个数做交换swap 2.小于区右扩less++ 3.下一个数l++
            if (arr[l] < arr[r])
                swap(arr,l++,++less);
            else if (arr[l] > arr[r]) //若大于，两件事 1.和大于区前一个数交换swap 2.大于区左扩more-- 3.l原地不变
                swap(arr, l, --more);
            else                       //若等于，下一个数l++
                l++;
        }
        System.out.println(l+"  "+r);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[more]+"  "+arr[r]);
        System.out.println("------");
        swap(arr,more,r);   //r位置上作为比较基准，介于less和more之间，放在more之前
        return new int[] {less + 1,more};
    }

    public static void QuickSort(int[] arr){
        if (arr.length < 2 || arr == null) return;
        QuickSort(arr, 0, arr.length - 1);
    }
    public static void QuickSort(int[] arr, int l, int r){
        while (l < r){
            swap(arr,r,(int)(l + Math.random() * (r - l + 1)));
            int[] tmp = quick(arr, l, r);
            quickSort(arr,l,tmp[0] - 1);
            quickSort(arr,tmp[1] + 1, r);
        }
    }
    public static int[] quick(int[] arr, int l, int r){
        int less = l - 1, more = r;

        while (l < more){
            if (arr[l] < arr[r])
                swap(arr,l++,++less);
            else if (arr[l] > arr[r])
                swap(arr,l,--more);
            else
                l++;
        }
        return new int[]{less + 1, more};
    }



//    public static void swap(int[] arr,int i,int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
//    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,6,4,8,3,7,2,1};
        InsertSort(arr);
        //System.out.println(Arrays.toString(BubbleSort(arr)));
        //System.out.println(Arrays.toString(insertionSort(arr)));
        //System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(arr));
    }

}
