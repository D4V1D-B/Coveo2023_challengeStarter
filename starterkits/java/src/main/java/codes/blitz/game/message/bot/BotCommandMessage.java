package codes.blitz.game.message.bot;

import java.util.List;

import codes.blitz.game.message.MessageType;
import codes.blitz.game.message.game.commands.CommandAction;

public record BotCommandMessage(MessageType type, Number tick, List<CommandAction> actions) {
    public BotCommandMessage(Number tick, List<CommandAction> actions)
    {
        this(MessageType.COMMAND, tick, actions);
    }
}
