import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Application {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Game game;

    public Application(PrintStream printStream, BufferedReader bufferedReader, Game game) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.game = game;
    }

    public void start() {
        game.play();
    }


    public void promptPlayerToMove() {
        printStream.println("Enter a number 1 through 9");
    }

    public Integer processInput() throws IOException {
        String userInput = bufferedReader.readLine();
        return Integer.parseInt(userInput);
    }
}
