package Lesson2.MyProject.ProductPart;

import java.util.List;

public class Basket {
    private List<Product> basketList;
    private int priceOfBasket;

    private int sumAll(){
        int sum = 0;
        for(Product s : this.basketList)
            sum += s.price;
        return sum;
    }
    public int getPriceOfBasket(){
        return sumAll();
    }
}
