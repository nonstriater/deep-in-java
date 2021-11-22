package com.nonstriater.deepinjava.algo.link;

/**
 * 复杂链表复制
 * 复杂链表定义: 每个结点除了有一个m_pNext的指针指向下一个结点外，还有一个m_pSibling的指针指向链表中任意结点或者NULL
 * 因此，难点在于 Sibling 指针指向任意节点
 *
 * 思路
 * 1. 借助哈希表，先遍历链表，将结点与新建结点构建映射关系，再遍历构建新链表各节点的next和random引用指向即可
 * 2. 考虑构建 原结点1→新结点1→原结点2→新结点2→...的拼接链表。
 * 这样在找到原结点random指向的同时，就可以找到新结点的random指向为原结点random指向的next结点 ； 一共遍历了三遍数组
 */
public class CopyLink {
}
