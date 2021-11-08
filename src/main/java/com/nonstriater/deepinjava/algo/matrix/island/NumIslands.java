package com.nonstriater.deepinjava.algo.matrix.island;

/**
 * 岛屿数量
 * 岛屿系列算法问题是经典的面试高频题， 核心考点就是用 DFS/BFS 算法遍历二维数组
 * 输入一个二维数组 grid，其中只包含 0 或者 1，0 代表海水，1 代表陆地，且假设该矩阵四周都是被海水包围着的。
 * 连成片的陆地形成岛屿，那么请你写一个算法，计算这个矩阵 grid 中岛屿的个数
 */
public class NumIslands {

    // 主函数，计算岛屿数量
    int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

}
