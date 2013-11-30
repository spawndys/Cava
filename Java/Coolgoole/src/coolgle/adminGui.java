/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolgle;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author rdg77_000
 */
public class adminGui extends javax.swing.JFrame 
{
    private ArrayList<Location> locationlist = new ArrayList<Location>();
    
    /**
     * Creates new form GuiUI
     */
    public adminGui() 
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frm = super.getSize();
        int xpos = (int) (screen.getWidth() / 8 - frm.getWidth() / 2);
        int ypos = (int) (screen.getHeight() / 30);
        super.setLocation(xpos,  ypos);
        initComponents();

        /*
        // Switch to user button
        switchUserBtn.setText("Switch To User");

        // User buttons
        userDelBtn.setText("Delete Selected");
        userModifyBtn.setText("Modify Selected");

        // Location Buttons
        newLocaBtn.setText("Add New Location");
        loModiSelectBtn.setText("Modify Selected");
        loDelBtn.setText("Delete Selected");
        */
        
        // Populate the location list
        populateLocationList();
    }

    
    private void newLocaBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // When user clicks new location button : 
        //this.setVisible(false);
        AddLocationGui addLoc = new AddLocationGui(this);
        addLoc.setVisible(true);    
    }
    
    private void modLocaBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // When user clicks mod location button : 
        //this.setVisible(false);
        AddLocationGui addLoc = new AddLocationGui(locationlist.get(locationDisplay.getSelectedIndex()), this);
        addLoc.setVisible(true);      
    }
    
    private void delLocaBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // When user clicks del location button : 
        // Show warning message : 
        String locationNameToDelete = locationlist.get(locationDisplay.getSelectedIndex()).getName();
        int comfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \n \" " + locationNameToDelete + " \" " );
        if (comfirm == 0)
        {
            // Selected YES
            
            // Delete location from arraylist
            locationlist.remove( locationDisplay.getSelectedIndex() );
            
            // Create database
            recreateDatabase();
            
            // Repopulate list
            populateLocationList();
        }
        if (comfirm == 1)
        {
            // Selected NO
        }
        if (comfirm == 2)
        {
            // Selected CANCEL
        }
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        welcomLabel1 = new javax.swing.JLabel();
        welcomLabel2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        switchUserBtn = new javax.swing.JButton();
        loModifyLabel = new javax.swing.JLabel();
        userModifyLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        locationDisplay = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        userDisplay = new javax.swing.JList();
        newLocaBtn = new javax.swing.JButton();
        loDelBtn = new javax.swing.JButton();
        loModiSelectBtn = new javax.swing.JButton();
        userDelBtn = new javax.swing.JButton();
        userModifyBtn = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        welcomLabel1.setText("Welcome to");

        welcomLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        welcomLabel2.setForeground(new java.awt.Color(153, 0, 0));
        welcomLabel2.setText("Coolgles Admin");

        label1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label1.setText("<html>\nEnter the location information below <br>\nand we will show you the way!\n</html>");

        label2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label2.setText("<html> The list of locations chosen is shown <br> on the right panel, click Map It to <br> show it on Google Earth! </html>");

        switchUserBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\switch_to_user.jpg")); // NOI18N

        loModifyLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        loModifyLabel.setText("Location Modification");

        userModifyLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        userModifyLabel.setText("User Modification");

        locationDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        locationDisplay.setModel(new javax.swing.AbstractListModel() 
        {
            //String[] strings = locationList.getNames();
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", "Item 17", "Item 18", "Item 19", "Item 20", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        locationDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(locationDisplay);

        userDisplay.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = userList.getString();
            String[] strings = { "Populating database..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(userDisplay);

        newLocaBtn.setToolTipText("Add a new location to the database");
        newLocaBtn.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                newLocaBtnActionPerformed(evt);
            }
        });
        
        loDelBtn.setToolTipText("Delete the currently selected location from database");
        loDelBtn.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                delLocaBtnActionPerformed(evt);
            }
        });
        
        loModiSelectBtn.setToolTipText("View and modify location details");
        loModiSelectBtn.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                modLocaBtnActionPerformed(evt);
            }
        });

        
        newLocaBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\add_new_location_button.jpg")); // NOI18N

        loDelBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\delete_selected_button.jpg")); // NOI18N

        loModiSelectBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\modify_selected_button.jpg")); // NOI18N

        userDelBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\delete_selected_button.jpg")); // NOI18N

        userModifyBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\rdg77_000\\Documents\\classes\\cmsc345\\output\\output\\modify_selected_button.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(loModifyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userModifyLabel)
                .addGap(216, 216, 216))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newLocaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(loModiSelectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(loDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userModifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(switchUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(welcomLabel2)))
                .addGap(611, 611, 611))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomLabel2)
                    .addComponent(welcomLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(switchUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loModifyLabel)
                            .addComponent(userModifyLabel))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(newLocaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loModiSelectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(loDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userModifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(adminGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new adminGui().setVisible(true);
            }
        });
        
    }
    
    public void populateLocationList()
    {
        try 
        {        
            // Clear out current list 
            locationlist.clear();

            // Fill in Location List
            DefaultListModel listModel;
            listModel = new DefaultListModel();
            locationDisplay.setModel(listModel);
            BufferedReader br;
            try
            {
                br = new BufferedReader(new FileReader("LocationDatabase.txt"));
                String locationString;
                //ArrayList<Location> DatabaseLocations = new ArrayList<Location>();
                // Read file Location by location
                while ((locationString = br.readLine()) != null)
                {
                    Location newLocation = new Location(locationString);
                    locationlist.add(newLocation);
                    listModel.addElement(newLocation.getName());
                }
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("Could Not find database File ");
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Error openning database file. ");
        }
    }
    
    // Replaces the currently selected location with a new one
    // Called from modify button -> save
    public void editLocation(Location newLoc)
    {
        // Replace currently selected object in list with new location 
        //(TODO : maybe put this in a copy function in location class)
        locationlist.get( locationDisplay.getSelectedIndex() ).setAddress(newLoc.getAddress());
        locationlist.get( locationDisplay.getSelectedIndex() ).setLatitude(newLoc.getLatitude());
        locationlist.get( locationDisplay.getSelectedIndex() ).setLongitude(newLoc.getLongitude());
        locationlist.get( locationDisplay.getSelectedIndex() ).setCity(newLoc.getCity());
        locationlist.get( locationDisplay.getSelectedIndex() ).setState(newLoc.getState());
        locationlist.get( locationDisplay.getSelectedIndex() ).setName(newLoc.getName());
        
         // Recreate database baesd on new arraylist
        recreateDatabase();

        // Repopulate list
        populateLocationList();
    }
    
    public void recreateDatabase()
    {
        // Clear old database file 
        PrintWriter writer;
        try 
        {
            writer = new PrintWriter("LocationDatabase.txt");
            writer.print("");
            writer.close();

            // Repopulate database file from arraylist 
            for (int i = 0; i < locationlist.size(); i++)
                locationlist.get(i).printToFile("LocationDatabase.txt");

        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Location Database Not Found");
        }
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton loDelBtn;
    private javax.swing.JButton loModiSelectBtn;
    private javax.swing.JLabel loModifyLabel;
    private javax.swing.JList locationDisplay;
    private javax.swing.JButton newLocaBtn;
    private javax.swing.JButton switchUserBtn;
    private javax.swing.JButton userDelBtn;
    private javax.swing.JList userDisplay;
    private javax.swing.JButton userModifyBtn;
    private javax.swing.JLabel userModifyLabel;
    private javax.swing.JLabel welcomLabel1;
    private javax.swing.JLabel welcomLabel2;
    // End of variables declaration//GEN-END:variables
    private List locationList;
    private ArrayList[] userList;
    
}
