package codes.blitz.game.message.game;

public record Meteor(String id, Vector position, Vector velocity, double size, MeteorType meteorType) {
}