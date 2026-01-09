package pkg;
import java.util.*;
import java.io.*;

public class Message {

	// Default Constructor
	String author;
	String subject;
	String body;
	int indentation;
	ArrayList<Message> reps = new ArrayList<Message>();
	public Message() {
		author = "";
		subject = "";
		body = "";
		indentation = 0;
	}
	
	// Parameterized Constructor
	public Message(String auth, String subj, String bod, int i) {
		author = auth;
		subject = subj;
		body = bod;
		indentation = i;
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. i < indentation
	public void print(int indentation){
		for(int i = 0; i < indentation; i++){
			System.out.print("  ");
		}
		System.out.println("Posted by: " + author);
		for(int i = 0; i < indentation; i ++){
			System.out.print("  ");
		}
		System.out.println("Subject: " + subject);
		for(int i = 0; i < indentation; i ++){
			System.out.print("  ");
		}
		System.out.println(body);
		for(int i = 0; i < reps.size(); i++){
			reps.get(i).print(i);
		}
	}

	// Default function for inheritance
	public boolean isReply(){
		return true;
	}

	// Returns the subject String
	public String getSubject(){
		return subject;
	} 

	// Returns the ID
	public int getId(){
		return 1;
	}

	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		reps.add(child);
	}

}
