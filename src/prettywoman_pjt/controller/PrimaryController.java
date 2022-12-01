package prettywoman_pjt.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import prettywoman_pjt.PrettyWoman_pjt;

public class PrimaryController {

    @FXML
    private Button btn_iniciar;
    
    @FXML
    private void moveLogin()throws IOException {
        PrettyWoman_pjt.setRoot("view/login_view");
    }
}
