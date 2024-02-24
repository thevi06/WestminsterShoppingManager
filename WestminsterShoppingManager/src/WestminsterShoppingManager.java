import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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

    public void printProduct() {

        if (getElectList().isEmpty() && getClothList().isEmpty()) {
            System.out.println("No products have added");
        } else {

            Collections.sort(electList, new Comparator<Electronics>() {
                @Override
                public int compare(Electronics e1, Electronics e2) {
                    return e1.getProductId().compareTo(e2.getProductId());
                }
            });

            Collections.sort(clothList, new Comparator<Clothing>() {
                @Override
                public int compare(Clothing c1, Clothing c2) {
                    return c1.getProductId().compareTo(c2.getProductId());
                }
            });
            System.out.println("\n*** List of all items ***");
            for (Electronics electronics : electList) {
                System.out.println("\nProduct Id :" + electronics.getProductId());
                System.out.println("Product Name :" + electronics.getProductName());
                System.out.println("Number of Items :" + electronics.getNumOfItems());
                System.out.println("Price :" + electronics.getPrice());
                System.out.println("Brand :" + electronics.getBrand());
                System.out.println("Warranty period :" + electronics.getWarrantyPeriod());
            }

            for (Clothing clothing : clothList) {
                System.out.println("\nProduct Id :" + clothing.getProductId());
                System.out.println("Product Name :" + clothing.getProductName());
                System.out.println("Number of Items :" + clothing.getNumOfItems());
                System.out.println("Price :" + clothing.getPrice());
                System.out.println("Size :" + clothing.getSize());
                System.out.println("Color :" + clothing.getColor());
            }
        }
    }
    // Using Iterator for safe removal
    public void deleteProduct(String productId) {
        boolean found = false;
        Iterator<Electronics> electronicsIterator = electList.iterator();
        while (electronicsIterator.hasNext()) {
            Electronics electronics = electronicsIterator.next();
            if (electronics.getProductId().equals(productId)) {
                found = true;
                electronicsIterator.remove();
                System.out.println("\nRemoved electronic item");
                break;
            }
        }

        // Using Iterator for safe removal
        Iterator<Clothing> clothingIterator = getClothList().iterator();
        while (clothingIterator.hasNext()) {
            Clothing clothing = clothingIterator.next();
            if (clothing.getProductId().equals(productId)) {
                found = true;
                clothingIterator.remove();
                System.out.println("\nRemoved clothing item");
                break;
            }
        }

        if (!found) {
            System.out.println("\nInvalid product id");
        }
    }

    public void addProduct(Products products) {
        String productId = products.getProductId();

        // Check if the product ID already exists in either list
        if (productExists(productId)) {
            System.out.println("Product ID already exists. Cannot add duplicate.");
            return;
        }

        if (getClothList().size() + getElectList().size() >= maxProducts) {
            System.out.println("Maximum limit reached");
        } else {
}