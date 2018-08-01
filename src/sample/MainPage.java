package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalTime;
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
    public JFXTextField cmd;
    @FXML
    public TabPane tabpane;
    @FXML
    public JFXButton insVlc;
    @FXML
    public JFXButton insSpotify;
    @FXML
    public JFXButton insRythmbox;
    @FXML
    public JFXButton insJava;
    @FXML
    public JFXButton insPy;
    @FXML
    public JFXButton insBuild;
    @FXML
    public JFXButton insNetbeans;
    @FXML
    public JFXButton insCb;
    @FXML
    public JFXTimePicker time;
    @FXML
    AnchorPane anchorpane;

    ActionsDeb action = new ActionsDeb();
    PackageNames packageNames = new PackageNames();
    StringBuffer output = new StringBuffer();
    Perm_dlt_others permdlt = new Perm_dlt_others();
    private File file;

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
            file = directoryChooser.showDialog(stage);
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
            file = fileChooser.showOpenDialog(stage);
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
    void installSofts(ActionEvent event) throws Exception {
        Button btn =  (Button) event.getSource();
        String btnId = btn.getId();
        System.out.println(btnId);

        outputTA.setText("Please wait while the operation is on process...");

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
            case "insHtop":
                output=action.installSofts(packageNames.htop);
                outputTA.setText(output.toString());
                break;
            case "insFboot":
                output=action.installSofts(packageNames.fastboot);
                outputTA.setText(output.toString());
                break;
            case "insPkgMngr":
                output=action.installSofts(packageNames.synaptics);
                outputTA.setText(output.toString());
                break;
            case "insTweak":
                output=action.installSofts(packageNames.tweaks);
                outputTA.setText(output.toString());
                break;
            case "insAdb":
                output=action.installSofts(packageNames.adb);
                outputTA.setText(output.toString());
                break;
            case "insVlc":
                output=action.installSofts(packageNames.vlc);
                outputTA.setText(output.toString());
                break;
            case "insSpotify":
                output=action.installSofts("spotify");
                outputTA.setText(output.toString());
                break;
            case "insRythmbox":
                output=action.installSofts(packageNames.rythmbox);
                outputTA.setText(output.toString());
                break;
            case "insJava":
                output=action.installSofts(packageNames.jdk);
                outputTA.setText(output.toString());
                break;
            case "insPy":
                output=action.installSofts(packageNames.python);
                outputTA.setText(output.toString());
                break;
            case "insBuild":
                output=action.installSofts(packageNames.build);
                outputTA.setText(output.toString());
                break;
            case "insNetbeans":
                output=action.installSofts(packageNames.netbeans);
                outputTA.setText(output.toString());
                break;
            case "insCb":
                output=action.installSofts(packageNames.codeblocks);
                outputTA.setText(output.toString());
                break;
        }
    }

    @FXML
    void changePerm(ActionEvent event){
        StringBuffer perm = new StringBuffer();
        System.out.println(pathDirPerm.getText());
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

    @FXML
    public void delete(ActionEvent event){
        if (isSafe(pathDirRmv.getText())) {
            performdlt(pathDirRmv);
            performdlt(pathFileRmv);
        }else{
            outputTA.setText("NOT SAFE TO DELETE!");
        }

    }

    private void performdlt(JFXTextField checkfield){

        if(!checkfield.getText().isEmpty()){
            System.out.println("Field ID: "+checkfield.getId());
            if(checkfield.getId().equalsIgnoreCase("pathDirRmv")){
                permdlt.RemoveDir(checkfield.getText());
            }
            if(checkfield.getId().equalsIgnoreCase("pathFileRmv")){
                permdlt.Removefile(checkfield.getText());
            }
            outputTA.setText(checkfield.getText()+ " is Removed");
        }

    }

    @FXML
    public void scheduleShutdown(){
        LocalTime gettime = time.getValue();
        String selectedtime = gettime.toString();
        permdlt.shutdown(selectedtime);
        outputTA.setText("Shutdown Scheduled for "+ selectedtime);

    }

    @FXML
    public void run(ActionEvent event){
        String inputcmd = cmd.getText();
        output=permdlt.execute(inputcmd);
        outputTA.setText("Command executed successfully!");
        output.append(outputTA.getText()+ "\n");
        outputTA.setText(output.toString());
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

    private boolean isSafe(String string){
        return string.contains("/home/");
    }

}
