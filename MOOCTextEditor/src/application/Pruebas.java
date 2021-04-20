package application;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pruebas {

//    private static List<String> getTokens(String text, String pattern) {
//        ArrayList<String> tokens = new ArrayList<String>();
//        Pattern tokSplitter = Pattern.compile(pattern);
//        Matcher m = tokSplitter.matcher(text);
//
//        while (m.find()) {
//            tokens.add(m.group());
//        }
//        System.out.println(text);
//        System.out.println(pattern);
//        System.out.println("MotherFucker: " + tokens.size());
//        System.out.println(tokens);
//        return tokens;
//    }

    private static int countSyllables(String word) {
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 2) and
        // EfficientDocument (module 3).
        String syllables = "aeiouy";
        int numVowels = 0;
        int numSyllabes = 0;
        int numEes = 0;
        int wordLen = word.length();
        int countWord = 1;
        for(char c: word.toCharArray()) {
            if(countWord == wordLen) {
                if(numSyllabes == 0) {
                    numSyllabes++;
                } else {
                    if( (c == 'e' && numEes > 0) || c != 'e') {
                        numSyllabes++;
                    }
                }
            } else {
                if(syllables.indexOf(c) >= 0) {
                    if(c == 'e') {
                        numEes++;
                    }
                    numVowels++;
                } else {
                    if(numVowels > 0) {
                        numSyllabes++;
                        numVowels = 0;
                    }
                }
            }
            countWord++;
        }
        return numSyllabes;
    }

    public static void main(String[] args) {
//        String text = "2314511167";
//        String[] s = text.split("1+");
//        Arrays.stream(s).forEach(t -> System.out.println(t));
//
//        /***********************/
//        List<String> lst = getTokens("waaaw", "a+");
//        lst.forEach(t -> System.out.println(t));
//
//        List<String> lst2 = getTokens("If you're happy and you know it, clap your hands","ap");
//        lst2.forEach(t -> System.out.println(t));
//        System.out.println(getTokens("This is a test.  How many???  "
//                + "Senteeeeeeeeeences are here... there should be 5!  Right?","[^!|?|.]+").size());
//        System.out.println(getTokens("","[^!|?|.]+").size());
//        System.out.println(getTokens("sentence, with, lots, of, commas.!  "
//                + "(And some poaren)).  The output is: 7.5.","[^!|?|.]+")); //first [^!|?] split by (\.\s) finally (?:.[^.])
//        System.out.println(getTokens("many???  Senteeeeeeeeeences are","[^!|?|.]+").size());
//        System.out.println(getTokens("Here is a series of test sentences. Your program should "
//                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
//                + "the correct amount of syllables (example, for example), "
//                + "but most of them will.","[^!|?|.]+").size());

//        System.out.println("fly: " + countSyllables("fly"));
//        System.out.println("the: " + countSyllables("the"));
//        System.out.println("yes: " + countSyllables("yes"));
//        System.out.println("cave: " + countSyllables("cave"));
//        System.out.println("double: " + countSyllables("double"));
//        System.out.println("segue: " + countSyllables("segue"));
        Random generate = new Random();
        int upperBound = 10;
        for(int i = 0; i <= 30;i++ ) {
            int index =generate.nextInt(upperBound);
            System.out.println("Random number: " + index);
        }
    }
}
