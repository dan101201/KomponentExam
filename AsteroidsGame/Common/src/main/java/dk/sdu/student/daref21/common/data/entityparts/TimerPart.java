package dk.sdu.student.daref21.common.data.entityparts;

import dk.sdu.student.daref21.common.data.Entity;
import dk.sdu.student.daref21.common.data.GameData;

/**
 *
 * @author Alexander
 */
public class TimerPart implements EntityPart {

    private float expiration;

    public TimerPart(float expiration) {
        this.expiration = expiration;
    }

    public float getExpiration() {
        return expiration;
    }

    public void setExpiration(float expiration) {
        this.expiration = expiration;
    }

    public void reduceExpiration(float delta) {
        this.expiration -= delta;
    }

    @Override
    public void process(GameData gameData, Entity entity) {
        if (expiration > 0) {
            reduceExpiration(gameData.getDelta());
        }

        if (expiration <= 0) {
            LifePart lifePart = entity.getPart(LifePart.class);
            lifePart.setLife(0);

        }
    }

    @Override
    public TimerPart clone() {
        return new TimerPart(expiration);
    }

}