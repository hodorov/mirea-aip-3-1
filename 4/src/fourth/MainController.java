package fourth;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import fourth.controls.fontpicker.FontPicker;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.StringJoiner;

public class MainController {

    @FXML
    FontPicker fontPicker;

    @FXML
    Button openBtn;

    @FXML
    Button saveBtn;

    @FXML
    TextArea textArea;

    File openedFile;

    @FXML
    public void initialize() {
        fontPicker.setValue(Font.getDefault());
        textArea.fontProperty().bind(fontPicker.valueProperty());

        openBtn.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открыть файл");
            File f = fileChooser.showOpenDialog(openBtn.getScene().getWindow());
            try(BufferedReader br = new BufferedReader(new FileReader(f))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.appendText(line + "\n");
                }
                openedFile = f;
            } catch (IOException e) {
                e.printStackTrace();
                textArea.setText("При открытии файла произошла ошибка!\n");
            }
        });

        saveBtn.setOnMouseClicked(event -> {
            if(openedFile == null) {
                textArea.setText("Нет открытого файла!\n");
                return;
            }
            try(FileWriter fw = new FileWriter(openedFile)) {
                fw.write(textArea.getText());
                textArea.setText("Файл успешно сохранён\n");
                openedFile = null;
            } catch (IOException e) {
                e.printStackTrace();
                textArea.setText("При записи файла произошла ошибка!\n");
            }
        });
    }
}
