package com.company;

    public class Hamming_Distance {
        static class Solution {
        public static int hammingDistance(int x, int y) {
            Integer z = x^y;
            z.byteValue();
            return Integer.bitCount(z);
        }
    }

        public static void main(String[] args) {
            int x = 1;
            int y = 4;
            Integer z = x^y;
            System.out.println(Hamming_Distance.Solution.hammingDistance(3,1));
        }
}
