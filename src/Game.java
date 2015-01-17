import java.io.BufferedReader;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private BufferedReader bufferedReader;
    private Board board;

    public Game(BufferedReader bufferedReader, Board board) {
        this.bufferedReader = bufferedReader;
        this.board = board;
    }

    public void start() {
        board.print();
        // as long as game not over, play...
    }

//    public void promptPlayerToMove() {
//        printStream.println("Enter a number 1 through 9");
//    }
//
//    public Integer processInput() throws IOException {
//        String userInput = bufferedReader.readLine();
//        return Integer.parseInt(userInput);
//    }

}
