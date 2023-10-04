package codes.blitz.game.message.game;

import java.util.List;

public record MeteorInfos(double score, double size, double approximateSpeed, List<ExplosionInfos> explodesInto) {
}