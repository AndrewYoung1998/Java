//Andrew Young
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AliceandWonderland {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Reads in file
		File myFile = new File("ALICES ADVENTURES IN WONDERLAND.txt");
		Scanner sc = new Scanner(myFile, "UTF-8");
		
		//Creates array list of strings 
		ArrayList<String> lstwords = new ArrayList<String>();
		
		//String array of stopwords
		String[] stopwords = { "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours",
				"yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its",
				"itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this",
				"that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had",
				"having", "do", "does", "did", "doing", "would", "should", "could", "ought", "i'm", "you're", "he's",
				"she's", "it's", "we're", "they're", "i've", "you've", "we've", "they've", "i'd", "you'd", "he'd",
				"she'd", "we'd", "they'd", "i'll", "you'll", "he'll", "she'll", "we'll", "they'll", "isn't", "aren't",
				"wasn't", "weren't", "hasn't", "haven't", "hadn't", "doesn't", "don't", "didn't", "won't", "wouldn't",
				"shan't", "shouldn't", "can't", "cannot", "couldn't", "mustn't", "let's", "that's", "who's", "what's",
				"here's", "there's", "when's", "where's", "why's", "how's", "a", "an", "the", "and", "but", "if", "or",
				"because", "as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between",
				"into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "in",
				"out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when",
				"where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such",
				"no", "nor", "not", "only", "own", "same", "so", "than", "too", "very" };

		//Variables to find word count and word length
		int wordcounter = 0;
		long totallength = 0;
		
		//Loops through file
		while (sc.hasNextLine()) {
			
			//Array of words read from the file
			String[] words = sc.nextLine().replaceAll("-+", " ").split(" ");
			
			/*
			 * Loops through array of stored words 
			 * gets rid of special characters
			 * Lower cases each word, trims word
			 */
			
			for (String word : words) {
				word = word.replaceAll("[^\\w’]", "").replaceAll("[’]", "'").toLowerCase().trim();
				
				if (word.length() > 3 && word.length() < 20) {

					if (word.endsWith("'")) {
						word = word.substring(0, word.length() - 1);
					}
					//Counts words
					wordcounter++;
					
					if (!word.matches("^.*\\d.*$")) {
						//adds lsit of words to array list
						if (!lstwords.contains(word)) {
							lstwords.add(word);
							
						}
					}
				}
			}
		}
		
		//Removes all stop words
		lstwords.removeAll(Arrays.asList(stopwords));
		
		//Sorts list of words
		Collections.sort(lstwords);

		int page = 0;
		int columns = 4;
		int rows = 20;

		/*
		 * Loops through the list of words
		 * Displays page number 
		 */
		while (page * columns * rows < lstwords.size()) {
			
			System.out.println("Page " + (page + 1));
			System.out.println("------------------------------------------------------------------------------");
			
			
			//Loops through to organize words into rows
			for (int y = 0; y < rows; y++) {
				String line = "|";
				
				//Loops through to organize words into columns
				for (int x = 0; x < columns; x++) {
					if (page * columns * rows + x * rows + y < lstwords.size()) {
						line += pad(lstwords.get(page * columns * rows + x * rows + y));
					}
					else {
						line+=pad("");
					}
				}
				
				//Displays list of words in a line 
				System.out.println(line+"|");
			}

			page++;
			System.out.println("------------------------------------------------------------------------------");

		}
		
		//Displays number of words
		System.out.println("Word count: "+wordcounter);
		
		//finds average word count
		for(String s:lstwords) {
			totallength+=s.length();
		}
		
		//Displays average word length
		System.out.printf("Average word length: %.1f",((double) totallength/lstwords.size()));
	}

	//adds padding between each column
	public static String pad(String word) {
		String padding = "                   ";
	
		word += padding.substring(word.length());
		return word;
	}
}
