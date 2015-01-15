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

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, board, bufferedReader);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() throws IOException {
        when(board.drawBoard()).thenReturn("board is drawn");
        game.play();
        verify(printStream).println("board is drawn");
    }

    @Test
    public void shouldDrawFormattedBoard() throws IOException {
        Board board = new Board();
        String formattedBoardString = "  |  |   \n---------\n  |  |   \n---------\n  |  |  ";
        game.play();
        assertThat(board.drawBoard(), is(formattedBoardString));
    }

//    @Test
//    public void shouldUpdateBoard() throws IOException {
//        Board board = new Board();
//        String formattedBoardString = "X |  |   \n---------\n  |  |   \n---------\n  |  |  ";
//        game.start();
//        when(bufferedReader.readLine()).thenReturn("1");

//        assertThat(board.drawBoard(), is(formattedBoardString));
//    }

    @Test
    public void shouldPrintBoardWithAnX() throws IOException {

    }


}