import implementation.visitable.Shoes;
import implementation.visitor.VipDiscount;
import interfaces.Visitor;

/**
 * Created by Nikolion on 20.05.2017.
 */
public class Test {
    public static void main(String[] args) {
        Visitor vipDiscount = new VipDiscount();
        Shoes shoes = new Shoes(100500);
        System.out.println(shoes.accept(vipDiscount));
    }
}
