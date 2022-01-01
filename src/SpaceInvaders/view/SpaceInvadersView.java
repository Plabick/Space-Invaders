package SpaceInvaders.view;


import SpaceInvaders.Constants;
import SpaceInvaders.model.SpaceInvadersBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

// Swing Version
public class SpaceInvadersView extends JFrame {

  public SpaceInvadersView(SpaceInvadersBoard gameBoard) {
    SpaceInvadersPanel panel = new SpaceInvadersPanel(gameBoard);
    this.setSize(new Dimension(Constants.GAME_BOARD_WIDTH, Constants.GAME_BOARD_HEIGHT));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(panel);
    this.setVisible(true);
  }

  public void setKeyListener(KeyListener keyListener){
    this.addKeyListener(keyListener);
  }
  
  public void refresh() {
    this.repaint();
  }
}
