package de.tum.in.ase.eist.entities.enemys;

import de.tum.in.ase.eist.entities.Entity;
import de.tum.in.ase.eist.entities.enemys.*;
import de.tum.in.ase.eist.physics.Vec2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EnemySpawner extends Entity {


    private Set<Enemy> allEnemys = new HashSet<>();
    private int cooldownDuration = 170;
    private int cooldown;


    @Override
    public void onUpdate() {
        if (cooldown == 0) {
            cooldown = cooldownDuration;
            switch (board().random().nextInt(7)) {
                case 1 -> createEnemy(new FastBoi()).moveToRandomStartPoint();
                case 2 -> createEnemy(new LaserGuy()).moveToRandomStartPoint();
                case 3 -> createEnemy(new OctoAlien()).moveToRandomStartPoint();
                case 4 -> createEnemy(new TheSmoothSilder(true)).moveToRandomStartPoint();
                case 5 -> createEnemy(new TheSmoothSilder(false)).moveToRandomStartPoint();
                default -> createEnemy(new BasicEnemy()).moveToRandomStartPoint();
            }
        } else {
            cooldown--;
        }
    }



    private Enemy createEnemy(Enemy enemy){
        board().registerEntity(enemy);
        enemy.spawner = this;
        allEnemys.add(enemy);
        return enemy;
    }


    public Set<Enemy> getAllEnemys() {
        return allEnemys;
    }
}
