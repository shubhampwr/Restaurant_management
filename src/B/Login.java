
package B;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */public Connection conn=null;
     public ResultSet rs=null;
    PreparedStatement pst=null;
    
    
    
    public Login() {
        initComponents();
//        this.setLocationRelativeTo(null);
        getConn();
        Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dm.width/2-this.getSize().width/2,dm.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,100));
    }

    public Connection getConn(){
        
        try {
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {}
        
      try {
        String url="jdbc:postgresql://localhost/Hotel";
        String user="postgres";
        String password="shubhampwr";
        
        
            conn=DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null,"connect");
        } catch (SQLException ex) {
            System.out.println(ex);
           
        }
       return conn;
        
  }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        dp1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t2 = new javax.swing.JPasswordField();
        l3 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(649, 353));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(787, 442));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(null);

        l5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        l5.setText("°°°hotel shubham°°°");
        l5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l5MouseClicked(evt);
            }
        });
        jPanel1.add(l5);
        l5.setBounds(10, 10, 310, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(590, 10, 30, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(80, 60, 630, 50);

        p2.setBackground(new java.awt.Color(200, 255, 255));
        p2.setForeground(new java.awt.Color(0, 204, 204));
        p2.setLayout(null);

        dp1.setBackground(new java.awt.Color(100, 255, 120));
        dp1.setPreferredSize(null);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("USERNAME   :");
        dp1.add(jLabel1);
        jLabel1.setBounds(330, 20, 160, 30);

        t1.setBackground(new java.awt.Color(240, 255, 255));
        t1.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
        });
        dp1.add(t1);
        t1.setBounds(330, 50, 159, 32);

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("PASSWORD   :");
        dp1.add(jLabel4);
        jLabel4.setBounds(330, 80, 160, 30);

        t2.setBackground(new java.awt.Color(240, 255, 255));
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
        });
        dp1.add(t2);
        t2.setBounds(330, 110, 160, 30);

        l3.setText("forget Password..?");
        l3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l3MouseClicked(evt);
            }
        });
        dp1.add(l3);
        l3.setBounds(400, 150, 120, 14);

        b1.setBackground(new java.awt.Color(0, 0, 255));
        b1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.setText("login");
        b1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b1KeyPressed(evt);
            }
        });
        dp1.add(b1);
        b1.setBounds(340, 180, 130, 31);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/loginLogo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        dp1.add(jLabel3);
        jLabel3.setBounds(90, 10, 170, 140);

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Member login");
        dp1.add(jLabel5);
        jLabel5.setBounds(80, 160, 200, 40);

        l2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/insert.png"))); // NOI18N
        l2.setText("New");
        l2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l2MouseEntered(evt);
            }
        });
        dp1.add(l2);
        l2.setBounds(80, 210, 80, 40);

        l1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/delete.png"))); // NOI18N
        l1.setText("Close");
        l1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });
        dp1.add(l1);
        l1.setBounds(170, 210, 90, 40);

        p2.add(dp1);
        dp1.setBounds(0, 0, 630, 260);

        getContentPane().add(p2);
        p2.setBounds(80, 110, 630, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
       
    this.dispose();;
    }//GEN-LAST:event_l1MouseClicked

    private void l2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseClicked

        String ab= JOptionPane.showInputDialog("Enter  password");
       if(ab.equals("ShubhamPwr"))
       {
        Create_user la=new Create_user();
       dp1.add(la);
       la.show();
       la.setSize(546, 238);
       }else
       {
           JOptionPane.showMessageDialog(null,"Please Contact Devloper Mr.Shubham Pawar\t\n Mb.no = 7972512327\n "
                   + "email = www.shubhampwr885@gmail.com"
                   + "");
       }
    }//GEN-LAST:event_l2MouseClicked

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        
        try{
                 String sql="SELECT  username,password\n" +
                 "	FROM public.\"User\" WHERE username=? and password=?   ;";
                 pst=conn.prepareStatement(sql);
                 pst.setString(1,t1.getText());
                 pst.setString(2,t2.getText());
                 rs=pst.executeQuery();
                 if(rs.next())
                 {
                     JOptionPane.showMessageDialog(null, "login Successfull!!");
                     new Owner_Area().setVisible(true);
                     this.dispose();
                 }else{                    
                        JOptionPane.showMessageDialog(null, "failsd");
                    }
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);
            }
   
    }//GEN-LAST:event_b1ActionPerformed

    private void l5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseClicked
String ab= JOptionPane.showInputDialog(null,"Enter Name");
 l5.setText(ab);          // TODO add your handling code here:
    }//GEN-LAST:event_l5MouseClicked

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t2.requestFocus();
    
}
              // TODO add your handling code here:
    }//GEN-LAST:event_t1KeyPressed

    private void t2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    try{
                 String sql="SELECT  username,password\n" +
                 "	FROM public.\"User\" WHERE username=? and password=?   ;";
                 pst=conn.prepareStatement(sql);
                 pst.setString(1,t1.getText());
                 pst.setString(2,t2.getText());
                 rs=pst.executeQuery();
                 if(rs.next())
                 {
//                     JOptionPane.showMessageDialog(null, "login Successfull!!");
                     new Owner_Area().setVisible(true);
                     this.dispose();
                 }else{                    
                        JOptionPane.showMessageDialog(null, "please Enter Correct UserID Password");
                    }
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);
            }      }     // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyPressed

    private void b1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    try{
                 String sql="SELECT  username,password\n" +
                 "	FROM public.\"User\" WHERE username=? and password=?   ;";
                 pst=conn.prepareStatement(sql);
                 pst.setString(1,t1.getText());
                 pst.setString(2,t2.getText());
                 rs=pst.executeQuery();
                 if(rs.next())
                 {
                     JOptionPane.showMessageDialog(null, "login Successfull!!");
                     new Frame2().setVisible(true);
                     this.dispose();
                 }else{                    
                        JOptionPane.showMessageDialog(null, "failsd");
                    }
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);
            }
    
}        // TODO add your handling code here:
    }//GEN-LAST:event_b1KeyPressed

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked

        try{
       String pno=JOptionPane.showInputDialog(null,"Enter Your Phone Number");
       
         String sql="SELECT  username,password\n" +
                 "	FROM public.\"User\" WHERE phno='"+pno+"'   ;";
                 pst=conn.prepareStatement(sql);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {
                  String uname= rs.getString(1);
                  String pas=rs.getString(2);
                  
                    {
                            JOptionPane.showMessageDialog(null,"Username :"+uname);
                   
                            JOptionPane.showMessageDialog(null,"password :"+pas);
                        }
                 }
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
    

        // TODO add your handling code here:
    }//GEN-LAST:event_l3MouseClicked

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed

    }//GEN-LAST:event_t1ActionPerformed

    private void l2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_l2MouseEntered

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JDesktopPane dp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l5;
    private javax.swing.JPanel p2;
    private javax.swing.JTextField t1;
    private javax.swing.JPasswordField t2;
    // End of variables declaration//GEN-END:variables
}
