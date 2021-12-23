package com.nonstriater.deepinjava.algo.tree;

import java.util.List;

/**
 * 二叉树路径和
 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 示例:
 给定如下二叉树，以及目标和 target = 22，

       5
      /  \
     4    8
    /    /  \
   11   13   4
   /\       / \
  7  2     5   1

 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 **/

public class BTreePath {


    /**
     * 打印路径和满足 sum 的所有组合
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathsSum(TreeNode root, int sum){

        return null;
    }

    /**
     * 是否有路径和满足 sum
     * @param root
     * @param sum
     * @return
     */
    public boolean isPathSum(TreeNode root, int sum){
        if (root == null) {
            return false;
        }

        int val = root.value;
        if (val == sum && root.left == null && root.right == null) {
            return true;
        }

        return isPathSum(root.left, sum-val) || isPathSum(root.right, sum-val);
    }


}
