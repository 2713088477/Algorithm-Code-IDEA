package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class MaxTwoTreeMultiply {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val =val;}
        TreeNode(int val ,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    private static final long  mod = (long) 1e9+7L;
    private long maxAns=Long.MIN_VALUE;
    private Map<TreeNode,Long> cnt = new HashMap<>();

    public int maxProduct(TreeNode root) {
        long sum=getTreeSum(root);
        dfs(root,sum);
        return  (int)(maxAns%mod);
    }

    private void dfs(TreeNode root, long sum) {
        if(root==null)return;
        //尝试切割左子树
        long leftSum=getTreeSum(root.left);
        long ans=(leftSum*((sum-leftSum)));
        maxAns=Math.max(maxAns,ans);
        //尝试切割右子树
        long rightSum=getTreeSum(root.right);
        ans=(rightSum*((sum-rightSum)));
        maxAns=Math.max(maxAns,ans);
        dfs(root.left,sum);
        dfs(root.right,sum);
    }

    private long getTreeSum(TreeNode root) {
        if(root==null) return 0L;
        if(cnt.containsKey(root)){
            return cnt.get(root);
        }else{
            long ans=root.val+getTreeSum(root.left)+getTreeSum(root.right);
            cnt.put(root,ans);
            return ans;
        }
    }


}
