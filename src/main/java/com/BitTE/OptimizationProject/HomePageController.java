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
import javafx.scene.control.Label;

public class HomePageController {
    
    private double length;
    private double width;
    private double height;
	private int menu_number; // Variable for the menuhandler class
    private char gender;

    public int getMenuNumber(){
        return menu_number;
    }

    public void setMenuNumber(int menu_number){
        this.menu_number = menu_number;
    }

    public char getGender(){
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

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
    void handleFemaleBottomwear(ActionEvent event) throws IOException {
		setGender('F');
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BottomwearFemale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleFemaleShoes(ActionEvent event) throws IOException {
		setGender('F');
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoesFemale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleFemaleTopwear(ActionEvent event) throws IOException {
		setGender('F');
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TopwearFemale.fxml"));
		Parent pane = loader.load();
		mainPane.getChildren().setAll(pane); 
    }

    @FXML
    void handleHygieneExtras(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Hygiene.fxml"));
		Parent pane = loader.load();
		mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleMaleBottomwear(ActionEvent event) throws IOException {
		setGender('M');
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BottomwearMale.fxml"));
		Parent pane = loader.load();
		mainPane.getChildren().setAll(pane); 
    }

    @FXML
    void handleMaleShoes(ActionEvent event) throws IOException {
		setGender('M');
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoesMale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handleMaleTopwear(ActionEvent event) throws IOException {
		setGender('M');
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TopwearMale.fxml"));
        Parent pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    void handlePersonalItemsExtras(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonalItems.fxml"));
		Parent pane = loader.load();
		mainPane.getChildren().setAll(pane); 
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
private ChoiceBox<String> SizeChoiceBoxJeans;
@FXML
private ChoiceBox<String> SizeChoiceBoxTShirtF;
@FXML
private ChoiceBox<String> SizeChoiceBoxShirtF;
@FXML
private ChoiceBox<String> SizeChoiceBoxHoodieF;
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
private ChoiceBox<String> SizeChoiceBoxBook;
@FXML
private ChoiceBox<String> SizeChoiceBoxToiletryBag;
// TShirt
@FXML
private Button minusButtonTShirt;
@FXML
private Button plusButtonTShirt;
@FXML
private Label tShirtCountLabel;
private int countTShirt = 0;

// Shirt
@FXML
private Button minusButtonShirt;
@FXML
private Button plusButtonShirt;
@FXML
private Label shirtCountLabel;
private int countShirt = 0;

// Hoodie
@FXML
private Button minusButtonHoodie;
@FXML
private Button plusButtonHoodie;
@FXML
private Label hoodieCountLabel;
private int countHoodie = 0;

// T-Shirt
@FXML
private Button minusButtonTShirtF;
@FXML
private Button plusButtonTShirtF;
@FXML
private Label countLabelTShirtF;
private int countTShirtF = 0;

// Shirt
@FXML
private Button minusButtonShirtF;
@FXML
private Button plusButtonShirtF;
@FXML
private Label countLabelShirtF;
private int countShirtF = 0;

// Hoodie
@FXML
private Button minusButtonHoodieF;
@FXML
private Button plusButtonHoodieF;
@FXML
private Label countLabelHoodieF;
private int countHoodieF = 0;

// Jeans
@FXML
private Button minusButtonJeans;
@FXML
private Button plusButtonJeans;
@FXML
private Label countLabelJeans;
private int countJeans = 0;

// Sweatpants
@FXML
private Button minusButtonSweatpants;
@FXML
private Button plusButtonSweatpants;
@FXML
private Label countLabelSweatpants;
private int countSweatpants = 0;

// Trousers
@FXML
private Button minusButtonTrousers;
@FXML
private Button plusButtonTrousers;
@FXML
private Label countLabelTrousers;
private int countTrousers = 0;

// Boxers
@FXML
private Button minusButtonBoxers;
@FXML
private Button plusButtonBoxers;
@FXML
private Label countLabelBoxers;
private int countBoxers = 0;

// Shorts
@FXML
private Button minusButtonShorts;
@FXML
private Button plusButtonShorts;
@FXML
private Label countLabelShorts;
private int countShorts = 0;

// Jeans (Female)
@FXML
private Button minusButtonJeansF;
@FXML
private Button plusButtonJeansF;
@FXML
private Label countLabelJeansF;
private int countJeansF = 0;

// Sweatpants (Female)
@FXML
private Button minusButtonSweatpantsF;
@FXML
private Button plusButtonSweatpantsF;
@FXML
private Label countLabelSweatpantsF;
private int countSweatpantsF = 0;

// Trousers (Female)
@FXML
private Button minusButtonTrousersF;
@FXML
private Button plusButtonTrousersF;
@FXML
private Label countLabelTrousersF;
private int countTrousersF = 0;

// Skirts (Female)
@FXML
private Button minusButtonSkirtsF;
@FXML
private Button plusButtonSkirtsF;
@FXML
private Label countLabelSkirtsF;
private int countSkirtsF = 0;

// Panties (Female)
@FXML
private Button minusButtonPantiesF;
@FXML
private Button plusButtonPantiesF;
@FXML
private Label countLabelPantiesF;
private int countPantiesF = 0;

// Sneaker
@FXML
private Button minusButtonSneaker;
@FXML
private Button plusButtonSneaker;
@FXML
private Label countLabelSneaker;
private int countSneaker = 0;

// Sandal
@FXML
private Button minusButtonSandal;
@FXML
private Button plusButtonSandal;
@FXML
private Label countLabelSandal;
private int countSandal = 0;

// Boots
@FXML
private Button minusButtonBoots;
@FXML
private Button plusButtonBoots;
@FXML
private Label countLabelBoots;
private int countBoots = 0;

// Socks
@FXML
private Button minusButtonSocks;
@FXML
private Button plusButtonSocks;
@FXML
private Label countLabelSocks;
private int countSocks = 0;

// Sneaker (Female)
@FXML
private Button minusButtonSneakerF;
@FXML
private Button plusButtonSneakerF;
@FXML
private Label countLabelSneakerF;
private int countSneakerF = 0;

// Sandal (Female)
@FXML
private Button minusButtonSandalF;
@FXML
private Button plusButtonSandalF;
@FXML
private Label countLabelSandalF;
private int countSandalF = 0;

// Boots (Female)
@FXML
private Button minusButtonBootsF;
@FXML
private Button plusButtonBootsF;
@FXML
private Label countLabelBootsF;
private int countBootsF = 0;

// Socks (Female)
@FXML
private Button minusButtonSocksF;
@FXML
private Button plusButtonSocksF;
@FXML
private Label countLabelSocksF;
private int countSocksF = 0;

// Book
@FXML
private Button minusButtonBook;
@FXML
private Button plusButtonBook;
@FXML
private Label countLabelBook;
private int countBook = 0;

// Passport 
@FXML
private Button minusButtonPassport;
@FXML
private Button plusButtonPassport;
@FXML
private Label countLabelPassport;
private int countPassport = 0;

// Laptop
@FXML
private Button minusButtonLaptop;
@FXML
private Button plusButtonLaptop;
@FXML
private Label countLabelLaptop;
private int countLaptop = 0;

// Toiletry Bag
@FXML
private Button minusButtonToiletryBag;
@FXML
private Button plusButtonToiletryBag;
@FXML
private Label countLabelToiletryBag;
private int countToiletryBag = 0;

// TShirt Counter
@FXML
public void counterTShirt(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonTShirt) {
        countTShirt++;
    } else if (source == minusButtonTShirt && countTShirt > 0) {
        countTShirt--;
    }
    tShirtCountLabel.setText(String.valueOf(countTShirt));
}

// Shirt Counter
@FXML
public void counterShirt(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonShirt) {
        countShirt++;
    } else if (source == minusButtonShirt && countShirt > 0) {
        countShirt--;
    }
    shirtCountLabel.setText(String.valueOf(countShirt));
}

// Hoodie Counter
@FXML
public void counterHoodie(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonHoodie) {
        countHoodie++;
    } else if (source == minusButtonHoodie && countHoodie > 0) {
        countHoodie--;
    }
    hoodieCountLabel.setText(String.valueOf(countHoodie));
}

// T-Shirt Counter
@FXML
public void counterTShirtF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonTShirtF) {
        countTShirtF++;
    } else if (source == minusButtonTShirtF && countTShirtF > 0) {
        countTShirtF--;
    }
    countLabelTShirtF.setText(String.valueOf(countTShirtF));
}

// Shirt Counter
@FXML
public void counterShirtF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonShirtF) {
        countShirtF++;
    } else if (source == minusButtonShirtF && countShirtF > 0) {
        countShirtF--;
    }
    countLabelShirtF.setText(String.valueOf(countShirtF));
}

// Hoodie Counter
@FXML
public void counterHoodieF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonHoodieF) {
        countHoodieF++;
    } else if (source == minusButtonHoodieF && countHoodieF > 0) {
        countHoodieF--;
    }
    countLabelHoodieF.setText(String.valueOf(countHoodieF));
}

