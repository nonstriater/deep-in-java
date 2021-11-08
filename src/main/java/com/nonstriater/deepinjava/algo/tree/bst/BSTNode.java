package com.nonstriater.deepinjava.algo.tree.bst;

/**
 * BST(binary search tree) 二叉搜索树
 * 特性： 对于 BST 的每一个节点 node，左子树节点的值都比 node 的值要小
 * 一个重要的性质：BST 的中序遍历结果是有序的（升序）
 *
 * AVL 平衡二叉树， 绝对平衡
 * 红黑树：相对平衡二叉树，弱平衡二叉树，旋转次数少；
 * 红黑树牺牲掉一定的平衡性（牺牲查找性能），换来了 插入，删除操作时 更少的旋转次数带来的开销。
 */
public class BSTNode {

    BSTNode left;
    BSTNode right;
    int value;

    /**
     * 是否合法的BST
     * @return
     */
    public boolean isValidBST(BSTNode root){

        return true;
    }

    /**
     * 查找元素
     * @param root
     * @param target
     * @return  能否找到
     */
    public boolean find(BSTNode root, int target) {

        return true;
    }

}
