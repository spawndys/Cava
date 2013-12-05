/*
 * TODO : promote and demote users.
 */

package coolgle;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*****************************************

 ** File: KMlCreator
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu,
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- To be created from the adminGui class, opens a window of user detials.
 ** 
 ***********************************************/

public class modifyUsersGui extends javax.swing.JFrame 
{

    private static int USER_MAX_LEN = 25; 
    
    private String oldname;
    private adminGui m_main;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel pswdLabel;
    private javax.swing.JTextField pswdText;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel usrLabel;
    private javax.swing.JTextField usrText;
    private javax.swing.JLabel isAdminLabel;
    private javax.swing.JCheckBox isAdminCheck;
    // End of variables declaration//GEN-END:variables
    /**
     * Constructor- Creates new form modifyUsers
     */
    public modifyUsersGui(adminGui mainFrame, String userName) 
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frm = super.getSize();
        int xpos = (int) (screen.getWidth() / 8 - frm.getWidth() / 2);
        int ypos = (int) (screen.getHeight() / 8 - frm.getHeight() / 2);
        super.setLocation(xpos,  ypos);
        initComponents();
        
        UserAuthentication getData= new UserAuthentication();
        pswdText.setText(getData.getPassword(userName));
        emailText.setText(getData.getEmail(userName));
        usrText.setText(userName);
        if (getData.getType(userName) == 1)
            isAdminCheck.setSelected(true);
        else
            isAdminCheck.setSelected(false);
        
        oldname = userName;
        
        m_main = mainFrame;
        
        // Makes it so that you can exit from pop up messages and this window without closing the entire app 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        usrText.setEditable(false);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * Description-initializes components
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usrLabel = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        pswdLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        usrText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        pswdText = new javax.swing.JTextField();
        isAdminLabel = new javax.swing.JLabel();
        isAdminCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usrLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        usrLabel.setText("Username: ");

        submitBtn.setIcon(new javax.swing.ImageIcon("Images\\submit button.jpg")); // NOI18N
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        pswdLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pswdLabel.setText("Password: ");

        emailLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailLabel.setText("Email: ");

        Label.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        Label.setText("User Properties");
        
        isAdminLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        isAdminLabel.setText("Is Admin: ");

        logoLabel.setIcon(new javax.swing.ImageIcon("Images\\logo.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pswdLabel)
                                .addComponent(usrLabel)
                                .addComponent(emailLabel)
                                .addComponent(isAdminLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailText, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(usrText, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(pswdText)
                                .addComponent(isAdminCheck)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Label)
                            .addGap(30, 30, 30))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(Label)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usrLabel)
                    .addComponent(usrText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pswdLabel)
                    .addComponent(pswdText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(isAdminCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isAdminLabel))
                .addGap(26, 26, 62)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * submitBtnActionPerformed(java.awt.event.ActionEvent evt) action listener
     * @param evt
     */
    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_submitBtnActionPerformed
        UserAuthentication updateUserAuth = new UserAuthentication();
        
        // Validation : 
	boolean nameTaken = updateUserAuth.userExists(usrText.getText());
        
        if ( usrText.getText().isEmpty() || pswdText.getText().length() < 2 || emailText.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "All fields must have data, passwords must be at least 2 characters"
                    , "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!(emailText.getText().contains("@") && emailText.getText().contains(".")) )
        {
            JOptionPane.showMessageDialog(null, "Email is not of correct format\n"
					+ "Ex : User@domain.com", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (oldname.compareTo(usrText.getText()) != 0 && nameTaken)
        {
            JOptionPane.showMessageDialog(null, "Name already taken", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        else if (usrText.getText().length() > USER_MAX_LEN)
	{
		JOptionPane.showMessageDialog(null, "Username must be under " + USER_MAX_LEN + " characters", "Error", JOptionPane.ERROR_MESSAGE); 
	}
        else // Success
        {
            if (isAdminCheck.isSelected())
                updateUserAuth.updateUser(oldname, usrText.getText(), pswdText.getText(), emailText.getText(), 1);
            else
                updateUserAuth.updateUser(oldname, usrText.getText(), pswdText.getText(), emailText.getText(), 0);
            m_main.populateUserList();
            this.setVisible(false);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    /**
     * main tester method
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
            java.util.logging.Logger.getLogger(modifyUsersGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifyUsersGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifyUsersGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifyUsersGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new modifyUsersGui(null, "").setVisible(true);
            }
        });
    }

  
}
