public class Player {
    private String name;
    private int wins;
    private int rounds;
    private int[] success;
    public Player(String name){
        this.name = name;
        rounds = 0;
        wins = 0;
        success = new int[]{0, 0, 0, 0, 0, 0, 0};
    }
    public String getName(){
        return name;
    }
    public int getWins(){
        return wins;
    }
    public int getRounds(){
        return rounds;
    }
    public double getWinPercentage(){
        return (double)(wins)/rounds;
    }
    public void win(int round){
        rounds++;
        wins++;
        success[round-1]=success[round-1]+1;
    }
    public void loss(){
        rounds++;
        success[6]=success[6]+1;
    }

    public void printInfo(){
        System.out.println(name + " has won " + success[0] + " times in the 1st round.");
        System.out.println(name + " has won " + success[1] + " times in the 2nd round.");
        System.out.println(name + " has won " + success[2] + " times in the 3rd round.");
        System.out.println(name + " has won " + success[3] + " times in the 4th round.");
        System.out.println(name + " has won " + success[4] + " times in the 5th round.");
        System.out.println(name + " has won " + success[5] + " times in the 6th round.");
        System.out.println(name + " has not won " + success[6] + " times.");
        System.out.println();
        if (rounds!=0){
            System.out.println(name + "'s winning percentage is " + getWinPercentage() + " in " + rounds + " games");
            System.out.println();
        }
    }
}
