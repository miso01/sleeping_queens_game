import java.util.Scanner;

public class GameAdaptor implements GamePlayerInterface{

    private final Game game;

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
    public void play(String cards) {

    }
}
