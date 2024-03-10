import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<Clothing> clothList = manager.getClothList();
        for (Clothing clothing : clothList) {
            Object[] rowData = {clothing.getProductId(), clothing.getProductName(), clothing.getCategory(), clothing.getPrice(), clothing.getNumOfItems(), clothing.getInfo()};
            tableModel.addRow(rowData);
        }

        ArrayList<Electronics> electList = manager.getElectList();
        for (Electronics electronics : electList) {
            Object[] rowData = {electronics.getProductId(), electronics.getProductName(), electronics.getCategory(), electronics.getPrice(), electronics.getNumOfItems(), electronics.getInfo()};
            tableModel.addRow(rowData);
        }

        productListTable.setDefaultEditor(Object.class, null);
        JScrollPane pane = new JScrollPane(productListTable);
        add(pane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to populate the table with data from the ArrayLists
    private void populateTable(ArrayList<Clothing> clothList, ArrayList<Electronics> electList, DefaultTableModel tableModel) {
        for (Clothing clothing : clothList) {
            Object[] rowData = {clothing.getProductId(), clothing.getProductName(), clothing.getCategory(), clothing.getPrice(),clothing.getNumOfItems(), clothing.getInfo()};
            if (clothing.getNumOfItems() < 3) {
                // Set the background color of the entire row to red
                Arrays.fill(rowData, Color.RED);
            }
            tableModel.addRow(rowData);
        }
