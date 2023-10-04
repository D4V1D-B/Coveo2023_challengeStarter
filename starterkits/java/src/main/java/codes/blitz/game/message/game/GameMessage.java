package codes.blitz.game.message.game;

import java.util.List;

public record GameMessage(String type, int tick, List<String> lastTickErrors, Constants constants,
                          Cannon cannon, List<Meteor> meteors, List<Projectile> rockets, int score) {
}