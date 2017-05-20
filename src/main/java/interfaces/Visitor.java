package interfaces;

import implementation.visitable.Accessories;
import implementation.visitable.Clothes;
import implementation.visitable.Shoes;

public interface Visitor {
    double visit(Clothes clothes);
    double visit(Shoes shoes);
    double visit(Accessories accessories);
}
