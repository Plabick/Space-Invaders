package SpaceInvaders.controller;

import SpaceInvaders.model.SpaceInvadersBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceInvadersKeyListener implements KeyListener {

  SpaceInvadersBoard board;

  public SpaceInvadersKeyListener(SpaceInvadersBoard board) {
    this.board = board;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyChar()) {
      case 'a':
        board.setPlayerDirection(-1);
        break;
      case 'd':
        board.setPlayerDirection(1);
        break;
      case ' ':
        board.fire();
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyChar() == 'a' || e.getKeyChar() == 'd') {
      board.setPlayerDirection(0);
    }
  }
}
