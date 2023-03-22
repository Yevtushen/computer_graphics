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

        root.getChildren().add(GetTriangleBase());
        root.getChildren().add(GetOutline());
        root.getChildren().add(GetBase());
        root.getChildren().add(GetRedLight());
        root.getChildren().add(GetYellowLight());
        root.getChildren().add(GetGreenLight());

        scene.setFill(Color.DIMGREY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Polygon GetTriangleBase(){
        Polygon triangle = new Polygon (200.0, 20.0, 150.0, 120.0, 250.0, 120.0 );
        triangle.setFill(Color.WHITE);
        return triangle;
    }

    private Polyline GetOutline(){
        Polyline line = new Polyline(200.0, 20.0, 150.0, 120.0, 250.0, 120.0, 200.0, 20.0);
        line.setStroke(Color.RED);
        line.setStrokeWidth(7);
        return line;
    }

    private Rectangle GetBase(){
        return new Rectangle(195, 124, 15, 100);
    }

    private Circle GetRedLight(){
        Circle light = new Circle(200, 50, 10);
        light.setFill(Color.RED);
        return light;
    }

    private Circle GetYellowLight(){
        Circle light = new Circle(200, 75, 10);
        light.setFill(Color.YELLOW);
        return light;
    }

    private Circle GetGreenLight(){
        Circle light = new Circle(200, 100, 10);
        light.setFill(Color.GREEN);
        return light;
    }
}
