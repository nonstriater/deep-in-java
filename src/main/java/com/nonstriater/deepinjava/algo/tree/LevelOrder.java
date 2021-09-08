package com.nonstriater.deepinjava.algo.tree;

import java.util.*;

/**
 * 按层遍历
 */
public class LevelOrder {

    private static class Node{
        int value;
        Node left, right;

        public Node(int v){
            this.value = v;
        }
    }

    public static void main(String[] args){

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n4.right = n5;

        System.out.println(levelOrder(n1));
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node node){
        if (node == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        Queue<Node> queue = new LinkedList();//LinkedList 就是一个Queue
        queue.add(node);
        while (queue.size() >0) {
            //当前层
            ArrayList<Integer> row = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                Node currentNode = queue.poll();//出队
                row.add(currentNode.value);//当前层元素，入当前层Array

                //当前层，当前节点 子节点 入队
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(row);
        }

        return result;
    }

}
