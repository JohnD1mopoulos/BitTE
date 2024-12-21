import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomePageController {


    @FXML
    private ImageView backgroundImageView;

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private Button startButton;
	
	@FXML
    private AnchorPane mainPane;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private Font x7;

    @FXML
    private Color x8;

    @FXML
    void handleFemaleBottomwear(ActionEvent event) {
        showPane("Female Bottomwear");
    }

    @FXML
    void handleFemaleShoes(ActionEvent event) {
        showPane("Female Shoes");
    }

    @FXML
    void handleFemaleTopwear(ActionEvent event) {
        showPane("Female Topwear");
    }

    @FXML
    void handleHygieneExtras(ActionEvent event) {
        showPane("Hygiene");
    }

    @FXML
    void handleMaleBottomwear(ActionEvent event) {
        showPane("Male Topwear");
    }

    @FXML
    void handleMaleShoes(ActionEvent event) {
        showPane("Male Shoes");
    }

    @FXML
    void handleMaleTopwear(ActionEvent event) {
        showPane("Male Topwear");
    }

    @FXML
    void handlePersonalItemsExtras(ActionEvent event) {
        showPane("Personal Items");
    }

    private void showPane(String content) {
        
        mainPane.getChildren().clear();

        
        Pane newPane = new Pane();
        newPane.setPrefSize(mainPane.getPrefWidth(), mainPane.getPrefHeight());

        
        Label label = new Label(content);
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #333;");
        label.setLayoutX(10);
        label.setLayoutY(10);

        
        newPane.getChildren().add(label);

        
        mainPane.getChildren().add(newPane);
    }

    @FXML
    public void handleSwitchToSecondPage(ActionEvent event) throws IOException {
        try {
            double length = Double.parseDouble(lengthTextField.getText());
            double width = Double.parseDouble(widthTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());

            System.out.println("Μήκος: " + length + ", Πλάτος: " + width + ", Ύψος: " + height);
			Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            AppStart app = new AppStart();
			app.switchToSecondPage(stage);
        } catch (NumberFormatException e) {
            System.out.println("Παρακαλώ εισάγετε έγκυρους αριθμούς.");
        }
    }
}
