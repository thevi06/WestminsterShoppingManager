import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShoppingGUI extends JFrame {

    private DefaultTableModel tableModel;
    private JPanel productDetailsPanel;

    public ShoppingGUI(WestminsterShoppingManager manager) {
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Westminster Shopping Center");
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Westminster Shopping Center");
        titleLabel.setFont(new Font("Calibre", Font.BOLD, 29));
        JPanel titlePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePane.add(titleLabel);
        add("North", titlePane);

        // Button Panel
        JPanel btnPanel = new JPanel();

        JButton sortBtn = new JButton("Sort");
        btnPanel.add(sortBtn);

        JButton addCart = new JButton("Add Cart");
        btnPanel.add(addCart);
