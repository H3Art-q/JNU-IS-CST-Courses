package lab8.chapter14;
// 14.27

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DetailedClock extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a clock
        ClockPane clock = new ClockPane();
        // Create a label
        String timeString = String.format("%02d:%02d:%02d"
                , clock.getHour()
                , clock.getMinute()
                , clock.getSecond());
        Label lblCurrentTime = new Label(timeString);

        // Place clock in center of border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);

        // Place label in bottom of border pane, and set alignment
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DetailedClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

}


class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    /**
     * Construct a default clock with the current time
     */
    public ClockPane() {
        setCurrentTime();
    }

    /**
     * Construct a clock with specified hour, minute, and second
     */
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Set a new hour
     */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /**
     * Return minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Set a new minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /**
     * Return second
     */
    public int getSecond() {
        return second;
    }

    /**
     * Set a new second
     */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();
        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock(); // Repaint the clock
    }

    /**
     * Paint the total clock
     */
    private void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        getChildren().clear();

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        // Draw hour label
        paintLabel(centerX, centerY, clockRadius);

        // Draw long calibration
        paintLongCalibration(centerX, centerY, clockRadius);

        // Draw short calibration
        paintShortCalibration(centerX, centerY, clockRadius);

        // Draw clock hand
        paintClockHand(centerX, centerY, clockRadius);
    }

    /**
     * Paint the short calibration of clock
     */
    private void paintShortCalibration(double centerX, double centerY, double clockRadius) {
        double startRadius = clockRadius - 4;
        for (int i = 0; i < 60; i++) {
            double startX = centerX + startRadius *
                    Math.sin(i * (2 * Math.PI / 60));
            double startY = centerY + startRadius *
                    Math.cos(i * (2 * Math.PI / 60));
            double endX = centerX + clockRadius *
                    Math.sin(i * (2 * Math.PI / 60));
            double endY = centerY + clockRadius *
                    Math.cos(i * (2 * Math.PI / 60));
            Line calibration = new Line(startX, startY, endX, endY);
            getChildren().add(calibration);
        }
    }

    /**
     * Paint the long calibration of clock
     */
    private void paintLongCalibration(double centerX, double centerY, double clockRadius) {
        double startRadius = clockRadius - 8;
        for (int i = 0; i < 12; i++) {
            double startX = centerX + startRadius *
                    Math.sin(i * (2 * Math.PI / 12));
            double startY = centerY + startRadius *
                    Math.cos(i * (2 * Math.PI / 12));
            double endX = centerX + clockRadius *
                    Math.sin(i * (2 * Math.PI / 12));
            double endY = centerY + clockRadius *
                    Math.cos(i * (2 * Math.PI / 12));
            Line calibration = new Line(startX, startY, endX, endY);
            getChildren().add(calibration);
        }
    }

    /**
     * Paint the clock hand
     */
    private void paintClockHand(double centerX, double centerY, double clockRadius) {
        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.BLUE);

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().addAll(sLine, mLine, hLine);
    }

    /**
     * Paint hour label
     */
    private void paintLabel(double centerX, double centerY, double clockRadius) {
        Text t1 = new Text(centerX + (clockRadius - 20) / 2,
                centerY - (clockRadius - 20) * Math.sqrt(3) / 2, "1");
        Text t2 = new Text(centerX + (clockRadius - 20) * Math.sqrt(3) / 2,
                centerY - (clockRadius - 20) / 2, "2");
        Text t3 = new Text(centerX + clockRadius - 20, centerY + 4, "3");

        Text t4 = new Text(centerX + (clockRadius - 20) * Math.sqrt(3) / 2,
                centerY + (clockRadius - 10) / 2, "4");
        Text t5 = new Text(centerX + (clockRadius - 20) / 2,
                centerY + (clockRadius - 10) * Math.sqrt(3) / 2, "5");
        Text t6 = new Text(centerX - 4, centerY + clockRadius - 13, "6");

        Text t7 = new Text(centerX - (clockRadius - 10) / 2,
                centerY + (clockRadius - 10) * Math.sqrt(3) / 2, "7");
        Text t8 = new Text(centerX - (clockRadius - 10) * Math.sqrt(3) / 2,
                centerY + (clockRadius - 10) / 2, "8");
        Text t9 = new Text(centerX - clockRadius + 10, centerY + 4, "9");

        Text t10 = new Text(centerX - (clockRadius - 10) * Math.sqrt(3) / 2,
                centerY - (clockRadius - 20) / 2, "10");
        Text t11 = new Text(centerX - (clockRadius - 10) / 2,
                centerY - (clockRadius - 20) * Math.sqrt(3) / 2, "11");
        Text t12 = new Text(centerX - 7, centerY - clockRadius + 22, "12");

        getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}