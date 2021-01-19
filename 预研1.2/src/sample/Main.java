package sample;

import com.sun.jndi.toolkit.url.UrlUtil;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;

public class Main extends Application {

    private static Parent build() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        TextField textField = new TextField();
        gridPane.add(textField, 0, 0);

        Button button = new Button();
        button.setText("click me");
        gridPane.add(button, 0, 1);

        Label label = new Label();
        label.setPrefWidth(200);
        label.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5");
        gridPane.add(label, 0, 2);

        final Controller controller = new Controller();
        controller.inputField = textField;
        controller.outputLabel = label;

        //button.setOnMouseClicked(controller::点击事件);
        //button.setOnMouseClicked(event -> controller.点击事件(event));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                controller.点击事件(mouseEvent);
            }
        });

        //关于表的实验
        TableView<Student> tableView= new TableView<>();
        gridPane.add(tableView,0,3);

        //表中有哪些列
        TableColumn<Student,String> idColumn = new TableColumn<>();
        idColumn.setText("#ID");
        idColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return param.getValue().getIdValue();
            }
        });
        tableView.getColumns().add(idColumn);

        TableColumn<Student,String> nameColumn = new TableColumn<>();
        nameColumn.setText("姓名");
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return param.getValue().getNameValue();
            }
        });
        tableView.getColumns().add(nameColumn);

        TableColumn<Student,String> ageColumn = new TableColumn<>();
        ageColumn.setText("age");
        ageColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return param.getValue().getAgeValue();
            }
        });
        tableView.getColumns().add(ageColumn);

        TableColumn<Student,String> genderColumn = new TableColumn<>();
        genderColumn.setText("gender");
        genderColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return param.getValue().getGenderValue();
            }
        });
        tableView.getColumns().add(genderColumn);

//        TableColumn<Student,String> hobbyColumn = new TableColumn<>();
//        hobbyColumn.setText("hobbyColumn");
//        ageColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
//                Student student = param.getValue();
//                String ageStr = String.valueOf(student.age);
//                return new SimpleStringProperty(ageStr);
//            }
//        });
        //tableView.getColumns().add(hobbyColumn);

        //关于表的实验结束
        controller.tableView = tableView;


        return gridPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("../a"));
        //Parent root = build();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        URL root1 = getClass().getResource("sample.fxml");
        System.out.println(root1);
        primaryStage.setTitle("胡苏秦");
        Parent root = FXMLLoader.load(root1);
        Scene scene = new Scene(root, 600, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
