import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private IOProcessor ioProcessor;
    private Player player;
    private Player player1;
    private Player player2;
    private Board board;
    private Game game;
    private PrintStream printStream;

    @Before
    public void setUp() throws IOException {
        ioProcessor = mock(IOProcessor.class);
        board = mock(Board.class);
        player1 = new Player(ioProcessor, "X", board);
    }

    @Test
    public void shouldUpdateCell1OfTheGridWhenUserEnters1() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(1);
        player1.move();
        verify(board).updateGrid(1, "X");
    }

    @Test
    public void shouldMarkBoardInTheFirstCell() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(1);
        player1.move();
        verify(board).updateGrid(1, "X");
    }

    @Test
    public void shouldMarkBoardInTheSecondCell() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(2);
        player1.move();
        verify(board).updateGrid(2, "X");
    }

    @Test
    public void shouldMarkBoardInTheSecondCellWithAStar() throws IOException {
        player = new Player(ioProcessor, "*", board);
        when(ioProcessor.getUserInput()).thenReturn(2);
        player.move();
        verify(board).updateGrid(2, "*");
    }


}