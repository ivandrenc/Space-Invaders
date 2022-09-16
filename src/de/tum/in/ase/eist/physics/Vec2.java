package de.tum.in.ase.eist.physics;

// basic 2 dimensional vector
public record Vec2(int x, int y) {
    public static final Vec2 ZERO = new Vec2(0, 0);

    public Vec2 add(Vec2 other){
        return  new Vec2(x()+ other.x(),y()+ other.y());
    }

    public Vec2 add(int x, int y){
        return  new Vec2(x()+ x,y()+ y);
    }

    public Vec2 centerToCorner(Vec2 size){
        return add(-size.x()/2, -size.y()/2);
    }

    public Vec2 cornerToCenter(Vec2 size){
        return add(size.x()/2, size.y()/2);
    }

}
