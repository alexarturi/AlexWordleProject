public class Wordle {

    public static String[] colors = {"gray", "gray", "gray", "gray", "gray"};
    public static boolean win;
    private WordSource source;
    public static String word;

    public Wordle(){
        win = false;
        source = new WordSource();
        word = source.getWord();
    }

    public void checkWord(String guess){
        String g = guess.toLowerCase();
        String computer = word.toLowerCase();
        char[] guessArr = g.toCharArray();
        char[] wordArr = computer.toCharArray();
        for (int i = 0; i<5; i++){
            int idx = computer.indexOf(guessArr[i]);
            if (guessArr[i]==wordArr[i]){
                colors[i] = "green";
            } else if(idx!=-1 && !colors[idx].equals("green")){
                colors[i] = "yellow";
            } else {
                colors[i] = "gray";
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
