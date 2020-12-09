package B;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
public class RateNV extends javax.swing.JFrame {
public Connection conn=null;
     public ResultSet rs=null;
    PreparedStatement pst=null;
    public RateNV() {
        initComponents();
         AutoCompleteDecorator.decorate(cb1);
        getConn();
        fetch();
        addCombo();
        Date1();
        time1();
    }
    
    public  void Date1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dtt=s.format(dt);
               l2.setText(dtt);
               }
            
       }).start();
   }
     
     
    public void time1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
               
               l1.setText(s.format(dt));
               }
            
       }).start();
       
   }
    
   public void addCombo(){
        try{
        
        String sql="SELECT menu, rate\n" +
"	FROM public.\"Rate\";";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            String menu=rs.getString(1);
            cb1.addItem(menu);
        }
        }catch(Exception e){
            
        }
        
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
 
  public void fetch()
    {
        try
        {
           
        String q="SELECT \"menu\", \"rate\"\n" +
"	FROM public.\"Rate\"ORDER BY menu ASC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
    }
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        t2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tbb = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        cb1 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(982, 550));
        setPreferredSize(new java.awt.Dimension(982, 550));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel4.setText("Update :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 80, 152, 32);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 120, 100, 30);

        jButton3.setBackground(new java.awt.Color(153, 102, 255));
        jButton3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(110, 210, 160, 40);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rate  :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 160, 90, 30);

        jButton4.setBackground(new java.awt.Color(153, 102, 255));
        jButton4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(110, 260, 160, 40);

        jButton5.setBackground(new java.awt.Color(153, 102, 255));
        jButton5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(110, 310, 160, 40);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jPanel1.add(jButton2);
        jButton2.setBounds(110, 360, 160, 40);

        t2.setBackground(new java.awt.Color(153, 255, 255));
        t2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t2.setForeground(new java.awt.Color(153, 0, 153));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t2KeyTyped(evt);
            }
        });
        jPanel1.add(t2);
        t2.setBounds(140, 160, 180, 32);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rate Card :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 550, 50);

        l2.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("jLabel5");
        jPanel2.add(l2);
        l2.setBounds(790, 36, 160, 20);

        l1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("jLabel5");
        jPanel2.add(l1);
        l1.setBounds(790, 6, 160, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 980, 70);

        jPanel3.setBackground(new java.awt.Color(153, 102, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 470, 980, 20);

        tbb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbb.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        tbb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbMouseClicked(evt);
            }
        });

        jPanel4.setLayout(null);

        tbl1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 102, 255)));
        tbl1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        tbl1.setForeground(new java.awt.Color(153, 0, 153));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Menu", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setRowHeight(25);
        tbl1.setShowHorizontalLines(false);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 580, 330);

        tbb.addTab("Non_Veg", jPanel4);

        jPanel5.setLayout(null);

        tbl2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 102, 255)));
        tbl2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        tbl2.setForeground(new java.awt.Color(153, 0, 153));
        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Menu", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setRowHeight(25);
        tbl2.setShowHorizontalLines(false);
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl2);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 580, 330);

        tbb.addTab("Veg", jPanel5);

        jPanel1.add(tbb);
        tbb.setBounds(360, 100, 580, 360);

        cb1.setBackground(new java.awt.Color(153, 255, 255));
        cb1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb1MouseClicked(evt);
            }
        });
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        cb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb1KeyPressed(evt);
            }
        });
        jPanel1.add(cb1);
        cb1.setBounds(140, 120, 180, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 980, 490);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("RateCard");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
new addMenu().setVisible(true);
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

        
               int i=tbl1.getSelectedRow();
        TableModel model=tbl1.getModel();
       
         cb1.setSelectedItem(model.getValueAt(i, 0).toString());
        t2.setText(model.getValueAt(i, 1).toString());
        
        
        
    }//GEN-LAST:event_tbl1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
        String d=l1.getText();
                String  t=l2.getText();
                String n=cb1.getSelectedItem().toString();
                int a=Integer.parseInt(t2.getText());
        
        
        if(tbb.getSelectedIndex()==0){
    
    try{
       
       String b=t2.getText(); 
       
        int b1 =Integer.valueOf(b);
    
     String sql=" UPDATE public.\"Rate\"\n" +
    "	SET \"menu\"='"+n+"', rate='"+b+"'\n" +
    "	WHERE menu='"+n +"'    ;";
     pst=conn.prepareStatement(sql);
                pst.execute();
                 JOptionPane.showMessageDialog(null, n+"  Updated as  "+b);
                fetch();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
            
            
             try{
               String query="INSERT INTO public.\"UpdateInfo\"(\n" +
        "	date, \"time\", itemname, rate)\n" +
        "	VALUES (?, ?, ?, ?);";
                PreparedStatement pst;
                pst = conn.prepareStatement(query);
                pst.setString(1,d);
                pst.setString(2,t);
                pst.setString(3,n);
                pst.setInt(4,a);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null,"\t Item Added");
                t2.setText("");
                cb1.setSelectedIndex(0);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            
            
}
 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     try{
       String a=cb1.getSelectedItem().toString();
       String b=t2.getText(); 
       
       
    
     String sql="DELETE FROM public.\"Rate\"\n" +
        "	WHERE menu='"+a +"'    ;";
                 pst=conn.prepareStatement(sql);
                 pst.execute();
                
                JOptionPane.showMessageDialog(null, "Deleted");
                fetch();
                cb1.setSelectedIndex(0);
                t2.setText("");
                
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);};

    }//GEN-LAST:event_jButton5ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2MouseClicked

    private void tbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_tbbMouseClicked

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
       

    }//GEN-LAST:event_cb1ActionPerformed

    private void cb1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             try{
       String a=cb1.getSelectedItem().toString();
       String sql=" SELECT menu, rate\n" +
"	FROM public.\"Rate\"WHERE menu='"+a+"'             ; ";
                 pst=conn.prepareStatement(sql);
                 rs= pst.executeQuery();
                 if(rs.next())
                 {
                     t2.setText(rs.getString(2));
                 }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1KeyPressed

    private void cb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb1MouseClicked

 try{
       String a=cb1.getSelectedItem().toString();
       String sql=" SELECT menu, rate\n" +
"	FROM public.\"Rate\"WHERE menu='"+a+"'             ; ";
                 pst=conn.prepareStatement(sql);
                 rs= pst.executeQuery();
                 if(rs.next())
                 {
                     t2.setText(rs.getString(2));
                 }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };        // TODO add your handling code here:
    }//GEN-LAST:event_cb1MouseClicked

    private void cb1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb1PopupMenuWillBecomeInvisible

        String a=cb1.getSelectedItem().toString();
                String sql=" SELECT menu, rate\n" +
                "	FROM public.\"Rate\"WHERE menu=?        ; ";
            
            try{
               
                pst=conn.prepareStatement(sql);
                pst.setString(1, a);
                rs= pst.executeQuery();
                if(rs.next())
                {
                    
                    t2.setText(rs.getString(2));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
            
            t2.requestFocus();


        // TODO add your handling code here:
    }//GEN-LAST:event_cb1PopupMenuWillBecomeInvisible

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==java.awt.event.KeyEvent.VK_ENTER) ||(c==java.awt.event.KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyTyped

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
            java.util.logging.Logger.getLogger(RateNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RateNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RateNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RateNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RateNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel l1;
    public javax.swing.JLabel l2;
    private javax.swing.JTextField t2;
    private javax.swing.JTabbedPane tbb;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    // End of variables declaration//GEN-END:variables
}
