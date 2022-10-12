package com.company;

public class Simplify_Path {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] strings = path.split("/");

        for (int i=0;i<strings.length;i++){
            if (strings[i].equals("") || strings[i].equals(".")){
                continue;
            } else if (strings[i].equals("..")) {
                int index = sb.lastIndexOf("/");
                if (index >= 0) {
                    sb.delete(index, sb.length());
                }
            }else{
                    sb.append("/");
                    sb.append(strings[i]);
                }

        }
        if (sb.length() == 0){
            sb.append('/');
        }
        return sb.toString();

    }
}
