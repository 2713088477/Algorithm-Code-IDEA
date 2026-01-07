package LeetCodeDaily;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxLevelSum {
    static class TreeNode{
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
    public int maxLevelSum(TreeNode root) {
        //1.先获取最大层数
        int deep=findDeep(root);
        int[] sum=new int[deep+1];
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.push(root);
        int cur=1;
        while(!queue.isEmpty()){
            int curSum=0;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode pop = queue.removeFirst();
                curSum+=pop.val;
                if(pop.left !=null)queue.addLast(pop.left);
                if(pop.right!=null)queue.addLast(pop.right);
            }
            sum[cur++]=curSum;
        }
        int maxIndex=1;
        for(int i=1;i<sum.length;i++){
            if(sum[i]>sum[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    private int findDeep(TreeNode root) {
        if(root ==null) return 0;
        return Math.max(findDeep(root.left),findDeep(root.right))+1;
    }
}
