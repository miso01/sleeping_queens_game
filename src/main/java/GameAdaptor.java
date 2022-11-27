import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameAdaptor implements GamePlayerInterface{

    private final Game game;

    GameObservable gameObservable = new GameObservable();

    public GameAdaptor() {
        Scanner scanner=  new Scanner(System.in);
        System.out.println("Welcome to Sleeping Queens game!");
        System.out.println("Before the game starts, we need to do some additional setup. Press any key to continue.");

        System.out.println("Please enter a number of players (2-5):");
        int numOfPlayers = scanner.nextInt();
        while (numOfPlayers < 2 || numOfPlayers > 5) {
            System.out.println("Invalid value! Please enter a number of players (2-5):");
            numOfPlayers = scanner.nextInt();
        }
        game = new Game(numOfPlayers);
    }

    @Override
    public void play(String command) {
        getCardPosition(command);
    }

    public int getCardPosition(String command){
        System.out.println("get card position called");
        // Compile regular expression
        final Pattern pattern = Pattern.compile("[h][0-20] [a-z][0-9][0_9]", Pattern.CASE_INSENSITIVE);
        // Match regex against input
        final Matcher matcher = pattern.matcher(command);
        // Use results...
        if(matcher.matches()){
            System.out.println("valid input");
        }

        // ^[h][0-20][a-z][0-9][0_9]$
        //int pos = command;
        return 0;

    }
    private void commandParser(String command){
        getCardPosition(command);
    }
}
