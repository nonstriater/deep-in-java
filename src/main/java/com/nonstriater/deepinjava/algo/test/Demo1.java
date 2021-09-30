package com.nonstriater.deepinjava.algo.test;

import java.util.LinkedList;

public class Demo1 {

    static class TreeNode{
        TreeNode left;
        TreeNode right;

        int value;

        public TreeNode(int v){
            value = v;
        }

    }

    public static void main(String[] args){

        TreeNode n1 = new TreeNode(1);

        levelReverse(n1);
    }

    public static void levelReverse(TreeNode root){

        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (list.size() > 0) {

            //出头节点
            TreeNode node = list.poll();
            System.out.printf("%d",node.value);

            //加子节点
            if (node.left != null) {
                list.add(node.left);
            }

            if (node.right != null) {
                list.add(node.right);
            }

        }

    }
}
