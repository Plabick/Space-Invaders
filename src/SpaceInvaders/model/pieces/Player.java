package SpaceInvaders.model.pieces;

import SpaceInvaders.Constants;

public class Player extends AbstractGamePiece {
  public Player() {
    super(
        Constants.GAME_BOARD_WIDTH / 2,
        Constants.GAME_BOARD_HEIGHT - 4 * (Constants.PLAYER_HEIGHT + Constants.PLAYER_PADDING),
        0);

    this.speed = Constants.PLAYER_SPEED_PER_TICK;
  }

  @Override
  public void onTick() {
    super.onTick();
    // Keep paddle on board
    this.x =
        Math.max(
            Constants.PLAYER_LENGTH / 2,
            Math.min(x, Constants.GAME_BOARD_WIDTH - Constants.PLAYER_LENGTH / 2));
  }

  public boolean collideWithBullet(Bullet b) {
    boolean withinBounds =
        b.getX() < this.getX() + Constants.PLAYER_LENGTH / 2
            && b.getX() > this.getX() - Constants.PLAYER_LENGTH / 2
            && b.getY() <= this.y + Constants.PLAYER_HEIGHT / 2
            && b.getY() >= this.y - Constants.PLAYER_HEIGHT / 2;
    return b.getStatus() && !b.fromPlayer() && withinBounds;
  }
}
