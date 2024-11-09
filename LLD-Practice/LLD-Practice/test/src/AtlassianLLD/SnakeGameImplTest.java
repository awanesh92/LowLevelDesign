package AtlassianLLD;

import AtlassianLLD.constants.Direction;
import AtlassianLLD.module.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SnakeGameImplTest {

  private SnakeGameImpl snakeGame;

  @BeforeEach
  void setUp() {
    // Initialize the game with test dimensions and parameters
    int boardWidth = 10;         // example board width
    int boardHeight = 10;        // example board height
    int initialSnakeSize = 3;    // initial snake length
    int growthRate = 5;          // snake grows every 5 moves

    // Create a new instance of SnakeGameImpl with the above parameters
    snakeGame = new SnakeGameImpl( initialSnakeSize, growthRate ,boardWidth, boardHeight );
  }

  @AfterEach
  void tearDown() {
    snakeGame = null;
  }

  @Test
  void moveSnake_shouldMoveInSpecifiedDirection() {
    // Test moving the snake in different directions and check its position

    // Move the snake UP and verify the new head position
    snakeGame.moveSnake(Direction.UP);
    Position headPosition = snakeGame.getBoard().getSnake().getHead(); // Assuming you have a getter for board and snake in `SnakeGameImpl`
    assertEquals(new Position(9, 2), headPosition, "Snake head should wrap around to bottom when moving UP from (0, 2)");

    // Move the snake RIGHT and verify
    snakeGame.moveSnake(Direction.RIGHT);
    headPosition = snakeGame.getBoard().getSnake().getHead();
    assertEquals(new Position(9, 3), headPosition, "Snake should move right one position from (9, 2)");

    // Add additional directional moves and assertions as needed
  }

  @Test
  void moveSnake_shouldGrowAfterFixedMoves() {
    // Make moves up to the growth threshold
    for (int i = 0; i < 5; i++) {
      snakeGame.moveSnake(Direction.RIGHT);
    }

    // Verify that the snake has grown by one segment
    int expectedSize = 4; // Initial size + 1 growth after 5 moves
    assertEquals(expectedSize, snakeGame.getBoard().getSnake().getBody().size(), "Snake should grow after 5 moves");
  }

  @Test
  void isGameOver_whenSnakeCollidesWithItself() {
    // Cause the snake to collide with itself (e.g., turn into its body)
    snakeGame.moveSnake(Direction.RIGHT);
    snakeGame.moveSnake(Direction.DOWN);
    snakeGame.moveSnake(Direction.LEFT);
    snakeGame.moveSnake(Direction.UP);  // Should collide with itself here

    assertTrue(snakeGame.isGameOver(), "Game should be over if snake collides with itself");
  }
}