/*
 * Switch to Admin View Dialog
 */
/*****************************************
** File: Search
** Team Name: Cava++
*Date: 10/18/13
** E-mail: Daniel Brandes bradan1@umbc.edu,
** Lizset Chavez <lizset1@umbc.edu>
** Patrick Ritchie <ritc1@umbc.edu>,
** Xiaofei He <xiaofei2@umbc.edu>,
** Yo-Han Kim <ykim18@umbc.edu>,
** Jim Millican <jmill1@umbc.edu>
** Decription- Switch to Admin View Dialog
***********************************************/

package coolgle;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class userSwitchGui extends javax.swing.JFrame 
{

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel pswdLabel;
    private javax.swing.JPasswordField pwrdText;
    private javax.swing.JButton switchBtn;
    // End of variables declaration//GEN-END:variables
    private static String user; 
    private adminGui mainFrame; // Screen that caused this one to appear
    
    /**
     * Constructor Creates new form userSwitch
     */
    public userSwitchGui(adminGui m_main, String userName) 
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frm = super.getSize();
        int xpos = (int) (screen.getWidth() / 8 - frm.getWidth() / 2);
	int ypos = (int) (screen.getHeight() / 8 - frm.getHeight() / 2);
	super.setLocation(xpos,  ypos);
        
        // Makes it so that you can exit from pop up messages and this window without closing the entire app 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        user = userName;
        mainFrame = m_main;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * Description-initializes components
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        switchBtn = new javax.swing.JButton();
        pwrdText = new javax.swing.JPasswordField();
        pswdLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        switchBtn.setIcon(new javax.swing.ImageIcon("Images\\switch_button.jpg")); // NOI18N
        switchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchBtnActionPerformed(evt);
            }
        });


        pswdLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pswdLabel.setText("User Password: ");

        logoLabel.setIcon(new javax.swing.ImageIcon("Images\\logo.jpg")); // NOI18N

        Label.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        Label.setText("System Switch - " + user);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(switchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label)
                            .addComponent(logoLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pswdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(pwrdText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(logoLabel)
                .addGap(18, 18, 18)
                .addComponent(Label)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwrdText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswdLabel))
                .addGap(27, 27, 27)
                .addComponent(switchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Description switchs gui to main screen
     * @param evt
     */
    private void switchBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_switchBtnActionPerformed
        // Validate PW : 
        UserAuthentication validatePW = new UserAuthentication();
        if (validatePW.logUser(user, pwrdText.getPassword(), 0))
        {
            mainGui userView = new mainGui(user);
            userView.setVisible(true);
            mainFrame.setVisible(false);
            this.setVisible(false);
        }
        else // Wrong PW 
        {
            JOptionPane.showMessageDialog(null, "Invalid Password", "Failure", JOptionPane.ERROR_MESSAGE);
        }


        
    }//GEN-LAST:event_switchBtnActionPerformed



}
