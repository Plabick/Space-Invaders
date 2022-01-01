package SpaceInvaders.controller;

import SpaceInvaders.Constants;
import SpaceInvaders.model.SpaceInvadersBoard;
import SpaceInvaders.view.SpaceInvadersView;

public class SpaceInvadersController {

  private final SpaceInvadersView view;
  private final SpaceInvadersBoard board;

  public SpaceInvadersController(SpaceInvadersView view, SpaceInvadersBoard board) {
    this.view = view;
    this.board = board;
    view.setKeyListener(new SpaceInvadersKeyListener(board));
  }

  public void start() throws InterruptedException {
    while (true) {
      Thread.sleep(1000 / Constants.TICKS_PER_SECOND);
      board.onTick();
      view.refresh();
    }
  }
}
