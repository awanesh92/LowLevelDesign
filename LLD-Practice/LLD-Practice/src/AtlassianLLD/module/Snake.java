package AtlassianLLD.module;

import java.util.HashSet;
import java.util.LinkedList;
import lombok.Getter;

@Getter
public class Snake {
  private int size;
  private LinkedList<Position> body;
  private HashSet<Position> bodyPosition;
  private int growsRate;
  private int moveCount;
  private boolean isAlive;

  public Snake(int size, int growsRate) {
    this.body = new LinkedList<>();
    this.bodyPosition = new HashSet<>();
    this.size = size;
    this.growsRate = growsRate;
    this.moveCount = 0;
    this.isAlive = true;

    //Initialize snake body
    for(int i=size-1;i>=0;i--) {
      Position position = new Position(0,i);
      this.body.add(position);
      this.bodyPosition.add(position);
    }
  }

  public Position getHead() {
    return this.body.getFirst();
  }

  public LinkedList<Position> getBody() {
    return body;
  }

  public HashSet<Position> getBodyPosition() {
    return bodyPosition;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void move(Position newHead) {
    if(this.bodyPosition.contains(newHead)){
      setAlive(false);
      return;
    }

    this.body.addFirst(newHead);
    this.bodyPosition.add(newHead);
    this.moveCount++;
    if(this.moveCount%this.growsRate!=0) {
      Position tail = this.body.removeLast();
      this.bodyPosition.remove(tail);
    }
  }
}