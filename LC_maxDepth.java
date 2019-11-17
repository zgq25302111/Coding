package Coding;

public class LC_maxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left_height = maxDepth(root.left);
			int right_height = maxDepth(root.right);
			return java.lang.Math.max(left_height, right_height) + 1;
		}
	}

	public int maxDepth2(TreeNode root) {
		return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
