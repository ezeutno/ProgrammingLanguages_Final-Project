package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {
    @FXML private BarChart bar;
    @FXML private PieChart pie;
    @FXML private LineChart line;
    @FXML private ToggleGroup TimeRadioButtonGroup;
    @FXML private RadioButton todayButton;
    @FXML private RadioButton monthButton;
    @FXML private RadioButton yearButton;
    @FXML private RadioButton timeButton;
    @FXML private DatePicker fromDate;
    @FXML private DatePicker toDate;

    public void printText(){
        System.out.println("Hey Text Printed!");
    }

    public void showPieChart() {
        Database db = new Database();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Satisfied", db.getCountRating(1)),
                        new PieChart.Data("Neutral", db.getCountRating(2)),
                        new PieChart.Data("Dissatisfied", db.getCountRating(3)));
        pie.setData(pieChartData);

        pie.setVisible(true);
        bar.setVisible(false);
        line.setVisible(false);
    }

    public void showBarChart(){
        Database db = new Database();

        bar.getXAxis().setLabel("Time");
        bar.getYAxis().setLabel("Satisfaction Level");



        pie.setVisible(false);
        bar.setVisible(true);
        line.setVisible(false);
    }

    public void showLineChart(){
        Database db = new Database();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Satisfied", db.getCountRating(1)),
                        new PieChart.Data("Neutral", db.getCountRating(2)),
                        new PieChart.Data("Dissatisfied", db.getCountRating(3)));
        pie.setData(pieChartData);

        pie.setVisible(false);
        bar.setVisible(false);
        line.setVisible(true);
    }

    public void enableDatePicker(){
        fromDate.setDisable(false);
        toDate.setDisable(false);
    }

    public void disableDatePicker(){
        fromDate.setDisable(true);
        toDate.setDisable(true);
    }
}
