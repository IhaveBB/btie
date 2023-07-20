public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode ret = binaryTree.createTree();
        System.out.println(binaryTree.getHeight(ret));
        int x = 0;
        for (int z = 0; z < 5; z++) {
            if (z>=2)
            {
                x++;
            }
        } System.out.println(x);
    }
}
