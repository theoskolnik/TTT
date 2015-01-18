import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private BufferedReader in;
    private IOProcessor ioProcessor;
    private Player player;
    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
        in = mock(BufferedReader.class);
        ioProcessor = new IOProcessor(in);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);
    }

    @Test
    public void shouldPrintBoardGrid() {
        board.print();
        verify(printStream, times(3)).printf("%3s|%3s|%3s\n", "", "", "");
        verify(printStream, times(2)).println("-----------");
    }

    @Test
    public void shouldUpdateBoardWithAnX() throws IOException {
        when(player1.getMove()).thenReturn(1);
        when(player1.symbol()).thenReturn("X");
        board.updateGrid(player1.getMove(), player1.symbol());
        board.print();
        verify(printStream, times(1)).printf("%3s|%3s|%3s\n", "X", "", "");
        verify(printStream, times(2)).printf("%3s|%3s|%3s\n", "", "", "");
        verify(printStream, times(2)).println("-----------");
    }

    @Test
    public void shouldCheckIfMoveIsValid() throws IOException {
        Board board = mock(Board.class);
        when(player1.getMove()).thenReturn(1);
        when(player1.symbol()).thenReturn("X");
        when(player2.getMove()).thenReturn(1);
        when(player2.symbol()).thenReturn("O");
        board.updateGrid(player1.getMove(), player1.symbol());
        board.validatesMove(player2.getMove());
        verify(board, times(0)).updateGrid(player2.getMove(), player2.symbol());

    }



}