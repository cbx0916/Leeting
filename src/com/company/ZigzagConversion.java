package com.company;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1){
                return s;
            }

            List<StringBuilder> rows = new ArrayList<>();
            for(int i=0;i<Math.min(numRows,s.length());i++){
                rows.add(new StringBuilder());
            }
            int curRow=0;
            int nextRow=0;
            for(char c:s.toCharArray()){
                rows.get(curRow).append(c);
                if(curRow==0 || curRow == numRows-1){
                    nextRow ^= 1;
                }
                curRow += nextRow==1 ? 1 : -1;
            }
            StringBuilder sb = new StringBuilder();
            for (StringBuilder row:rows){
                sb.append(row);
            }
            return sb.toString();
        }
    }
}
