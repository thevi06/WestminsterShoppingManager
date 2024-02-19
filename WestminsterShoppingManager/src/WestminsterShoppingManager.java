import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        if(getElectList().isEmpty() && getClothList().isEmpty()){
            System.out.println("No products have added");
        }else{

            Collections.sort(electList, new Comparator<Electronics>() {
                @Override
                public int compare(Electronics e1, Electronics e2) {
                    return e1.getProductId().compareTo(e2.getProductId());
                }
            });
        }

    }
}
