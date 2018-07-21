package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LandingPage {
    @FXML
    private ImageView deb;

    @FXML
    private ImageView arch;

    Main accessmain = new Main();

    public void openDebMainPanel(MouseEvent mouseEvent) throws IOException {
        accessmain.loadScene(Main.mainPage);
    }
}
