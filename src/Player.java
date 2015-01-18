import java.io.IOException;

/**
 * Created by tskolnik on 1/17/15.
 */
public class Player {

    private IOProcessor ioProcessor;
    private String symbol;
    private Board board;

    public Player(IOProcessor ioProcessor, String symbol, Board board) {
        this.ioProcessor = ioProcessor;
        this.symbol = symbol;
        this.board = board;
    }

    public void move() throws IOException {
        int userInput = ioProcessor.getUserInput();
        board.updateGrid(userInput, symbol);
    }

}
