package dk.sdu.student.daref21.asteroidsystem;

import dk.sdu.student.daref21.common.data.Entity;

/**
 *
 * @author corfixen
 */
public class Asteroid extends Entity {
    private int size;

    public Asteroid(int size){
        setSize(size);
    }

    public void setSize(int size) {
        this.size = size;
        setRadius(size * 2);
    }

    public int getSize() {
        return size;
    }

    public int getScale(){
        return size * 2;
    }
}
