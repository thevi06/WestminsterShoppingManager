import java.io.Serializable;

public abstract class Products implements Serializable {
    private String productId;
    private String productName;
    private int numOfItems;
    private int price;
}
