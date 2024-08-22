package dk.sdu.student.daref21.playersystem;

import dk.sdu.student.daref21.common.data.Entity;
import dk.sdu.student.daref21.common.data.GameData;
import static dk.sdu.student.daref21.common.data.GameKeys.LEFT;
import static dk.sdu.student.daref21.common.data.GameKeys.RIGHT;
import static dk.sdu.student.daref21.common.data.GameKeys.UP;

import dk.sdu.student.daref21.common.data.GameKeys;
import dk.sdu.student.daref21.common.data.World;
import dk.sdu.student.daref21.common.data.entityparts.MovingPart;
import dk.sdu.student.daref21.common.data.entityparts.PositionPart;
import dk.sdu.student.daref21.common.services.IEntityProcessingService;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;



/**
 *
 * @author jcs
 */
public class PlayerControlSystem implements IEntityProcessingService {
    int shootingCD = 100;
    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);

            movingPart.setLeft(gameData.getKeys().isDown(LEFT));
            movingPart.setRight(gameData.getKeys().isDown(RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(UP));

            if (gameData.getKeys().isDown(GameKeys.SPACE) && shootingCD <= 0) {
                //world.addEntity(bullet.createBullet(player, gameData));
                shootingCD = 100;
            }
            shootingCD--;
            
            movingPart.process(gameData, player);
            positionPart.process(gameData, player);

            updateShape(player);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
