package AtlassianLLD;

import AtlassianLLD.SnakeInterface.snakeGame;
import AtlassianLLD.constants.Direction;
import AtlassianLLD.module.Board;
import AtlassianLLD.module.Position;
import AtlassianLLD.module.Snake;

public class SnakeGameImpl implements snakeGame {

  private Snake snake;
  private Board board;

  public SnakeGameImpl(int size, int growthRate, int height, int width) {
    this.snake = new Snake(size, growthRate);
    this.board = new Board(width, height, snake);
  }

  @Override
  public void moveSnake(Direction snakeDirection) {
   Position nextPosition = board.getNextPosition(snakeDirection);
   if(board.isValidMove(nextPosition)) {
     snake.move(nextPosition);
   }
   else
    snake.setAlive(false);
  }

  @Override
  public boolean isGameOver() {
    return snake.isAlive();
  }
}
