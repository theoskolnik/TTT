import java.io.IOException;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private Board board;
    private IOProcessor ioProcessor;

    public Game(IOProcessor ioProcessor, Board board) {
        this.ioProcessor = ioProcessor;
        this.board = board;
    }

    public void start() throws IOException {
        board.print();
        ioProcessor.promptPlayer();
        ioProcessor.processInput();
        // as long as game not over, play...
    }


}
