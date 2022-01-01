package SpaceInvaders.model;

import SpaceInvaders.Constants;
import SpaceInvaders.model.piece.Alien;
import SpaceInvaders.model.piece.Bullet;
import SpaceInvaders.model.piece.Player;

import java.util.ArrayList;
import java.util.Random;

public class SpaceInvadersBoard {
  private final ArrayList<Bullet> bullets;
  private ArrayList<Alien> aliens;
  private final Player player;
  private final Random random;
  private int score = 0;
  private boolean notOver = true;

  public SpaceInvadersBoard() {
    bullets = new ArrayList<>();
    initializeAliens();
    player = new Player();
    random = new Random();
  }

  public ArrayList<Alien> getAliens() {
    return new ArrayList<>(this.aliens);
  }

  public void onTick() {
    if (this.notOver) {
      if (random.nextInt(Constants.ALIEN_SHOOT_EVERY_N_TICKS) == 1) {
        Alien shooter = aliens.get(random.nextInt(aliens.size() - 1));
        bullets.add(new Bullet(shooter.getX(), shooter.getY(), 1));
      }
      for (Bullet b : bullets) {
        b.onTick();
        for (Alien a : aliens) {
          if (a.collideWithBullet(b)) {
            a.destroy();
            b.destroy();
            this.score++;
          }
          if (player.collideWithBullet(b)) {
            this.notOver = false;
          }
        }
      }
    }
    if (anyAlienOutsideOfBounds()) {
      for (Alien a : aliens) {
        a.goDownLevel();
        a.toggleDirection();
      }
    }
    for (Alien a : aliens) {
      a.onTick();
    }
    this.player.onTick();
  }

  private void initializeAliens() {
    aliens = new ArrayList<>();
    for (int j = 0; j < Constants.ALIEN_ROWS; j++) {
      for (int k = 0; k < Constants.ALIENS_PER_ROW; k++) {
        int x =
            Constants.ALIEN_HORIZONTAL_PADDING
                + k * (Constants.ALIEN_HORIZONTAL_SPACING + Constants.ALIEN_SIZE);
        int y =
            Constants.ALIEN_VERTICAL_PADDING
                + j * (Constants.ALIEN_VERTICAL_SPACING + Constants.ALIEN_SIZE);
        int direction = j % 2 == 0 ? 1 : -1;
        aliens.add(new Alien(x, y, direction));
      }
    }
  }

  private boolean anyAlienOutsideOfBounds() {
    return this.aliens.get(0).getX() <= 0
        || this.aliens.get(aliens.size() - 1).getX() > Constants.GAME_BOARD_WIDTH;
  }

  public int getPlayerX() {
    return this.player.getX();
  }

  public int getPlayerY() {
    return this.player.getY();
  }

  public void setPlayerDirection(int i) {
    this.player.setDirection(i);
  }

  public void fire() {
    this.bullets.add(new Bullet(player.getX(), player.getY(), -1));
  }

  public ArrayList<Bullet> getBullets() {
    return new ArrayList<>(this.bullets);
  }

  public int getScore() {
    return this.score;
  }

  public boolean isNotOver() {
    return this.notOver;
  }
}
