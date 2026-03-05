package samples.searching;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeByBFS {
	
	//recursive approach
	public boolean isSymmetricRec(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;

		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}

	//using queue
	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		Queue<TreeNode> leftTree = new LinkedList<>();
		Queue<TreeNode> rightTree = new LinkedList<>();

		leftTree.add(root.left);
		rightTree.add(root.right);

		while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
			TreeNode leftNode = leftTree.poll();
			TreeNode rightNode = rightTree.poll();
			if (leftNode == null && rightNode == null)
				continue;
			if (leftNode == null || rightNode == null)
				return false;
			if (leftNode.val != rightNode.val)
				return false;

			// pushing order is very important
			leftTree.add(leftNode.left);
			leftTree.add(leftNode.right);
			// push in reverse for right tree so we can check as mirror image
			rightTree.add(rightNode.right);
			rightTree.add(rightNode.left);

		}
		return true;
	}

}
