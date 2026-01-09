package pkg;
import java.util.*;
import java.io.*;

public class Topic extends Message {

	// Default Constructor
	public Topic() {
		author = "";
		subject = "";
		body = "";
		indentation = 0;
	}

	// Parameterized constructor
	public Topic(String auth, String subj, String bod, int i) {
		author = auth;
		subject = subj;
		body = bod;
		indentation = i;
	}

	// Returns if it's a reply (false)
	public boolean isReply(){
		return false;
	}
}
