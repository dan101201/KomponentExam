package dk.sdu.student.daref21.bulletsystem;

import dk.sdu.student.daref21.common.data.Entity;
    import dk.sdu.student.daref21.common.data.GameData;
    import dk.sdu.student.daref21.common.data.World;
    import dk.sdu.student.daref21.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Finds and removes all bullet entities
        for (Entity e : world.getEntities()) {
            if (e.getClass() == Bullet.class) {
                world.removeEntity(e);
            }
        }
    }

}
