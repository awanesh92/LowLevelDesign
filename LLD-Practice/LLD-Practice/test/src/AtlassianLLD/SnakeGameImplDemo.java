package AtlassianLLD;

import AtlassianLLD.constants.Direction;
import java.util.ArrayList;
import java.util.Arrays;

public class SnakeGameImplDemo {

  public static void main(String[] args) {
    SnakeGameImpl snakeGame = new SnakeGameImpl(3, 5, 4, 4);

    ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(Direction.UP,Direction.UP,Direction.UP));
    for (Direction direction: directions) {
      snakeGame.moveSnake(direction);
    }
    System.out.println(snakeGame.isGameOver());
  }
}
