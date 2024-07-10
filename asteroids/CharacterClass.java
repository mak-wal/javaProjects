package com.example.buttonandlabel.asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.HashMap;
import java.util.Map;

public abstract class CharacterClass {
    private Point2D movement;
    private Polygon geometryOfCharacter;
    public Map<Polygon,Boolean> mortalityOfObjects = new HashMap<>();

    public CharacterClass(int x, int y, Polygon geometry) {
        this.geometryOfCharacter = geometry;
        this.geometryOfCharacter.setTranslateX(x);
        this.geometryOfCharacter.setTranslateY(y);
        this.movement = new Point2D(0, 0);    //wartość w kierunku x lub y wprowadzi satek w natychmiastowy ruch po odpaleniu programu
        this.mortalityOfObjects.put(this.geometryOfCharacter, true);//kluczowe! Na początku zakładamy że obiekt jest ,,żywy"
    }
    public Polygon getGeometryOfCharacter() {
        return this.geometryOfCharacter;
    }
    public void move() {
        this.geometryOfCharacter.setTranslateX(this.geometryOfCharacter.getTranslateX()
                + this.movement.getX());
        this.geometryOfCharacter.setTranslateY(this.geometryOfCharacter.getTranslateY()
                + this.movement.getY());
        if (this.geometryOfCharacter.getTranslateX() < 0) {
            this.geometryOfCharacter.setTranslateX(this.geometryOfCharacter.getTranslateX() + AsteroidsApplication.WIDTH);
        }

        if (this.geometryOfCharacter.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.geometryOfCharacter.setTranslateX(this.geometryOfCharacter.getTranslateX() % AsteroidsApplication.WIDTH);
        }

        if (this.geometryOfCharacter.getTranslateY() < 0) {
            this.geometryOfCharacter.setTranslateY(this.geometryOfCharacter.getTranslateY() + AsteroidsApplication.HEIGHT);
        }

        if (this.geometryOfCharacter.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.geometryOfCharacter.setTranslateY(this.geometryOfCharacter.getTranslateY() % AsteroidsApplication.HEIGHT);
        }
    }
    public void accelerate() {
        double yAxis = Math.sin(Math.toRadians(this.geometryOfCharacter.getRotate()));
        double xAxis = Math.cos(Math.toRadians(this.geometryOfCharacter.getRotate()));

        yAxis *= 0.15;
        xAxis *= 0.15;

        this.movement = this.movement.add(xAxis, yAxis);
    }

    public void turnLeft() {
        this.geometryOfCharacter.setRotate(geometryOfCharacter.getRotate() - 5);
    }

    public void turnRight() {
        this.geometryOfCharacter.setRotate(geometryOfCharacter.getRotate() + 5);
    }

    public boolean collide(CharacterClass characterHit) {
        Shape collisionArea = Shape.intersect(this.geometryOfCharacter,characterHit.getGeometryOfCharacter());
        // tworzymy nowy Shape po prostu ze skrzyżowania dwóch znanych nam wcześniej shepów
        return collisionArea.getBoundsInLocal().getWidth() !=-1; // getBoundsInLocal zwraca granice prostokąta (bounding box)
        // w lokalnym układzie współrzędnych tego obszaru kolizji. Granice prostokąta są reprezentowane jako obiekt Bounds.
        // getWidth zwraca szerokość tego prostokąta (bounding box).
        //Jeśli szerokość obszaru kolizji jest różna od -1, oznacza to, że istnieje rzeczywista kolizja między obiektami.
        // Wartość -1 jest zwracana przez JavaFX, gdy nie ma żadnego obszaru kolizji (czyli collisionArea jest pusty).
    }
    //_____________________________________________
    //metody do pocisków
    public Point2D getMovement(){
        return this.movement;
    }
    public void setMovement(Point2D newMovement){
        this.movement = newMovement;
    }
    //metody mające pozwolić na usprawnienie kodu początek
    public boolean isAlive() {
        return this.mortalityOfObjects.get(this.geometryOfCharacter);
    }
    public void setAlive (Boolean isAliveToken) {
        this.mortalityOfObjects.put(this.geometryOfCharacter,isAliveToken);
    }
    //metody mające pozwolić na usprawnienie kodu koniec

}
