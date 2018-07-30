package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPage implements Initializable {

    @FXML
    public JFXButton insChrome;
    @FXML
    public JFXButton insFFox;
    @FXML
    public JFXButton insTBird;
    @FXML
    public JFXButton insEmpathy;
    @FXML
    public JFXButton insDeluge;
    @FXML
    public TextArea outputTA;
    @FXML
    public JFXButton insHtop;
    @FXML
    public JFXButton insFboot;
    @FXML
    public JFXButton insPkgMngr;
    @FXML
    public JFXButton insTweak;
    @FXML
    public JFXButton insAdb;
    @FXML
    public JFXButton directoryPerm;
    @FXML
    public JFXButton directoryRmv;
    @FXML
    public JFXButton filePerm;
    @FXML
    public JFXButton fileRmv;
    @FXML
    public VBox vbx;
    @FXML
    public JFXCheckBox readOw;
    @FXML
    public JFXCheckBox readGr;
    @FXML
    public JFXCheckBox readGb;
    @FXML
    public JFXCheckBox writeOw;
    @FXML
    public JFXCheckBox writeGr;
    @FXML
    public JFXCheckBox writeGb;
    @FXML
    public JFXCheckBox ExeOw;
    @FXML
    public JFXCheckBox ExeGr;
    @FXML
    public JFXCheckBox ExeGb;
    @FXML
    JFXTextField pathDirPerm;
    @FXML
    JFXTextField pathFilePerm;
    @FXML
    JFXTextField pathDirRmv;
    @FXML
    JFXTextField pathFileRmv;
    @FXML
    AnchorPane anchorpane;

    ActionsDeb action = new ActionsDeb();
    PackageNames packageNames = new PackageNames();
    StringBuffer output = new StringBuffer();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        /*vbx.setDisable(true);
        outputTA.setText("Please wait while te package manager cache updates...");
        output=action.initializaCache();
        outputTA.setText(output.toString());*/
        vbx.setDisable(false);
    }

    @FXML
    void openBrowser(ActionEvent event){
        Button btn =  (Button) event.getSource();
        String btnId = btn.getId();
        if (btnId.equalsIgnoreCase("directoryPerm") || btnId.equalsIgnoreCase("directoryRmv")){
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Choose A folder");
            Stage stage = (Stage) anchorpane.getScene().getWindow();
            File file = directoryChooser.showDialog(stage);
            if (btnId.equalsIgnoreCase("directoryPerm")){
                if (file!=null){
                    pathDirPerm.setText(file.getAbsolutePath());
                }
            }
            else {
                pathDirRmv.setText(file.getAbsolutePath());
            }
        }
        else if (btnId.equalsIgnoreCase("filePerm") || btnId.equalsIgnoreCase("fileRmv")){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose A folder");
            Stage stage = (Stage) anchorpane.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);
            if (btnId.equalsIgnoreCase("filePerm")){
                if (file!=null){
                    pathFilePerm.setText(file.getAbsolutePath());
                }
            }
            else {
                pathFileRmv.setText(file.getAbsolutePath());
            }
        }

    }

    @FXML
    void installInternetSofts(ActionEvent event) throws Exception {
        Button btn =  (Button) event.getSource();
        String btnId = btn.getId();

        switch (btnId){
            case "insChrome":
                output= action.installSofts(packageNames.chrome);
                outputTA.setText(output.toString());
                break;
            case "ionsFFox":
                output=action.installSofts(packageNames.firefox);
                outputTA.setText(output.toString());
                break;
            case "insTBird":
                output=action.installSofts(packageNames.thunderbird);
                outputTA.setText(output.toString());
                break;
            case "insDeluge":
                output=action.installSofts(packageNames.deluge);
                outputTA.setText(output.toString());
                break;
            case "insEmpathy":
                output=action.installSofts(packageNames.deluge);
                outputTA.setText(output.toString());
                break;
        }
    }

}
