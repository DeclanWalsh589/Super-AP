package pkg;
import java.util.Scanner;
import java.util.Random;


public class Stack {
	/*  LAST IN FIRST OUT  */
	Node top;

	/* 
		Postcondition: The top will be null.
	*/
	public Stack() {
		top = null;
	}

	/*
		Insert a new Node on top of the stack
	*/
	public void push(int data){
		Node placeholder = top;
		top = new Node(data);
		top.setNext(placeholder);
	}

	/*
		Removes the top node of the stack
	*/
	public int pop(){
		if(!isEmpty){
			int value = top.getData();
			top = top.getNext();
			return value;
		}
	}

	/*
		Returns the top value of the stack. Doesn't pop. 
	*/
	public int peek(){
		if(!isEmpty){
			return top.getData();
		}
	}

	/*
		Checks if the stack is empty. 
	*/
	public boolean isEmpty(){
		if(top == null){
			return true
		}
	}
}
