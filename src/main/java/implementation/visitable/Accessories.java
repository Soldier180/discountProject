package implementation.visitable;

import interfaces.Visitable;
import interfaces.Visitor;


public class Accessories implements Visitable{
    private  double price;

    public double getPrice() {
        return price;
    }

    public Accessories(double price) {
        this.price = price;
    }
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
