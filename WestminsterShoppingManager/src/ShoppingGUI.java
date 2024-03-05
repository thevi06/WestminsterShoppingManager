import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ShoppingGUI extends JFrame {

    private DefaultTableModel tableModel;
    private JPanel productDetailsPanel;

    public ShoppingGUI(WestminsterShoppingManager manager) {
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
