package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ToggleGroup;

public class Controller {
    @FXML
    BarChart bar;
    @FXML
    PieChart pie;
    @FXML
    LineChart line;
    @FXML
    ToggleGroup TimeRadioButtonGroup;

    public void printText(){
        System.out.println("Hey Text Printed!");
    }

    public void showPieChart(){
        pie.setVisible(true);
        bar.setVisible(false);
        line.setVisible(false);
    }

    public void showBarChart(){
        pie.setVisible(false);
        bar.setVisible(true);
        line.setVisible(false);
    }

    public void showLineChart(){
        pie.setVisible(false);
        bar.setVisible(false);
        line.setVisible(true);
    }
}
