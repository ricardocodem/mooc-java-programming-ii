package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        BorderPane savingsPane = new BorderPane();
        
        //savings slider setup
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setSnapToTicks(true);
        savingsSlider.setBlockIncrement(500);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);

        Label savingsInfo = new Label();
        savingsInfo.setText("" + savingsSlider.getValue());

        savingsPane.setLeft(new Label("Monthly savings"));
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsInfo);
        savingsPane.setPadding(new Insets(10));
        
        //interest rate slider setup
        BorderPane interestPane = new BorderPane();

        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setMinorTickCount(10);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);

        Label interestInfo = new Label();
        interestInfo.setText("" + interestSlider.getValue());

        interestPane.setLeft(new Label("Yearly interest rate"));
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestInfo);
        interestPane.setPadding(new Insets(10));
        
        //add savings and interest slider to slider component
        VBox sliderVBox = new VBox();
        sliderVBox.getChildren().addAll(savingsPane, interestPane);
        //chart layout setup
        layout.setTop(sliderVBox);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);
        lineChart.setTitle("Savings calulator");

        layout.setCenter(lineChart);

        XYChart.Series savingsSeries = new XYChart.Series();
        XYChart.Series savingsWithInterestSeries = new XYChart.Series();

        lineChart.getData().add(savingsSeries);
        lineChart.getData().add(savingsWithInterestSeries);

        savingsSlider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            int savings = newvalue.intValue();
            savingsInfo.setText("" + savings);
            updateChart(savingsSlider.getValue(), interestSlider.getValue(), savingsSeries, true);
        });

        interestSlider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            interestInfo.setText("" + newvalue);
            updateChart(savingsSlider.getValue(), interestSlider.getValue(), savingsWithInterestSeries, false);
        });
        
        //init chart
        for (int year = 0; year < 31; year++) {
            double sum = savingsSlider.getValue() * 12 * year;
            savingsSeries.getData().add(new XYChart.Data(year, sum));
            savingsWithInterestSeries.getData().add(new XYChart.Data(year, sum));
        }
        
        Scene view = new Scene(layout, 640, 480);

        stage.setScene(view);
        stage.show();
    }

    private void updateChart(double savings, double interest, XYChart.Series data, boolean flag) {
        data.getData().clear();

        double rate = 0;
        double amount = 0;
        double value = 0;

        if (flag == true) {
            rate = 0;
        } else {
            rate = interest / 100;
        }
        for (int i = 0; i < 31; i++) {
            if (i == 0) {
                amount = 0;
            } else {
                amount = (value + (savings * 12)) * (1 + rate);
            }
            value = amount;
            data.getData().add(new XYChart.Data(i, amount));
            System.out.println(amount);
        }
    }
}
