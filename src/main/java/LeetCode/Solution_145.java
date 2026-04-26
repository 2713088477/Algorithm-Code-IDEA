package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_145 {

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
