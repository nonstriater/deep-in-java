package com.nonstriater.deepinjava.algo.tree.traverse;

import com.nonstriater.deepinjava.algo.tree.TreeNode;

/**
 * tree 节点个数
 */
public class NodeCnt {

    public int nodeCnt(TreeNode root){
        if (root == null) {
            return 0;
        }

        return 1 + nodeCnt(root.left) + nodeCnt(root.right);
    }

    /**
     * 满二叉树节点个数
     * 满二叉树：每层都是满的， 节点个数为  2^h - 1 ， h 是树高度
     * @param root
     * @return
     */
    public int fullTreeNodeCnt(TreeNode root){
        int h = 0;
        while (root.left != null) {
            root = root.left;
            h++;
        }

        return (int)Math.pow(2, h) - 1;

    }
}
