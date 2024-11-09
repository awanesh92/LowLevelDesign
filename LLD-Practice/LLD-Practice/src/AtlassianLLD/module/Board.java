package AtlassianLLD.module;

import AtlassianLLD.constants.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Board {

  private int width;
  private int height;
  private Snake snake;

  public Board(int width, int height, Snake snake) {
    this.width = width;
    this.height = height;
    this.snake = snake;
  }

  public boolean isValidMove(Position position) {
    return !snake.getBodyPosition().contains(position);
  }

  public Position getNextPosition(Direction direction) {
    Position currPosition= snake.getHead();
    int newX = currPosition.getX();
    int newY = currPosition.getY();
    switch (direction) {
      case UP -> newX = (currPosition.getX()-1+height)%height;
      case DOWN -> newX = (currPosition.getX()+1)%height;
      case LEFT -> newY = (currPosition.getY()-1+width)%width;
      case RIGHT -> newY = (currPosition.getY()+1)%width;
    }
    return new Position(newX, newY);
  }

}
