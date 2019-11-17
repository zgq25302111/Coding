package Coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

	void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.val);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>(0);

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Queue<TreeNode> curLevelNodes = new LinkedList<TreeNode>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			curLevelNodes.offer(node);
			if (queue.isEmpty()) {
				List<Integer> list = new ArrayList<>(curLevelNodes.size());
				while (!curLevelNodes.isEmpty()) {
					TreeNode curNode = curLevelNodes.poll();
					list.add(curNode.val);

					if (curNode.left != null) {
						queue.offer(curNode.left);
					}

					if (curNode.right != null) {
						queue.offer(curNode.right);
					}
				}
				result.add(list);
			}
		}
		return result;
	}
}
