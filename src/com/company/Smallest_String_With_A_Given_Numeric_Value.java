package com.company;

import java.util.Arrays;

public class Smallest_String_With_A_Given_Numeric_Value {
    public String getSmallestString(int n, int k) {
        char res[] = new char[n];
        Arrays.fill(res,'a');

        k -= n;

        while (k > 0){
            res[--n] += Math.min(25,k);
            k -= Math.min(25,k);
        }
        return String.valueOf(res);

    }
}
