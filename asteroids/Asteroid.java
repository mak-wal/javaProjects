package com.example.buttonandlabel.asteroids;

import java.util.Random;

public class Asteroid extends CharacterClass {
    Random random = new Random();
    private double rotationalMovement;
    public Asteroid(int x,int y) {

        super(x,y , new AsteroidCreator().createPolygon());

        super.getGeometryOfCharacter().setRotate(random.nextInt(360));

        int accelerationAmount = 1 + random.nextInt(5);
        for (int i = 0; i < accelerationAmount; i++) {
            accelerate();
        }
        this.rotationalMovement = 0.5 - random.nextDouble();
    }

    @Override
    public void move() {
        super.move();
        super.getGeometryOfCharacter().setRotate(super.getGeometryOfCharacter().getRotate()+rotationalMovement);
    }
}
