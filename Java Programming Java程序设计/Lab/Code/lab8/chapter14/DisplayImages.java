package lab8.chapter14;
// 14.1

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayImages extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the image views
        GridPane totalPane = new GridPane();
        totalPane.setPadding(new Insets(5, 5, 5, 5));
        totalPane.setHgap(5);
        totalPane.setVgap(5);

        Image image1 = new Image("image/germany.gif");
        Image image2 = new Image("image/china.gif");
        Image image3 = new Image("image/fr.gif");
        Image image4 = new Image("image/us.gif");

        totalPane.add(new ImageView(image1), 0, 0);
        totalPane.add(new ImageView(image2), 1, 0);
        totalPane.add(new ImageView(image3), 0, 1);
        totalPane.add(new ImageView(image4), 1, 1);

        // Create a scene and place it in the stage
        Scene scene = new Scene(totalPane);
        primaryStage.setTitle("DisplayImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}