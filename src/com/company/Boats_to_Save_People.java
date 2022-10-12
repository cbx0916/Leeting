package com.company;

import java.util.Arrays;

public class Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j){
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }
        return ans;

    }
}
