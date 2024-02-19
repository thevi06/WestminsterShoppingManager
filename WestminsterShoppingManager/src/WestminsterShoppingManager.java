import java.util.ArrayList;

public class WestminsterShoppingManager implements ShoppingManager {
    public final static int maxProducts = 50;
    public ArrayList<Electronics> electList = new ArrayList<>();
    public ArrayList<Clothing> clothList = new ArrayList<>();

    public ArrayList<Electronics> getElectList() {
        return electList;
    }

    public ArrayList<Clothing> getClothList() {
        return clothList;
    }

    public void printProduct(){
        
    }
}
