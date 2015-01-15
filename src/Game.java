import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private Board board;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Game(PrintStream printStream, Board board, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.board = board;
        this.bufferedReader = bufferedReader;
    }

    public Integer processInput() throws IOException {
        String userInput = bufferedReader.readLine();
        return Integer.parseInt(userInput);
    }

    public void play() {
        printStream.println(board.drawBoard());
    }
}
