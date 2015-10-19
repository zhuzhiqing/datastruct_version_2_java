package com.jason.hihocoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Trie {
	
	Node head;
	public Trie(){
		head = new Node();
	}
	
	public void addWord(String word){
		Node tmp = head;
		for(int i=0; i<word.length(); i++){
			tmp = tmp.addChildifNotExisit(word.charAt(i));
		}
		tmp.end = true;
	}
	
	public Node find(String word){
		Node tmp = head;
		int i=0;
		for(i=0; i<word.length(); i++){
			if(tmp.child == null)
				return null;
			
			tmp = tmp.getChild(word.charAt(i));
			if(tmp==null)
				return null;
		}
		
		return tmp;
	}
	
	int count = 0;
	public void count(Node node){
		count = 0;
		if(node == null){
			System.out.println(0);
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		countIterative(stack);
		
		System.out.println(count);
	}

	private void countIterative(Stack<Node> nodes){
		if(nodes == null)
			return;
		if(nodes.size()==0)
			return;
		
		Node node = nodes.pop();
		if(node.end)
			count++;
		
		if(node.child ==null ||node.child.size()==0){		//叶子节点
			return;
		}
		
		for(int i=0; i<node.child.size();i++){
			nodes.push(node.child.get(i));
			countIterative(nodes);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie instance = new Trie();
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		String str = "";
		for(int i=0; i<count; i++){
			str = "";
			while(str.equals("")){
				str = scanner.nextLine();
			}
		
			instance.addWord(str);
		}
		
		count = scanner.nextInt();
		for(int i=0; i<count; i++){
			str = "";
			while(str.equals("")){
				str = scanner.next();
			}
			Node node = instance.find(str);
			instance.count(node);
		}
		
		scanner.close();
		
	}

	class Node{
		char key;
		boolean end = false;
		List<Node> child;
		
		public boolean containsChild(char key){
			if(child==null)
				return false;
			
			for(int i=0; i<child.size(); i++){
				if(child.get(i).key == key)
					return true;
			}
			
			return false;
		}
		
		public Node getChild(char key){
			if(child==null)
				return null;
			
			for(int i=0; i<child.size(); i++){
				if(child.get(i).key == key)
					return child.get(i);
			}
			
			return null;
		}
		
		public Node addChild(char key){
			if(child == null)
				child = new ArrayList<Node>();
			
			Node tmp = new Node();
			tmp.key = key;
			child.add(tmp);
			
			return tmp;
		}
		
		public Node addChildifNotExisit(char key){
			
			Node tmp = getChild(key);
			if(tmp == null){
				return addChild(key);
			}else{
				return tmp;
			}
		}
	}
}
