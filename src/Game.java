import java.io.IOException;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private Board board;
    private Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void start() throws IOException {
        board.print();
        Integer move = player.getMove();
        board.updateGrid(move);
        board.print();
    }


}
