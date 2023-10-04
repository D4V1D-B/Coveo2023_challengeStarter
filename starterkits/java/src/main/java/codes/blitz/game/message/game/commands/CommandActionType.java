package codes.blitz.game.message.game.commands;

public enum CommandActionType
{
    ROTATE("ROTATE"),
    LOOKAT("LOOKAT"),
    SHOOT("SHOOT");

    private final String text;

    CommandActionType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
