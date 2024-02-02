public class Clothing extends Products {
    private String size;
    private String color;

    public Clothing(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing{"+super.toString() +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String toStringGui() {
        return size + ',' +color;
    }

    public String getSize() {
        return size;
    }

    public String getCategory() {
        return "Clothing";
    }
}