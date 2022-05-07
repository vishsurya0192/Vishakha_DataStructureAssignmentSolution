package com.DSA.question2;


public class BinarySearchTree {
	
	static class Node{
		int data;
		Node leftNode, rightNode;
		
	Node(int value) {
		data = value;
		leftNode = rightNode = null;
	}
 }
	public Node node;
	public Node prevNode = null;
	public Node headNode = null;
	
	
	public void skewedTree(Node root, int value) {
		if(root == null)
			return;
		
		if(value > 0) 
			skewedTree(root.rightNode,value);
		else
			skewedTree(root.leftNode,value);
		
		Node rightNode = root.rightNode;
		Node leftNode = root.leftNode;
		
		if(headNode == null) {
			headNode = root;
			root.leftNode = null;
			prevNode = root;
		}
		else {
			prevNode.rightNode = root;
			root.leftNode = null;
			prevNode = root;
		}
		if(value > 0) 
			skewedTree(leftNode, value);
		else
			skewedTree(rightNode, value);
	}
	
	public void rightSkewedTree(Node root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		rightSkewedTree(root.rightNode);
	}
	

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.node = new Node(50);
		tree.node.leftNode = new Node(30);
		tree.node.rightNode = new Node(60);
		tree.node.leftNode.leftNode = new Node(10);
		tree.node.rightNode.leftNode = new Node(55);
		int value = 0;
		tree.skewedTree(tree.node, value);
		
		System.out.println("right skewed tree according to the business requirement is: ");
		tree.rightSkewedTree(tree.headNode);

	}

}
