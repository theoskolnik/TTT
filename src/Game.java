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
        board.print();
        Integer move1 = player1.getMove();
        board.updateGrid(move1, player1.symbol());
        board.print();
        Integer move2 = player2.getMove();
        board.updateGrid(move2, player2.symbol());
        board.print();
    }


}
