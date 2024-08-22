    package dk.sdu.student.daref21.asteroidsystem;

import dk.sdu.student.daref21.common.data.Entity;
import dk.sdu.student.daref21.common.data.GameData;
import dk.sdu.student.daref21.common.data.World;
import dk.sdu.student.daref21.common.data.entityparts.LifePart;
import dk.sdu.student.daref21.common.data.entityparts.MovingPart;
import dk.sdu.student.daref21.common.data.entityparts.PositionPart;
import dk.sdu.student.daref21.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;
    private int life;
    private float deacceleration, acceleration, maxSpeed, rotationSpeed;
    private int shapePointCount;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < Math.floor(Math.random() * 15) + 5; i++) {
            asteroid = createStarterAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    public Entity createStarterAsteroid(GameData gameData) {
        float x = (float) (Math.random() * gameData.getDisplayWidth());
        float y = (float) (Math.random() * gameData.getDisplayHeight());
        float radians = (float) (Math.random() * (2 * Math.PI));

        float startSpeed = (float) (Math.random() * 50f) + 25f;

        Entity asteroid = new Asteroid(3);
        this.updateRadius(asteroid);

        this.buildAsteroid(gameData, asteroid, x, y, radians, startSpeed);


        return asteroid;
    }

    private void updateRadius(Entity asteroid) {
        float radius = 0;
        switch (this.life) {
            case 1:
                radius = 10;
                break;
            case 2:
                radius = 15;
                break;
            case 3:
                radius = 25;
                break;
            default:
                break;
        }
        asteroid.setRadius(radius);
    }

    private void buildAsteroid(GameData gameData, Entity asteroid, float x, float y, float radians, float startSpeed) {

        asteroid.setShapeX(new float[this.shapePointCount]);
        asteroid.setShapeY(new float[this.shapePointCount]);
        asteroid.add(new MovingPart(this.deacceleration, this.acceleration, this.maxSpeed, this.rotationSpeed));
        asteroid.add(new PositionPart(x, y, radians));
        LifePart lifePart = new LifePart(this.life, 0);
        asteroid.add(lifePart);
        this.updateRadius(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

}
