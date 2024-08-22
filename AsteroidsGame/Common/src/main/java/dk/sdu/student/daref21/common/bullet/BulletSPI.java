package dk.sdu.student.daref21.common.bullet;

import dk.sdu.student.daref21.common.data.Entity;
import dk.sdu.student.daref21.common.data.GameData;

public interface BulletSPI {
    Entity createBullet(Entity e, GameData gameData);
}
