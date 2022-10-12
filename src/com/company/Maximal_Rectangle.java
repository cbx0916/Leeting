package com.company;

public class Maximal_Rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 && matrix[0].length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        for (int i=0;i<n;i++){
            right[i]=n;
        }
        int max = 0;
        for(int i=0;i<m;i++){
            int curl=0,curr=n;
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                    left[j] = Math.max(left[j],curl);
                }else {
                    height[j] = 0;
                    left[j]=0;curl = j+1;
                }

            }
            for (int j=n-1;j>=0;j--){
                if (matrix[i][j]=='1'){
                    right[j] = Math.min(right[j],curr);
                }else {
                    right[j] = n;
                    curr = j;
                }
                System.out.println("第"+i+"行"+j+"列："+left[j]+"--"+right[j]+"--"+height[j]);
                max = Math.max(max,(right[j]-left[j])*height[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] max = {{1,0,1,0,0}, {1,0,1,1,1}, {1,1,1,1,1}, {1,0,0,1,0}};
        System.out.println(max.length+"-----"+max[0].length);
        int[] sum = new int[3];
        System.out.println(sum[0]+sum[1]);
        char[][] AS = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(AS));
    }

}
