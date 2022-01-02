package SpaceInvaders.view;

import SpaceInvaders.Constants;
import SpaceInvaders.model.SpaceInvadersBoard;
import SpaceInvaders.model.piece.Alien;
import SpaceInvaders.model.piece.Bullet;

import javax.swing.*;
import java.awt.*;

public class SpaceInvadersPanel extends JPanel {
  private final SpaceInvadersBoard gameBoard;

  SpaceInvadersPanel(SpaceInvadersBoard gameBoard) {
    super();
    this.gameBoard = gameBoard;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Constants.BACKGROUND_COLOR);
    g.setColor(Constants.FOREGROUND_COLOR);
    if (this.gameBoard.isNotOver()) {
      this.drawPlayer(gameBoard.getPlayerX(), gameBoard.getPlayerY(), g);
      this.drawScore(gameBoard.getScore(), Constants.GAME_BOARD_WIDTH - 40, g);
      this.drawAliens(g);
      this.drawBullets(g);
    } else {
      this.drawGameOverMessage(g);
    }
  }

  private void drawBullets(Graphics g) {
    g.setColor(Constants.BULLET_COLOR);
    for (Bullet bullet : this.gameBoard.getBullets()) {
      if (bullet.getStatus()) drawBall(bullet.getX(), bullet.getY(), Constants.BULLET_SIZE, g);
    }
  }

  private void drawAliens(Graphics g) {
    g.setColor(Constants.FOREGROUND_COLOR);
    for (Alien alien : this.gameBoard.getAliens()) {
      if (alien.getStatus()) drawBall(alien.getX(), alien.getY(), Constants.ALIEN_SIZE, g);
    }
  }

  private void drawGameOverMessage(Graphics g) {
    String message = "Game Over!    Final Score: " + gameBoard.getScore();
    g.drawChars(
        message.toCharArray(),
        0,
        message.length(),
        Constants.GAME_BOARD_WIDTH / 2 - 80,
        Constants.GAME_BOARD_HEIGHT / 2 - 20);
  }

  private void drawPlayer(int x, int y, Graphics g) {
    int centerY = y - Constants.PLAYER_HEIGHT / 2;
    int centerX = x - Constants.PLAYER_LENGTH / 2;
    g.fillRect(centerX, centerY, Constants.PLAYER_LENGTH, Constants.PLAYER_HEIGHT);
  }

  private void drawBall(int x, int y, int diameter, Graphics g) {
    int centerX = x - diameter / 2;
    int centerY = y - diameter / 2;
    g.fillOval(centerX, centerY, diameter, diameter);
  }

  private void drawScore(int score, int x, Graphics g) {
    String scoreString = String.valueOf(score);
    g.drawChars(
        scoreString.toCharArray(), 0, scoreString.length(), x, Constants.GAME_BOARD_HEIGHT - 40);
  }
}
