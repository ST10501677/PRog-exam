/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattresssalesgui;

/**
 *
 * @author njabu
 */
import javax.swing.;
import java.awt.;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class MattressSalesGUI extends JFrame {
    JComboBox<String> cmbProduct;
    JTextField txtCustomerName, txtPrice;
    JButton btnProcess;
    MovieTickets movieTickets = new MovieTickets();
    public MovieTicketsGUI() {    
        setTitle("Product App");    
        setSize(400, 400);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());  
        
        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu EditMenu = new JMenu("Edit");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        
        fileMenu.add(exitItem);
        EditMenu.add(processItem);
        EditMenu.add(clearItem);
        menuBar.add(fileMenu);
        menuBar.add(EditMenu);
        setJMenuBar(menuBar);
        
        // Input components
        cmbProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
        });
        
        txtCustomerName = new JTextField();
        txtPrice = new JTextField();
         txtReport= new JTextArea(6, 20);
        txtReport.setEditable(false);
       
        // Input panel
        JPanel inputPanel = new JPanel(
            new GridLayout(3, 2, 10, 10)    );
        inputPanel.add(new JLabel("Customer Name:"));
        inputPanel.add(txtCustomerName);
        inputPanel.add(new JLabel("Select Product:"));
        inputPanel.add(cmbProduct);
        inputPanel.add(new JLabel(" Price:"));
        inputPanel.add(txtPrice);
        
        
        // Main panel
        JPanel mainPanel = new JPanel(
            new BorderLayout(10, 20)
        );
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(
                20, 15, 20, 15
            )
        );
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(reportPanel, BorderLayout.CENTER);
        add(mainPanel);
        
        // Menu actions
        processItem.addActionListener(e -> processProduct());
        clearItem.addActionListener(e -> clearFields());  
        exitItem.addActionListener(e -> System.exit(0));
        
        setVisible(true);
    }
    
    // Process Purchase sales
            private void processProduct() {
        try {
            String ProductName =
                cmbProduct.getSelectedItem().toString();
            int Commission = Integer.parseInt(
                    txtCustomerName.getText().trim()
                );
            double ProductPrice =
                Double.parseDouble(
                    txtPrice.getText().trim()
                );
            PurchaceData data = new PurchaseData(
                CustomerName,ProductName, ProductPrice
            );
            
            // Validate input
            if (!CustomerName.ValidateData(data)) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid Name."
                );
                return;
            }
            

            
            // Generate report
            String report = String.format(
                Locale.US,
                "Customer Name: %s\n" +
                "PRICE: R %.1f\n" +
                "Product %d\n" +
                "TOTAL PRICE: R %.1f",
                txtCustomerName,
                txtPrice,
                Commission,
                GetTotal())
            );

            // Save report
            saveReport(report);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Enter a valid Name and price."
            );
        }}
    // Save report to text file
    private void saveReport(String report) {
        try (FileWriter writer =
             new FileWriter("report.txt")) {
            writer.write("Data LOG\n");
            writer.write(
                "********************************\n"
            );
            writer.write(report);
            writer.write(
                "\n********************************"
            );
            JOptionPane.showMessageDialog(
                this,
                "Data saved successfully!"
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                this,
                "Error saving report."
            );
        }}
    // Clear all fields
    private void clearFields() {
        cmbProduct.setSelectedIndex(0);
        txtCustomerName.setText("");
        txtPrice.setText("");
         }
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MattressSalesGUI();
                      });
    }
}


