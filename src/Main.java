import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(printStream);
        Game game = new Game(in, board);
        game.start();
    }
}

