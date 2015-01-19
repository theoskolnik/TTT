import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class GameTest {

    private Board board;
    private Player player1;
    private Player player2;
    private Game game;
    private IOProcessor ioProcessor;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ioProcessor = mock(IOProcessor.class);
        game = new Game(board, player1, player2);

    }

    @Test
    public void shouldCheckIfAllBoardSpacesAreTaken() throws IOException {
        when(board.allSpacesTaken()).thenReturn(true);
        game.start();
        Assert.assertEquals(true, game.gameIsOver());
    }

    @Test
    public void shouldPlayUntilGameIsOverIsTrue() throws IOException {
        Game game = mock(Game.class);
        when(game.gameIsOver()).thenReturn(true);
        verify(game, times(0)).play();
    }

    @Test
    public void shouldTellPlayer1ToMoveWhenGameStarts() throws IOException {
        when(board.allSpacesTaken()).thenReturn(false).thenReturn(true);
        game.start();
        verify(player1).move();
    }

    @Test
    public void shouldUpdateFirstCellWithPlayerSymbol() throws IOException {
        Player player = new Player(ioProcessor, "*", board);
        when(ioProcessor.getUserInput()).thenReturn(1);
        player.move();
        verify(board).updateGrid(1, "*");
    }




}