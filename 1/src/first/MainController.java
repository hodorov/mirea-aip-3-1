package first;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML
    TextField aInput;

    @FXML
    TextField bInput;

    @FXML
    TextField cInput;

    @FXML
    TextArea area;

    @FXML
    Button calcBtn;

    @FXML
    Button clearBtn;

    @FXML
    Button exitBtn;

    @FXML
    MenuItem calcMenu;

    @FXML
    MenuItem clearMenu;

    @FXML
    MenuItem exitMenu;

    @FXML
    MenuItem calcContextMenu;

    @FXML
    MenuItem clearContextMenu;

    @FXML
    MenuItem exitContextMenu;

    @FXML
    public void initialize() {
        exitContextMenu.setOnAction(event -> System.exit(0));
        exitMenu.setOnAction(event -> System.exit(0));
        exitBtn.setOnMouseClicked(event -> System.exit(0));

        clearContextMenu.setOnAction(event -> clear());
        clearMenu.setOnAction(event -> clear());
        clearBtn.setOnMouseClicked(event -> clear());

        calcContextMenu.setOnAction(event -> calc());
        calcMenu.setOnAction(event -> calc());
        calcBtn.setOnMouseClicked(event -> calc());
    }

    private void clear() {
        aInput.setText("");
        bInput.setText("");
        cInput.setText("");
        area.setText("");

    }

    private void calc() {
        area.appendText("********\n");
        double a;
        try {
            a = Double.valueOf(aInput.getText());
            area.appendText(String.format("A = %.2f\n", a));
        } catch (Exception e) {
            area.appendText("Сторона A не является числом типа double\n");
            return;
        }

        double b;
        try {
            b = Double.valueOf(bInput.getText());
            area.appendText(String.format("B = %.2f\n", b));
        } catch (Exception e) {
            area.appendText("Сторона B не является числом типа double\n");
            return;
        }

        double c;
        try {
            c = Double.valueOf(cInput.getText());
            area.appendText(String.format("C = %.2f\n", c));
        } catch (Exception e) {
            area.appendText("Сторона C не является числом типа double\n");
            return;
        }

        if (!(a + b > c && a + c > b && b + c > a)) {
            area.appendText("Треугольник с указанными сторонами не существует\n");
            return;
        }

        double P = (a + b + c);
        area.appendText(String.format("Периметр теругольника = %.2f\n", P));
        double p = P / 2;
        area.appendText(String.format("Высота теругольника = %.2f\n", p));
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        area.appendText(String.format("Площадь треугольника = %.2f\n", S));
        double r = S / p;
        area.appendText(String.format("Радиус вписанной окружности равен = %.2f\n", r));
        double R = P / 4 * S;
        area.appendText(String.format("Радиус описанной окружности равен = %.2f\n", R));
    }
}
