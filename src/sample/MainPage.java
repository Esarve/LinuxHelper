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
    public JFXCheckBox readUsr;
    @FXML
    public JFXCheckBox readGr;
    @FXML
    public JFXCheckBox readOt;
    @FXML
    public JFXCheckBox writeUsr;
    @FXML
    public JFXCheckBox writeGr;
    @FXML
    public JFXCheckBox writeOt;
    @FXML
    public JFXCheckBox exeUsr;
    @FXML
    public JFXCheckBox ExeGr;
    @FXML
    public JFXCheckBox exeOt;
    @FXML
    public JFXTextField pathDirPerm;
    @FXML
    public JFXTextField pathFilePerm;
    @FXML
    public JFXTextField pathDirRmv;
    @FXML
    public JFXTextField pathFileRmv;
    @FXML
    AnchorPane anchorpane;

    ActionsDeb action = new ActionsDeb();
    PackageNames packageNames = new PackageNames();
    StringBuffer output = new StringBuffer();
    Perm_dlt_others permdlt = new Perm_dlt_others();

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

    @FXML
    void changePerm(ActionEvent event){
        int getcode=0;
        StringBuffer perm = new StringBuffer();
        String getperm="";
        chnagePermAnotherOneDontKnowWhy(perm, pathDirPerm);

        chnagePermAnotherOneDontKnowWhy(perm, pathFilePerm);
    }

    private void chnagePermAnotherOneDontKnowWhy(StringBuffer perm, JFXTextField checkField) {
        int getcode;
        String getperm;
        if(!checkField.getText().isEmpty()){
            getcode = calculateScore();
            getperm = permdlt.getPermission(checkField.getText());
            perm.append("Current Permission: \n"+getperm+"\n");
            outputTA.setText(perm.toString());

            permdlt.ChnagePermission(checkField.getText() , Integer.toString(getcode));

            getperm = permdlt.getPermission(checkField.getText());
            perm.append("New Permission: \n"+getperm+"\n");
            outputTA.setText(perm.toString());
        }
    }

    private int calculateScore(){
        int usr = 0;
        int ot = 0;
        int gr = 0;

        if(readUsr.isSelected()) usr+=4;
        if(writeUsr.isSelected()) usr+=2;
        if(exeUsr.isSelected()) usr+=1;
        if(readGr.isSelected()) gr+=4;
        if(writeGr.isSelected()) gr+=2;
        if(ExeGr.isSelected()) gr+=1;
        if(readOt.isSelected()) ot+=4;
        if(writeOt.isSelected()) ot+=2;
        if(exeOt.isSelected()) ot+=1;

        int totalScore= (usr*100)+(gr*10)+ot;

        return totalScore;
    }

}
