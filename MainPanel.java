import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MainPanel extends Application {

    private Color currentColor = Color.BLUE;
    private String currentFunction = "line";
    private int currentLineWidth = 1;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        final ColorPicker colorPicker = new ColorPicker();


        BorderPane border = new BorderPane();
        FlowPane flowPane1 = new FlowPane();
        FlowPane flowPane2 = new FlowPane(Orientation.VERTICAL);
        FlowPane flowPane3 = new FlowPane();
        border.setTop(flowPane1);
        border.setLeft(flowPane2);
        border.setCenter(flowPane3);

        Label titleLabel = new Label("A Drawing Application by Jonas and Graham");
        Label shapeLabel = new Label("Select Shape Type");
        Label lineWidthLabel = new Label("Select Line Width");
        Label colorLabel = new Label("Select Colour");

        // Setup shape picker button.
        final ComboBox<String> functionComboBox = new ComboBox<>();
        functionComboBox.getItems().addAll("line", "oval", "rectangle");
        functionComboBox.getSelectionModel().selectFirst();
        functionComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldSelection, String newSelection) {
                currentFunction = newSelection;
            }
        });

        // Setup a color picker button.
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentColor = colorPicker.getValue();
            }
        });

        // Setup line width picker.
        final ComboBox<String> lineThickness = new ComboBox<>();
        lineThickness.getItems().addAll("1","2","3","4");
        lineThickness.getSelectionModel().selectFirst();
        lineThickness.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldSelection, String newSelection) {
                currentLineWidth = Integer.parseInt(newSelection);
            }
        });

        primaryStage.setScene(new Scene(border, 800, 800));
        flowPane1.setVgap(8);
        flowPane2.setVgap(8);
        flowPane3.setVgap(8);
        flowPane1.setHgap(4);
        flowPane2.setHgap(4);
        flowPane3.setHgap(4);
        flowPane1.setPrefWrapLength(300);
        flowPane2.setPrefWrapLength(300);
        flowPane3.setPrefWrapLength(300);
        flowPane1.getChildren().add(titleLabel);
        flowPane2.getChildren().add(shapeLabel);
        flowPane3.getChildren().add(functionComboBox);
        flowPane2.getChildren().add(lineWidthLabel);
        flowPane2.getChildren().add(lineThickness);
        flowPane2.getChildren().add(colorLabel);
        flowPane2.getChildren().add(colorPicker);
        primaryStage.setTitle("Welcome to SuperDraw");
        primaryStage.show();

    }
}