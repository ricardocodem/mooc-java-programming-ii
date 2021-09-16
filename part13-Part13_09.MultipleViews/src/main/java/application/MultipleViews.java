package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        //first view
        BorderPane layout = new BorderPane();
        layout.setTop(new Label("First View!"));
        Button button = new Button("To the second view!");
        layout.setCenter(button);
        //create first scene view
        Scene first = new Scene(layout);

        //second view
        VBox secLayout = new VBox();
        Button button2 = new Button("To the third view!");
        secLayout.getChildren().add(button2);
        secLayout.getChildren().add(new Label("Second view!"));
        //create second scene
        Scene second = new Scene(secLayout);

        //third view
        GridPane thirdView = new GridPane();
        Button button3 = new Button("To the first view!");
        thirdView.add(new Label("Third View!"), 0, 0);
        thirdView.add(button3, 1, 1);
        //create third scene
        Scene third = new Scene(thirdView);

        //event handlers
        button.setOnAction((event) -> {
            window.setScene(second);
        });

        button2.setOnAction((event) -> {
            window.setScene(third);
        });
        button3.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();

    }

}
