package com.example.buttonandlabel.asteroids;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class AsteroidsApplication extends Application {

    public static int HEIGHT = 1080;
    public static int WIDTH = 1920;
    private Map<KeyCode, Boolean> keyCodeRegister;
    private List<Asteroid> asteroids;
    List<Projectile> projectiles = new ArrayList<>();

    @Override
    public void start(Stage window) {
        this.keyCodeRegister = new HashMap<>();//muszę zainicjować ją. Bez tej linijki program będzie wskazywał błąd z powodu na wartość ,null' dla HashMapy
        this.asteroids = new ArrayList<>();
        Text text = new Text(20,10,"Points: 0");

        Pane componentGroup = new Pane();
        componentGroup.setPrefSize(WIDTH, HEIGHT);

        componentGroup.getChildren().add(text);
        AtomicInteger scoreCounter = new AtomicInteger();

        Ship ship = new Ship((WIDTH / 2), (HEIGHT / 2));

        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            asteroids.add(new Asteroid(random.nextInt(WIDTH), random.nextInt(HEIGHT)));
        }
        for (Asteroid asteroid1 : asteroids) {
            componentGroup.getChildren().add(asteroid1.getGeometryOfCharacter());
        }
            /*asteroids.forEach(asteroid1 -> {
                componentGroup.getChildren().add(asteroid1.getGeometryOfCharacter());
            });*/

        componentGroup.getChildren().add(ship.getGeometryOfCharacter());
        Scene scene = new Scene(componentGroup);

        scene.setOnKeyPressed(keyEvent -> {
            keyCodeRegister.put(keyEvent.getCode(), true);
        });

        scene.setOnKeyReleased(keyEvent -> {
            keyCodeRegister.put(keyEvent.getCode(), false);
        });


        window.setTitle("Wojna sithów");
        window.setScene(scene);
        window.show();

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (keyCodeRegister.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (keyCodeRegister.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (keyCodeRegister.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                if (keyCodeRegister.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 22) {

                    Projectile projectile = new Projectile(
                            (int) ship.getGeometryOfCharacter().getTranslateX(),
                            (int) ship.getGeometryOfCharacter().getTranslateY());

                    projectile.getGeometryOfCharacter().setRotate(ship.getGeometryOfCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();//przspieszamy prędkość pocisku (dzięki temu nigdy nie pozostanie w miejscu!)
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    //normalizujemy prędkość (czyli przekształcamy ją na jednostkowy wektor o długości 1) i mnożymy x3

                    componentGroup.getChildren().add(projectile.getGeometryOfCharacter());
                }

                ship.move();
                projectiles.forEach(projectile ->
                        projectile.move());

//                projectiles.forEach(projectile -> {
//                    List<Asteroid> collisions = asteroids.stream()
//                            .filter(asteroid -> asteroid.collision(projectile))
//                            .collect(Collectors.toList());
//
//                    collisions/*.stream()*/.forEach(collided -> {
////dlaczego stream()? collisions jest już listą, więc bezpośrednie użycie
//// forEach na liście jest poprawne. Jednak użycie stream() i forEach również działa i jest bardziej
//// idiomatyczne w kontekście strumieni w Java. W tym przypadku oba podejścia są poprawne i działają tak samo.
//                        asteroids.remove(collided);
//                        componentGroup.getChildren().remove(collided.getGeometryOfCharacter());
//
//                        projectiles.forEach(asteroid -> {
//                            List<Projectile> projectilesHit = projectiles.stream()
//                                    .filter(projectile1 -> projectile1.collision(asteroid))
//                                    .collect(Collectors.toList());
//
//                            projectilesHit.forEach(projectileHitted -> {
//                                        projectiles.remove(projectileHitted);
//                                        componentGroup.getChildren().remove(projectileHitted.getGeometryOfCharacter());
//                                    }
//                            );
//                        });
//                    });
//                });
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            asteroid.setAlive(false);
                            text.setText("Points:" + scoreCounter.addAndGet(100));
                            projectile.setAlive(false);
                        }
                    });
                });

                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> componentGroup.getChildren().remove(projectile.getGeometryOfCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));

                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> componentGroup.getChildren().remove(asteroid.getGeometryOfCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));

/*
// //dlaczego wersja na dole zakomentowana jest gorsza od tego
////co jest powyżej:
////Bezpieczeństwo wątkowe: Usuwanie elementów z listy podczas iteracji nad nią (jak w zakomentowanej wersji)
////może prowadzić do wyjątków i nieprzewidywalnego zachowania.
////Wydajność: Pierwsza wersja jest bardziej efektywna, ponieważ najpierw tworzy listę elementów do usunięcia,
////a następnie usuwa je wszystkie na raz, zamiast wykonywać wiele operacji usuwania w pętli.

// projectiles.stream().filter(projectile ->
//                        !projectile.isAlive()).forEach(projectile -> {
//                    projectiles.remove(projectile);
//                    componentGroup.getChildren().remove(projectile.getGeometryOfCharacter());
//                });
//
//                asteroids.stream().filter(
//                        asteroid -> !asteroid.isAlive()).forEach(asteroid -> {
//                    asteroids.remove(asteroid);
//                    componentGroup.getChildren().remove(asteroid.getGeometryOfCharacter());
//                });
*/
                for (Asteroid asteroid1 : asteroids) {
                    asteroid1.move();
                    if (ship.collide(asteroid1)) {
                        stop();
                    }
                }
                //funkcja dodająca asteroidy z prawdopodobieństwem 0,5% za każdym razem,
                //gdy wywoływany jest obiekt AnimationTimer. Jest dodawana tylko wtedy,
                //gdy nie zderzy się natychmiast ze statkiem.
                //Metoda handle obiektu AnimationTimer jest wywoływana około 60 razy na sekundę,
                //więc w ciągu dziesięciu sekund dodawanych jest kilka asteroid.
                if(Math.random() < 0.5) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    //asteroidy pojawiają się
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        componentGroup.getChildren().add(asteroid.getGeometryOfCharacter());
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
