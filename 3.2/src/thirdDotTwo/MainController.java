package thirdDotTwo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class MainController {

    @FXML
    ChoiceBox<Integer> choiceBox;

    @FXML
    ListView<Integer> listView;

    @FXML
    Button sortAscBtn;

    @FXML
    Button sortDescBtn;

    @FXML
    Button firstToLastBtn;

    @FXML
    Button randBtn;
    
    private ObservableList<Integer> items;

    @FXML
    public void initialize() {
        items = listView.getItems();
        for (int i = 0; i <= 15; i++) {
            items.add(ThreadLocalRandom.current().nextInt(0, 100000));
        }
        choiceBox.itemsProperty().bind(listView.itemsProperty());
        sortAscBtn.setOnMouseClicked(event -> Collections.sort(items));
        sortDescBtn.setOnMouseClicked(event -> items.sort(Collections.reverseOrder()));
        firstToLastBtn.setOnMouseClicked(event -> {
            int size = items.size();
            Integer first = items.get(0);
            items.set(0, items.get(size - 1));
            items.set(size - 1, first);
        });
        randBtn.setOnMouseClicked(event -> Collections.shuffle(items));
    }
}
