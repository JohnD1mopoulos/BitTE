import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

public class HomePageController {
    
    private double length;
    private double width;
    private double height;

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BottomwearFemale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleFemaleShoes(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoesFemale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleFemaleTopwear(ActionEvent event) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Topwear.fxml"));
       Parent pane = loader.load();
       mainPane.getChildren().setAll(pane); 
    }

    @FXML
    void handleHygieneExtras(ActionEvent event) {
        
    }

    @FXML
    void handleMaleBottomwear(ActionEvent event) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("BottomwearMale.fxml"));
       Parent pane = loader.load();
       mainPane.getChildren().setAll(pane); 
    }

    @FXML
    void handleMaleShoes(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoesMale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleMaleTopwear(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Topwear.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handlePersonalItemsExtras(ActionEvent event) {
        
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
     public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
	
	@FXML
    private ChoiceBox<String> SizeChoiceBoxTShirt;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxShirt;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxHoodie;

    @FXML
    private Button minusButton;

    @FXML
    private Button plusButton;
	
	@FXML
    private ChoiceBox<String> SizeChoiceBoxJeans;
   
    @FXML
    private ChoiceBox<String> SizeChoiceBoxSweatpants;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxTrousers;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxBoxers;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxShorts;
	
	 @FXML
    private ChoiceBox<String> SizeChoiceBoxJeansF;
   
    @FXML
    private ChoiceBox<String> SizeChoiceBoxSweatpantsF;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxTrousersF;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxSkirtsF;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxPantiesF;
	
    @FXML
    private ChoiceBox<String> SizeChoiceBoxSneaker;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxSandal;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxBoots;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxSocks;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxSneakerF;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxSandalF;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxBootsF;

    @FXML
    private ChoiceBox<String> SizeChoiceBoxSocksF;

    @FXML
    public void initialize() {
        if (SizeChoiceBoxTShirt != null) {
            SizeChoiceBoxTShirt.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxShirt.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxHoodie.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
        }
		
		if (SizeChoiceBoxJeans != null) {
            SizeChoiceBoxJeans.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxSweatpants.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxTrousers.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxBoxers.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxShorts.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
        }
		
		if (SizeChoiceBoxJeansF != null) {
            SizeChoiceBoxJeansF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxSweatpantsF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxTrousersF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxSkirtsF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxPantiesF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            
        }
		
		if (SizeChoiceBoxSneaker != null) {
            SizeChoiceBoxSneaker.setItems(FXCollections.observableArrayList("38-40", "40-42", "42-44"));
            SizeChoiceBoxSandal.setItems(FXCollections.observableArrayList("38-40", "40-42", "42-44"));
            SizeChoiceBoxBoots.setItems(FXCollections.observableArrayList("38-40", "40-42", "42-44"));
            SizeChoiceBoxSocks.setItems(FXCollections.observableArrayList("38-40", "40-42", "42-44"));
            
        }

        if (SizeChoiceBoxSneakerF != null) {
            SizeChoiceBoxSneakerF.setItems(FXCollections.observableArrayList("34-36", "36-38", "38-40"));
            SizeChoiceBoxSandalF.setItems(FXCollections.observableArrayList("34-36", "36-38", "38-40"));
            SizeChoiceBoxBootsF.setItems(FXCollections.observableArrayList("34-36", "36-38", "38-40"));
            SizeChoiceBoxSocksF.setItems(FXCollections.observableArrayList("34-36", "36-38", "38-40"));
            
        }
    }
}
