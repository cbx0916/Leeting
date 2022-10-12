package com.company;



public class Delete_Node_in_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){return null;}
        if (root.val == key){
            if (root.left==null){return root.right;}
            else{
                TreeNode node = root.left;
                //TreeNode nodef = root.left;
                while (node.right!=null){
                    //nodef = node;
                    node = node.right;
                }
                int i = root.val;
                root.val = node.val;
                node.val = i;
                //nodef.right = null;

            }
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }

}
