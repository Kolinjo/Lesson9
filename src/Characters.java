package marko.kozic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.curiousworks.lesson9.FileHelper;

public class Characters {
	
	private HashMap<String, Character> characters = new HashMap<String, Character>();
	
	public Character getCharacter(String name) {
		return characters.get(name);
	}

	public Characters() {
		Emotions emo = new Emotions("emo.txt");
		String charactersMetaData = FileHelper.loadMetaData();
		String rows[] = charactersMetaData.split("\n");

		// Skip 1st (i = 0) row "CHARACTER, ALLEGIANCE, MESSAGES_FILE" as it contains headers.
		for(int i = 1; i < rows.length; i++) {
			String columns[] = rows[i].split(", ");
			Character character = new Character(columns[0], emo);
			character.loyaltyOfTheHouse = columns[1];
			character.textFile = columns[2];
			character.messages = FileHelper.loadMessages(character.textFile);
			characters.put(character.getFirstName(), character);
		}
	}
	
	public void displayCharacterNumberOfMessages() {
		for(Character character : characters.values()) {
			String characterTextFile = character.textFile;
			JOptionPane.showMessageDialog(null, character.getName() + " " 
					+ " has a total number of messages " + character.totalNumberOfMessages(characterTextFile));
		}
	}
	
	public Character getSaddestCharacter() {
		Character saddestCharacter = null;

		for(Character character : characters.values()) {
			if (saddestCharacter == null) {
				saddestCharacter = character;
			}

			if (character.getDisposition() < saddestCharacter.getDisposition()) {
				saddestCharacter = character;
			}
		}
		
		return saddestCharacter;
	}

	public Character getHappiestCharacter() {
		Character happiestCharacter = null;

		for(Character character : characters.values()) {
			if (happiestCharacter == null) {
				happiestCharacter = character;
			}

			if (character.getDisposition() > happiestCharacter.getDisposition()) {
				happiestCharacter = character;
			}
		}
		
		return happiestCharacter;
	}
}
