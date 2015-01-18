import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

/**
 * Created by tskolnik on 1/17/15.
 */
public class IOProcessor {

    private BufferedReader in;
    private PrintStream printStream;

    IOProcessor(BufferedReader in, PrintStream printStream) {
        this.in = in;
        this.printStream = printStream;
    }

    public void printInvalidMoveMessage() {
        System.out.println("Move is already taken. Go again.");
    }

    public int getUserInput() throws IOException {
        printStream.println("Enter a number 1 through 9");
        String userInput = in.readLine();
        return parseInt(userInput);
    }
}

