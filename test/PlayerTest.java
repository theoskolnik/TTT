import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private IOProcessor ioProcessor;
    private Player player;
    private Board board;

    @Before
    public void setUp() throws IOException {
        ioProcessor = mock(IOProcessor.class);
        board = mock(Board.class);
        player = new Player(ioProcessor, "X", board);
    }

    @Test
    public void shouldUpdateCell1OfTheGridWhenUserEnters1() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(1);
        player.move();
        verify(board).updateGrid(1, "X");
    }

    @Test
    public void shouldMarkBoardInTheFirstCell() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(1);
        player.move();
        verify(board).updateGrid(1, "X");
    }

    @Test
    public void shouldMarkBoardInTheSecondCell() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(2);
        player.move();
        verify(board).updateGrid(2, "X");
    }

    @Test
    public void shouldMarkBoardInTheSecondCellWithAStar() throws IOException {
        Player player = new Player(ioProcessor, "*", board);
        when(ioProcessor.getUserInput()).thenReturn(2);
        player.move();
        verify(board).updateGrid(2, "*");
    }




}