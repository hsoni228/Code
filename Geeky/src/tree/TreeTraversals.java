package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {

	public static void postTraversalRecursive(TreeNode root) {
		if(root == null)
			return;
		
		postTraversalRecursive(root.left);
		postTraversalRecursive(root.right);
		System.out.print(root.data + " ");
	}

	public static void preTraversalRecursive(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		preTraversalRecursive(root.left);
		preTraversalRecursive(root.right);
	}

	public static void inorderTraversalRecursive(TreeNode root) {
		if(root == null)
			return;
		
		inorderTraversalRecursive(root.left);
		System.out.print(root.data + " ");
		inorderTraversalRecursive(root.right);
	}

	private static void levelOrderTraversal(Queue<TreeNode> queue) {
		if(queue.element() == null)
			return;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
	}

	public static void levelOrderTreeTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		levelOrderTraversal(queue);
	}
}
