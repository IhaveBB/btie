import sun.reflect.generics.tree.Tree;

/**
 * @author IhaveBB
 */
public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode root = null;

    public boolean search(int val){
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val < val){
                cur = cur.right;
            }else if(cur.val > val){
                cur = cur.left;
            }else {
                //cur.val == val;
                return true;
            }
        }
        return false;
    }

    public boolean insert(int val){
        TreeNode node = new TreeNode(val);
        if(root == null){
            root = node;
            return true;
        }
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val < val){
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val){
                parent = cur;
                cur = cur.left;
            }else{
                //相等的情况
                return false;
            }
        }
        if(parent.val < val){
            parent.right = node;
        }else{
            parent.left = node;
        }
        return true;
    }
}
