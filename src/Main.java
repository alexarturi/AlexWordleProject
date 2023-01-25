import java.util.Scanner;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        Wordle game = new Wordle();
        System.out.println("Welcome to Wordle by Alex Arturi!");
        Scanner scan = new Scanner(System.in);

        System.out.println("The word is: " + game.getWord());

        int counter = 1;
        String current = "";
        while (!Wordle.win && counter<=6){
            while (current.length()!=5){
                System.out.print("Input your guess " + counter + "/6: ");
                current = scan.nextLine();
            }
            game.checkWord(current);
            char[] guessArr = current.toCharArray();
            int c = 0;
            for (String i : Wordle.colors){
                if (i.equals("green")){
                    System.out.print(ANSI_GREEN + guessArr[c] + ANSI_RESET+ " ");
                    System.out.println("gi");
                }
                if (i.equals("yellow")){
                    System.out.print(ANSI_YELLOW + guessArr[c] + ANSI_RESET + " ");
                    System.out.println("yi");
                }
                if (i.equals("gray")) {
                    System.out.print(ANSI_BLACK + guessArr[c] + ANSI_RESET+" ");
                    System.out.println("gri");
                }
                c++;
            }
            Wordle.win = game.checkWin();
            counter++;
        }

    }
}