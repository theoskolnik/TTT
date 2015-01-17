import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;

    public Game(PrintStream printStream, BufferedReader bufferedReader, Board board) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
    }

    public void start() {
        printStream.println(board.print());
//        promptPlayerToMove();
    }

    public void promptPlayerToMove() throws IOException {
        printStream.println("Enter a number 1 through 9");
    }

    public Integer processInput() throws IOException {
        String userInput = bufferedReader.readLine();
        return Integer.parseInt(userInput);
    }

}
