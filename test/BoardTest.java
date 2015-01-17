import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private Game game;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, bufferedReader, board);
    }

    @Test
    public void shouldDrawFormattedBoard() {
        Board board = new Board();
//        String formattedBoardString = "%-3s | %3s | %3s";
        String formattedBoardString = "  |  |   \n---------\n  |  |   \n---------\n  |  |  ";
        board.print();
        assertThat(board.print(), is(formattedBoardString));
    }

//    @Test
//    public void shouldUpdateBoardWithAnX() throws IOException {
//        String formattedBoardString = "X |  |   \n---------\n  |  |   \n---------\n  |  |  ";
//        when(app.processInput()).thenReturn(1);
//        app.start();
//        app.processInput();
//        assertThat(board.updateBoard(), is(formattedBoardString));
//    }

}