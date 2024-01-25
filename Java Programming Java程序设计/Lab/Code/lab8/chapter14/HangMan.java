package lab8.chapter14;
// 14.17

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HangMan extends Application {
    @Override
    public void start(Stage primaryStage){
        Arc arc = new Arc(80, 380, 60, 30, 0, 180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);

        Line longVerticalLine = new Line(80, 350, 80, 20);
        Line longHorizontalLine = new Line(80, 20, 260, 20);
        Line shortVerticalLine = new Line(260, 20, 260, 50);

        Circle head = new Circle(260, 80, 30, Color.WHITE);
        head.setStroke(Color.BLACK);

        Line body = new Line(260, 50, 260, 220);

        Line rightHand = new Line(260, 80, 160, 180);
        Line leftHand = new Line(260, 80, 360, 180);
        Line rightLeg = new Line(260, 220, 200, 280);
        Line leftLeg = new Line(260, 220, 320, 280);

        Group allElement = new Group();
        allElement.getChildren().addAll(
                arc,
                longVerticalLine,
                longHorizontalLine,
                shortVerticalLine,
                body,
                rightHand,
                leftHand,
                rightLeg,
                leftLeg,
                head
        );

        // Create a scene and place it in the stage
        Scene scene = new Scene(new BorderPane(allElement), 400, 400);
        primaryStage.setTitle("HangMan"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
