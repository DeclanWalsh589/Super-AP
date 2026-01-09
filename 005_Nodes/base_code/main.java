import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		Node [] nodes = new Node[100];
		for(int i = 0; i < 100; i ++){
			nodes[i] = (new Node((int)(Math.random() * 100)));
			if(i != 0){
				nodes[i-1].setNext(nodes[i]);
			}
		}
		for(int i = 0; i < 100; i++){
			System.out.println(nodes[i].getData());
		}
	}
}
