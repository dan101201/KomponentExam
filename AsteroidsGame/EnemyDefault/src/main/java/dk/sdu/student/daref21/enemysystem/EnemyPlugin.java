    package dk.sdu.student.daref21.enemysystem;

import dk.sdu.student.daref21.common.data.Entity;
import dk.sdu.student.daref21.common.data.GameData;
import dk.sdu.student.daref21.common.data.World;
import dk.sdu.student.daref21.common.data.entityparts.LifePart;
import dk.sdu.student.daref21.common.data.entityparts.MovingPart;
import dk.sdu.student.daref21.common.data.entityparts.PositionPart;
import dk.sdu.student.daref21.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = 3.1415f / 2;
        
        Entity enemyShip = new Enemy();
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(1, 0));

        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }

}
