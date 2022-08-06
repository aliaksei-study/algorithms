package com.tree.redblack;

public class RedBlackTreeNode {
    public Integer key;
    public RedBlackTreeNode left;
    public RedBlackTreeNode right;
    public RedBlackTreeNode parent;
    public Color color;

    public RedBlackTreeNode(Integer key) {
        this.key = key;
    }

    public RedBlackTreeNode(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        RedBlackTreeNode node = (RedBlackTreeNode) obj;

        return this.key.equals(node.key);
    }
}
