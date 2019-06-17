package marko.kozic;

import java.io.IOException;
import java.util.HashMap;

import org.curiousworks.lesson9.FileHelper;

public class Source {
	
	/**
	 * 1. Create a character class that contains the data for each character in the gotmetadata.txt file. 
	 * You may want to use additional classes to do this.
	 */
	public static Characters characters = new Characters();
	
	public static void main(String[] args) throws IOException  {
		// 2. Print all Daenerys' messages.
		Character Daenerys = characters.getCharacter("Daenerys");
		Daenerys.printMessages();
		
		// 3. Create a pop up that displays the number of messages that each character has sent. 
		characters.displayCharacterNumberOfMessages();
		// 4. We are going to analyze the character's dispositions by measuring their emoji usage.
		// 4a. Verify that Tyrion has a positive disposition (is more happy than sad).
		if (characters.getCharacter("Tyrion").hasPositiveDisposition()) {
			System.out.println("Verified. Tyrion has a positive disposition (is more happy than sad).");
		}
		
		// 4b. Print the character who has the most positive and the most negative disposition.
		System.out.println("Most negative disposition: " + characters.getSaddestCharacter().getName());
		System.out.println("Most positive disposition: " + characters.getHappiestCharacter().getName());
		
		// 4c. Does Jon love Daenerys more than she loves him?
		Character Jon = characters.getCharacter("Jon");
		if (Jon.lovesMore(Daenerys)) {
			System.out.println("Jon love Daenerys more than she loves him");
		}
		
		
	}

}
