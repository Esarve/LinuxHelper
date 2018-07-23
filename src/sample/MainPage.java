package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainPage {

    @FXML
    public JFXButton insChrome;
    @FXML
    public JFXButton insFFox;
    @FXML
    public JFXButton insTBird;
    @FXML
    public JFXButton insTG;
    @FXML
    public JFXButton insDeluge;
    @FXML
    public TextArea outputTA;

    @FXML
    JFXTextField locationPathDir;

    @FXML
    JFXTextField locationPathFile;

    @FXML
    AnchorPane anchorpane;

    ActionsISDeb action = new ActionsISDeb();
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

    @FXML
    void installInternetSofts(ActionEvent event){
        Button btn =  (Button) event.getSource();
        String btnId = btn.getId();

        switch (btnId){
            case "insChrome":
                StringBuffer output= action.installSofts(action.chrome);
                outputTA.setText(output.toString());
                break;
            case "insFFox":
                break;
            case "insTBird":
                break;
            case "insTG":
                break;
            case "insDeluge":
                break;
        }
    }



}
