package entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private BasketState basketState;
    private List<Product> basketList = new ArrayList<>();
    private Integer priceOfBasket;
    private Integer buyerId;

    public Basket(BasketState basketState, List<Product> basketList, Integer priceOfBasket, Integer buyerId) {
        this.basketState = basketState;
        this.basketList = basketList;
        this.priceOfBasket = priceOfBasket;
        this.buyerId = buyerId;
    }

    public BasketState getBasketState() {
        return basketState;
    }

    public List<Product> getBasketList() {
        return basketList;
    }

    public Integer getPriceOfBasket() {
        return priceOfBasket;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public void setBasketState(BasketState basketState) {
        this.basketState = basketState;
    }

    public void setBasketList(List<Product> basketList) {
        this.basketList = basketList;
    }

    public void setPriceOfBasket(Integer priceOfBasket) {
        this.priceOfBasket = priceOfBasket;
    }
}
