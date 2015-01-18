import java.io.IOException;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private final Player player1;
    private final Player player2;
    private Board board;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() throws IOException {
        while(!gameIsOver()) {
            play();
        }
    }

    public void play() throws IOException {
        board.print();
        player1.move();
        game:
        if(gameIsOver()) {
            break game;
        } else {
            board.print();
            player2.move();
        }
    }

    public boolean gameIsOver() {
        return board.allSpacesTaken();
    }
}
