package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static final String landingPage="LandingPage.fxml";
    public static final String mainPage="MainPage.fxml";


    public static Stage parentWindow;
    @Override
    public void start(Stage primaryStage) throws Exception{
        parentWindow=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        primaryStage.setTitle("Linux Helper");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void loadScene(String  fxml) throws IOException{
        Parent pagetoload;
        pagetoload= FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pagetoload);
        parentWindow.setScene(scene);
    }
}
