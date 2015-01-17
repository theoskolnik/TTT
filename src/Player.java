import java.io.IOException;

/**
 * Created by tskolnik on 1/17/15.
 */
public class Player {

    private IOProcessor ioProcessor;
    private String symbol;

    public Player(IOProcessor ioProcessor, String symbol) {
        this.ioProcessor = ioProcessor;
        this.symbol = symbol;
    }

    public Integer getMove() throws IOException {
        ioProcessor.promptPlayer();
        return ioProcessor.processInput();
    }

    public String symbol() {

        return symbol;
    }
}
