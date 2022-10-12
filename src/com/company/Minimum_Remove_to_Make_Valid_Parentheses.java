package com.company;

import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        //char stack[] = new char[s.length()+1];
        if(s==null || s.length()==0){
            return s;
        }
        boolean[] invalid = new boolean[s.length()];//true 无效，false 有效
        Stack<Integer> stack= new Stack<>();
        int top=1;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
                invalid[i]=true;
            }else if (c==')'){
                if (!stack.empty()){
                    invalid[stack.pop()] = false;
                    invalid[i] = false;
                }else {
                    invalid[i] = true;
                }
            }else {
                invalid[i] = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (!invalid[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        if(s==null || s.length()==0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (char c:s.toCharArray()){
            if (c=='('){
                left++;
            }else if(c==')'){
                if (left==0) continue;
                left--;
            }
            sb.append(c);
        }
        StringBuilder res = new StringBuilder() ;
        for (int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if (c=='(' && left-->0){
                continue;
            }
            res.append(c);
        }
        return res.reverse().toString();
    }









}
