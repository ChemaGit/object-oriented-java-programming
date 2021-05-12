package spelling;

import java.util.*;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie() {
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word) {
	    //TODO: Implement this method.
		if(word != null && !word.isEmpty() && word.length() > 0) {
			char[] lowerWord = word.toLowerCase().toCharArray();
			int maxIndex = lowerWord.length - 1;
			return addWord(lowerWord, 0, maxIndex, this.root);
		} else return false;
	}

	private boolean addWord(char[] lowerWord, int index, int maxIndex, TrieNode next) {
		TrieNode nextNode = next.getChild(lowerWord[index]);
		if(index == maxIndex) {
			if(nextNode == null) { // this node doesn't exist
				nextNode = next.insert(lowerWord[index]);
				nextNode.setEndsWord(true);
				this.size += 1;
				return true;
			} else { // this node already exists
				if(nextNode.endsWord()) return false;
				else {
					nextNode.setEndsWord(true);
					this.size +=1;
					return true;
				}
			}
		} else {
			if(nextNode == null) nextNode = next.insert(lowerWord[index]);
			return addWord(lowerWord, index + 1, maxIndex, nextNode);
		}
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size() {
	    //TODO: Implement this method
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) {
	    // TODO: Implement this method
		if(s != null && !s.isEmpty() && s.length() > 0) return isWord(s.toLowerCase().toCharArray(), this.root, 0, s.length() - 1);
		else return false;
	}

	private boolean isWord(char[] s, TrieNode node, int index, int maxIndex) {
		char nextChar = s[index];
		TrieNode nextNode = node.getChild(nextChar);
		if(index == maxIndex) return nextNode.endsWord();
		else return isWord(s, nextNode, index + 1, maxIndex);
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
		List<String> lstRes = new ArrayList<>();
		// 1. Find the stem in the trie.  If the stem does not appear in the trie, return an empty list
		if(prefix != null && !prefix.isEmpty() && prefix.length() > 0) {
			TrieNode nodeStem = findStem(prefix.toLowerCase().toCharArray(), 0, prefix.length() - 1, this.root);
			if(nodeStem != null) {
				// 2. Once the stem is found, perform a breadth first search to generate completions
				Queue<TrieNode> q = new LinkedList<TrieNode>();
				q.add(nodeStem);
				return checkList(predictCompletions(lstRes, q, numCompletions), numCompletions);
			} else return lstRes;
		} else return lstRes;
     }

     private List<String> predictCompletions(List<String> lstRes,Queue<TrieNode> q, int numCompletions) {
     	if(!q.isEmpty() && numCompletions > 0) {
     		TrieNode node = q.remove();
     		if(node.endsWord()) {
     			lstRes.add(node.getText());
				numCompletions -= 1;
				if(numCompletions == 0) return lstRes;
			}
     		Set<Character> setChs = node.getValidNextCharacters();
     		setChs.forEach(c -> q.add(node.getChild(c)));
     		return predictCompletions(lstRes, q, numCompletions);
		} else return lstRes;
	 }

	 private List<String> checkList(List<String> lstRes, int numCompletions) {
     	if(lstRes.size() > numCompletions) {
			lstRes.remove(lstRes.size() - 1);
     		return checkList(lstRes, numCompletions);
		} else return lstRes;
	 }

     private TrieNode findStem(char[] prefix, int index, int maxIndex, TrieNode node) {
     	char nextChar = prefix[index];
     	if(node != null) {
			TrieNode nextNode = node.getChild(nextChar);
			if (index == maxIndex) return nextNode;
			else return findStem(prefix, index + 1, maxIndex, nextNode);
		} else return null;
	 }

 	// For debugging
 	public void printTree() {
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr) {
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	
	public static void main(String[] args) {
		AutoCompleteDictionaryTrie ac = new AutoCompleteDictionaryTrie();
		ac.addWord("dog");
		ac.addWord("downhill");
		ac.addWord("downhiller");
		ac.addWord("doge");
		ac.addWord("dogg");
		ac.addWord("dawg");
		ac.addWord("dage");
		ac.addWord("doggo");
		ac.addWord("doggie");
		ac.addWord("doggos");
		ac.addWord("doggoes");
		ac.addWord("doggies");
		ac.addWord("test");
		ac.addWord("tester");
		ac.addWord("testing");
		ac.addWord("tested");
		ac.addWord("testin");
		ac.addWord("teston");
		ac.addWord("testone");
		ac.addWord("testine");
		ac.addWord("testell");
		ac.addWord("testcase");
		ac.addWord("testbase");
		ac.addWord("testcases");
		// ac.printNode(ac.root);
		List<String> auto = ac.predictCompletions("dogg", 10);
		auto.forEach(w -> System.out.println(w));
	}
	
}