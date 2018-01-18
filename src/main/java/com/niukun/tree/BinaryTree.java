package com.niukun.tree;

public class BinaryTree {
	int value;
	BinaryTree left;
	BinaryTree right;
	public BinaryTree(int value) {
		this.value = value;
	}
	
	/**
	 * 前序遍历
	 * @param bt
	 */
	public void firstRead(BinaryTree bt){
		if(bt.value>0) {
			System.out.print(bt.value + " ");
			if(bt.left!=null) {
				firstRead(bt.left);
			}
			if(bt.right!=null) {
				firstRead(bt.right);
			}
			
		}else {
			System.out.println("Empty tree....");
		}
	}
	
	/**
	 * 中序遍历 
	 * @param bt
	 */
	public void midRead(BinaryTree bt){
		if(bt.value>0) {
			
			if(bt.left!=null) {
				midRead(bt.left);
			}
			System.out.print(bt.value + " ");
			if(bt.right!=null) {
				midRead(bt.right);
			}
			
		}else {
			System.out.println("Empty tree....");
		}
	}
	
	/**
	 * 后序遍历
	 * @param bt
	 */
	public void lastRead(BinaryTree bt){
		if(bt.value>0) {
			if(bt.left!=null) {
				lastRead(bt.left);
			}
			if(bt.right!=null) {
				lastRead(bt.right);
			}
			System.out.print(bt.value + " ");
			
		}else {
			System.out.println("Empty tree....");
		}
	}
	
}