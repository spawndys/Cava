/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coolgle;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author rdg77_000
 */
public class AddLocationGui extends javax.swing.JFrame 
{
    // Set to 0 if you're adding a location
    // Set to 1 if you're modifying a location
    private int status = 0;
    private adminGui m_main;
    /**
     * Creates new form AddLocation
     */
    public AddLocationGui(adminGui mainFrame) 
    {
        setUp();
        status = 0;
        m_main = mainFrame; 
    }
    
    // This will be used with the modify location screen, it will load the 
    // add location screen with the data already pre-filled in. 
    public AddLocationGui(Location newLocation, adminGui mainFrame) 
    {
        setUp();
        
        this.loNameText.setText(newLocation.getName());
        this.loLatText.setText(String.valueOf(newLocation.getLatitude()));
        this.loLongText.setText(String.valueOf(newLocation.getLongitude()));
        this.loCityText.setText(newLocation.getCity()); 
        this.loStateText.setText(newLocation.getState()); 
        this.loAddressText.setText(newLocation.getAddress());
        
        status = 1; 
        m_main = mainFrame; 
    }
    
    // Called from all constructors 
    public void setUp()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frm = super.getSize();
        int xpos = (int) (screen.getWidth() / 8 - frm.getWidth() / 2);
        int ypos = (int) (screen.getHeight() / 8 - frm.getHeight() / 2);
        super.setLocation(xpos,  ypos);            
        initComponents();
        
