package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_94 {
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        f(root);
        return ans;
    }
    public void f(TreeNode root){
        if(root==null){
            return;
        }
        f(root.left);
        ans.add(root.val);
        f(root.right);
    }
}
