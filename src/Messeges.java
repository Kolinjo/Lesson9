package marko.kozic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Messeges {
	
	public Character toCharacter;
	public String msg;
	
	public Messeges(Character c, String msg) {
		toCharacter = c;
		this.msg = msg;
	}
	
	public Character getCharacter() {
		return toCharacter;
	}
	
	public String getMessage() {
		return msg;
	}
	

}
