package de.tum.in.ase.eist.entities.enemys.movement;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.physics.Vec2;

public class SnakeLineMove implements MovementPattern{

    private int direction = 0;
    private int vertDistance = 30;
    private int speed = 3;

    private int distToNextSwap;


    @Override
    public void move(Entity e) {
        if(direction == 0){
            e.position = e.position.add(speed,0);
            if(e.position.x() + e.size.x() > e.board().getWidth()){
                distToNextSwap = e.position.y() + vertDistance;
                direction = 1;
            }
        } else if(direction == 1){
            e.position = e.position.add(0,speed);
            if(e.position.y() > distToNextSwap){
                direction = 2;
            }
        }  else if(direction == 2){
            e.position = e.position.add(-speed,0);
            if(e.position.x() <= 0){
                distToNextSwap = e.position.y() + vertDistance;
                direction = 3;
            }
        } else if(direction == 3){
            e.position = e.position.add(0,speed);
            if(e.position.y() > distToNextSwap){
                direction= 0;
            }
        }
    }

    @Override
    public Vec2 getSpawnLocation(Entity e) {
        return e.board().random().nextBoolean() ? new Vec2(3 - e.size.x(), 0) : new Vec2(e.board().getWidth() -3 , 0);
    }
}
