package textgen;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator) {
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}

	private List<String> getTokens(String pattern, String text) {
//		ArrayList<String> tokens = new ArrayList<String>();
//		Pattern tokSplitter = Pattern.compile(pattern);
//		Matcher m = tokSplitter.matcher(text);
//
//		while (m.find()) {
//			tokens.add(m.group());
//		}
//
//		StringBuffer textStringT = new StringBuffer();
//		tokens.stream().forEach(t -> textStringT.append(t));
		String[] arr = text.split("[\\s]+");
		return Arrays.asList(arr);
	}

	private int checkNode(List<ListNode> ln, String word, int tam, int index) {
		if(index == tam) return -1;
		else {
			ListNode node = ln.get(index);
			if(node.getWord().equals(word)) {
				return index;
			} else {
				return checkNode(ln, word, tam, ++index);
			}
		}
	}
	
	/** Train the generator by adding the sourceText
	 *
	 *set "starter" to be the first word in the text
	 * set "prevWord" to be starter
	 * for each word "w" in the source text starting at the second word
	 *    check to see if "prevWord" is already a node in the list
	 *       if "prevWord" is a node in the list
	 *          add "w" as a nextWord to the "prevWord" node
	 *       else
	 *          add a node to the list with "prevWord" as the node's word
	 *          add "w" as a nextWord to the "prevWord" node
	 *     set "prevWord" = "w"
	 *
	 * add starter to be a next word for the last word in the source text.
	 */
	@Override
	public void train(String sourceText) {
		if(sourceText != null && !sourceText.equals("") && !sourceText.isEmpty()) {
			List<String> tokens = getTokens("[^!?]+", sourceText);
			tokens.stream().forEach(t -> System.out.println(t));
			this.starter = tokens.get(0);
			String prevWord = this.starter;
			for(String word : tokens) {
				if(wordList.isEmpty()) {
					ListNode node = new ListNode(word);
					wordList.add(node);
				} else {
					int index = checkNode(wordList, prevWord, wordList.size(), 0);
					if(index >= 0) {
						wordList.get(index).addNextWord(word);
					} else {
						ListNode n = new ListNode(prevWord);
						n.addNextWord(word);
						wordList.add(n);
					}
				}
				prevWord = word;
			}
			ListNode n = new ListNode(prevWord);
			n.addNextWord(starter);
			wordList.add(n);
		}
	}

	private ListNode getNode(String word, int index) {
		ListNode node = this.wordList.get(index);
		if(word.equals(node.getWord())) return node;
		else return getNode(word, ++index);
	}
	
	/** 
	 * Generate the number of words requested.
	 *
	 * set "currWord" to be the starter word
	 * set "output" to be ""
	 * add "currWord" to output
	 * while you need more words
	 *    find the "node" corresponding to "currWord" in the list
	 *    select a random word "w" from the "wordList" for "node"
	 *    add "w" to the "output"
	 *    set "currWord" to be "w"
	 *    increment number of words added to the list
	 */
	@Override
	public String generateText(int numWords) {
		// TODO: Implement this method
		String currWord = starter;
		String space = " ";
		StringBuffer output = new StringBuffer();
		if(numWords > 0 && this.wordList.size() > 0) {
			output.append(currWord);
			int count = 0;
			while(count < numWords - 1) {
				ListNode node = getNode(currWord, 0);
				String w = node.getRandomNextWord(this.rnGenerator);
				output.append(space).append(w);
				currWord = w;
				count++;
			}
		}
		return output.toString();
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString() {
		String toReturn = "";
		for (ListNode n : wordList) {
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText) {
		// TODO: Implement this method.
		this.starter = "";
		this.wordList = new LinkedList<ListNode>();
		this.rnGenerator = new Random(25);
		this.train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args) {
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(87));
		gen.train("hi there hi Leo");
		System.out.println(gen.generateText(4));


		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);

		List<String> tokens = gen.getTokens("[^.!?,]+", textString);

		String textString3 = "You say yes, I say no, You say stop, and I say go, go, go, Oh no. You say goodbye and I say hello, hello, hello, I don't know why you say goodbye,";
		System.out.println(textString3);
//		gen.train(textString);
//		System.out.println(gen);
//		System.out.println(gen.generateText(20));
//		String textString2 = "You say yes, I say no, "+
//				"You say stop, and I say go, go, go, "+
//				"Oh no. You say goodbye and I say hello, hello, hello, "+
//				"I don't know why you say goodbye, I say hello, hello, hello, "+
//				"I don't know why you say goodbye, I say hello. "+
//				"I say high, you say low, "+
//				"You say why, and I say I don't know. "+
//				"Oh no. "+
//				"You say goodbye and I say hello, hello, hello. "+
//				"I don't know why you say goodbye, I say hello, hello, hello, "+
//				"I don't know why you say goodbye, I say hello. "+
//				"Why, why, why, why, why, why, "+
//				"Do you say goodbye. "+
//				"Oh no. "+
//				"You say goodbye and I say hello, hello, hello. "+
//				"I don't know why you say goodbye, I say hello, hello, hello, "+
//				"I don't know why you say goodbye, I say hello. "+
//				"You say yes, I say no, "+
//				"You say stop and I say go, go, go. "+
//				"Oh, oh no. "+
//				"You say goodbye and I say hello, hello, hello. "+
//				"I don't know why you say goodbye, I say hello, hello, hello, "+
//				"I don't know why you say goodbye, I say hello, hello, hello, "+
//				"I don't know why you say goodbye, I say hello, hello, hello,";
//		System.out.println(textString2);
//		gen.retrain(textString2);
//		System.out.println(gen);
//		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode {
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word) {
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}

	/**
	 * select a random word from the "wordList" for "node"
	 * @param generator
	 * @return
	 */
	public String getRandomNextWord(Random generator) {
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int upperBound = nextWords.size();
		int index = generator.nextInt(upperBound);
	    return this.nextWords.get(index);
	}

	public String toString() {
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


