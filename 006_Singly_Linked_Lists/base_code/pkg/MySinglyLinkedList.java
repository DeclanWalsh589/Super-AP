package pkg;
import java.util.Scanner;
import java.util.Random;


public class MySinglyLinkedList {
	Node head;
	/* 
		Postcondition: The head will be null 
	*/
	public MySinglyLinkedList() {
		head = null;
	}
	public MySinglyLinkedList(Node h){
		head = h;
	}

	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos){
		int i = 0;
		Node next = head.getNext();
		while(next.getNext() != null){
			if(i == pos){
				return next.getData();
			}
			i++;
			next = next.getNext();
		}
		return -1;
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data){
	    Node placeholder = new Node(data);
    	Node current = head;
    	Node prev = head;
    	if (current == null) {
    		head = new Node(data);
        	return;
		}
		if(pos == 0){
			head = placeholder;
			head.setNext(current);
			return;
		}


    for (int i = 0; i < pos - 1 && current != null; i++) {
    	prev = current;
        current = current.getNext();
    }

    if (current == null) {
       prev.setNext(placeholder);
       return;
    }

    placeholder.setNext(current.getNext());
    current.setNext(placeholder);  

	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos){
		Node next = head.getNext();
		Node previous = head;
		int i = 0;
		if(pos == 0){
			head = next;
		}
		while(next.getNext() != null){
			if(i == pos){
				previous.setNext(next.getNext());
			}
			previous = next;
			next = next.getNext();
		}
	}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList(){
		Node next = head;
		// System.out.println(head.getData());
		while(next != null){
			System.out.println(next.getData());
			next = next.getNext();
		}
	
	}
}
