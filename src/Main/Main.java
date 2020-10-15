package Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**class Main
 * @author Matteo Falkenberg
 * @version 1.20, 15.10.2020
 */

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) {

        VBox box_main = new VBox();
        box_main.setSpacing(10);
        box_main.setPadding(new Insets(25));

        Label label_celsius = new Label("Grad Celsius");
        box_main.getChildren().add(label_celsius);

        TextField field_celsius = new TextField();
        field_celsius.setMinWidth(250);
        field_celsius.setPromptText("Bitte geben Sie einen Wert ein ...");
        box_main.getChildren().add(field_celsius);

        Label label_fahrenheit = new Label("Grad Fahrenheit");
        box_main.getChildren().add(label_fahrenheit);

        TextField field_fahrenheit = new TextField();
        field_fahrenheit.setMinWidth(250);
        field_fahrenheit.setPromptText("Bitte geben Sie einen Wert ein ...");
        box_main.getChildren().add(field_fahrenheit);

        Button c_to_f = new Button("Convert C -> F");
        c_to_f.addEventHandler(MouseEvent.MOUSE_CLICKED, c_to_f_handler);
        box_main.getChildren().add(c_to_f);

        Button f_to_c = new Button("Convert F -> C");
        f_to_c.addEventHandler(MouseEvent.MOUSE_CLICKED, f_to_c_handler);
        box_main.getChildren().add(f_to_c);


    }

}
