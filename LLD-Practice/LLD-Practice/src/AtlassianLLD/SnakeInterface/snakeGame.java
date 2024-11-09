package AtlassianLLD.SnakeInterface;

import AtlassianLLD.constants.Direction;

public interface snakeGame {
  void moveSnake(Direction snakeDirection);
  boolean isGameOver();
}
