package com.company;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = countNum(mid, matrix, n);

            if (k > count)
                left = mid + 1;
            else
                right = mid;

        }
        return right;
    }

    public static int countNum(int num,int[][] matrix, int n){
        int count = 0;
        int i = 0, j = n - 1;
        while(j >= 0 && i < n)
            if (num >= matrix[i][j]) {
                count += j + 1;
                i++;
            }
            else{
                j--;
            }
            return count;
        }





    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13}, {12,13,15}};

        System.out.println(kthSmallest(matrix,8));
//        System.out.println(kthSmallest2(matrix,8));
    }
}


