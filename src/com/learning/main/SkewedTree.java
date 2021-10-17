package com.learning.main;

public class SkewedTree {
	static class Node{
		Node leftNode;
		Node rightNode;
		int nodeData;
	}
	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData=nodeData;
		temp.leftNode=null;
		temp.rightNode=null;
		return temp;
	}
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	
	static void skewed(Node root) {
		if(root==null) {
			return;
		}
		skewed(root.leftNode);
		Node right=root.rightNode;
		if (headNode==null)
 	    {
 	        headNode = root;
 	        root.leftNode = null;
 	        prevNode = root;
 	    }
 	    else
 	    {
 	        prevNode.rightNode = root;
 	        root.leftNode = null;
 	        prevNode = root;
 	    }
 	    skewed(right);
	}
	static void traverseRightSkewed(Node root){
		if(root == null)
        {
			return;
        }
        System.out.print(root.nodeData + " ");
        traverseRightSkewed(root.rightNode);       
	}
	public static void main(String[] args) {
		Node root = newNode(50);
		root.leftNode = newNode(30);
		root.rightNode = newNode(60);
		root.leftNode.leftNode = newNode(10);
		root.rightNode.leftNode = newNode(55);
		skewed(root);
		traverseRightSkewed(headNode);
	}
}

