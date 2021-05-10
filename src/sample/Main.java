package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class Main extends Application {

    public Button hangupOneByOne;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        primaryStage.setTitle("SIPStorm");
        primaryStage.setScene(new Scene(root, 260, 850));
        primaryStage.setResizable(true);
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
