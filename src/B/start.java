/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author LENOVO
 */
public class start extends javax.swing.JFrame {

    /**
     * Creates new form start
     */
    public start() {
        initComponents(); time1();Date1();
         Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dm.width/2-this.getSize().width/2,dm.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,150));
    }

    public void time1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("MMMM d,yyyy");
               
               l2.setText(s.format(dt));
               }
            
       }).start();
   }
    
     
     
    public void Date1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
               
               l3.setText(s.format(dt));
               }
            
       }).start();
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dp1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 476));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 476));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/settings-icon-23053.png"))); // NOI18N
        jLabel1.setText("Setting");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, 30));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/login1d.png"))); // NOI18N
        jLabel2.setText("login");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 30));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(120, 50, 150, 370);

        dp1.setBackground(new java.awt.Color(153, 120, 255));

        jPanel4.setBackground(new java.awt.Color(153, 100, 255));
        jPanel4.setLayout(null);

        l2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("date");
        jPanel4.add(l2);
        l2.setBounds(320, 10, 190, 40);

        l3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        l3.setForeground(new java.awt.Color(255, 255, 255));
        l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l3.setText("time");
        jPanel4.add(l3);
        l3.setBounds(20, 10, 260, 50);

        dp1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dp1Layout = new javax.swing.GroupLayout(dp1);
        dp1.setLayout(dp1Layout);
        dp1Layout.setHorizontalGroup(
            dp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        dp1Layout.setVerticalGroup(
            dp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dp1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 166, Short.MAX_VALUE))
        );

        getContentPane().add(dp1);
        dp1.setBounds(270, 120, 810, 300);

        jPanel3.setBackground(new java.awt.Color(153, 0, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(null);

        l1.setBackground(new java.awt.Color(255, 255, 255));
        l1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("Hotel Management System");
        jPanel3.add(l1);
        l1.setBounds(80, 0, 584, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7);
        jLabel7.setBounds(780, 10, 30, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(260, 50, 820, 70);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

  new la().setVisible(true);
    
   

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
         Splash sp=new Splash();
         sp.setVisible(true);
         try{
             for(int i=0;i<=100;i++)
         {
             Thread.sleep(40);
             sp.l1.setText(Integer.toString(i)+"%");
             sp.p1.setValue(i);
         }
            }
             catch(Exception e){ }
         sp.dispose();
        billing b=new billing();
         double time=0;
         double exxtime=1*60;
         try{
             if(time==exxtime)
             {
                b.dispose();
              }
         }
         catch(Exception ev){ }
         b.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel l1;
    public javax.swing.JLabel l2;
    public javax.swing.JLabel l3;
    // End of variables declaration//GEN-END:variables
}
