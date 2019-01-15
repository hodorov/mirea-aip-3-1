package thirdDotOne;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import thirdDotOne.controls.fontpicker.FontPicker;

import java.util.StringJoiner;

public class MainController {

    @FXML
    Label label;

    @FXML
    TextField textField;

    @FXML
    TextArea textArea;

    @FXML
    ColorPicker textColor;

    @FXML
    ColorPicker backgroundColor;

    @FXML
    FontPicker fontPicker;

    @FXML
    public void initialize() {
        textColor.setValue(Color.BLACK);
        label.textFillProperty().bind(textColor.valueProperty());
        textColor.setOnAction(event -> {
            textField.setStyle(textField.getStyle() + "-fx-text-fill: " + toRgba(textColor.getValue()) + ";");
            textArea.setStyle(textArea.getStyle() + "-fx-text-fill: " + toRgba(textColor.getValue()) + ";");
        });

        backgroundColor.setOnAction(event -> {
            label.setStyle(label.getStyle() + "-fx-background-color: " + toRgba(backgroundColor.getValue()) + ";");
            textField.setStyle(textField.getStyle() + "-fx-background-color: " + toRgba(backgroundColor.getValue()) + ";");
            textArea.setStyle(textArea.getStyle() + "-fx-control-inner-background: " + toRgba(backgroundColor.getValue()) + ";");
        });

        fontPicker.setValue(Font.getDefault());
        label.fontProperty().bind(fontPicker.valueProperty());
        textField.fontProperty().bind(fontPicker.valueProperty());
        textArea.fontProperty().bind(fontPicker.valueProperty());
    }

    private String toRgba(Color c) {
        StringJoiner sj = new StringJoiner(",", "rgba(", ")");
        sj.add(String.valueOf((int) (255 * c.getRed())));
        sj.add(String.valueOf((int) (255 * c.getGreen())));
        sj.add(String.valueOf((int) (255 * c.getBlue())));
        sj.add(String.valueOf((int) (255 * c.getOpacity())));
        return sj.toString();
    }
}
