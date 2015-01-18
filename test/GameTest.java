import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private Board board;
    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);

    }

    @Test
    public void shouldCheckIfAllBoardSpacesAreTaken() throws IOException {
        when(board.allSpacesTaken()).thenReturn(true);
        game.start();
        Assert.assertEquals(true, game.gameIsOver());
    }



}