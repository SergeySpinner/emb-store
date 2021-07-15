package projectFiles.entity;

public class Product extends BaseEntity{
    private String name;
    private Integer price;
    private Integer prodQuantity;
    private String prodInfo;

    public Product(Integer id, String name, Integer price, Integer prodQuantity, String prodInfo) {
        super(id);
        this.name = name;
        this.price = price;
        this.prodQuantity = prodQuantity;
        this.prodInfo = prodInfo;
    }

    public Integer getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(Integer prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public String getProdInfo() {
        return prodInfo;
    }

    public void setProdInfo(String prodInfo) {
        this.prodInfo = prodInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String toString(){
        return "{Product:id=" + getId() +
                ",prodName=" + getName() +
                ",price=" + getPrice() +
                ",prodQuantity=" + getProdQuantity() +
                ",prodInfo=" + getProdInfo() + '}';
    }
}
