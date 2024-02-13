package org.dvn.leetcode.medium.binarytree;

//1448
public class CountGoodNodesInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int goodNodes(TreeNode root) {
        return checkGoodNode(root, root.val);
    }

    public int checkGoodNode(TreeNode node, int curMax) {
        if (node == null) {
            return 0;
        }
        if (node.val >= curMax) {
            return checkGoodNode(node.left, node.val) + checkGoodNode(node.right, node.val) + 1;
        } else {
            return checkGoodNode(node.left, curMax) + checkGoodNode(node.right, curMax);
        }

    }

}
