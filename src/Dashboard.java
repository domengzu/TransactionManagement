
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import com.toedter.calendar.JDateChooser;


public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        // Remove window decorations (title bar, borders, etc.)
        setUndecorated(true);
        initComponents();
        setDateChooserFormat();
        setFullScreen();
        setLocationRelativeTo(null);
        loadDataToTable();
        disableUpdateBtn();
        //disableUpdateButton();
        initializeDateChooserTimer();
        
        //Customize Table
        // Hide the ID column (assuming it's the first column - index 0)
        TableColumnModel columnModel = DashboardTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(0);
        idColumn.setMaxWidth(0);
        idColumn.setPreferredWidth(0);
        idColumn.setResizable(false);
        DashboardTable.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        //Set current date in DateChooser
        DateChooser.setDate(new java.util.Date());
        
        // Add a property change listener to reload data when date changes
        DateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                loadDataToTable();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DashboardTable = new javax.swing.JTable();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldAddress = new javax.swing.JTextField();
        fieldProductName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        fieldReceiptType = new javax.swing.JComboBox<>();
        fieldUnit = new javax.swing.JSpinner();
        fieldPricePerUnit = new javax.swing.JSpinner();
        fieldTotalPrice = new javax.swing.JSpinner();
        btnCancelUpdate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DashboardTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DashboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Date", "Receipt Type", "Name", "Address", "Product Name", "Unit (KG)", "Price Per Unit", "Total Price", "Inputed by:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DashboardTable.setRowHeight(30);
        DashboardTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DashboardTable);
        if (DashboardTable.getColumnModel().getColumnCount() > 0) {
            DashboardTable.getColumnModel().getColumn(1).setResizable(false);
            DashboardTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            DashboardTable.getColumnModel().getColumn(2).setMinWidth(70);
            DashboardTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            DashboardTable.getColumnModel().getColumn(3).setMinWidth(200);
            DashboardTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            DashboardTable.getColumnModel().getColumn(4).setMinWidth(200);
            DashboardTable.getColumnModel().getColumn(4).setPreferredWidth(200);
            DashboardTable.getColumnModel().getColumn(5).setMinWidth(150);
            DashboardTable.getColumnModel().getColumn(5).setPreferredWidth(150);
            DashboardTable.getColumnModel().getColumn(5).setMaxWidth(150);
            DashboardTable.getColumnModel().getColumn(6).setMinWidth(30);
            DashboardTable.getColumnModel().getColumn(6).setPreferredWidth(30);
            DashboardTable.getColumnModel().getColumn(7).setMinWidth(60);
            DashboardTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            DashboardTable.getColumnModel().getColumn(8).setMinWidth(40);
            DashboardTable.getColumnModel().getColumn(8).setPreferredWidth(40);
        }

        jButton4.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Receipt Type");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 238, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Address:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 238, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Product Name:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 134, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Name: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 238, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Price Per Unit:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 132, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Unit (KG):");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 90, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Total Price:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });
        jPanel3.add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 277, 30));

        fieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddressActionPerformed(evt);
            }
        });
        jPanel3.add(fieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 277, 30));

        fieldProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldProductNameActionPerformed(evt);
            }
        });
        jPanel3.add(fieldProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 277, 30));

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 130, 50));

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 130, 40));

        fieldReceiptType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldReceiptType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Charge Receipt", "Collection Receipt", "Sales Receipt" }));
        fieldReceiptType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldReceiptTypeActionPerformed(evt);
            }
        });
        jPanel3.add(fieldReceiptType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 277, -1));
        jPanel3.add(fieldUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 114, 30));
        jPanel3.add(fieldPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 130, 30));
        jPanel3.add(fieldTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 130, 30));

        btnCancelUpdate.setText("Cancel");
        btnCancelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 120, 40));

        jButton1.setText("Canal");

        jButton2.setText("Admin Access");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Employee Cashout");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel1.setText("Mycel's Management System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // Get the selected row index
        int selectedRow = DashboardTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a row to update", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get the ID of the selected record (assuming ID is in column 0)
        String id = DashboardTable.getValueAt(selectedRow, 0).toString();

        // Validate input fields
        if (fieldName.getText().trim().isEmpty() || 
            fieldAddress.getText().trim().isEmpty() || 
            fieldProductName.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, 
                "Please fill in all required fields", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Get values from text fields
        String receiptType = (String) fieldReceiptType.getSelectedItem();
        String name = fieldName.getText();
        String address = fieldAddress.getText();
        String productName = fieldProductName.getText();
        int unit = (Integer) fieldUnit.getValue();
        int pricePerUnit = (Integer) fieldPricePerUnit.getValue();
        int totalPrice = (Integer) fieldTotalPrice.getValue();

        // Get current user as recordedBy
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        

        try {
            // Get connection
            conn = DBConnection.mycon();
            
            // Prepare SQL query to check credentials
            String getInfo = "SELECT * FROM users WHERE status = 1";
            stmt = conn.prepareStatement(getInfo);

            // Execute the query
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String fullName = rs.getString("fullName"); // Works fine
                String recordedBy = fullName; // Current user's login
                System.out.println(recordedBy);

            // Create SQL update query
            String updateQuery = "UPDATE transactions SET " +
                                "receiptType = '" + receiptType + "', " +
                                "name = '" + name + "', " +
                                "address = '" + address + "', " +
                                "productName = '" + productName + "', " +
                                "unit = " + unit + ", " +
                                "pricePerUnit = " + pricePerUnit + ", " +
                                "totalPrice = " + totalPrice + ", " +
                                "recordedBy = '" + recordedBy + "' " +
                                "WHERE id = '" + id + "' ";

            // Execute update
            int result = stmt.executeUpdate(updateQuery);
            
            if (result > 0) {
                showStatusMessage("Data Updated Successfully!", true);

                // Reload table data to reflect changes
                loadDataToTable();

                // Clear input fields
                clearFields();
            } else {
                showStatusMessage("No Record was updated", false);
                } 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Database error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }   
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void fieldProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldProductNameActionPerformed

    private void fieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddressActionPerformed

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            // Get connection to database
            conn = DBConnection.mycon();
           
            // Get values from text fields
            String receiptType = (String) fieldReceiptType.getSelectedItem();
            String name = fieldName.getText();
            String address = fieldAddress.getText();
            String productName = fieldProductName.getText();
            int unit = (Integer) fieldUnit.getValue();
            int pricePerUnit = (Integer) fieldPricePerUnit.getValue();
            int totalPrice = (Integer) fieldTotalPrice.getValue();
            
            // Prepare SQL query to check credentials
            String getInfo = "SELECT * FROM users WHERE status = 1";
            stmt = conn.prepareStatement(getInfo);

            // Execute the query
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String fullName = rs.getString("fullName"); // Works fine
                String recordedBy = fullName; // Current user's login

            // Prepare SQL statement
            String sql = "INSERT INTO transactions (receiptType, name, address, productName, unit, pricePerUnit, totalPrice, recordedBy) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Create prepared statement
            PreparedStatement pst = conn.prepareStatement(sql);
            
            // Set values for the prepared statement
            pst.setString(1, receiptType);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, productName);
            pst.setInt(5, unit);
            pst.setInt(6, pricePerUnit);
            pst.setInt(7, totalPrice);
            pst.setString(8, recordedBy);
            // Execute the statement
            pst.executeUpdate();
            
            // reload Table contents
            loadDataToTable();

            // Close the prepared statement and connection
            pst.close();
            conn.close();
            
            showStatusMessage("Data Saved Successfully!", true);

            // Optional: Clear the text fields after successful save
            clearFields();
            }
        } catch (SQLException e) {
            showStatusMessage("Error: " + e.getMessage(), false);
            e.printStackTrace();
 
        } finally {
            // Close all resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void fieldReceiptTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldReceiptTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldReceiptTypeActionPerformed

    private void DashboardTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardTableMouseClicked
        // TODO add your handling code here:

        if(evt.getClickCount() == 2){
            System.out.println("clicked 2x");
            enableUpdateBtn();
            disableSaveBtn();

            int i = DashboardTable.getSelectedRow();

            String receipt_type = DashboardTable.getValueAt(i, 2).toString();
            String name = DashboardTable.getValueAt(i, 3).toString();
            String address = DashboardTable.getValueAt(i, 4).toString();
            String product_name = DashboardTable.getValueAt(i, 5).toString();
            int unit = Integer.parseInt(DashboardTable.getValueAt(i, 6).toString());
            int price_per_unit = Integer.parseInt(DashboardTable.getValueAt(i, 7).toString());
            int total_price = Integer.parseInt(DashboardTable.getValueAt(i, 8).toString());

            //field_id.setText(id);
            if (receipt_type.equals("Charge Receipt")) {
                fieldReceiptType.setSelectedIndex(0);
            }else if (receipt_type.equals("Collection Receipt")) {
                fieldReceiptType.setSelectedIndex(1);
            }else {
                fieldReceiptType.setSelectedIndex(2);
            }

            fieldName.setText(name);
            fieldAddress.setText(address);
            fieldProductName.setText(product_name);
            fieldUnit.setValue(unit);
            fieldPricePerUnit.setValue(price_per_unit);
            fieldTotalPrice.setValue(total_price);
        }
    }//GEN-LAST:event_DashboardTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCancelUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUpdateActionPerformed
        // TODO add your handling code here:
        enableSaveBtn();
        disableUpdateBtn();
        clearFields();
        
    }//GEN-LAST:event_btnCancelUpdateActionPerformed
    
    
    
    // Helper method to clear all text fields
    private void clearFields() {
        fieldReceiptType.setSelectedIndex(0);
        fieldName.setText("");
        fieldAddress.setText("");
        fieldProductName.setText("");
        fieldUnit.setValue(0);
        fieldPricePerUnit.setValue(0);
        fieldTotalPrice.setValue(0);
    }
    
    /**
    * Shows a status message using a label that appears and fades away
    * 
    * @param message The message to display
    * @param isSuccess True for success message (green), false for error (red)
    */
    private JLabel statusLabel = null;
    private Timer statusTimer = null;

    private void showStatusMessage(String message, boolean isSuccess) {

        // If there's an existing status message showing, remove it
        if (statusLabel != null && statusLabel.isVisible()) {
            this.remove(statusLabel);
            if (statusTimer != null && statusTimer.isRunning()) {
                statusTimer.stop();
            }
        }

        // Create a new status label
        statusLabel = new JLabel(message);
        statusLabel.setOpaque(true);

        // Style the label based on message type
        if (isSuccess) {
            statusLabel.setBackground(new Color(46, 204, 113)); // Green
        } else {
            statusLabel.setBackground(new Color(231, 76, 60)); // Red
        }

        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add a subtle shadow effect for better visibility
        statusLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        // Calculate position (centered at the top)
        Dimension labelSize = statusLabel.getPreferredSize();
        int x = (this.getWidth() - labelSize.width) / 2;
        int y = 20; // Top padding

        // Set label position and size
        statusLabel.setBounds(x, y, labelSize.width, labelSize.height);

        // Add label to dashboard (assuming this is the JFrame)
        this.setLayout(null); // Ensure absolute positioning works
        this.add(statusLabel);
        statusLabel.setVisible(true);

        // Bring to front (in case it's behind other components)
        statusLabel.getParent().setComponentZOrder(statusLabel, 0);

        // Repaint to show the label immediately
        this.repaint();

        // Create timer to hide the label after 3 seconds
        statusTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fadeOutStatusLabel();
            }
        });

        statusTimer.setRepeats(false);
        statusTimer.start();
    }

    /**
     * Gradually fades out the status label for a smooth disappearing effect
     */
    private void fadeOutStatusLabel() {
        if (statusLabel == null || !statusLabel.isVisible()) {
            return;
        }

        final Timer fadeTimer = new Timer(50, null);
        final float[] alpha = {1.0f};

        fadeTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha[0] -= 0.05f;
                if (alpha[0] <= 0) {
                    fadeTimer.stop();
                    statusLabel.setVisible(false);
                    Dashboard.this.remove(statusLabel);
                    Dashboard.this.repaint();
                } else {
                    Color bg = statusLabel.getBackground();
                    statusLabel.setBackground(new Color(
                        bg.getRed(), bg.getGreen(), bg.getBlue(), 
                        Math.max(0, Math.min(255, (int)(alpha[0] * 255)))
                    ));
                    Dashboard.this.repaint();
                }
            }
        });

        fadeTimer.start();
    }
    
    /**
    * Function to load data from database into the JTable
    */
    private void loadDataToTable() {
        
        try {
            // Get connection from your existing connection method
            Connection conn = DBConnection.mycon();

            java.util.Date selectedDate = DateChooser.getDate();
            DefaultTableModel model = (DefaultTableModel) DashboardTable.getModel();

            if (selectedDate != null) {
                // Convert java.util.Date to java.sql.Date for proper SQL date comparison
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

                // Modified query to use proper date comparison
                String query = "SELECT id, DATE_FORMAT(date, '%m/%d/%Y') AS date, receiptType, name, address, "
                        + "productName, unit, pricePerUnit, totalPrice, recordedBy "
                        + "FROM transactions WHERE DATE(date) = ? ORDER BY date DESC";

                PreparedStatement pst = conn.prepareStatement(query);
                pst.setDate(1, sqlDate);  // Use setDate instead of setString
                ResultSet rs = pst.executeQuery();

                // Clear existing data in the table
                model.setRowCount(0);

                boolean hasRecords = false;  // Flag to check if any records were found

                // Iterate through result set and add rows to table model
                while (rs.next()) {
                    hasRecords = true;  // Records found
                    Object[] row = {
                        rs.getString("id"),
                        rs.getString("date"),
                        rs.getString("receiptType"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("productName"),
                        rs.getInt("unit"),
                        rs.getInt("pricePerUnit"),
                        rs.getInt("totalPrice"),
                        rs.getString("recordedBy")
                    };

                    // Add row to the model
                    model.addRow(row);
                }

                if (!hasRecords) {
                    // Show message if no records found for the selected date
                    SimpleDateFormat displayFormat = new SimpleDateFormat("MM/dd/yyyy");
                    String formattedDate = displayFormat.format(selectedDate);
                    showStatusMessage("No records found for " + formattedDate, false);
                } else {
                    // Apply peso sign formatting to price columns only if we have records
                    applyPesoSignFormat(DashboardTable, 7); // pricePerUnit column
                    applyPesoSignFormat(DashboardTable, 8); // totalPrice column
                }

                // Close resources
                rs.close();
                pst.close();

            } else {
                // When no date is selected, keep the current table data
                // Don't do anything - this preserves the current view
            }
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Database error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void applyPesoSignFormat(JTable table, int columnIndex) {
        // Get the column from the table
        TableColumn column = table.getColumnModel().getColumn(columnIndex);

        // Create a custom cell renderer
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                // Get the default renderer component
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                // Check if the component is a label and the value is not null
                if (c instanceof JLabel && value != null) {
                    JLabel label = (JLabel) c;

                    // Ensure right alignment for currency values
                    label.setHorizontalAlignment(SwingConstants.LEFT);

                    try {
                        // Parse the value to get a number
                        Number numValue;
                        if (value instanceof Number) {
                            numValue = (Number) value;
                        } else {
                            numValue = Integer.parseInt(value.toString());
                        }

                        // Format with peso sign and thousand separators
                        NumberFormat formatter = NumberFormat.getInstance(Locale.getDefault());
                        String formattedValue = "₱: " + formatter.format(numValue);
                        label.setText(formattedValue);
                    } catch (Exception e) {
                        // If parsing fails, just add the peso sign
                        label.setText("₱: " + value.toString());
                    }
                }

                return c;
            }
        };

        // Apply the renderer to the column
        column.setCellRenderer(renderer);
    }
    
    
    private void disableUpdateButton() {
        btnUpdate.setEnabled(false);
        // Optional: You can also change the button appearance to give a visual cue
        btnUpdate.setBackground(new Color(200, 200, 200)); // Light gray background
        btnUpdate.setForeground(Color.GRAY); // Gray text

    }
    
    private void enableUpdateButton() {
        btnUpdate.setEnabled(true);
        // Restore the button's original appearance using UIManager defaults
        btnUpdate.setBackground(UIManager.getColor("Button.background"));
        btnUpdate.setForeground(UIManager.getColor("Button.foreground"));

        // If you also changed other properties, reset those too
        btnUpdate.setFont(UIManager.getFont("Button.font"));
        btnUpdate.setBorder(UIManager.getBorder("Button.border"));
    }
    
    private void setFullScreen() {
        // Get the default screen device
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        // Set the window to full-screen mode
        gd.setFullScreenWindow(this);
    }
    
    public void setDateChooserFormat() {
        // Create a SimpleDateFormat with the desired pattern

        // Set this format to the JDateChooser
        DateChooser.setDateFormatString("MM/dd/yyyy");

        // Set current date
        DateChooser.setDate(new java.util.Date());
    }
    
    

    // Create a method to initialize the timer
    private void initializeDateChooserTimer() {
        // Create timer that executes every 3 seconds (3000 milliseconds)
        dateChooserTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if DateChooser is empty
                if (DateChooser.getDate() == null) {
                    loadAllRecords();  // Load all records if empty
                }
            }
        });

        dateChooserTimer.start();  // Start the timer
    }

    // Create a method to load all records
    private void loadAllRecords() {
        try {
            Connection conn = DBConnection.mycon();
            DefaultTableModel model = (DefaultTableModel) DashboardTable.getModel();

            // Clear existing data
            model.setRowCount(0);

            String query = "SELECT id, DATE_FORMAT(date, '%m/%d/%Y') AS date, receiptType, name, address, "
                    + "productName, unit, pricePerUnit, totalPrice, recordedBy "
                    + "FROM transactions ORDER BY date DESC";

            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getString("id"),
                    rs.getString("date"),
                    rs.getString("receiptType"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("productName"),
                    rs.getInt("unit"),
                    rs.getInt("pricePerUnit"),
                    rs.getInt("totalPrice"),
                    rs.getString("recordedBy")
                };
                model.addRow(row);
            }

            // Apply peso sign formatting if there are records
            if (model.getRowCount() > 0) {
                applyPesoSignFormat(DashboardTable, 7); // pricePerUnit column
                applyPesoSignFormat(DashboardTable, 8); // totalPrice column
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Database error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void cleanup() {
        if (dateChooserTimer != null && dateChooserTimer.isRunning()) {
            dateChooserTimer.stop();
        }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    
    //Hide buttons
    private void disableSaveBtn(){
        btnSave.setVisible(false);
    
    }
    
    private void disableUpdateBtn(){
        btnUpdate.setVisible(false);
        btnCancelUpdate.setVisible(false);
    
    }
    
    private void enableSaveBtn(){
        btnSave.setVisible(true);
    
    }
    
    private void enableUpdateBtn(){
        btnUpdate.setVisible(true);
        btnCancelUpdate.setVisible(true);
    
    }
    
    
    
    // Declare the Timer at class level
    private Timer dateChooserTimer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DashboardTable;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton btnCancelUpdate;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField fieldAddress;
    private javax.swing.JTextField fieldName;
    private javax.swing.JSpinner fieldPricePerUnit;
    private javax.swing.JTextField fieldProductName;
    private javax.swing.JComboBox<String> fieldReceiptType;
    private javax.swing.JSpinner fieldTotalPrice;
    private javax.swing.JSpinner fieldUnit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
