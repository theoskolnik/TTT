import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by tskolnik on 1/17/15.
 */
public class IOProcessor {

    private BufferedReader in;

    IOProcessor(BufferedReader in) {
        this.in = in;
    }

    protected void promptPlayer() {
        System.out.println("Enter a number 1 through 9");
    }

    protected Integer processInput() throws IOException {
        String userInput = in.readLine();
        return Integer.parseInt(userInput);
    }
}
