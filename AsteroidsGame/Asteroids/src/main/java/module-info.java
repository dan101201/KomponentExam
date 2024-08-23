import dk.sdu.student.daref21.asteroidsystem.AsteroidControlSystem;
import dk.sdu.student.daref21.asteroidsystem.AsteroidPlugin;
import dk.sdu.student.daref21.common.services.IEntityProcessingService;
import dk.sdu.student.daref21.common.services.IGamePluginService;

module Asteroids {
    requires Common;
    provides IEntityProcessingService with AsteroidControlSystem;
    provides IGamePluginService with AsteroidPlugin;
}