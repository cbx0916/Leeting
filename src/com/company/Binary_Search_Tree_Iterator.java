package com.company;

import java.util.Stack;

public class Binary_Search_Tree_Iterator {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    static class BSTIterator {
        Stack<TreeNode> stack ;
        public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            if (root ==  null) return;
            while (root != null){
                stack.push(root);
                root = root.left;
            }

        }

        public int next() {
            TreeNode curNode = stack.pop();
            if (curNode.right != null){
                TreeNode insertNode = curNode.right;
                while (insertNode != null){
                    stack.push(insertNode);
                    insertNode = insertNode.left;
                }
            }
            return curNode.val;
        }

        public boolean hasNext() {
            return !stack.empty();
        }
    }

    public static void main(String[] args) {
        //BSTIterator bSTIterator = new BSTIterator();
    }

}
