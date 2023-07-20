/*
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }

    //前序遍历
    public List<TreeNode> preOrder2(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root);
        List<TreeNode> leftTree = preOrder2(root.left);
        ret.addAll(leftTree);
        List<TreeNode> rightTree = preOrder2(root.right);
        ret.addAll(rightTree);
        return ret;
    }

    //中序遍历
    public List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> leftTree = inorderTraversal(root.left);
        ret.addAll(leftTree);
        ret.add(root);
        List<TreeNode> rightTree = inorderTraversal(root.right);
        ret.addAll(rightTree);
        return ret;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int getLeafSize2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    public int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeigh = getHeight(root.right);
        return Math.max(leftHeight, rightHeigh) + 1;

    }
}*/

public class BinaryTree {

    static class TreeNode {
        public char val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用

        public TreeNode(char val) {
            this.val = val;
        }
    }

    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root == null){
            return ;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null){
            return ;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null){
            return ;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if(root == null){
            return ;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size2(root.left);
        int rightSize = size2(root.right);
        return leftSize + rightSize + 1;
    }




    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    void getLeafNodeCount1(TreeNode root) {
        if(root == null){
            return ;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
        if(root.left == null && root.right == null) {
            leafSize++;
        }
    }

    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCount2(root.left)+ getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k-1) +
                getKLevelNodeCount(root.right, k-1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;

    }


    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {

        return null;
    }

    //层序遍历
    void levelOrder(TreeNode root) {

    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        return true;
    }
}