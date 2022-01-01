package SpaceInvaders.model.piece;

import SpaceInvaders.Constants;

public class Bullet extends GamePiece {
  private boolean alive = true;

  public Bullet(int x, int y, int direction) {
    super(x, y, direction);
    this.speed = Constants.BULLET_SPEED_PER_TICK;
  }

  @Override
  public void onTick() {
    this.y += Constants.BULLET_SPEED_PER_TICK * direction;
  }

  @Override
  public void setDirection(int direction) {
    throw new UnsupportedOperationException("Bullets can not change direction once fired");
  }

  public void destroy() {
    this.alive = false;
  }

  public boolean getStatus() {
    return this.alive;
  }

  public boolean fromPlayer() {
    return this.direction == -1;
  }
}
