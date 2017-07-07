package tree;


public class BinarySearchTree {
	TreeNode root;
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int arr[] = {5,3,4,1,7,8};
		
		for(int i = 0; i < arr.length; i++){
			bst.root = insertIntoTree(bst.root, arr[i]);
		}
		
		System.out.println("Inorder Traversal of tree");
		TreeTraversals.inorderTraversalRecursive(bst.root);
		
		System.out.println("\nPre Traversal of tree");
		TreeTraversals.preTraversalRecursive(bst.root);
		
		System.out.println("\nPost Traversal of tree");
		TreeTraversals.postTraversalRecursive(bst.root);
		
		System.out.println("\nLevel Order Traversal of tree");
		TreeTraversals.levelOrderTreeTraversal(bst.root);
	}

	private static TreeNode insertIntoTree(TreeNode root, int data) {
		TreeNode node = new TreeNode(data);
		if(root == null){
			root = node;
			return root;
		}
		
		if(data < root.data)
			root.left = insertIntoTree(root.left, data);
		else
			root.right = insertIntoTree(root.right, data);
		return root;
	}
}