// Jeans Counter
@FXML
public void counterJeans(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonJeans) {
        countJeans++;
    } else if (source == minusButtonJeans && countJeans > 0) {
        countJeans--;
    }
    countLabelJeans.setText(String.valueOf(countJeans));
}

// Sweatpants Counter
@FXML
public void counterSweatpants(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSweatpants) {
        countSweatpants++;
    } else if (source == minusButtonSweatpants && countSweatpants > 0) {
        countSweatpants--;
    }
    countLabelSweatpants.setText(String.valueOf(countSweatpants));
}

// Trousers Counter
@FXML
public void counterTrousers(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonTrousers) {
        countTrousers++;
    } else if (source == minusButtonTrousers && countTrousers > 0) {
        countTrousers--;
    }
    countLabelTrousers.setText(String.valueOf(countTrousers));
}

// Boxers Counter
@FXML
public void counterBoxers(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonBoxers) {
        countBoxers++;
    } else if (source == minusButtonBoxers && countBoxers > 0) {
        countBoxers--;
    }
    countLabelBoxers.setText(String.valueOf(countBoxers));
}

// Shorts Counter
@FXML
public void counterShorts(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonShorts) {
        countShorts++;
    } else if (source == minusButtonShorts && countShorts > 0) {
        countShorts--;
    }
    countLabelShorts.setText(String.valueOf(countShorts));
}

