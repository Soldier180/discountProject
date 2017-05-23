import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.DecimalFormat;


public class ResultWindowController {
    @FXML
    Label lblShoes;
    @FXML
    Label lblClothes;
    @FXML
    Label lblAccessories;
    DecimalFormat df = new DecimalFormat("#.##");

    public void setPriceValues(double clothesPrice ,
                               double shoesPrice,
                               double accessoriesPrice){
        lblAccessories.setText(df.format(accessoriesPrice));
        lblClothes.setText(df.format(clothesPrice));
        lblShoes.setText(df.format(shoesPrice));
    }
}
