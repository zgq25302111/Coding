package Coding;

import java.util.Deque;
import java.util.LinkedList;

public class LC_isValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	public boolean isValidBST4(TreeNode root) {
		return backtrack(root, null, null);
	}

	private boolean backtrack(TreeNode root, Integer low, Integer high) {
		if (root == null)
			return true;
		if (low != null && root.val <= low || high != null && root.val >= high)
			return false;
		return backtrack(root.left, low, root.val) && backtrack(root.right, root.val, high);
	}

	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;

		int val = node.val;
		if (lower != null && val <= lower)
			return false;
		if (upper != null && val >= upper)
			return false;

		if (!helper(node.right, val, upper))
			return false;
		if (!helper(node.left, lower, val))
			return false;
		return true;
	}

	public boolean isValidBST2(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean isValidBST3(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList();
		double inorder = -Double.MAX_VALUE;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (root.val <= inorder)
				return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}
}
