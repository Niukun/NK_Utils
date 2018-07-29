package com.niukun.tree;


public class Demo{
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);
		bt.left = new BinaryTree(2);
		bt.left.left = new BinaryTree(4);
		bt.left.right = new BinaryTree(5);
		bt.right = new BinaryTree(3);
		bt.right.left = new BinaryTree(6);
		bt.right.right = new BinaryTree(7);
		
		
		BinaryTree.firstRead(bt);
		System.out.println();
		BinaryTree.midRead(bt);
		System.out.println();
		BinaryTree.lastRead(bt);
	}
}