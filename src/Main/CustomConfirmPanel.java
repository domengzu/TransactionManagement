package Main;

import javax.swing.*;

public class CustomConfirmPanel extends javax.swing.JPanel {
    private boolean confirmed = false;
    private boolean isShowing = false;
    
    public CustomConfirmPanel() {
        setLayout(new java.awt.GridBagLayout());
        setBackground(new java.awt.Color(0, 0, 0, 120));
        
        // Create the confirmation panel
        JPanel confirmBox = new javax.swing.JPanel();
        confirmBox.setLayout(new java.awt.GridBagLayout());
        confirmBox.setBackground(java.awt.Color.WHITE);
        confirmBox.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
        
        // Message label
        JLabel messageLabel = new javax.swing.JLabel("Are you sure you want to update this record?");
        messageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Buttons panel
        JPanel buttonPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(java.awt.Color.WHITE);
        
        JButton confirmButton = new javax.swing.JButton("Confirm");
        JButton cancelButton = new javax.swing.JButton("Cancel");
        
        // Style buttons
        confirmButton.setPreferredSize(new java.awt.Dimension(100, 30));
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 30));
        
        // Add action listeners
        confirmButton.addActionListener(e -> {
            confirmed = true;
            hidePanel();
        });
        
        cancelButton.addActionListener(e -> {
            confirmed = false;
            hidePanel();
            
        });
        
        // Add components
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        
        // Layout for confirm box
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new java.awt.Insets(20, 30, 10, 30);
        confirmBox.add(messageLabel, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(0, 20, 20, 20);
        confirmBox.add(buttonPanel, gbc);
        
        // Add confirm box to this panel
        add(confirmBox);
        
        // Make this panel invisible initially
        setVisible(false);
    }
    
    public void showPanel() {
        setVisible(true);
        isShowing = true;
    }
    
    public void hidePanel() {
        setVisible(false);
        isShowing = false;
    }
    
    public boolean isShowing() {
        return isShowing;
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    // Add this new method
    public void reset() {
        confirmed = false;
        isShowing = false;
        setVisible(false);
    }
}
