package tree;


public class ChildrenSumProblem {

	static TreeNode root;
	
	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(30);
		
		TreeTraversals.inorderTraversalRecursive(root);
		
		checkChildrenSumProperty(root);
		System.out.println();
		TreeTraversals.inorderTraversalRecursive(root);
	}

	private static int checkChildrenSumProperty(TreeNode node) {
		if(node.left == null && node.right == null)
			return node.data;
		
		int left = node.left != null ? checkChildrenSumProperty(node.left) : 0;
		int right = node.right != null ? checkChildrenSumProperty(node.right) : 0;
		
		if(left + right > node.data)
			node.data += (left + right) - node.data;
		else if(left + right < node.data){
			int diff = node.data - (left + right);
			manageDiff(diff, node);
		}
		return node.data;
	}

	private static void manageDiff(int diff, TreeNode node) {
		if(node.left != null){
			node.left.data += diff;
			manageDiff(diff, node.left);
		}else if(node.right != null){
			node.right.data += diff;
			manageDiff(diff, node.right);
		}
	}
}
