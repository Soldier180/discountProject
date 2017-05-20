import implementation.visitable.Accessories;
import implementation.visitable.Clothes;
import implementation.visitable.Shoes;
import implementation.visitor.NoDiscount;
import implementation.visitor.PremiumDiscount;
import implementation.visitor.VipDiscount;
import interfaces.Visitor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button btnNoDiscount;
    @FXML
    Button btnPremiumDiscount;
    @FXML
    Button btnVipDiscount;
    @FXML
    TextField tfClothesPrice;
    @FXML
    TextField tfShoesPrice;
    @FXML
    TextField tfAccessoriesPrice;

    Clothes clothes;
    Accessories accessories;
    Shoes shoes;

    double clothesPrice;
    double shoesPrice;
    double accessoriesPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfClothesPrice.setOnKeyPressed(event -> onValidateTextField(tfClothesPrice));
        tfAccessoriesPrice.setOnKeyPressed(event -> onValidateTextField(tfAccessoriesPrice));
        tfShoesPrice.setOnKeyPressed(event -> onValidateTextField(tfShoesPrice));
        btnNoDiscount.setOnAction(event -> calcNoDiscount());
        btnPremiumDiscount.setOnAction(event -> calcPremiumDiscount());
        btnVipDiscount.setOnAction(event -> calcVipDiscount());
    }

    private void onValidateTextField(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d+\\.?]", ""));
            }
        });
    }

    private void calcNoDiscount() {
        readValuesFromTextFields();
        createVisitable();
        Visitor visitor = new NoDiscount();
        showResultWindowWithPrice("No discount",clothes.accept(visitor),
                shoes.accept(visitor),
                accessories.accept(visitor));
    }

    private void calcPremiumDiscount() {
        readValuesFromTextFields();
        createVisitable();
        Visitor visitor = new PremiumDiscount();
        showResultWindowWithPrice("Premium discount",clothes.accept(visitor),
                shoes.accept(visitor),
                accessories.accept(visitor));
    }
    private void calcVipDiscount() {
        readValuesFromTextFields();
        createVisitable();
        Visitor visitor = new VipDiscount();
        showResultWindowWithPrice("VIP discount",clothes.accept(visitor),
                shoes.accept(visitor),
                accessories.accept(visitor));
    }

    private  void createVisitable(){
        clothes = new Clothes(clothesPrice);
        shoes = new Shoes(shoesPrice);
        accessories = new Accessories(accessoriesPrice);
    }


    private void readValuesFromTextFields() {
        try {
            if (String.valueOf(tfShoesPrice.getCharacters()).isEmpty()) {
                shoesPrice = 0;
            } else {
                shoesPrice = Double.parseDouble(String.valueOf(tfShoesPrice.getCharacters()));
            }
            if (String.valueOf(tfClothesPrice.getCharacters()).isEmpty()) {
                clothesPrice = 0;
            } else {
                clothesPrice = Double.parseDouble(String.valueOf(tfClothesPrice.getCharacters()));
            }
            if (String.valueOf(tfAccessoriesPrice.getCharacters()).isEmpty()) {
                accessoriesPrice = 0;
            } else {
                accessoriesPrice = Double.parseDouble(String.valueOf(tfAccessoriesPrice
                        .getCharacters()));
            }

        } catch (NumberFormatException e) {
            showError();
        }
    }

    public void showResultWindowWithPrice(String title, double clothesPrice,
                                          double shoesPrice, double accessoriesPrice) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("resultWindow.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("discount.png")));
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setTitle(title);
            dialogStage.setResizable(false);


            ResultWindowController controller = loader.getController();
            controller.setPriceValues(clothesPrice, shoesPrice, accessoriesPrice);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText("Attention - some error in input data");
        alert.showAndWait();
    }


}
