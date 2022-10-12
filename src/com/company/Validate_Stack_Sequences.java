package com.company;

import java.util.Stack;

public class Validate_Stack_Sequences {

    //Greedy
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int p:pushed){
            stack.push(p);
            while (!stack.isEmpty() && i<N && stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }

        return i==N;
    }
}
