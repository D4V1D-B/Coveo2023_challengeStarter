package codes.blitz.game.message.game.commands;

import java.util.Objects;

public abstract class CommandAction {
    protected final CommandActionType type;

    public CommandAction(CommandActionType type) {
        this.type = type;
    }

    public CommandActionType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandAction)) return false;
        CommandAction action1 = (CommandAction) o;
        return Objects.equals(getType(), action1.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}