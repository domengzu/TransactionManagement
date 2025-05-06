package Main;


import java.awt.Dimension;
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
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.Toolkit;
import java.sql.Statement;
import javax.swing.JLayeredPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import java.awt.Font;
import java.awt.Color;




public class Dashboard extends javax.swing.JFrame {
    private CustomConfirmPanel confirmPanel;

    public Dashboard() {
        // Remove window decorations (title bar, borders, etc.)
        setUndecorated(true);
        initComponents();
        setDateChooserFormat();
        setFullScreen();
        setLocationRelativeTo(null);
        loadDataToTable();
        disableUpdateBtn();
        initializeDateChooserTimer();
        initProductTable();
        disableItemsBtnUpdate();
        setupTotalPriceCalculation();
        setupDashboardSearch();
        calculateDayProfit();
        calculateTransactionsTotal();

        
        //Customize Table
        // Hide the ID column (assuming it's the first column - index 0)
        TableColumnModel columnModel = DashboardTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(0);
        idColumn.setMaxWidth(0);
        idColumn.setPreferredWidth(0);
        idColumn.setResizable(false);
        DashboardTable.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        
        //tableItems Dashboard
        //Customize Table
        // Hide the ID column (assuming it's the first column - index 0)
        TableColumnModel itemsModel = tableItems.getColumnModel();
        TableColumn itemsidColumn = itemsModel.getColumn(0);
        itemsidColumn.setMinWidth(0);
        itemsidColumn.setMaxWidth(0);
        itemsidColumn.setPreferredWidth(0);
        itemsidColumn.setResizable(false);
        tableItems.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        //Set current date in DateChooser
        DateChooser.setDate(new java.util.Date());
        
        // Add a property change listener to reload data when date changes
        DateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                    loadDataToTable();
                }
            }); 
        
         // Initialize and setup confirm panel
        confirmPanel = new CustomConfirmPanel();
        getLayeredPane().add(confirmPanel, JLayeredPane.POPUP_LAYER);
        getLayeredPane().setLayout(null);
        confirmPanel.setOpaque(false);

        // Set the confirm panel size to match the window
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        confirmPanel.setBounds(0, 0, size.width, size.height);
        
        // total field not editable
        fieldOveralTotal.setEditable(false);
        // Disable both text field and buttons
        fieldTotalPrice.setEditable(false);
        
        // Add this in your form initialization or constructor
        DateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                calculateDayProfit();
            }
        });
        
        // Add this in your form initialization or constructor
        DateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                calculateTransactionsTotal();
            }
        });
        
        // set receipt type to sales Receipt as default:
        fieldReceiptType.setSelectedIndex(2);
        
        DateChooser.addPropertyChangeListener("date", evt -> {
        SharedData.setSelectedDate(DateChooser.getDate()); // Sync the selected date
        loadDataToTable(); // Reload data based on selected date
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
        fieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        fieldOveralTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        transactionsTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnLoadAllData = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldAddress = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        fieldReceiptType = new javax.swing.JComboBox<>();
        btnCancelUpdate = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        fieldUnit = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldPricePerUnit = new javax.swing.JSpinner();
        fieldProductName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnItemUpdate = new javax.swing.JButton();
        btnItemCancel = new javax.swing.JButton();
        fieldTotalPrice = new javax.swing.JTextField();
        btnEmployeeCashout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dayProfit = new javax.swing.JLabel();

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
                "id", "Date", "Receipt Type", "Name", "Address", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        }

        DateChooser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        fieldSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldSearch.setText("Search");
        fieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchActionPerformed(evt);
            }
        });

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Product Name", "Unit", "Price Per Unit", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableItems);
        if (tableItems.getColumnModel().getColumnCount() > 0) {
            tableItems.getColumnModel().getColumn(2).setResizable(false);
            tableItems.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Overall Total:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Total:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Transactions");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Products List");

        btnLoadAllData.setText("Load All Data");
        btnLoadAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAllDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldOveralTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(286, 286, 286)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(227, 227, 227)
                            .addComponent(btnLoadAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(transactionsTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(674, 674, 674)
                        .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                    .addComponent(btnLoadAllData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldOveralTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transactionsTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
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
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 134, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Name: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 238, -1));

        fieldName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });
        jPanel3.add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 277, 30));

        fieldAddress.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddressActionPerformed(evt);
            }
        });
        jPanel3.add(fieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 277, 30));

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 130, 40));

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 640, 130, 40));

        fieldReceiptType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldReceiptType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Charge Receipt", "Collection Receipt", "Sales Receipt" }));
        fieldReceiptType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldReceiptTypeActionPerformed(evt);
            }
        });
        jPanel3.add(fieldReceiptType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 277, -1));

        btnCancelUpdate.setText("Cancel");
        btnCancelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 120, 40));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldUnit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel4.add(fieldUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, 114, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Unit (KG):");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 90, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Total Price:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 132, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Price Per Unit:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 69, 132, -1));

        fieldPricePerUnit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel4.add(fieldPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 96, 130, 30));

        fieldProductName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldProductNameActionPerformed(evt);
            }
        });
        jPanel4.add(fieldProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, 277, 30));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 130, 36));

        btnItemUpdate.setText("Update");
        btnItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 130, 40));

        btnItemCancel.setText("Cancel");
        btnItemCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemCancelActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 40));

        fieldTotalPrice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel4.add(fieldTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 130, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 300, 300));

        btnEmployeeCashout.setText("Employee Cashout");
        btnEmployeeCashout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeCashoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEmployeeCashout, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnEmployeeCashout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel1.setText("Mycel's Management System");

        btnClose.setBackground(new java.awt.Color(255, 102, 102));
        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel10.setText("Day Profit:");

        dayProfit.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        dayProfit.setText("00.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1375, 1375, 1375))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnClose)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayProfit)
                                .addGap(36, 36, 36))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose)
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayProfit)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnEmployeeCashoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeCashoutActionPerformed
        // TODO add your handling code here:
        // Create and show the new EmployeeCashout frame
        EmployeeCashout employeeCashout = new EmployeeCashout();
        employeeCashout.setVisible(true);

        // Close the current Dashboard frame
        // 'this' refers to the current JFrame (Dashboard)
        this.dispose();
    }//GEN-LAST:event_btnEmployeeCashoutActionPerformed

    private void btnItemCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemCancelActionPerformed
        // TODO add your handling code here:
        disableItemsBtnUpdate();
        enableBtnAdd();
        itemClearFields();
    }//GEN-LAST:event_btnItemCancelActionPerformed

    private void btnItemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableItems.getSelectedRow();

        // Validation checks
        if (selectedRow == -1) {
            showStatusMessage("Please select an item to update", false);
            return;
        }

        if (fieldProductName.getText().trim().isEmpty()) {
            showStatusMessage("Please enter a product name", false);
            return;
        }

        try {
            // Get values from fields
            String productName = fieldProductName.getText().trim();
            int unit = Integer.parseInt(fieldUnit.getValue().toString());
            double pricePerUnit = Double.parseDouble(fieldPricePerUnit.getValue().toString());
            double totalPrice = unit * pricePerUnit;

            // Update the selected row in the table
            tableItems.setValueAt(productName, selectedRow, 0);
            tableItems.setValueAt(unit, selectedRow, 1);
            tableItems.setValueAt(String.format("₱%.2f", pricePerUnit), selectedRow, 2);

            // Update the overall total
            updateTotalPrice();

            // Clear input fields
            fieldProductName.setText("");
            fieldUnit.setValue(0);
            fieldPricePerUnit.setValue(0);
            fieldTotalPrice.setText("0");

            // Set focus back to product name field
            fieldProductName.requestFocus();

            showStatusMessage("Item Updated Successfully!", true);

        } catch (NumberFormatException e) {
            showStatusMessage("Please enter valid numbers for Unit and Price", false);
        }
    }//GEN-LAST:event_btnItemUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (fieldProductName.getText().trim().isEmpty()) {
            showStatusMessage("Please enter a product name", false);
            return;
        }

        try {
            // Get values from fields
            String productName = fieldProductName.getText().trim();
            int unit = Integer.parseInt(fieldUnit.getValue().toString());
            double pricePerUnit = Double.parseDouble(fieldPricePerUnit.getValue().toString());
            double amount = Double.parseDouble(fieldTotalPrice.getText().toString());

            // Add row to table
            Object[] row = {
                productName,
                unit,
                String.format("₱%.2f", pricePerUnit), // Format price with peso sign
                String.format("₱%.2f", amount)
            };
            productTableModel.addRow(row);

            updateTotalPrice();  // Update the overall total

            // Clear input fields
            fieldProductName.setText("");
            fieldUnit.setValue(0);
            fieldPricePerUnit.setValue(0);
            fieldTotalPrice.setText("0");

            // Set focus back to product name field
            fieldProductName.requestFocus();

        } catch (NumberFormatException e) {
            showStatusMessage("Please enter valid numbers for Unit and Price", false);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void fieldProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldProductNameActionPerformed

    private void btnCancelUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUpdateActionPerformed
        // TODO add your handling code here:
        enableSaveBtn();
        disableUpdateBtn();
        clearFields();

        // Clear all rows in tableItems
        DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
        model.setRowCount(0);  // This removes all rows from the table

        // Reset the total price display (if you have one)
        updateTotalPrice();
    }//GEN-LAST:event_btnCancelUpdateActionPerformed

    private void fieldReceiptTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldReceiptTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldReceiptTypeActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        int selectedViewRow = DashboardTable.getSelectedRow();

        // Validation checks
        if (selectedId == -1) {
            showStatusMessage("Please select a row to Update", false);
            return;
        }

        if (fieldName.getText().trim().isEmpty() ||
            fieldAddress.getText().trim().isEmpty()) {
            showStatusMessage("Please fill in all required fields", false);
            return;
        }

        // Show confirmation panel
        confirmPanel.showPanel();

        // Start a thread to wait for confirmation
        new Thread(() -> {
            while (confirmPanel.isShowing()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            // If confirmed, proceed with update on EDT
            if (confirmPanel.isConfirmed()) {
                // gi conpirm
                enableSaveBtn();
                SwingUtilities.invokeLater(() -> {
                    // Row selection check and handling
                    if (selectedViewRow == -1) {
                        String currentName = fieldName.getText().trim();
                        String currentAddress = fieldAddress.getText().trim();

                        // Try to find and select the row that matches our current data
                        for (int i = 0; i < DashboardTable.getRowCount(); i++) {
                            String tableName = DashboardTable.getValueAt(i, 3).toString();
                            String tableAddress = DashboardTable.getValueAt(i, 4).toString();

                            if (tableName.equals(currentName) && tableAddress.equals(currentAddress)) {
                                DashboardTable.setRowSelectionInterval(i, i);
                                System.out.println("Found and reselected row: " + i);
                                break;
                            }
                        }
                    }

                    if (selectedViewRow == -1) {
                        showStatusMessage("Please select a row to Update", false);
                        return;
                    }

                    Connection conn = null;
                    PreparedStatement stmtTransaction = null;
                    PreparedStatement stmtDeleteItems = null;
                    PreparedStatement stmtInsertItems = null;

                    try {
                        // Get the ID from the selected row
                        int id = Integer.parseInt(DashboardTable.getValueAt(selectedViewRow, 0).toString());
                        System.out.println("Processing update for ID: " + id);

                        // Get values from text fields
                        String receiptType = (String) fieldReceiptType.getSelectedItem();
                        String name = fieldName.getText().trim();
                        String address = fieldAddress.getText().trim();
                        double totalPrice = calculateTotal();

                        conn = DBConnection.mycon();
                        conn.setAutoCommit(false);

                        // 1. Update the transaction
                        String updateQuery = "UPDATE transactions SET " +
                        "receiptType = ?, " +
                        "name = ?, " +
                        "address = ?, " +
                        "totalPrice = ? " +
                        "WHERE id = ?";

                        stmtTransaction = conn.prepareStatement(updateQuery);
                        stmtTransaction.setString(1, receiptType);
                        stmtTransaction.setString(2, name);
                        stmtTransaction.setString(3, address);
                        stmtTransaction.setDouble(4, totalPrice);
                        stmtTransaction.setInt(5, id);

                        stmtTransaction.executeUpdate();

                        // 2. Delete existing items
                        String deleteItemsQuery = "DELETE FROM transaction_items WHERE transaction_id = ?";
                        stmtDeleteItems = conn.prepareStatement(deleteItemsQuery);
                        stmtDeleteItems.setInt(1, id);
                        stmtDeleteItems.executeUpdate();

                        // 3. Insert new items
                        String insertItemQuery = "INSERT INTO transaction_items (transaction_id, productName, unit, pricePerUnit, totalPrice) VALUES (?, ?, ?, ?, ?)";
                        stmtInsertItems = conn.prepareStatement(insertItemQuery);

                        // Loop through all items in tableItems
                        for (int i = 0; i < productTableModel.getRowCount(); i++) {
                            String productName = productTableModel.getValueAt(i, 0).toString();
                            int unit = Integer.parseInt(productTableModel.getValueAt(i, 1).toString());
                            double pricePerUnit = Double.parseDouble(
                                productTableModel.getValueAt(i, 2).toString()
                                .replace("₱", "")
                                .trim()
                            );
                            double itemTotalPrice = unit * pricePerUnit;

                            stmtInsertItems.setInt(1, id);
                            stmtInsertItems.setString(2, productName);
                            stmtInsertItems.setInt(3, unit);
                            stmtInsertItems.setDouble(4, pricePerUnit);
                            stmtInsertItems.setDouble(5, itemTotalPrice);
                            stmtInsertItems.executeUpdate();
                        }

                        // If we get here, commit the transaction
                        conn.commit();
                        showStatusMessage("Data Updated Successfully!", true);
                        loadDataToTable();
                        selectedId = -1;
                        clearFields();
                        clearProductsTable();

                    } catch (Exception e) {
                        // If there's an error, rollback the transaction
                        if (conn != null) {
                            try {
                                conn.rollback();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                        showStatusMessage("Error: " + e.getMessage(), false);
                        e.printStackTrace();
                    } finally {
                        try {
                            if (stmtInsertItems != null) stmtInsertItems.close();
                            if (stmtDeleteItems != null) stmtDeleteItems.close();
                            if (stmtTransaction != null) stmtTransaction.close();
                            if (conn != null) {
                                conn.setAutoCommit(true);
                                conn.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            // if Cancel or noting hahayyy
        }).start();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        PreparedStatement pst = null;
        Connection conn = null;

        try {
            // Validate input fields
            if (fieldName.getText().trim().isEmpty() ||
                fieldAddress.getText().trim().isEmpty()) {
                showStatusMessage("Please fill in all required fields", false);
                return;
            }

            // Check if there are products in the table
            if (productTableModel.getRowCount() == 0) {
                showStatusMessage("Please add at least one product", false);
                return;
            }

            // Get connection to database
            conn = DBConnection.mycon();

            // Disable auto-commit
            conn.setAutoCommit(false);

            try {
                // Get values from text fields
                String receiptType = (String) fieldReceiptType.getSelectedItem();
                String name = fieldName.getText().trim();
                String address = fieldAddress.getText().trim();
                double totalPrice = calculateTotal(); // Get total from calculation

                // Prepare SQL statement for transactions
                String sql = "INSERT INTO transactions (date, receiptType, name, address, totalPrice) " +
                "VALUES (NOW(), ?, ?, ?, ?)";

                // Create prepared statement with RETURN_GENERATED_KEYS
                pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // Set values for the prepared statement
                pst.setString(1, receiptType);
                pst.setString(2, name);
                pst.setString(3, address);
                pst.setDouble(4, totalPrice);

                // Execute the insert
                int result = pst.executeUpdate();

                // Get the generated transaction ID
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (!generatedKeys.next()) {
                    throw new SQLException("Creating transaction failed, no ID obtained.");
                }
                int transactionId = generatedKeys.getInt(1);

                // Now insert all products
                String productSql = "INSERT INTO transaction_items (transaction_id, productName, unit, pricePerUnit, totalPrice) " +
                "VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement productPst = conn.prepareStatement(productSql)) {
                    // Loop through all products in the table
                    for (int i = 0; i < productTableModel.getRowCount(); i++) {
                        String productName = productTableModel.getValueAt(i, 0).toString();
                        int unit = Integer.parseInt(productTableModel.getValueAt(i, 1).toString());
                        double pricePerUnit = Double.parseDouble(
                            productTableModel.getValueAt(i, 2).toString()
                            .replace("₱", "")
                            .trim()
                        );
                        double itemTotalPrice = unit * pricePerUnit;

                        productPst.setInt(1, transactionId);
                        productPst.setString(2, productName);
                        productPst.setInt(3, unit);
                        productPst.setDouble(4, pricePerUnit);
                        productPst.setDouble(5, itemTotalPrice);

                        productPst.executeUpdate();
                    }
                }

                // If we got here, everything worked, so commit the transaction
                conn.commit();

                // Show success message
                showStatusMessage("Transaction Saved Successfully!", true);

                // Reload Table contents
                loadDataToTable();

                // Clear products table
                clearProductsTable();

                // Clear all fields
                clearFields();

            } catch (SQLException e) {
                // Something went wrong, rollback the transaction
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                throw e; // Re-throw the exception to be caught by outer catch block
            }

        } catch (SQLException e) {
            showStatusMessage("Error: " + e.getMessage(), false);
            e.printStackTrace();

        } finally {
            try {
                // Reset auto-commit to true
                if (conn != null) {
                    conn.setAutoCommit(true);
                }

                // Close resources
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void fieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddressActionPerformed

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNameActionPerformed

    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemsMouseClicked
        if(evt.getClickCount() == 2) {
            enableItemBtnUpdate();
            disableBtnAdd();

            int i = tableItems.getSelectedRow();
            tableItems.setRowSelectionInterval(i, i);

            try {
                // Get values from the selected row
                String productName = tableItems.getValueAt(i, 0).toString();
                int unit = Integer.parseInt(tableItems.getValueAt(i, 1).toString());
                double pricePerUnit = Double.parseDouble(
                    tableItems.getValueAt(i, 2).toString()
                    .replace("₱", "")
                    .trim()
                );

                // Calculate total price
                double totalPrice = unit * pricePerUnit;

                // Set values to fields
                fieldProductName.setText(productName);
                fieldUnit.setValue(unit);
                fieldPricePerUnit.setValue(pricePerUnit);
                fieldTotalPrice.setText(String.format("%.2f", totalPrice));

            } catch (Exception e) {
                System.out.println("Error setting field values:");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tableItemsMouseClicked

    private void fieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchActionPerformed
        // TODO add your handling code here:
        searchDashboard();
    }//GEN-LAST:event_fieldSearchActionPerformed

    private void DashboardTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardTableMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            //isEditing = true;
            System.out.println("clicked 2x");
            enableUpdateBtn();
            disableSaveBtn();

            int i = DashboardTable.getSelectedRow();
            //int i = DashboardTable.getSelectedRow();
            // Add debug prints
            System.out.println("Selected Row Index: " + i);

            DashboardTable.setRowSelectionInterval(i, i);

            // Convert view index to model index and print
            int modelRow = DashboardTable.convertRowIndexToModel(i);
            System.out.println("Model Row Index: " + modelRow);

            try {

                // Store the ID when double-clicked
                selectedId = Integer.parseInt(DashboardTable.getValueAt(i, 0).toString());
                System.out.println("Stored selected ID: " + selectedId);

                int id = Integer.parseInt(DashboardTable.getValueAt(i, 0).toString());
                // Print the ID and other key information
                System.out.println("Selected ID: " + id);
                System.out.println("Row Data:");
                for(int col = 0; col < DashboardTable.getColumnCount(); col++) {
                    String colName = DashboardTable.getColumnName(col);
                    String value = DashboardTable.getValueAt(i, col) != null ?
                    DashboardTable.getValueAt(i, col).toString() : "null";
                    System.out.println(colName + ": " + value);
                }

                String receipt_type = DashboardTable.getValueAt(i, 2).toString();
                String name = DashboardTable.getValueAt(i, 3).toString();
                String address = DashboardTable.getValueAt(i, 4).toString();
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

                loadTransactionItems(selectedId);

                // Print the values being set to fields
                System.out.println("\nValues being set to fields:");
                System.out.println("Receipt Type: " + receipt_type);
                System.out.println("Name: " + name);

                DashboardTable.setRowSelectionInterval(i, i);
            } catch (Exception e) {
                System.out.println("Error processing row data:");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DashboardTableMouseClicked

    private void btnLoadAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAllDataActionPerformed
        // TODO add your handling code here:
        
        DateChooser.setDate(null);
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Get connection
            conn = DBConnection.mycon();
            DefaultTableModel model = (DefaultTableModel) DashboardTable.getModel();

            // Clear existing data in table
            model.setRowCount(0);

            // SQL query to get all transactions ordered by most recent date
            String query = "SELECT id, DATE_FORMAT(date, '%m/%d/%Y') AS date, receiptType, name, address, totalPrice "
                        + "FROM transactions ORDER BY date DESC";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            boolean hasRecords = false;

            // Add rows to table model
            while (rs.next()) {
                hasRecords = true;
                Object[] row = {
                    rs.getString("id"),
                    rs.getString("date"),
                    rs.getString("receiptType"),
                    rs.getString("name"),
                    rs.getString("address"),
                    String.format("₱%,.2f", rs.getDouble("totalPrice")) // Format price with peso sign and commas
                };
                model.addRow(row);
            }

            if (!hasRecords) {
                showStatusMessage("No transactions found in the database", false);
            } else {
                showStatusMessage("All transactions loaded successfully", true);
            }

            // Calculate and update the total
            calculateTransactionsTotal();

        } catch (SQLException e) {
            showStatusMessage("Database error: " + e.getMessage(), false);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnLoadAllDataActionPerformed
        
        
    //private boolean isEditing = false;
    private int selectedId = -1;    
    private void loadTransactionItems(int transactionId) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            // Clear existing items from the table
            clearProductsTable();  // assuming you renamed this method to clearItemsTable()

            // Get connection to database
            conn = DBConnection.mycon();

            // Prepare SQL statement to get items for this transaction
            String sql = "SELECT productName, unit, pricePerUnit, totalPrice FROM transaction_items WHERE transaction_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, transactionId);

            // Execute query
            rs = pst.executeQuery();

            // Add items to the table
            while (rs.next()) {
                String productName = rs.getString("productName");
                int unit = rs.getInt("unit");
                double pricePerUnit = rs.getDouble("pricePerUnit");
                double totalPrice = rs.getDouble("totalPrice");

                // Add row to table
                Object[] row = {
                    productName,
                    unit,
                    String.format("₱%.2f", pricePerUnit), // Format price with peso sign
                        String.format("₱%.2f", totalPrice) // Format price with peso sign
                };
                productTableModel.addRow(row);  // assuming you renamed this to itemTableModel
            }

            // Update the total
            updateTotalPrice();

        } catch (SQLException e) {
            System.out.println("Error loading transaction items:");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }    
    
    private TableRowSorter<DefaultTableModel> dashboardSorter;

    // Add this in your constructor or initComponents method
    public void setupDashboardSearch() {
        // Set up the table sorter
        DefaultTableModel model = (DefaultTableModel) DashboardTable.getModel();
        dashboardSorter = new TableRowSorter<>(model);
        DashboardTable.setRowSorter(dashboardSorter);

        // Set up the placeholder
        fieldSearch.setForeground(Color.GRAY);
        fieldSearch.setText("Search...");

        // Add focus listener for placeholder
        fieldSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fieldSearch.getText().equals("Search...")) {
                    fieldSearch.setText("");
                    fieldSearch.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fieldSearch.getText().isEmpty()) {
                    fieldSearch.setForeground(Color.GRAY);
                    fieldSearch.setText("Search...");
                }
            }
        });

        // Add document listener for real-time search
        fieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchDashboard();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchDashboard();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchDashboard();
            }
        });
    }

    // Search method for dashboard
    private void searchDashboard() {
        String text = fieldSearch.getText();

        if (text.equals("Search...")) {
            dashboardSorter.setRowFilter(null);
        } else {
            try {
                // Create a case-insensitive filter that searches all columns
                RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
                    @Override
                    public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                        for (int i = 0; i < entry.getValueCount(); i++) {
                            if (entry.getStringValue(i).toLowerCase().contains(text.toLowerCase())) {
                                return true;
                            }
                        }
                        return false;
                    }
                };
                dashboardSorter.setRowFilter(filter);

            } catch (Exception e) {
                dashboardSorter.setRowFilter(null);
            }
        }
    }    
    private void setupTotalPriceCalculation() {
        // Add property change listener to Unit spinner
        ((JSpinner.DefaultEditor) fieldUnit.getEditor()).getTextField().addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                calculateItemTotal();
            }
        });

        // Add document listener to Unit spinner's text field
        ((JSpinner.DefaultEditor) fieldUnit.getEditor()).getTextField().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { calculateItemTotal(); }
            public void removeUpdate(DocumentEvent e) { calculateItemTotal(); }
            public void changedUpdate(DocumentEvent e) { calculateItemTotal(); }
        });

        // Add property change listener to Price Per Unit spinner
        ((JSpinner.DefaultEditor) fieldPricePerUnit.getEditor()).getTextField().addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                calculateItemTotal();
            }
        });

        // Add document listener to Price Per Unit spinner's text field
        ((JSpinner.DefaultEditor) fieldPricePerUnit.getEditor()).getTextField().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { calculateItemTotal(); }
            public void removeUpdate(DocumentEvent e) { calculateItemTotal(); }
            public void changedUpdate(DocumentEvent e) { calculateItemTotal(); }
        });
    }

    private void calculateItemTotal() {
        try {
            String unitText = ((JSpinner.DefaultEditor) fieldUnit.getEditor()).getTextField().getText();
            String priceText = ((JSpinner.DefaultEditor) fieldPricePerUnit.getEditor()).getTextField().getText();

            if (!unitText.isEmpty() && !priceText.isEmpty()) {
                int unit = Integer.parseInt(unitText);
                double pricePerUnit = Double.parseDouble(priceText);
                double total = unit * pricePerUnit;

                fieldTotalPrice.setText(String.format("%.2f", total));
            }
        } catch (NumberFormatException e) {
            // Invalid input - do nothing or set to 0
            fieldTotalPrice.setText("");
        }
    }
    
    // Update total price field
    private void updateTotalPrice() {
        double total = calculateTotal();
    fieldOveralTotal.setText(String.format("₱%.2f", total));
    
    }
    
    private DefaultTableModel productTableModel;
    // Initialize the table model in your constructor or initComponents()
    private void initProductTable() {
        String[] columnNames = {"Product Name", "Unit", "Price Per Unit", "Amount"};
        productTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };
        tableItems.setModel(productTableModel);
    }
    
    private void clearProductsTable() {
        if (productTableModel != null) {
            productTableModel.setRowCount(0);
            updateTotalPrice();
        }
    }
    
    private double calculateTotal() {
        double total = 0;
        for (int i = 0; i < productTableModel.getRowCount(); i++) {
            int unit = Integer.parseInt(productTableModel.getValueAt(i, 1).toString());
            String priceString = productTableModel.getValueAt(i, 2).toString()
                                                .replace("₱", "")
                                                .trim();
            double price = Double.parseDouble(priceString);
            total += unit * price;
        }
        return total;
    }
    
    // Helper method to clear all text fields
    private void clearFields() {
        selectedId = -1;
        fieldReceiptType.setSelectedIndex(2);
        fieldName.setText("");
        fieldAddress.setText("");
        //isEditing = false;
        itemClearFields();
    }
    
    private void itemClearFields() {
        fieldProductName.setText("");
        fieldUnit.setValue(0);
        fieldPricePerUnit.setValue(0);
        fieldTotalPrice.setText("");
        
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
            DefaultTableModel model = (DefaultTableModel) DashboardTable.getModel();
            java.util.Date selectedDate = DateChooser.getDate();

            // Clear existing data in the table
            model.setRowCount(0);

            PreparedStatement pst;
            String query;

            if (selectedDate != null) {
                // If date is selected, use the existing date filter query
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                
                query = "SELECT id, DATE_FORMAT(date, '%m/%d/%Y') AS date, receiptType, name, address, totalPrice "
                        + "FROM transactions WHERE DATE(date) = ? ORDER BY date DESC";
                pst = conn.prepareStatement(query);
                pst.setDate(1, sqlDate);
            } else {
                // If no date selected, load all records
                query = "SELECT id, DATE_FORMAT(date, '%m/%d/%Y') AS date, receiptType, name, address, totalPrice "
                        + "FROM transactions ORDER BY date DESC";
                pst = conn.prepareStatement(query);
            }

            ResultSet rs = pst.executeQuery();
            boolean hasRecords = false;

            // Iterate through result set and add rows to table model
            while (rs.next()) {
                hasRecords = true;
                Object[] row = {
                    rs.getString("id"),
                    rs.getString("date"),
                    rs.getString("receiptType"),
                    rs.getString("name"),
                    rs.getString("address"),
                    String.format("₱ %.2f", rs.getDouble("totalPrice"))  // Changed this line
                };

                model.addRow(row);
                calculateTransactionsTotal();
            }

            if (!hasRecords) {
                if (selectedDate != null) {
                    // Show message if no records found for the selected date
                    SimpleDateFormat displayFormat = new SimpleDateFormat("MM/dd/yyyy");
                    String formattedDate = displayFormat.format(selectedDate);
                    showStatusMessage("No records found for " + formattedDate, false);
                } else {
                    // Show message if no records found at all
                    showStatusMessage("No records found in the database", false);
                }
            } else {
                
            }

            // Close resources
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            showStatusMessage("Database error: " + e.getMessage(), false);
            e.printStackTrace();
        }
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
        //DateChooser.setDateFormatString("MM/dd/yyyy");

        // Set current date
        DateChooser.setDate(new java.util.Date());
    }

    // Create a method to initialize the timer
    private void initializeDateChooserTimer() {
        dateChooserTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DateChooser.getDate() == null) {
                    loadDataToTable();
                }
            }
        });
    }
    
    private void calculateDayProfit() {
        if (DateChooser.getDate() == null) {
            dayProfit.setText("₱0.00");
            return;
        }

        Connection conn = null;
        PreparedStatement pstRevenue = null;
        PreparedStatement pstExpenses = null;
        ResultSet rsRevenue = null;
        ResultSet rsExpenses = null;

        try {
            // Use fonts that support the peso sign
            Font customFont = new Font("Segoe UI", Font.PLAIN, 36); // or your preferred size
            dayProfit.setFont(customFont);
            
            conn = DBConnection.mycon();

            // Format the selected date to match MySQL date format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = sdf.format(DateChooser.getDate());

            // Get total revenue for the selected date
            String revenueQuery = "SELECT COALESCE(SUM(totalPrice), 0) as total_revenue FROM transactions " +
                                "WHERE DATE(date) = ? AND receiptType != 'Charge Receipt'";
            pstRevenue = conn.prepareStatement(revenueQuery);
            pstRevenue.setString(1, selectedDate);
            rsRevenue = pstRevenue.executeQuery();

            // Get total expenses for the selected date
            String expensesQuery = "SELECT COALESCE(SUM(amount), 0) as total_expenses FROM employee_cashout " +
                                 "WHERE DATE(date) = ?";
            pstExpenses = conn.prepareStatement(expensesQuery);
            pstExpenses.setString(1, selectedDate);
            rsExpenses = pstExpenses.executeQuery();

            double totalRevenue = 0;
            double totalExpenses = 0;
            
            if (rsRevenue.next()) {
                totalRevenue = rsRevenue.getDouble("total_revenue");
            }

            if (rsExpenses.next()) {
                totalExpenses = rsExpenses.getDouble("total_expenses");
            }

            // Calculate net profit
            double netProfit = totalRevenue - totalExpenses;

            // Display net profit with proper formatting
            if (netProfit >= 0) {
                dayProfit.setText(String.format("₱%,.2f", netProfit));
                dayProfit.setForeground(new Color(0, 153, 0)); // Green color for positive profit
            } else {
                dayProfit.setText(String.format("-₱%,.2f", Math.abs(netProfit)));
                dayProfit.setForeground(Color.RED); // Red color for negative profit (loss)
            }

            // Optionally display revenue and expenses details
            System.out.println("Date: " + selectedDate);
            System.out.println("Total Revenue: ₱" + String.format("%,.2f", totalRevenue));
            System.out.println("Total Expenses: ₱" + String.format("%,.2f", totalExpenses));
            System.out.println("Net Profit: ₱" + String.format("%,.2f", netProfit));

        } catch (SQLException e) {
            dayProfit.setText("Error");
            System.out.println("Error calculating day profit:");
            e.printStackTrace();
        } finally {
            try {
                if (rsRevenue != null) rsRevenue.close();
                if (rsExpenses != null) rsExpenses.close();
                if (pstRevenue != null) pstRevenue.close();
                if (pstExpenses != null) pstExpenses.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    private void calculateTransactionsTotal() {
        if (DateChooser.getDate() == null) {
            transactionsTotal.setText("₱0.00");
            return;
        }

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.mycon();

            // Format the selected date to match MySQL date format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = sdf.format(DateChooser.getDate());

            // SQL query to get total for the selected date
            String query = "SELECT COALESCE(SUM(totalPrice), 0) as total " +
               "FROM transactions " +
               "WHERE DATE(date) = ? AND receiptType != 'Charge Receipt'";

            pst = conn.prepareStatement(query);
            pst.setString(1, selectedDate);
            rs = pst.executeQuery();

            double total = 0.0;
            if (rs.next()) {
                total = rs.getDouble("total");
            }

            // Set font and format the total
            Font customFont = new Font("Segoe UI", Font.PLAIN, 14);
            transactionsTotal.setFont(customFont);
            transactionsTotal.setText(String.format("₱%,.2f", total));
            transactionsTotal.setEditable(false);
            transactionsTotal.setBackground(Color.WHITE);

        } catch (SQLException e) {
            System.out.println("Error calculating transactions total: " + e.getMessage());
            transactionsTotal.setText("Error");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
    
    //Hide buttons in Transactions
    private void disableSaveBtn(){
        btnSave.setVisible(false);
    
    }
    
    private void disableUpdateBtn(){
        btnUpdate.setVisible(false);
        btnCancelUpdate.setVisible(false);
    
    }
    
    private void enableSaveBtn(){
        btnSave.setVisible(true);
        btnUpdate.setVisible(false);
        btnCancelUpdate.setVisible(false);
    
    }
    
    private void enableUpdateBtn(){
        btnUpdate.setVisible(true);
        btnCancelUpdate.setVisible(true);
    
    } 
    
    //Hide buttons in Items
    private void disableBtnAdd(){
        btnAdd.setVisible(false);
    
    }
    private void disableItemsBtnUpdate(){
        btnItemUpdate.setVisible(false);
        btnItemCancel.setVisible(false);
    
    }
    private void enableBtnAdd(){
        btnAdd.setVisible(true);
        btnItemUpdate.setVisible(false);
        btnItemCancel.setVisible(false);
    
    }
    private void enableItemBtnUpdate(){
        btnItemUpdate.setVisible(true);
        btnItemCancel.setVisible(true);
    
    }
    
    
    
    
    // Declare the Timer at class level
    private Timer dateChooserTimer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DashboardTable;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelUpdate;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEmployeeCashout;
    private javax.swing.JButton btnItemCancel;
    private javax.swing.JButton btnItemUpdate;
    private javax.swing.JButton btnLoadAllData;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel dayProfit;
    private javax.swing.JTextField fieldAddress;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldOveralTotal;
    private javax.swing.JSpinner fieldPricePerUnit;
    private javax.swing.JTextField fieldProductName;
    private javax.swing.JComboBox<String> fieldReceiptType;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JTextField fieldTotalPrice;
    private javax.swing.JSpinner fieldUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableItems;
    private javax.swing.JTextField transactionsTotal;
    // End of variables declaration//GEN-END:variables
}
