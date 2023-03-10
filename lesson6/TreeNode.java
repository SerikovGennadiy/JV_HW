package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    ArrayList<TreeNode> traversal = new ArrayList<TreeNode>();

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

    public List<Integer> preorderTraversal(TreeNode root) {
       Check(root);

       return traversal
                .stream()
                .map(node -> node.GetValue())
                .collect(Collectors.toList());
    }

    void Check(TreeNode node) {
        if(node != null) {
            traversal.add(node);
            Check(node.left);
            Check(node.right);
        }
    }

    public int GetValue() {
        return this.val;
    }
}