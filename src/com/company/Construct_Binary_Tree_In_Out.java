package com.company;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_In_Out {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
         for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
         }


        return bH(inorder,postorder,map,0,inorder.length,0,postorder.length-1);
    }
    public TreeNode bH(int[] inorder,int[] postorder,Map<Integer,Integer> map,int iStart,int iEnd,int pStart,int pEnd){
         if(iStart>iEnd || pStart>pEnd) return null;
         TreeNode root = new TreeNode(postorder[pEnd]);
         int mid = map.get(postorder[pEnd]);
         root.left = bH(inorder,postorder,map,iStart,mid-1,pStart,pStart+mid-iStart-1);
         root.right = bH(inorder,postorder,map,mid+1,iEnd,pStart+mid-iStart,pEnd-1);



        return root;
    }
}
