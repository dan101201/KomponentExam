import dk.sdu.student.daref21.common.bullet.BulletSPI;
import dk.sdu.student.daref21.common.services.IEntityProcessingService;
import dk.sdu.student.daref21.common.services.IGamePluginService;
import dk.sdu.student.daref21.playersystem.PlayerControlSystem;
import dk.sdu.student.daref21.playersystem.PlayerPlugin;

module Player {
    exports dk.sdu.student.daref21.playersystem;
    requires Common;
    requires BulletDefault;
    provides IEntityProcessingService with PlayerControlSystem;
    provides IGamePluginService with PlayerPlugin;
    uses BulletSPI;
}