package marko.kozic;

import java.util.List;

import org.curiousworks.lesson9.FileHelper;

public class Emotions {
	
	public String happyEmotions[];
	public String sadEmotions[];
	public String loveEmotions[];

	public Emotions(String emoText) {
		List<String> ls = FileHelper.loadMessages(emoText);
		happyEmotions = ls.get(0).split(" ");
		sadEmotions = ls.get(1).split(" ");
		loveEmotions = ls.get(2).split(" ");
	}
	

}
