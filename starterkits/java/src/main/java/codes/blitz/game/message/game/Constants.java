package codes.blitz.game.message.game;

import java.util.Map;

public record Constants(WorldConstants world, RocketsConstants rockets, 
                        int cannonCooldownTicks, Map<MeteorType, MeteorInfos> meteorInfos) {
}