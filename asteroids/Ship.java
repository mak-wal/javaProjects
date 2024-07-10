package com.example.buttonandlabel.asteroids;

import javafx.scene.shape.Polygon;

public class Ship extends CharacterClass {
    public Ship(int x, int y) {
        super(x, y, new Polygon(-11, -11, 33, -2, -11, 11));
    }
}
