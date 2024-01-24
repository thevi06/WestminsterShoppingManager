import java.io.Serializable;

public abstract class Products implements Serializable {
    private String productId;
    private String productName;
    private int numOfItems;
    private int price;

    public String toString() {
        return "Products{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", numOfItems=" + numOfItems +
                ", price=" + price +
                '}';
    }
}
