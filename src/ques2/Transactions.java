package ques2;

import java.io.*;

import ques2.Transactions.Node;

public class Transactions {

	static class Node{
		Node leftNode;
		Node rightNode;
		int data;
	};
	
	static Node newNode(int data){

		Node temp  = new Node();
		temp.data = data;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
		
	}
	
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
	
    //Logic to present node values in ascending order by creating a right skewed tree
	static void convertBSTToSkewedTree(Node root)
	{
		if(root == null)
		{
			return;
		}
		
		convertBSTToSkewedTree(root.leftNode);
		
		
		Node rightNode = root.rightNode;
		
		if(headNode == null)
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
		
		convertBSTToSkewedTree(rightNode);
		
	}
	
	//Skewed Tree Traversal
	 static void traverseSkewedTree(Node root) {
		 
		 if(root == null)
		 {
			 return;
		 }
		 System.out.print(root.data + " ");
		 traverseSkewedTree(root.rightNode);
	 }
	 
	 //Driver code
	 public static void main(String[] args) {
			// TODO Auto-generated method stub

				Node root = Transactions.newNode(50);
				root.leftNode = Transactions.newNode(30);
				root.rightNode = Transactions.newNode(60);
				root.leftNode.leftNode = Transactions.newNode(10);
				root.rightNode.leftNode = Transactions.newNode(55);
				
				Transactions.convertBSTToSkewedTree(root);
				Transactions.traverseSkewedTree(headNode);
				
			}

	
}
