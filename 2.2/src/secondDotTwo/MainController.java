package secondDotTwo;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MainController {
    private double earthAngle = 0;
    private double moonAngle = 0;

    @FXML
    Pane pane;

    @FXML
    Circle sunCircle;

    private Circle earthCircle;
    private Circle moonCircle;

    @FXML
    public void initialize() {
        sunCircle = new Circle(sunCircle.getLayoutX(), sunCircle.getLayoutY(), sunCircle.getRadius(), Paint.valueOf("yellow"));
        earthCircle = new Circle(sunCircle.getCenterX(), sunCircle.getCenterY() - (sunCircle.getRadius() * 3), sunCircle.getRadius() * 0.5, Paint.valueOf("blue"));
        moonCircle = new Circle(earthCircle.getCenterX(), earthCircle.getCenterY() - (earthCircle.getRadius() * 2), earthCircle.getRadius() * 0.5, Paint.valueOf("red"));
        pane.getChildren().addAll(earthCircle, moonCircle);
        Thread t = new Thread(() -> {
            while (true) {
                rotateAround(sunCircle, earthCircle, sunCircle.getRadius() * 3, earthAngle % 360);
                rotateAround(earthCircle, moonCircle, earthCircle.getRadius() * 2, moonAngle % 360);
                earthAngle += 1;
                moonAngle += 3;
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void rotateAround(Circle center, Circle satellite, double distance, double angle) {
        satellite.setCenterX(center.getCenterX() + distance * Math.sin(Math.toRadians(angle)));
        satellite.setCenterY(center.getCenterY() - distance * Math.cos(Math.toRadians(angle)));
    }
}
