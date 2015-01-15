import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Main {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board();
        Game game = new Game(printStream, board);
        game.start();
    }
}
