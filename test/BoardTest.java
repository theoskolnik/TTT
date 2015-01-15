import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
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
    private BufferedReader bufferedReader;
    private Application app;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        game = mock(Game.class);
        app = new Application(printStream, bufferedReader, game);
    }

    @Test
    public void shouldDrawFormattedBoard() throws IOException {
        Board board = new Board();
        String formattedBoardString = "  |  |   \n---------\n  |  |   \n---------\n  |  |  ";
        game.returnBoard();
        assertThat(board.drawBoard(), is(formattedBoardString));
    }

    @Test
    public void shouldUpdateBoardWithAnX() throws IOException {
        String formattedBoardString = "X |  |   \n---------\n  |  |   \n---------\n  |  |  ";
        when(app.processInput()).thenReturn(1);
        app.start();
        app.processInput();
        assertThat(board.updateBoard(), is(formattedBoardString));
    }

}