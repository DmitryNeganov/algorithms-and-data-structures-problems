package org.dvn.leetcode.easy.binarytree;

import java.util.ArrayList;
import java.util.List;

//872
public class LeafSimilarTrees {

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

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leafs1 = new ArrayList<>();
            List<Integer> leafs2 = new ArrayList<>();

            collectAlllLeafs(root1, leafs1);
            collectAlllLeafs(root2, leafs2);

            if (leafs1.size() != leafs2.size()) {
                return false;
            }
            return leafs1.equals(leafs2);
        }

        private void collectAlllLeafs(TreeNode root, List<Integer> list) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                list.add(root.val);
            } else {
                collectAlllLeafs(root.left, list);
                collectAlllLeafs(root.right, list);
            }
        }
    }
}