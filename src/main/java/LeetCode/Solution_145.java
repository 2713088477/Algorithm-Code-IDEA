package LeetCode;

import java.util.ArrayList;
import java.util.List;

//测试链接:
public class Solution_145 {
    class TreeNode {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findValue(root, list);
        return list;
    }
    public void findValue(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        findValue(root.left,list);
        findValue(root.right,list);
        list.add(root.val);

    }
}
