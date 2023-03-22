package com.example.lab1;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class MyApplication extends Application {
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250);

        Polygon triangle = new Polygon (200.0, 20.0, 150.0, 120.0, 250.0, 120.0 );
        root.getChildren().add(triangle);
        triangle.setFill(Color.WHITE);

        Polyline line = new Polyline(200.0, 20.0, 150.0, 120.0, 250.0, 120.0, 200.0, 20.0);
        root.getChildren().add(line);
        line.setStroke(Color.RED);
        line.setStrokeWidth(7);

        Rectangle base = new Rectangle(195, 124, 15, 100);
        root.getChildren().add(base);

        Circle redcircle = new Circle(200, 50, 10);
        root.getChildren().add(redcircle);
        redcircle.setFill(Color.RED);
        Circle yellowcircle = new Circle(200, 75, 10);
        root.getChildren().add(yellowcircle);
        yellowcircle.setFill(Color.YELLOW);
        Circle greencircle = new Circle(200, 100, 10);
        root.getChildren().add(greencircle);
        greencircle.setFill(Color.GREEN);

        scene.setFill(Color.DIMGREY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
