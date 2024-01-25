package lab8.chapter14;
// 14.29

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class BeanMachine extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        BeanPane beanMachine = new BeanPane();

        pane.setCenter(beanMachine);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("BeanMachine"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

class BeanPane extends Pane {
    BeanPane() {
        paint();
    }

    public void paint() {
        double topCenterPointX = getWidth() / 2;
        double topCenterPointY = 0;
        getChildren().clear();

        paintFrame(topCenterPointX, topCenterPointY);

        paintCircles(topCenterPointX, topCenterPointY);
    }

    private void paintCircles(double topCenterPointX, double topCenterPointY) {
        double circleGap = getWidth() / 20;
        double circleRadius = circleGap / 2;
        double startX = topCenterPointX;
        double startY = topCenterPointY + circleGap + getWidth() / 10;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Circle circle = new Circle(startX + (2 * circleGap) * j, startY, circleRadius);
                circle.setFill(Color.GREEN);
                getChildren().add(circle);
            }
            startX -= circleGap;
            startY += 2 * circleGap;
        }
    }

    private void paintFrame(double topCenterPointX, double topCenterPointY) {
        Line leftEntrance = new Line(
                topCenterPointX - getWidth() / 20,
                topCenterPointY + 5,
                topCenterPointX - getWidth() / 20,
                topCenterPointY + getWidth() / 10
        );
        Line rightEntrance = new Line(
                topCenterPointX + getWidth() / 20,
                topCenterPointY + 5,
                topCenterPointX + getWidth() / 20,
                topCenterPointY + getWidth() / 10
        );
        Line leftHypotenuse = new Line(
                topCenterPointX - getWidth() / 20,
                topCenterPointY + getWidth() / 10,
                topCenterPointX - 0.4 * getWidth(),
                topCenterPointY + 0.78 * getWidth()

        );
        Line rightHypotenuse = new Line(
                topCenterPointX + getWidth() / 20,
                topCenterPointY + getWidth() / 10,
                topCenterPointX + 0.4 * getWidth(),
                topCenterPointY + 0.78 * getWidth()
        );
        Line leftBottomLine = new Line(
                topCenterPointX - 0.4 * getWidth(),
                topCenterPointY + 0.78 * getWidth(),
                topCenterPointX - 0.4 * getWidth(),
                topCenterPointY + 0.98 * getWidth()
        );
        Line rightBottomLine = new Line(
                topCenterPointX + 0.4 * getWidth(),
                topCenterPointY + 0.78 * getWidth(),
                topCenterPointX + 0.4 * getWidth(),
                topCenterPointY + 0.98 * getWidth()
        );
        Line bottomLine = new Line(
                topCenterPointX - 0.4 * getWidth(),
                topCenterPointY + 0.98 * getWidth(),
                topCenterPointX + 0.4 * getWidth(),
                topCenterPointY + 0.98 * getWidth()
        );
        double startX = topCenterPointX - 0.3 * getWidth();
        for (int i = 0; i < 7; i++) {
            Line verticalSepLine = new Line(
                    startX,
                    topCenterPointY + 0.76 * getWidth(),
                    startX,
                    topCenterPointY + 0.98 * getWidth()
            );
            startX += 0.1 * getWidth();
            getChildren().add(verticalSepLine);
        }
        getChildren().addAll(
                leftEntrance,
                rightEntrance,
                leftHypotenuse,
                rightHypotenuse,
                leftBottomLine,
                rightBottomLine,
                bottomLine
        );
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}