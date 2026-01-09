package pkg;
import java.util.*;
import java.io.*;

public class Reply extends Message {

	// Default Constructor
	public Reply() {
		author = "";
		subject = "";
		body = "";
		indentation = 0;
	}

	// Parameterized Constructor
	public Reply(String auth, String subj, String bod, int i) {
		author = auth;
		subject = subj;
		body = bod;
		indentation = i;
	}

	// Returns if this is a reply (true)
	public boolean isReply(){
		return true;
	}
}
