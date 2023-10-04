package codes.blitz.game.message.game.commands;

public class CommandActionShoot extends CommandAction {
    public CommandActionShoot() {
        super(CommandActionType.SHOOT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandActionShoot)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}