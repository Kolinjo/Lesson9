package marko.kozic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Character {

	public String name;
	public String loyaltyOfTheHouse;
	public String textFile;
	public List<String> messages; 
	public int happines;
	public Emotions emo;
	

	public Character(String name, Emotions emo) {
		this.emo = emo;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getLoyaltyOfTheHouse() {
		return loyaltyOfTheHouse;
	}

	public String getTextFile() {
		return textFile;
	}

	@Override
	public String toString() {
		return "Name of the character is " + name + " and is loyal to  " + loyaltyOfTheHouse;

	}
	
	public String getFirstName() {
		return name.split(" ")[0];
	}
	
	public void printMessages() {
		for(String m: messages) {
			System.out.println(m);
		}
	}

	public int totalNumberOfMessages(String fileName) {
		List<String> sentences = new ArrayList<>();
		File file = new File("resource/message_logs/" + fileName);
		int totalNumberOfMessages = 0;

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = buffer.readLine();

			while (line != null) {
				boolean isSentence = line.contains("\"");
				if (isSentence) {
					int indexOfQuote = line.indexOf("\"");
					sentences.add(line.substring(indexOfQuote, line.length() - 1));
					totalNumberOfMessages += 1;
				}
				line = buffer.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return totalNumberOfMessages;

	}

	public int calculateHappiness() {
		int happiness = 0;

		for(String m: messages) {
			for(String happyE: emo.happyEmotions) {
				happiness += ( m.split(happyE, -1).length ) - 1;
			}
		}
		
		return happiness;
	}

	public int calculateSadness() {
		int sadness = 0;

		for(String m: messages) {
			for(String sadE: emo.sadEmotions) {
				sadness += ( m.split(sadE, -1).length ) - 1;
			}
		}
		
		return sadness;
	}

	public int calculateLovingness() {
		int lovingness = 0;

		for(String m: messages) {
			for(String sadE: emo.loveEmotions) {
				lovingness += ( m.split(sadE, -1).length ) - 1;
			}
		}
		
		return lovingness;
	}
	
	public Boolean hasPositiveDisposition() {
		return getDisposition() > 0;
	}
	
	public int getDisposition() {
		return calculateHappiness() - calculateSadness();
	}
	
	public Boolean lovesMore(Character c) {
		return calculateLovingness() > c.calculateLovingness();
	}

}
