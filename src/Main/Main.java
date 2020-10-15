package Main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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

        Label label_celsius = new Label("Degree Celsius");
        box_main.getChildren().add(label_celsius);

        TextField field_celsius = new TextField();
        field_celsius.setMinWidth(250);
        field_celsius.setPromptText("Please enter a value ...");
        box_main.getChildren().add(field_celsius);

        Label label_fahrenheit = new Label("Degree Fahrenheit");
        box_main.getChildren().add(label_fahrenheit);

        TextField field_fahrenheit = new TextField();
        field_fahrenheit.setMinWidth(250);
        field_fahrenheit.setPromptText("Please enter a value ...");
        box_main.getChildren().add(field_fahrenheit);


        EventHandler<MouseEvent> c_to_f_handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try{
                    double tempC = Double.parseDouble(field_celsius.getText());

                    if(tempC < -273.15)     //absoluter Nullpunkt kann nicht überschritten werden
                        throw new java.lang.RuntimeException();

                    Double tempF = tempC * 1.8 + 32;
                    tempF = tempF * 100;    //zum Runden der Kommastellen
                    Math.round(tempF);
                    tempF = tempF / 100;
                    field_fahrenheit.setText(tempF.toString());
                }
                catch(Exception e){
                    field_celsius.setText("Please enter a valid number");
                }

            }
        };


        Button c_to_f = new Button("Convert C -> F");
        c_to_f.addEventHandler(MouseEvent.MOUSE_CLICKED, c_to_f_handler);
        box_main.getChildren().add(c_to_f);


        EventHandler<MouseEvent> f_to_c_handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try{
                    double tempF = Double.parseDouble(field_fahrenheit.getText());

                    if(tempF < -459.67)         //kann nicht kleiner als absoluter Nullpunkt sein
                        throw new java.lang.RuntimeException();

                    double tempC = (tempF - 32) / 1.8;
                    tempC = tempC / 100;    //runden vom Wert
                    Math.round(tempC);
                    tempC = tempC * 100;
                    field_celsius.setText(Double.toString(tempC));
                }
                catch (Exception e){
                    field_fahrenheit.setText("Please enter a valid number");
                }

            }
        };


        Button f_to_c = new Button("Convert F -> C");
        f_to_c.addEventHandler(MouseEvent.MOUSE_CLICKED, f_to_c_handler);
        box_main.getChildren().add(f_to_c);

        Scene scene = new Scene(box_main);
        stage.setTitle("Temp. Converter");
        stage.setScene(scene);
        stage.show();
    }

}
