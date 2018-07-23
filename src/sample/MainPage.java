package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainPage {
    @FXML
    JFXTextField locationPathDir;

    @FXML
    JFXTextField locationPathFile;

    @FXML
    AnchorPane anchorpane;

    @FXML
    void openBrowserDir(ActionEvent event){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose A folder");
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        File file = directoryChooser.showDialog(stage);
        if (file!=null){
            locationPathDir.setText(file.getAbsolutePath());
        }
    }

    @FXML
    void openBrowserFile(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose A file");
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file!=null){
            locationPathFile.setText(file.getAbsolutePath());
        }
    }




}
