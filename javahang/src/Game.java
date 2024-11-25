//import java.util.*;
import java.util.Scanner;

public class Game 
{
    private String word;
    private String[][] words = {{"apple", "banana", "coconut", "pineapple", "kiwi", "mango"}, 
                                {"bosten terrier", "tabby cat", "elephant", "donkey", "horse", "hippo", "austrialian crocodile"},
                                {"carrot", "celery", "eggplant", "tomato", "chopped spinach", "broccoli"}};
    private char[] guessedLetters;
    private Scanner input = new Scanner(System.in);
    private int randNum; 
    private int guesses;
    private String validChars;
    


    Game(int cate)
    {
        randNum = (int)(Math.random() * words[cate].length);
        word = words[cate][randNum];
        guessedLetters = new char[word.length()];
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == ' ')
            {
                guessedLetters[i] = ' ';
            }
            else{
                guessedLetters[i] = '_';
            }
        }
        guesses = 5;
        validChars = "qwertyuiopasdfghjklzxcvbnm ";
    }

    public int getGuesses()
    {
        return guesses;
    }

    public void removeGuess()
    {
        guesses--;
    }

    public String getWord()
    {
        return word;
    }

    public void printDash() //prints dashes and updates every time called if a correct letter is guessed
    {
        for(int i = 0; i < word.length(); i++)
        {
            System.out.print(guessedLetters[i] + " ");
        }
        System.out.println();
    }
 
    public void askLetter() //asks the letter then calls on check letter
    {
        System.out.print("enter a letter: ");
        String letter = input.nextLine().toLowerCase();
        char cLetter = letter.charAt(0);
        checkLetter(cLetter);
    }


    public void checkLetter(char cL) //checks if letter is a valid character, automatically approves spaces in said check due to constructor
    {
        boolean wordThere = false;
        boolean validChar = false;
        for(int i = 0; i < validChars.length(); i++)
        {
            if(validChars.charAt(i) == cL)
            {
                validChar = true;
            }
        }
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == cL)
            {
                wordThere = true;
                guessedLetters[i] = cL;
            }
        }
        if(!validChar)
        {
            System.out.println("enter a valid character, guesses left: " + guesses);
        }
        else if(!wordThere)
        {
            removeGuess();
            System.out.println("you guessed wrong, guesses left: " + guesses);
        }
        else
        {
            System.out.println("correct! guesses left: " + guesses);
        } 
    }

    public boolean wordComCheck() //checks if the word is complete
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(guessedLetters[i] != word.charAt(i))
            {
                return false;
            }
        }
        return true;
    }




}
