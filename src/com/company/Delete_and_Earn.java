package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

/*
    740. Delete and Earn
 */
public class Delete_and_Earn {
    static class Solution {
        public static int deleteAndEarn(int[] nums) {
            int maxNumber = 0;
            HashMap<Integer, Integer> points = new HashMap<>();

            for (int num : nums) {
                points.put(num, points.getOrDefault(num, 0) + num);
                maxNumber = Math.max(maxNumber, num);
            }

            List<Integer> elements = new ArrayList<Integer>(points.keySet());
            Collections.sort(elements);

            int local_point = points.get(elements.get(0));
            int remote_point = 0;
            System.out.println(local_point);
            for (int i=1;i<elements.size();i++){

                int tmp = local_point;
                int ctr = elements.get(i);
                if(ctr==elements.get(i-1)+1){
                    //local_point = remote_point + nums[i];
                    local_point = Math.max(local_point,remote_point+points.get(ctr));
                }else{
                    local_point += points.get(ctr);
                    //remote_point = local_point;
                }

                //System.out.println(local_point);
                remote_point = tmp;
            }
            return local_point;
        }
        public static int deleteAndEarn2(int[] nums) {
            int maxNumber = 0;
            HashMap<Integer, Integer> points = new HashMap<>();

            // Precompute how many points we gain from taking an element
            for (int num : nums) {
                points.put(num, points.getOrDefault(num, 0) + num);
                maxNumber = Math.max(maxNumber, num);
            }

            List<Integer> elements = new ArrayList<Integer>(points.keySet());
            Collections.sort(elements);

            // Base cases
            int twoBack = 0;
            int oneBack = points.get(elements.get(0));
            System.out.println(oneBack);

            for (int i = 1; i < elements.size(); i++) {
                int currentElement = elements.get(i);
                int temp = oneBack;
                if (currentElement == elements.get(i - 1) + 1) {
                    // The 2 elements are adjacent, cannot take both - apply normal recurrence
                    oneBack = Math.max(oneBack, twoBack + points.get(currentElement));
                } else {
                    // Otherwise, we don't need to worry about adjacent deletions
                    oneBack += points.get(currentElement);
                }
                //System.out.println(oneBack);
                twoBack = temp;
            }

            return oneBack;
        }

        public static void main(String[] args) {
            int[] a = {3,4,2};
            System.out.println(deleteAndEarn(a));
            System.out.println(deleteAndEarn2(a));
        }
    }
}
