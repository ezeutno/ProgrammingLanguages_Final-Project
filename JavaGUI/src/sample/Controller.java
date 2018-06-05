package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    private int loop;
    private Database db = new Database();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getToday();
        showPieChart();
    }

    public void printText(){
        System.out.println("Hey Text Printed!");
    }

    public void showPieChart() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Satisfied", db.getRatingCount(1, fromDate.getValue().toString(), toDate.getValue().toString())),
                        new PieChart.Data("Neutral", db.getRatingCount(2, fromDate.getValue().toString(), toDate.getValue().toString())),
                        new PieChart.Data("Dissatisfied", db.getRatingCount(3, fromDate.getValue().toString(), toDate.getValue().toString())));
        pie.setData(pieChartData);

        pie.setVisible(true);
        bar.setVisible(false);
        line.setVisible(false);
    }

    public void showBarChart(){
        bar.getData().clear();
        bar.getData().clear();
        bar.getXAxis().setLabel("Time");
        bar.getYAxis().setLabel("Satisfaction Level");

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Satisfied");
        series2.setName("Neutral");
        series3.setName("Dissatisfied");

        if(todayButton.isSelected()) loop = 24;
        else if(monthButton.isSelected()) loop = LocalDate.now().lengthOfMonth();
        else if(yearButton.isSelected()) loop = 12;
        else loop = toDate.getValue().getDayOfYear() - fromDate.getValue().getDayOfYear() + 1;
        for(int x = 1; x <= loop; x++){
            series1.getData().add(new XYChart.Data(String.valueOf(x), db.getRatingCount(1, fromDate.getValue().toString(), toDate.getValue().toString())));
            series2.getData().add(new XYChart.Data(String.valueOf(x), db.getRatingCount(2, fromDate.getValue().toString(), toDate.getValue().toString())));
            series3.getData().add(new XYChart.Data(String.valueOf(x), db.getRatingCount(3, fromDate.getValue().toString(), toDate.getValue().toString())));
        }

        bar.getData().addAll(series1, series2, series3);

        pie.setVisible(false);
        bar.setVisible(true);
        line.setVisible(false);
    }

    public void showLineChart(){

        pie.setVisible(false);
        bar.setVisible(false);
        line.setVisible(true);
    }

    public void enableDatePicker(){
        fromDate.setDisable(false);
        toDate.setDisable(false);
    }

    public void getToday(){
        fromDate.setValue(LocalDate.now());
        toDate.setValue(LocalDate.now());
        disableDatePicker();
    }

    public void getThisMonth(){
        fromDate.setValue(LocalDate.now().minusDays(LocalDate.now().getDayOfMonth()-1));
        toDate.setValue(fromDate.getValue().plusMonths(1).minusDays(1));
        disableDatePicker();
    }

    public void getThisYear(){
        fromDate.setValue(LocalDate.now().minusDays(LocalDate.now().getDayOfMonth()-1).minusMonths(LocalDate.now().getMonthValue()-1));
        toDate.setValue(fromDate.getValue().plusDays(30).plusMonths(11));
        disableDatePicker();
    }

    public void disableDatePicker(){
        fromDate.setDisable(true);
        toDate.setDisable(true);
    }
}