// Jeans (Female) Counter
@FXML
public void counterJeansF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonJeansF) {
        countJeansF++;
    } else if (source == minusButtonJeansF && countJeansF > 0) {
        countJeansF--;
    }
    countLabelJeansF.setText(String.valueOf(countJeansF));
}

// Sweatpants (Female) Counter
@FXML
public void counterSweatpantsF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSweatpantsF) {
        countSweatpantsF++;
    } else if (source == minusButtonSweatpantsF && countSweatpantsF > 0) {
        countSweatpantsF--;
    }
    countLabelSweatpantsF.setText(String.valueOf(countSweatpantsF));
}

// Trousers (Female) Counter
@FXML
public void counterTrousersF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonTrousersF) {
        countTrousersF++;
    } else if (source == minusButtonTrousersF && countTrousersF > 0) {
        countTrousersF--;
    }
    countLabelTrousersF.setText(String.valueOf(countTrousersF));
}

// Skirts (Female) Counter
@FXML
public void counterSkirtsF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSkirtsF) {
        countSkirtsF++;
    } else if (source == minusButtonSkirtsF && countSkirtsF > 0) {
        countSkirtsF--;
    }
    countLabelSkirtsF.setText(String.valueOf(countSkirtsF));
}

// Panties (Female) Counter
@FXML
public void counterPantiesF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonPantiesF) {
        countPantiesF++;
    } else if (source == minusButtonPantiesF && countPantiesF > 0) {
        countPantiesF--;
    }
    countLabelPantiesF.setText(String.valueOf(countPantiesF));
}

