package com.example.buttonandlabel.asteroids;

import javafx.scene.Node;
import javafx.scene.shape.Polygon;

import java.util.Random;

public class AsteroidCreator {

    public Polygon createPolygon() {
        Random random = new Random();
        double radius = random.nextInt(20) + 15;
        Polygon polygon = new Polygon();
        //te wartości są stałe dla pięciokąta
        //te wyrażenia z PI są to kąty pod jakim znajduje się dany wierzchołek
        //względem środka
        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);

        //dodanie wsp. wierzcholłków do wielokąta tworzą one pieciokąt o
        //określonym rozmiarze (radius)
        polygon.getPoints().addAll(
                     radius, 0.0, //pierwszy punkt oddalony na prawo od środka okręgu na osi x
                    radius * c1, -1 * radius * s1,
                    -1 * radius * c2, -1 * radius * s2,
                    -1 * radius * c2, radius * s2,
                    radius * c1, radius * s1);

        for (int i=0;i<polygon.getPoints().size();i++) {
            int factor = random.nextInt(5)-2;
            polygon.getPoints().set(i, polygon.getPoints().get(i) + factor);
        }
        return polygon;
    }


}
