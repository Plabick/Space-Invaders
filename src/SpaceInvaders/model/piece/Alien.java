package SpaceInvaders.model.piece;

import SpaceInvaders.Constants;

public class Alien extends AbstractGamePiece {
  private boolean alive;

  public Alien(int x, int y, int direction) {
    super(x, y, direction);
    this.speed = Constants.ALIEN_SPEED_PER_TICK;
    alive = true;
  }

  public void toggleDirection() {
    this.direction *= -1;
  }

  public void goDownLevel() {
    this.y += Constants.ALIEN_SHIFT_PER_LEVEL;
  }

  public boolean collideWithBullet(Bullet b) {
    int distance = (int) Math.sqrt(Math.pow(this.x - b.getX(), 2) + Math.pow(this.y - b.getY(), 2));

    return b.fromPlayer() && this.alive && b.getStatus() && distance <= Constants.ALIEN_SIZE;
  }

  public void destroy() {
    this.alive = false;
  }

  public boolean getStatus() {
    return this.alive;
  }
}
