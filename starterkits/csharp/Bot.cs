using System;
using System.Collections.Generic;

namespace Application;

public class Bot
{
    public const string NAME = "MyBot C#";
    private int direction = 1;

    /// <summary>
    /// This method should be use to initialize some variables you will need throughout the game.
    /// </summary>
    public Bot()
    {
        Console.WriteLine("Initializing your super mega bot!");
    }

    /// <summary>
    /// Here is where the magic happens, for now the moves are random. I bet you can do better ;)
    /// </summary>
    public Action[] GetNextMove(GameMessage gameMessage)
    {
        if (gameMessage.Cannon.Orientation >= 45)
        {
            direction = -1;
        }
        else if (gameMessage.Cannon.Orientation <= -45)
        {
            direction = 1;
        }

        return new Action[] { new ActionRotate(15 * direction), new ActionShoot() };
    }
}
