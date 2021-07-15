package projectFiles.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private BasketState basketState;
    private List<Integer> idList = new ArrayList<>();
    private List<Product> basketList = new ArrayList<>();
    private Integer priceOfBasket;
    private Integer buyerId;

    public Basket(String basketState, List<Product> basketList, Integer buyerId) {
        this.setBasketState(basketState);
        this.basketList = basketList;
        this.setPriceOfBasket(basketList);
        this.buyerId = buyerId;
    }

    public Basket(String basketState, Product product, Integer buyerId) {
        this.setBasketState(basketState);
        this.buyerId = buyerId;
        this.basketList.add(product);
    }

    public Basket(){}

    public void addToBasketList(Product product){
        this.basketList.add(product);
    }

    public void addToIdList(Integer productId){ this.idList.add(productId);}

    public BasketState getBasketState() {
        return basketState;
    }

    public void setBasketState(String basketState) {
        if (basketState.equals(BasketState.CONFIRMED.toString()))
            this.basketState = BasketState.CONFIRMED;
        else this.basketState = BasketState.ON_AGREEMENT;
    }

    public List<Product> getBasketList() {
        return basketList;
    }

    public void setBasketList(List<Product> basketList) {
        this.basketList = basketList;
    }

    public Integer getPriceOfBasket() {
        return priceOfBasket;
    }

    private void setPriceOfBasket(List<Product> basketList) {
        Integer sum = 0;
        for (Product product : basketList)
            sum += product.getPrice();
        this.priceOfBasket = sum;
    }

    public void setPriceOfBasket() {
        Integer sum = 0;
        for (Product product : this.basketList)
            sum += product.getPrice();
        this.priceOfBasket = sum;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketState=" + basketState +
                ", basketList=" + basketList.toString() +
                ", priceOfBasket=" + priceOfBasket +
                ", buyerId=" + buyerId +
                '}';
    }
}
