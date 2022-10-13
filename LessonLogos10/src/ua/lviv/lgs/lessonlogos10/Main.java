package ua.lviv.lgs.lessonlogos10;

import java.util.Scanner;

public class Main {

    private static final int NUMBER_CHAR = 5;
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        String text = readText();
        System.out.println("Palindromes: " + reverseText(text));
        System.out.println("Vowels have been replaced: " + changeVowels(text));
        System.out.println("Number of words in a sentence: " + countNumberOfWords(text));

    }

    public static String readText() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text (rus): ");
        String input = scan.nextLine();
        return input;
    }

    public static String reverseText(String text) {

        if (text == null) {
            throw new IllegalArgumentException("Sentence can not be null");
        } else if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("Sentence can not be empty");
        }
       
        String[] words = text.split(DELIMITER);
        StringBuilder reversedWord = new StringBuilder();
        for (String word : words) {
            String wordClean = word.replaceAll("[^А-Яа-я]", "");
            if (wordClean.length() == NUMBER_CHAR) {
                String word2 = new StringBuilder(wordClean).reverse().toString();
                if (word2.equalsIgnoreCase(wordClean)) {
                    reversedWord.append(wordClean).append(DELIMITER);
                }
            }
        }
        if (reversedWord.length() > 0) {

            return reversedWord.toString();
        } else {
            text = "Palindromes not present in the text!";
            return text;
        }
    }
    
    
    public static String changeVowels(String text) {
        String[] words = text.split(DELIMITER);
        String vowelsChan = text.replaceAll("['А','Е','Ё','И','О','У','Ы','Э','Ю','Я','а','е','ё','и','о','у','ы','э','ю','я']", "-");
        return vowelsChan;
        
    }
    
    public static int countNumberOfWords(String text) {
        String[] words = text.split(DELIMITER);
        int number = words.length;
        return  number;
        
    }

}
