import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel ddText = new JLabel("Select product category:");
        btnPanel.add(ddText);

        String[] items = {"All", "Electronics", "Clothes"};
        JComboBox<String> dropdown = new JComboBox<>(items);
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = dropdown.getSelectedItem().toString();
                updateTable(selectedCategory, tableModel, manager);
            }
        });

        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortTable();
            }
        });
        btnPanel.add(dropdown);

        add(btnPanel, BorderLayout.NORTH);

        // Table Panel
        String[] columnNames = {"Product ID", "Name", "Category", "Price", "Number of Items", "Info"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable productListTable = new JTable(tableModel);
