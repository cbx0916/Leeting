package com.company;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import java.util.ArrayList;

public class Recover_Binary_Search_Tree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
//      TreeNode() {};
    }
    public static void print(TreeNode root){
        if (root!=null){

            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
    }

    static TreeNode firstElement,secondElement = null;
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    static TreeNode fc, sc = null;
    static TreeNode pr = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {
            tras(root);
          int temp = fc.val;
          fc.val = sc.val;
          sc.val = temp;
    }
    private static void traverse(TreeNode root){
          if (root == null) return;

          traverse(root.left);
          //System.out.println(root.val);
          if (fc == null && prev.val >= root.val)
                fc = prev;
          if (fc != null && prev.val >= root.val)
                sc = root;
          prev = root;

          traverse(root.right);
    }

    public static void recoverTN(TreeNode root){
        traverse(root);
        int tmp = fc.val;
        fc.val = sc.val;
        sc.val = tmp;

    }
    private static void tras(TreeNode root){
        if (root == null) return;
        tras(root.left);

        if (fc == null && pr.val >= root.val)
            fc = pr;
        if (fc != null && pr.val >= root.val)
            sc = root;
        pr = root;

        tras(root.right);
    }


    public static void main(String[] args) {
        TreeNode tr;
        tr = new TreeNode(3);
        tr.left = new TreeNode(1);
        tr.right = new TreeNode(4);
        tr.right.left = new TreeNode(2);

        TreeNode er;
        er = new TreeNode(1);
        er.left = new TreeNode(3);
        er.left.right= new TreeNode(2);

        TreeNode dd;
        dd = new TreeNode(9);
        dd.left = new TreeNode(2);
        dd.left.right = new TreeNode(4);
        dd.right = new TreeNode(7);
        dd.right.left = new TreeNode(6);
        dd.right.right = new TreeNode(5);

//        print(tr);
        recoverTree(dd);
        //recoverTN(dd);
//        print(tr);

    }


}