// Sneaker Counter
@FXML
public void counterSneaker(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSneaker) {
        countSneaker++;
    } else if (source == minusButtonSneaker && countSneaker > 0) {
        countSneaker--;
    }
    countLabelSneaker.setText(String.valueOf(countSneaker));
}

// Sandal Counter
@FXML
public void counterSandal(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSandal) {
        countSandal++;
    } else if (source == minusButtonSandal && countSandal > 0) {
        countSandal--;
    }
    countLabelSandal.setText(String.valueOf(countSandal));
}

// Boots Counter
@FXML
public void counterBoots(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonBoots) {
        countBoots++;
    } else if (source == minusButtonBoots && countBoots > 0) {
        countBoots--;
    }
    countLabelBoots.setText(String.valueOf(countBoots));
}

// Socks Counter
@FXML
public void counterSocks(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSocks) {
        countSocks++;
    } else if (source == minusButtonSocks && countSocks > 0) {
        countSocks--;
    }
    countLabelSocks.setText(String.valueOf(countSocks));
}

// Sneaker (Female) Counter
@FXML
public void counterSneakerF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSneakerF) {
        countSneakerF++;
    } else if (source == minusButtonSneakerF && countSneakerF > 0) {
        countSneakerF--;
    }
    countLabelSneakerF.setText(String.valueOf(countSneakerF));
}

// Sandal (Female) Counter
@FXML
public void counterSandalF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSandalF) {
        countSandalF++;
    } else if (source == minusButtonSandalF && countSandalF > 0) {
        countSandalF--;
    }
    countLabelSandalF.setText(String.valueOf(countSandalF));
}

// Boots (Female) Counter
@FXML
public void counterBootsF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonBootsF) {
        countBootsF++;
    } else if (source == minusButtonBootsF && countBootsF > 0) {
        countBootsF--;
    }
    countLabelBootsF.setText(String.valueOf(countBootsF));
}

// Socks (Female) Counter
@FXML
public void counterSocksF(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonSocksF) {
        countSocksF++;
    } else if (source == minusButtonSocksF && countSocksF > 0) {
        countSocksF--;
    }
    countLabelSocksF.setText(String.valueOf(countSocksF));
}

// Book Counter
@FXML
public void counterBook(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonBook) {
        countBook++;
    } else if (source == minusButtonBook && countBook > 0) {
        countBook--;
    }
    countLabelBook.setText(String.valueOf(countBook));
}

// Laptop Counter
@FXML
public void counterLaptop(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonLaptop) {
        countLaptop++;
    } else if (source == minusButtonLaptop && countLaptop > 0) {
        countLaptop--;
    }
    countLabelLaptop.setText(String.valueOf(countLaptop));
}

// Passport Counter
@FXML
public void counterPassport(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonPassport) {
        countPassport++;
    } else if (source == minusButtonPassport && countPassport > 0) {
        countPassport--;
    }
    countLabelPassport.setText(String.valueOf(countPassport));
}


// Toiletry Bag Counter
@FXML
public void counterToiletryBag(ActionEvent event) {
    Object source = event.getSource();
    if (source == plusButtonToiletryBag) {
        countToiletryBag++;
    } else if (source == minusButtonToiletryBag && countToiletryBag > 0) {
        countToiletryBag--;
    }
    countLabelToiletryBag.setText(String.valueOf(countToiletryBag));
}


    @FXML
    public void initialize() {
        if (SizeChoiceBoxTShirt != null) {
            SizeChoiceBoxTShirt.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxShirt.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxHoodie.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
        }
		
		if (SizeChoiceBoxTShirtF != null) {
            SizeChoiceBoxTShirtF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxShirtF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
            SizeChoiceBoxHoodieF.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
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
		
		if (SizeChoiceBoxBook != null) {
            SizeChoiceBoxBook.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM", "LARGE"));
        }

        if (SizeChoiceBoxToiletryBag != null) {
            SizeChoiceBoxToiletryBag.setItems(FXCollections.observableArrayList("SMALL", "MEDIUM"));
        }
    }
}