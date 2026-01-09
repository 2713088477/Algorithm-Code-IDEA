package dfs;


public class FindMaxDeepTree {

    public class TreeNode {
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
   public class Pair<K,V> {
        K key;
        V value;

       public Pair() {
       }
       public Pair(K key, V value) {
           this.key = key;
           this.value = value;
       }
       public K getKey() {
           return key;
       }

       public void setKey(K key) {
           this.key = key;
       }

       public V getValue() {
           return value;
       }

       public void setValue(V value) {
           this.value = value;
       }
   }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return f(root).getKey();
    }
    public Pair<TreeNode,Integer> f(TreeNode curRoot){
        if(curRoot==null){
            return new Pair<>(null,0);
        }
        Pair<TreeNode,Integer> left=f(curRoot.left);
        Pair<TreeNode,Integer> right=f(curRoot.right);
        if(left.getValue()>right.getValue()){
            return new Pair<>(left.getKey(),left.getValue()+1);
        }else if(left.getValue()<right.getValue()){
            return new Pair<>(right.getKey(),right.getValue()+1);
        }
        return new Pair<>(curRoot, left.getValue()+1);
    }

}
