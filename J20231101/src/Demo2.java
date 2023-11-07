class TreeNode {
	char data;     // 节点的数据
	TreeNode left; // 左子树节点
	TreeNode right; // 右子树节点

	//初始化节点
	public TreeNode(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	TreeNode root; // 二叉树的根节点

	// 创建二叉树
	public void createTree(String input) {
		if (input == null || input.length() == 0) {
			return; // 如果输入为空或长度为0，直接返回
		}
		TreeNode[] nodes = new TreeNode[input.length()];

		// 创建节点对象，将节点放入数组
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '@') {
				nodes[i] = new TreeNode(input.charAt(i)); // 如果输入字符不是'@'，创建节点并放入数组
			}
		}

		// 构建树结构
		for (int i = 0; i < input.length() / 2; i++) {
			if (nodes[i] != null) {
				int leftIndex = 2 * i + 1;
				int rightIndex = 2 * i + 2;

				if (leftIndex < input.length()) {
					nodes[i].left = nodes[leftIndex]; // 连接左子树
				}

				if (rightIndex < input.length()) {
					nodes[i].right = nodes[rightIndex]; // 连接右子树
				}
			}
		}

		root = nodes[0]; // 根节点为数组的第一个节点
	}

	// 先序遍历
	public void preOrderTraversal(TreeNode node) {
		if (node != null) {
			if (node.data != '#') {
				System.out.print(node.data); // 输出节点的数据（排除'#'字符）
			}
			if (node.left != null || node.right != null) {
				preOrderTraversal(node.left); // 递归遍历左子树
				preOrderTraversal(node.right); // 递归遍历右子树
			}
		}
	}

	// 中序遍历
	public void inOrderTraversal(TreeNode node) {
		if (node != null) {
			if (node.left != null) {
				inOrderTraversal(node.left); // 递归遍历左子树
			}
			if (node.data != '#') {
				System.out.print(node.data); // 输出节点的数据（排除'#'字符）
			}
			if (node.right != null) {
				inOrderTraversal(node.right); // 递归遍历右子树
			}
		}
	}

	// 后序遍历
	public void postOrderTraversal(TreeNode node) {
		if (node != null) {
			if (node.left != null || node.right != null) {
				postOrderTraversal(node.left); // 递归遍历左子树
				postOrderTraversal(node.right); // 递归遍历右子树
			}
			if (node.data != '#') {
				System.out.print(node.data); // 输出节点的数据（排除'#'字符）
			}
		}
	}
}

public class Demo2 {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		String input = "ABCDEFG@@J@@I#";
		tree.createTree(input);

		System.out.println("前序遍历结果：");
		tree.preOrderTraversal(tree.root);
		System.out.println();

		System.out.println("中序遍历结果：");
		tree.inOrderTraversal(tree.root);
		System.out.println();

		System.out.println("后序遍历结果：");
		tree.postOrderTraversal(tree.root);
		System.out.println();
	}
}
