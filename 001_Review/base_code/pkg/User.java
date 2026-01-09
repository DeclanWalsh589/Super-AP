package pkg;
import java.util.*;
import java.io.*;

public class User {

	// Creates a User with empty name and password.
	String username;
	String pass;
	public User() {
		username = "";
		pass = "";
	}

	// Creates a User with given username and password.
	public User(String usr, String pwd) {
		username = usr;
		pass = pwd;
	}

	// Returns the username
	public String getUsername(){
		return username;
	}

	// Returns true if the stored username/password matches the parameters. Otherwise returns false.
	// Note that, even with a User with empty name and password, this is actually a valid User object (it is the default User), 
	// This function must still return false if given an empty username string.  
	public boolean check(String usr, String psd){
		if(usr.equals(username) && psd.equals(pass))
		{
			if(usr != ""){
				return true;
			}
		}
		return false;
	}

	// Sets a new password.
	// This function should only set the password if the current (old) password is passed in.
	// Also, a default User cannot have its password changed. 
	// Return true if password changed, return false if not.
	public boolean setPassword(String oldPass, String newPass){
		if(oldPass == pass){
			pass = newPass;
			System.out.println("Password Accepted");
			return true;
		}
		System.out.println("Wrong password");
		return false;
	}
}
