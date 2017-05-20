package implementation.visitor;

import implementation.visitable.Accessories;
import implementation.visitable.Clothes;
import implementation.visitable.Shoes;
import interfaces.Visitor;

import java.text.DecimalFormat;

public class NoDiscount implements Visitor {

    public NoDiscount() {
    }

    public double visit(Clothes clothes) {
        return clothes.getPrice();
    }

    public double visit(Shoes shoes) {
        return shoes.getPrice();
    }

    public double visit(Accessories accessories) {
        return accessories.getPrice();
    }
}
