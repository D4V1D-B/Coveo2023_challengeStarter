package codes.blitz.game.message.game.commands;

import java.util.Objects;

import codes.blitz.game.message.game.Vector;

public class CommandActionLookAt extends CommandAction {
    private Vector target;

    public CommandActionLookAt(Vector target) {
        super(CommandActionType.LOOKAT);
        this.target = target;
    }

    public Vector getTarget() {
        return target;
    }

    public void setTarget(Vector target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandActionLookAt)) return false;
        if (!super.equals(o)) return false;
        CommandActionLookAt that = (CommandActionLookAt) o;
        return Objects.equals(getTarget(), that.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTarget());
    }
}