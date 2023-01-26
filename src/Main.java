import java.util.Scanner;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        System.out.println("Welcome to Wordle by Alex Arturi!");
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        Player player = new Player(name);
        System.out.println("Welcome, " + name + "!");

        String command = "";

        while(!command.equals("stop")){
            Wordle game = new Wordle();
            command = "";
            while (!command.equals("stop") && !command.equals("s") && !command.equals("k")){
                System.out.println("Type in 'stop' to stop playing.");
                System.out.println("Type in 's' to view your stats");
                System.out.println("Type in 'k' to keep playing");
                command = scan.nextLine();
            }
            if(command.equals("s")){
                player.printInfo();
            }
            if(command.equals("k")){
                int counter = 1;
                while (!Wordle.win && counter<=6){
                    System.out.println();
                    String current = "";
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
                        }
                        if (i.equals("yellow")){
                            System.out.print(ANSI_YELLOW + guessArr[c] + ANSI_RESET + " ");
                        }
                        if (i.equals("gray")) {
                            System.out.print(ANSI_BLACK + guessArr[c] + ANSI_RESET+" ");
                        }
                        c++;
                    }
                    Wordle.win = game.checkWin();
                    counter++;
                }
                boolean yes = true;
                for (String i : Wordle.colors){
                    if (!i.equals("green")){
                        yes = false;
                    }
                }
                if (yes){
                    if (counter!=1){
                        player.win(counter-1);
                        System.out.println("\nYou solved today's wordle in " + (counter-1) + "/6 guesses!");
                    }
                } else {
                    player.loss();
                }
                System.out.println();
                System.out.println("The word was " + Wordle.word);
            }
        }
    }
}