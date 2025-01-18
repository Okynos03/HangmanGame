import java.util.Scanner;

class Hangman {
    Scanner sc = new Scanner(System.in);
    String secretWord = "hangman";
    int maxAttempts = 10;
    int attempts = 0;
    boolean guessedWord = false;

    char[] guessedWords = new char[secretWord.length()];

    public void play(){
        for (int i = 0; i < guessedWords.length; i++){
            guessedWords[i] = '_';
            //System.out.print(guessedWords[i]);
        }

        while (!guessedWord && attempts < maxAttempts){
            System.out.println("Word to guess: " + String.valueOf(guessedWords));
            System.out.println("Please enter a letter: ");

            char letter = Character.toLowerCase(sc.next().charAt(0));

            boolean found = false;
            for (int i = 0; i < secretWord.length(); i++){
                if(secretWord.charAt(i) == letter){
                    guessedWords[i] = letter;
                    found = true;
                }
            }

            if(!found){
                attempts++;
                System.out.println("Incorrect guess! Rest attempts: " + (maxAttempts - attempts));
            }

            if(String.valueOf(guessedWords).equals(secretWord)){
                guessedWord = true;
                System.out.println("Congratulations! You guessed correctly!");
                System.out.println("Secret word: " + secretWord);
                System.out.println("Guessed Word: " + String.valueOf(guessedWords));
                System.out.println("Rest attempts: " + (maxAttempts - attempts));
            }

        }
        if(!guessedWord){
            System.out.println("You have not more attempts. Game over!");
            System.out.println("The secret word is: " + secretWord);
        }

        sc.close();
    }

}
