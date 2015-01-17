import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        player = new Player(ioProcessor, "X");
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        game = new Game(board, player1, player2);
    }

    @Test
    public void shouldReturnAnInteger() throws IOException {
        when(ioProcessor.processInput()).thenReturn(1);
        Integer expected = 1;
        Assert.assertEquals(expected, player.getMove());
    }

    @Test
    public void shouldHaveXSymbolIfFirstPlayer() throws IOException {
        when(player1.symbol()).thenReturn("X");
        when(player1.getMove()).thenReturn(1);
        when(player2.symbol()).thenReturn("O");
        when(player2.getMove()).thenReturn(2);
        game.start();
        verify(board).updateGrid(1, "X");
        verify(board).updateGrid(2, "O");
    }

}