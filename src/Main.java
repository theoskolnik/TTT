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
        Board board = new Board(printStream);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        IOProcessor ioProcessor = new IOProcessor(in, printStream);
        Player player1 = new Player(ioProcessor, "X", board);
        Player player2 = new Player(ioProcessor, "O", board);
        Game game = new Game(board, player1, player2, player1);
        game.start();
    }
}

