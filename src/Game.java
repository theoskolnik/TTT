import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public String returnBoard() {
        return board.drawBoard();
    }
}