        // Makes it so that you can exit from pop up messages without closing the entire app 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() 
	 {
        addLocationLabel = new javax.swing.JLabel();
        loNameLabel = new javax.swing.JLabel();
        loCityLabel = new javax.swing.JLabel();
        loStateLabel = new javax.swing.JLabel();
        loLongLabel = new javax.swing.JLabel();
        loLatLabel = new javax.swing.JLabel();
        loLatText = new javax.swing.JTextField();
        loNameText = new javax.swing.JTextField();
        saveLocationBtn = new javax.swing.JButton();
        loCityText = new javax.swing.JTextField();
        loStateText = new javax.swing.JTextField();
        loLongText = new javax.swing.JTextField();
        loAddressLabel = new javax.swing.JLabel();
        loAddressText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addLocationLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        addLocationLabel.setText("Add / Location Properties");

        loNameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        loNameLabel.setText("Location Name: ");

        loCityLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        loCityLabel.setText("Location City: ");

        loStateLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        loStateLabel.setText("Location State: ");

        loLongLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        loLongLabel.setText("Location Longitude: ");

        loLatLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        loLatLabel.setText("Location Latitude: ");

        loLatText.setToolTipText("");
        loLatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loLatTextActionPerformed(evt);
            }
        });

        loNameText.setToolTipText("");
        loNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loNameTextActionPerformed(evt);
            }
        });

        saveLocationBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\save_location_button.jpg")); // NOI18N
        saveLocationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationBtnActionPerformed(evt);
            }
        });

        loCityText.setToolTipText("");
        loCityText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loCityTextActionPerformed(evt);
            }
        });

        loStateText.setToolTipText("");
        loStateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loStateTextActionPerformed(evt);
            }
        });

        loLongText.setToolTipText("");
        loLongText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loLongTextActionPerformed(evt);
            }
        });

        loAddressLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        loAddressLabel.setText("Location Address: ");

        loAddressText.setToolTipText("");
        loAddressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loAddressTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(addLocationLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveLocationBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(loNameLabel)
                                    .addComponent(loStateLabel)
                                    .addComponent(loCityLabel)
                                    .addComponent(loLongLabel)
                                    .addComponent(loLatLabel)
                                    .addComponent(loAddressLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loLatText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loCityText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loStateText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loLongText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(addLocationLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loNameLabel)
                    .addComponent(loNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loCityLabel)
                    .addComponent(loCityText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loStateLabel)
                    .addComponent(loStateText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loLongLabel)
                    .addComponent(loLongText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loLatText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loLatLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loAddressLabel)
                    .addComponent(loAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveLocationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loLatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loLatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loLatTextActionPerformed

    private void saveLocationBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_saveLocationBtnActionPerformed
        //int comfirm = JOptionPane.showConfirmDialog(null, "Do you want to add this new city to the list? (No to clear text field)");

        // If status = 1 (Mod location) just save the data over the current data
        if ( status == 1 )
        {
            // Error if not all data filled in 
            if ((this.loNameText.getText().isEmpty() && this.loAddressText.getText().isEmpty()) ||
                this.loLatText.getText().isEmpty() || this.loLongText.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Locations cannot be saved unless the following fields contain data:"
                        + "\nLatitude\nLongitude\nName or Address", "Failure", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Make a new location given the data in the fields 
                Location newLoc = new Location(
                                  this.loNameText.getText(),
                                  Double.parseDouble(this.loLatText.getText()),
                                  Double.parseDouble(this.loLongText.getText()),
                                  this.loCityText.getText(),
                                  this.loStateText.getText(),
                                  this.loAddressText.getText());

                // Copy into database and refresh main page
                m_main.editLocation(newLoc);
            }
            
        }
        // if status = 0 (Add location) launch geocoder to get all the current data, and make a new Location data. 
        if ( status == 0 )
        {
            // Confirm that the user entered at least a name or address. 
            if (this.loNameText.getText().isEmpty() && this.loAddressText.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Must enter either a name or address", "Failure", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Create new geocoder object 
                Geocoder geo = new Geocoder();
                // Search for the name
                String geoCoderInput = "";
                geoCoderInput += (this.loNameText.getText().isEmpty() ? "" : this.loNameText.getText());
                geoCoderInput += (this.loAddressText.getText().isEmpty() ? "" : ", " + this.loAddressText.getText());
                geoCoderInput += (this.loCityText.getText().isEmpty() ? "" : ", " + this.loCityText.getText());
                geoCoderInput += (this.loStateText.getText().isEmpty() ? "" : ", " + this.loStateText.getText());
                Location newLocation = geo.createLocation( geoCoderInput );

                // Ask the user if they really want to add the location the geocoder found. 
                int comfirm = JOptionPane.showConfirmDialog(null, "Searching for : \n" + 
                                    geoCoderInput + "\nFound : \n" + newLocation + "\nIs this the location you'd like to add? ");
                if (comfirm == 0) // Yes
                {
                    // Add location to database
                    if ( !newLocation.printToFile("LocationDatabase.txt") )
                    {
                          System.out.println("Error occured printing location information to database. ");
                    }
                }
                else
                {
                    // No
                }
            }
        } 
        
        this.setVisible(false);
        // Refresh main admin gui
        m_main.populateLocationList();
 
    }//GEN-LAST:event_saveLocationBtnActionPerformed

    private void loNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loNameTextActionPerformed

    private void loCityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loCityTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loCityTextActionPerformed

    private void loStateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loStateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loStateTextActionPerformed

    private void loLongTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loLongTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loLongTextActionPerformed

    private void loAddressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loAddressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loAddressTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(AddLocationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLocationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLocationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLocationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                //new AddLocationGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLocationLabel;
    private javax.swing.JLabel loAddressLabel;
    private javax.swing.JTextField loAddressText;
    private javax.swing.JLabel loCityLabel;
    private javax.swing.JTextField loCityText;
    private javax.swing.JLabel loLatLabel;
    private javax.swing.JTextField loLatText;
    private javax.swing.JLabel loLongLabel;
    private javax.swing.JTextField loLongText;
    private javax.swing.JLabel loNameLabel;
    private javax.swing.JTextField loNameText;
    private javax.swing.JLabel loStateLabel;
    private javax.swing.JTextField loStateText;
    private javax.swing.JButton saveLocationBtn;
    // End of variables declaration//GEN-END:variables

    

}
