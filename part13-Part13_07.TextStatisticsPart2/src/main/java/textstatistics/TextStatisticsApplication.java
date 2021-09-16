package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        
        HBox texts = new HBox();
        texts.setSpacing(5);
        
        texts.getChildren().add(letters);        
        texts.getChildren().add(words);
        texts.getChildren().add(longestWord);
        
        TextArea textArea = new TextArea();
        
        layout.setCenter(textArea);
        layout.setBottom(texts);
        
        Scene view = new Scene(layout);
        
        stage.setScene(view);
        stage.show();

        /*event listener*/
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int word = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            letters.setText("Letters: " + String.valueOf(characters));
            words.setText("Words: " + String.valueOf(word));
            longestWord.setText("The longest word is: " + longest);
        });
        
    }
    
}
