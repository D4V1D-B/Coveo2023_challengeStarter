package codes.blitz.game.bot;

import codes.blitz.game.message.game.GameMessage;
import codes.blitz.game.message.game.commands.Command;
import codes.blitz.game.message.game.commands.CommandActionRotate;
import codes.blitz.game.message.game.commands.CommandActionShoot;

public class Bot
{
    private int direction;

    public Bot()
    {
        System.out.println("Initializing your super duper mega bot.");
        // initialize some variables you will need throughout the game here
        this.direction = 1;
    }

    /*
     * Here is where the magic happens. I bet you can do better ;)
     */
    public Command getCommand(GameMessage gameMessage)
    {
        Command command =  new Command();

        if (gameMessage.cannon().orientation() >= 45) {
            this.direction = -1;
        } else if (gameMessage.cannon().orientation() <= -45) {
            this.direction = 1;
        }

        command.addAction(new CommandActionRotate(15 * this.direction));
        command.addAction(new CommandActionShoot());
        return command;
    }
}