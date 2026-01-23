import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        Main main = new Main();
        main.game();
    }

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int wins = 0;
    int losses = 0;
    int oldWordCount = 0;
    int newWordCount = 0;
    int min = 5;
    int max = 10;
    String mysteryWord = "";


    public String sonnet = "Two households, both alike in dignity,\n" +
                                        "In fair Verona, where we lay our scene,\n" +
                                        "From ancient grudge break to new mutiny,\n" +
                                        "Where civil blood makes civil hands unclean.\n" +
                                        "From forth the fatal loins of these two foes\n" +
                                        "A pair of star-cross’d lovers take their life;\n" +
                                        "Whose misadventured piteous overthrows\n" +
                                        "Do with their death bury their parents’ strife.\n" +
                                        "The fearful passage of their death-mark’d love,\n" +
                                        "And the continuance of their parents’ rage,\n" +
                                        "Which, but their children’s end, nought could remove,\n" +
                                        "Is now the two hours’ traffic of our stage;\n" +
                                        "The which if you with patient ears attend,\n" +
                                        "What here shall miss, our toil shall strive to mend.\n";

    String[] words = stringToArray(sonnet);


    public String[] stringToArray(String s){
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].replaceAll("[.,;]", "");
        }

        return words;
    }

    public void playTheSonnet(){
        oldWordCount = newWordCount;
        newWordCount = oldWordCount + random.nextInt((max - min) + 1) + min;

        mysteryWord = words[newWordCount];

        String[] newWords = new String[words.length];
        for(int i = 0; i < words.length; i++){
            newWords[i] = words[i].replaceAll("[.,;]", "");
        }

        for(int i = oldWordCount;  i < newWordCount; i++ ){
            System.out.print(newWords[i] + " ");
        }

        System.out.println(censorWord(mysteryWord));
    }

    public static String censorWord(String word){
        String censoredWord = "";

        for(int i = 0; i < word.length(); i++){
            censoredWord += "_";
        }

        return censoredWord;
    }

    public void winOrLoss(String answer){
        if (answer.equalsIgnoreCase(mysteryWord)) {
            wins++;
            System.out.println("Wins: " + wins );
            System.out.println("Losses: " + losses);
        }
        else{
            losses++;
            System.out.println("Wins: " + wins );
            System.out.println("Losses: " + losses);
        }


    }

    public void game(){
        while (wins < 3 && losses < 3){
            playTheSonnet();
            System.out.println("Guess the next word: ");
            String guess = scanner.nextLine();
            winOrLoss(guess);
        }

        if (wins == 3) System.out.println("Congratulations! You win!");
        else if (losses == 3) System.out.println("Womp womp! You lose!");
    }

}
