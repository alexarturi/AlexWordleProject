public class Wordle {
    private String[] bank = {"HELLO", "IRATE", "ADIEU", "BRAKE", "MOUNT", "HAPPY", "TRACK", "PARTY", "FUDGE", "DROOP"};
    private String starter;
    public static String[] colors = {"gray", "gray", "gray", "gray", "gray"};
    public static boolean win;

    public Wordle(){
        starter = bank[(int)(Math.random()*10)];
        win = false;
    }

    public String getWord(){
        return starter;
    }

    public void checkWord(String guess){
        char[] guessArr = guess.toCharArray();
        char[] wordArr = starter.toCharArray();
        for (int i = 0; i<5; i++){
            if (guessArr[i]==wordArr[i]){
                colors[i] = "green";
            } else {
                if(starter.indexOf(guessArr[i])!=-1) {
                    colors[i] = "yellow";
                }
            }
        }
    }

    public boolean checkWin(){
        int count = 0;
        for (String i : colors){
            if (i.equals("green")){
                count++;
            }
        }
        if (count==5){
            return true;
        }
        return false;
    }
}
