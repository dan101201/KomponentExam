import dk.sdu.student.daref21.bulletsystem.BulletControlSystem;
import dk.sdu.student.daref21.bulletsystem.BulletPlugin;
import dk.sdu.student.daref21.common.services.IGamePluginService;
import dk.sdu.student.daref21.common.services.IEntityProcessingService;
import dk.sdu.student.daref21.common.bullet.BulletSPI;

module BulletDefault {
    requires Common;
    provides BulletSPI with BulletControlSystem;
    provides IGamePluginService with BulletPlugin;
    provides IEntityProcessingService with BulletControlSystem;
}