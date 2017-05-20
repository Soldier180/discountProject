package implementation.visitor;

import implementation.visitable.Accessories;
import implementation.visitable.Clothes;
import implementation.visitable.Shoes;
import interfaces.Visitor;

import java.text.DecimalFormat;

public class PremiumDiscount implements Visitor {

    public PremiumDiscount() {
    }
    public double visit(Clothes clothes) {//discount 10%
        return clothes.getPrice()- (clothes.getPrice()*.1);
    }

    public double visit(Shoes shoes) {//discount 10%
        return shoes.getPrice()- (shoes.getPrice()*.1);
    }

    public double visit(Accessories accessories) {//discount 15%
        return accessories.getPrice() - (accessories.getPrice()*.15);
    }
}
