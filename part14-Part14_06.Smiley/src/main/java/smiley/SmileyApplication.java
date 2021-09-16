package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        drawShape(painter);
        
        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        Scene view = new Scene(paintingLayout, Color.WHITE);

        stage.setScene(view);
        stage.show();
    }

    public void drawShape(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        //fillRect X Y W H
        //left eye
        gc.fillRect(95,75,50,50);
        //right eye
        gc.fillRect(235,75,50,50);
        //smile l border
        gc.fillRect(45,240,50,50);
        //smile r border
        gc.fillRect(285,240,50,50);
        //smile center
        gc.fillRect(95,290,190,50);
    }

}
