package codes.blitz.game.message.game.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Command
{
    private final List<CommandAction> actions = new ArrayList<>();

    public Command() {}

    public Command(List<CommandAction> actions)
    {
        this.actions.addAll(actions);
    }

    public void addAction(CommandAction commandAction)
    {
        actions.add(commandAction);
    }

    public List<CommandAction> getActions()
    {
        return actions;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(actions, command.actions);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(actions);
    }
}
