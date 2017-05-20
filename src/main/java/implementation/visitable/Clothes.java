package implementation.visitable;

import interfaces.Visitable;
import interfaces.Visitor;


public class Clothes implements Visitable {
    private  double price;

    public double getPrice() {
        return price;
    }

    public Clothes(double price) {
        this.price = price;
    }
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
