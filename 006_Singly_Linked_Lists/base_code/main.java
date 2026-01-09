import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		MySinglyLinkedList SLL = new MySinglyLinkedList(new Node(2));
		MySinglyLinkedList RSLL = new MySinglyLinkedList();
		for(int i = 0; i < 20; i++){
			SLL.insert(i,(int)(Math.random() * 100));
		}
		for(int i = 0; i < 20; i ++){
			int index = (int)(Math.random() * 20);
			SLL.insert(index, -1);
		}
		SLL.printList();
		for(int i = 0; i < 40; i ++){
			RSLL.insert(0,SLL.get(i));
		}
		System.out.println("____________________________________________________________________");
		RSLL.printList();
	}
}
