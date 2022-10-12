package com.company;

import java.util.ArrayList;
import java.util.List;

public class Find_and_Replace_Pattern {
    public static List<String> findAndReplace(String[] words, String pattern){
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if (stringYes(word,pattern))
                res.add(word);
        }
        return res;
    }
    public static boolean stringYes(String word, String pattern){
        if(word.length() != pattern.length())
            return false;
        for (int i = 0; i < word.length(); i++){
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (word.indexOf(c1) != pattern.indexOf(c2))
                return false;
        }
        return true;
    }

    public static List<String> findAndRe(String[] words,String pattern){
        List<String> res = new ArrayList<>();

        for (String word:words){
            if (isSame(word,pattern))
                res.add(word);
        }

        return res;
    }
    public static boolean isSame(String word,String pattern){
        if (word.length() != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++){
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (word.indexOf(c1) != pattern.indexOf(c2))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abc","deq","aaa","mee","aqq"};
        String pattern = new String("abb");

//        System.out.println(findAndReplace(words,pattern));
        System.out.println(findAndRe(words,pattern));
    }
}


