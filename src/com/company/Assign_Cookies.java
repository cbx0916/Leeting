package com.company;

import java.util.Arrays;

public class Assign_Cookies {
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = s.length - 1,j = g.length - 1; i >= 0 && j >= 0; j--)

            if (s[i] >= g[j]) {
                count++;
                i--;
                System.out.println("----!s:" + s[i] + " g:" + g[j]);
            }

        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
}
