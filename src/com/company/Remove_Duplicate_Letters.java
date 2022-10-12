package com.company;

import java.util.*;

public class Remove_Duplicate_Letters {
    public static String removeDuplicateLetters(String s) {
        if (s.length()==0 || s == null){return s;}
        int[] val = new int[26];
        Stack<Character> stack = new Stack<>();
        HashSet<Character> ch = new HashSet<>();
        char[] res = new char[26];

        int len = s.length();
        for (int i=0;i<len;i++){
            val[s.charAt(i)-'a']++;
        }

        System.out.println(Arrays.toString(val));

        for (char c:s.toCharArray()){

            val[c-'a']--;
            if (ch.contains(c)) continue;

            //System.out.println("stack:"+stack.peek()+"val[stack.peek()-'a']:"+(val[stack.peek()-'a']));
            while (!stack.isEmpty() && c < stack.peek() && val[stack.peek()-'a']>0){
                System.out.println("当前字符："+c);
                System.out.println("stack的顶需要大于当前字符:"+stack.peek());
                System.out.println("val[stack.peek()-'a']需要大于0:"+(val[stack.peek()-'a']));
                System.out.println();

                char tmp = stack.pop();
                System.out.println("对于s的每一个c，tmp:"+tmp);
                ch.remove(tmp);
            }
            stack.push(c);
            ch.add(c);
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }
//    public static String removeDuplicateLetters2(String s) {
//        if (s.length()==0 || s == null){return s;}
//        Map<Character,Integer> hash = new HashMap<>();
//        Map<Character, Boolean> saved = new HashMap<Character, Boolean>();
//        char[] res = new char[26];
//        for (Character c:s.toCharArray()) hash.put(c,new Integer(c-'a'));
//
//        for (char c:s.toCharArray()){
//            hash[c];
//        }
//        int len = s.length();
//        for (int i=0;i<len;i++){
//            val[s.charAt(i)-'a']++;
//        }
//
//        for (char c:s.toCharArray()){
//
//            val[c-'a']--;
//            if (ch.contains(c)) continue;
//
//            while (!stack.isEmpty() && c < stack.peek() && val[stack.peek()-'a']>0){
//                char tmp = stack.pop();
//                System.out.println("对于s的每一个c，tmp:"+tmp);
//                ch.remove(tmp);
//            }
//            stack.push(c);
//            ch.add(c);
//        }
//        StringBuffer sb = new StringBuffer();
//        while (!stack.isEmpty()) sb.append(stack.pop());
//
//        return sb.reverse().toString();
//    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}
