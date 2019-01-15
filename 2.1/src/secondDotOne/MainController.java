package secondDotOne;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class MainController {

    @FXML
    ImageView logo;

    @FXML
    public void initialize() {
        logo.setImage(new Image(getClass().getResource("MIREA_Logo.png").toExternalForm()));
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setNode(logo);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fadeTransition.play();
        }).start();
    }
}
