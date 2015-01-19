import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class GameTest {

    private Board board;
    private Player player1;
    private Player player2;
    private Game game;
    private IOProcessor ioProcessor;
    private Player currentPlayer;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        currentPlayer = mock(Player.class);
        ioProcessor = mock(IOProcessor.class);
        game = new Game(board, player1, player2, player1);

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

    @Test
    public void shouldNotPrintTheBoardWhenPlayerMoveIsInvalid() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(1);
        when(board.isMoveTaken(1)).thenReturn(true);
        game.play();
        verify(board, times(1)).print();
    }

    @Test
    public void shouldStartWithPlayer1AsCurrentPlayer() throws IOException {
        game.play();
        verify(player1).move();
    }

    @Test
    public void shouldSwapPlayers() throws IOException {
        game.play();
        verify(player1).move();
        verify(player2).move();
    }

    @Test
    public void shouldPrintBoardBeforePlayer2EntersAMove() throws IOException {
        when(ioProcessor.getUserInput()).thenReturn(1).thenReturn(2);
        when(board.allSpacesTaken()).thenReturn(false).thenReturn(false).thenReturn(true);
        game.start();
        verify(board, times(2)).print();
    }

    @Test
    public void shouldEndGameWhenAllSpacesAreTaken() throws IOException {
        when(board.allSpacesTaken()).thenReturn(true);
        game.play();
        Assert.assertEquals(game.gameIsOver(), true);
    }

}