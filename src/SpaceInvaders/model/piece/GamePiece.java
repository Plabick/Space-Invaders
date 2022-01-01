package SpaceInvaders.model.piece;

import SpaceInvaders.Constants;

public abstract class GamePiece {
  protected int x, y;
  protected int direction;
  protected int speed; 

  public GamePiece(int x, int y, int direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public void onTick() {
    this.x = x + (this.speed * direction);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }
}
