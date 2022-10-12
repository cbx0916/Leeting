package com.company;

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null){
            return false;
        }
        int i = 0; int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) --j;
            else i++;
        }
        return false;
    }
}
