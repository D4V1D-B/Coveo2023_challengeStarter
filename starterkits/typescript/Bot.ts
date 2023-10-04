import { GameMessage, Action, ActionTypes } from "./GameInterface";

export class Bot {
  constructor() {
    console.log("Initializing your super duper mega bot");
    // This method should be use to initialize some variables you will need throughout the game.
  }

  private direction = 1;

  /*
   * Here is where the magic happens, for now the moves are random. I bet you can do better ;)
   */
  getNextMoves(gameMessage: GameMessage): Action[] {
    if (gameMessage.cannon.orientation >= 45) {
      this.direction = -1;
    }
    else if (gameMessage.cannon.orientation <= -45) {
      this.direction = 1;
    }

    return [
      {
        type: ActionTypes.ROTATE,
        angle: 15 * this.direction,
      },
      {
        type: ActionTypes.SHOOT,
      }
    ];
  }
}
