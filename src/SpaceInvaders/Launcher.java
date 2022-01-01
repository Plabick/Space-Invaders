package SpaceInvaders;

import SpaceInvaders.controller.SpaceInvadersController;
import SpaceInvaders.model.SpaceInvadersBoard;
import SpaceInvaders.view.SpaceInvadersView;

public class Launcher {
  public static void main(String[] args) throws InterruptedException {
    SpaceInvadersBoard board = new SpaceInvadersBoard();
    SpaceInvadersView view = new SpaceInvadersView(board);
    SpaceInvadersController controller = new SpaceInvadersController(view, board);
    controller.start();
  }
}
