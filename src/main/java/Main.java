import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameAdaptor gameAdaptor = new GameAdaptor();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
            gameAdaptor.play(scanner.next());


    }
}
