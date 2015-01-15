import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private Board board;
    private PrintStream printStream;

    public Game(PrintStream printStream, Board board) {
        this.printStream = printStream;
        this.board = board;
    }

    public void start() {
        printStream.println(board.drawBoard());
    }
}
