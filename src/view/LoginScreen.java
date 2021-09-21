
package view;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.ConnectionDB;

public class LoginScreen extends javax.swing.JFrame {
   
    public LoginScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        labelStatus = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        labelUsername.setText("Usuário:");

        labelPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        labelPassword.setText("Senha:");

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtPassword.setMinimumSize(new java.awt.Dimension(7, 27));
        txtPassword.setPreferredSize(new java.awt.Dimension(7, 27));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        labelStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        labelStatus.setText("Status");

        buttonLogin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        buttonLogin.setText("Logar");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelUsername)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUsername)))
                            .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPassword)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername)
                    .addComponent(txtUsername))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addGap(18, 18, 18)
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLogin)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        //Chamando a classe de conexão 
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = ConnectionDB.conector();
        System.out.println(conexao);
     
        var sql = "SELECT * FROM `login`.`log` WHERE username=? AND password=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());
            rs = pst.executeQuery();
            //se existir a pessoa
            if (rs.next()){
                labelStatus.setText("Status: Entrou!!!");
            }else{
                labelStatus.setText("Status: Usuário ou senha inválidos!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
