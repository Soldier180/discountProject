package implementation.visitor;

import implementation.visitable.Accessories;
import implementation.visitable.Clothes;
import implementation.visitable.Shoes;
import interfaces.Visitor;

import java.text.DecimalFormat;

public class VipDiscount implements Visitor{

    public VipDiscount() {
    }
    public double visit(Clothes clothes) {//discount 15%
        return clothes.getPrice()- (clothes.getPrice()*.15);
    }

    public double visit(Shoes shoes) {//discount 20%
        return shoes.getPrice()- (shoes.getPrice()*.2);
    }

    public double visit(Accessories accessories) {//discount 25%
        return accessories.getPrice() - (accessories.getPrice()*.25);
    }
}
