import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class HomePageControl {


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
    private void initialize() {

        startButton.setOnAction(event -> handleStartButton());
    }

    private void handleStartButton() {
        try {
            double length = Double.parseDouble(lengthTextField.getText());
            double width = Double.parseDouble(widthTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());

            System.out.println("Μήκος: " + length + ", Πλάτος: " + width + ", Ύψος: " + height);
        } catch (NumberFormatException e) {
            System.out.println("Παρακαλώ εισάγετε έγκυρους αριθμούς.");
        }
    }
}
