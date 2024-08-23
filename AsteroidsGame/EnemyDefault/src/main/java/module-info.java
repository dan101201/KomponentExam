import dk.sdu.student.daref21.common.services.IEntityProcessingService;
import dk.sdu.student.daref21.common.services.IGamePluginService;
import dk.sdu.student.daref21.enemysystem.EnemyControlSystem;
import dk.sdu.student.daref21.enemysystem.EnemyPlugin;

module EnemyDefault {
    requires Common;
    provides IEntityProcessingService with EnemyControlSystem;
    provides IGamePluginService with EnemyPlugin;
}
