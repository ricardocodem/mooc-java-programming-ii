package ticTacToe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private ArrayList<Button> buttons;
    private String currentPlayer;
    private Label turn;
    private boolean endgame;

    public TicTacToeApplication() {
        this.buttons = new ArrayList<>();
        this.currentPlayer = "X";
        this.turn = new Label("Turn: " + this.currentPlayer);
        this.endgame = false;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Create main layout
        BorderPane layout = new BorderPane();
        layout.setPrefSize(310, 350);
        turn.setFont(new Font(30.0));

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        //create buttons
        for (int i = 0; i < 9; i++) {
            buttons.add(createButton());
        }

        grid.add(buttons.get(0), 0, 0);
        grid.add(buttons.get(1), 0, 1);
        grid.add(buttons.get(2), 0, 2);
        grid.add(buttons.get(3), 1, 0);
        grid.add(buttons.get(4), 1, 1);
        grid.add(buttons.get(5), 1, 2);
        grid.add(buttons.get(6), 2, 0);
        grid.add(buttons.get(7), 2, 1);
        grid.add(buttons.get(8), 2, 2);

        //Set the game board view
        layout.setTop(turn);
        layout.setCenter(grid);

        //Create main scene with layout
        Scene view = new Scene(layout);

        //Show the main Scene
        stage.setScene(view);
        stage.show();
    }

    private Button createButton() {
        Button btn = new Button(" ");
        btn.setFont(Font.font("Monospaced", 40));
        btn.setPrefSize(90, 90);
        btn.setOnAction((event) -> {
            if (!btn.getText().equals(" ")) {
                return;
            }
            if (endgame) {
                return;
            }
            if (this.currentPlayer.equals('X')) {
                btn.setText(this.currentPlayer);
                takeTurn();
                turn.setText("Turn: " + currentPlayer);
            } else {
                btn.setText(this.currentPlayer);
                takeTurn();
                turn.setText("Turn: " + currentPlayer);
            }
            if (gameWon() || drawGame()) {
                turn.setText("The end!");
                endgame = true;
            }
        });
        return btn;
    }

    private void takeTurn() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }

    private boolean drawGame() {
        for (Button bt : buttons) {
            if (bt.getText().equals(" ")) {
                return false;
            }
        }
        return true;
    }

    private boolean gameWon() {
        //check first column 
        if (!buttons.get(0).getText().equals(" ")) {
            if (buttons.get(0).getText().equals(buttons.get(1).getText()) && buttons.get(0).getText().equals(buttons.get(2).getText())) {
                return true;
            }
        }
        //check second column
        if (!buttons.get(3).getText().equals(" ")) {
            if (buttons.get(3).getText().equals(buttons.get(4).getText()) && buttons.get(3).getText().equals(buttons.get(5).getText())) {
                return true;
            }
        }
        //check third column
        if (!buttons.get(6).getText().equals(" ")) {
            if (buttons.get(6).getText().equals(buttons.get(7).getText()) && buttons.get(6).getText().equals(buttons.get(8).getText())) {
                return true;
            }
        }
        //check first row
        if (!buttons.get(0).getText().equals(" ")) {
            if (buttons.get(0).getText().equals(buttons.get(3).getText()) && buttons.get(0).getText().equals(buttons.get(6).getText())) {
                return true;
            }
        }
        //check second row
        if (!buttons.get(1).getText().equals(" ")) {
            if (buttons.get(1).getText().equals(buttons.get(4).getText()) && buttons.get(1).getText().equals(buttons.get(7).getText())) {
                return true;
            }
        }
        //check third row
        if (!buttons.get(2).getText().equals(" ")) {
            if (buttons.get(2).getText().equals(buttons.get(5).getText()) && buttons.get(2).getText().equals(buttons.get(8).getText())) {
                return true;
            }
        }
        //check right diagonal
        if (!buttons.get(0).getText().equals(" ")) {
            if (buttons.get(0).getText().equals(buttons.get(4).getText()) && buttons.get(0).getText().equals(buttons.get(8).getText())) {
                return true;
            }
        }
        //check left diagonal
        if (!buttons.get(6).getText().equals(" ")) {
            if (buttons.get(6).getText().equals(buttons.get(4).getText()) && buttons.get(6).getText().equals(buttons.get(2).getText())) {
                return true;
            }
        }
        return false;
    }
}
