import java.io.IOException;

/**
 * Created by tskolnik on 1/17/15.
 */
public class Player {

    private IOProcessor ioProcessor;

    public Player(IOProcessor ioProcessor) {
        this.ioProcessor = ioProcessor;
    }

    public Integer getMove() throws IOException {
        ioProcessor.promptPlayer();
        return ioProcessor.processInput();
    }
}
