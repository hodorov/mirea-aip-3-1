package thirdDotThree;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    @FXML
    Button mainLineBtn;

    @FXML
    Button secondLineBtn;

    @FXML
    Button firstToLastBtn;

    @FXML
    TableView<List<String>> table;

    @FXML
    public void initialize() {
        for (int i = 0; i < 6; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                row.add((i + 1) + "" + (j + 1));
            }
            table.getItems().add(FXCollections.observableArrayList(row));
        }

        TableColumn<List<String>, String> castedCol;
        castedCol = (TableColumn<List<String>, String>) table.getColumns().get(0);
        castedCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(0)));
        castedCol = (TableColumn<List<String>, String>) table.getColumns().get(1);
        castedCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(1)));
        castedCol = (TableColumn<List<String>, String>) table.getColumns().get(2);
        castedCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(2)));
        castedCol = (TableColumn<List<String>, String>) table.getColumns().get(3);
        castedCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(3)));
        castedCol = (TableColumn<List<String>, String>) table.getColumns().get(4);
        castedCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(4)));
        castedCol = (TableColumn<List<String>, String>) table.getColumns().get(5);
        castedCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(5)));

        mainLineBtn.setOnMouseClicked(event -> {
            String[][] tmpMatrix = new String[6][6];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    tmpMatrix[j][i] = table.getItems().get(i).get(j);
                }
            }

            table.getItems().clear();
            for (int i = 0; i < 6; i++) {
                table.getItems().add(new ArrayList<>(Arrays.asList(tmpMatrix[i]).subList(0, 6)));
            }
        });

        secondLineBtn.setOnMouseClicked(event -> {
            String[][] tmpMatrix = new String[6][6];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    tmpMatrix[5 - j][5 - i] = table.getItems().get(i).get(j);
                }
            }

            table.getItems().clear();
            for (int i = 0; i < 6; i++) {
                table.getItems().add(new ArrayList<>(Arrays.asList(tmpMatrix[i]).subList(0, 6)));
            }
        });

        firstToLastBtn.setOnMouseClicked(event -> {
            int size = table.getItems().size();
            List<String> first = table.getItems().get(0);
            table.getItems().set(0, table.getItems().get(size - 1));
            table.getItems().set(size - 1, first);
        });

    }
}
