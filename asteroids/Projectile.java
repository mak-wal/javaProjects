package com.example.buttonandlabel.asteroids;

import javafx.scene.shape.Polygon;

public class Projectile extends CharacterClass {

    public Projectile(int x, int y) {
        super(x, y, new Polygon(2,-2,2,2,-2,2,-2,-2));
    }
}
