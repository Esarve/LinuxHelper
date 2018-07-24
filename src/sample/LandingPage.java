package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LandingPage {

    Main accessmain = new Main();

    public void openDebMainPanel(MouseEvent mouseEvent) throws Exception {
        accessmain.loadScene(Main.mainPage);
    }
}
