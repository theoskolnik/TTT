import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private Game game;

//    When the program starts, draw a board that looks like this:
//            |   |
//            ---------
//            |   |
//            ---------
//            |   |

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        game = new Game(printStream, board);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        when(board.drawBoard()).thenReturn("board is drawn");
        game.start();
        verify(printStream).println("board is drawn");
    }

    @Test
    public void shouldDrawFormattedBoard() {
        Board board = new Board();
        String formattedBoardString = "  |  |   \n---------\n  |  |   \n---------\n  |  |  ";
        game.start();
        assertThat(board.drawBoard(), is(formattedBoardString));
    }



}