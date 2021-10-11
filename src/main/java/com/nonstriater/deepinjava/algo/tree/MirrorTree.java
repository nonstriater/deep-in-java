package com.nonstriater.deepinjava.algo.tree;

/**
 * 镜像， 翻转二叉树
 * 就是交换每个节点的左右子节点
 */
public class MirrorTree {

    private static class Node{
        int value;
        Node left, right;

        public Node(int v){
            this.value = v;
        }
    }

    public static void main(String[] args){

    }

    /**
     *
     *           1
     *          / \
     *         2   3
     *            /
     *           4
     *            \
     *             5
     */
    public static void test1(){

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n4.right = n5;

        reverse(n1);

    }

    /**
     * 翻转整棵树: 就是交换每个节点的左右子节点
     * @param root
     * @return
     */
    public static void reverse(Node root){
        //bad case
        if (root == null) {
            return ;
        }

        //把交换左右子节点的代码放在了前序遍历的位置
        //后序遍历的位置也是可以的
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        reverse(root.left);
        reverse(root.right);

    }

}
