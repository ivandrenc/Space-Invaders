package de.tum.in.ase.eist.entities;

import de.tum.in.ase.eist.gameboard.GameObject;
import de.tum.in.ase.eist.physics.Vec2;

//base class for all Objects in the game. DO NOT USE CONSTRUCTORS, use onCreate methode instead
public abstract class Entity extends GameObject {

    //universal properties
    public Vec2 position;
    public Vec2 size;



}
