package com.nonstriater.deepinjava.algo.tree;

/**
 * 二叉树的最近公共祖先
 * 使用 动态规划思路, 后续遍历思路
 */
public class CommonParent {


    /**
     *
     * @param root  root节点
     * @param p  节点
     * @param q  节点
     * @return
     */
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况 1  ：p, q 在 root 为根的树中
        if (left != null && right != null) {
            return root;
        }
        // 情况 2 ：p, q 不在  root 为根的树中
        if (left == null && right == null) {
            return null;
        }
        // 情况 3 ： p, q 只有1个在root 为根的树中
        return left == null ? right : left;
    }

}
