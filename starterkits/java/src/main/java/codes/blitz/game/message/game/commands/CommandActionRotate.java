package codes.blitz.game.message.game.commands;

import java.util.Objects;

public class CommandActionRotate extends CommandAction {
    private double angle;

    public CommandActionRotate(double angle) {
        super(CommandActionType.ROTATE);
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandActionRotate)) return false;
        if (!super.equals(o)) return false;
        CommandActionRotate that = (CommandActionRotate) o;
        return Double.compare(that.getAngle(), getAngle()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAngle());
    }
}