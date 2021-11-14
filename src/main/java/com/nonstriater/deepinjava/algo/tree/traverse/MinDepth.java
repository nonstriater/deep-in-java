package com.nonstriater.deepinjava.algo.tree.traverse;

import com.nonstriater.deepinjava.algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小高度(深度)，这是一个 BFS
 * 思路：BFS
 */
public class MinDepth {


     int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//队尾追加，队满返回false
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();//从队列中删除第一个元素. 队空返回null

                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */

                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }

            /* 这里增加步数 */
            depth++;
        }
        return depth;

    }

}
