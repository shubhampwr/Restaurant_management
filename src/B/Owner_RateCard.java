/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
 
/**
 *
 * @author LENOVO
 */
public class Owner_RateCard extends javax.swing.JInternalFrame {
ConnectDB cdb=new ConnectDB();
RateNV r=new RateNV();
    public Connection conn=cdb.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    Statement smt=null;
    /**
     * Creates new form Owner_RateCard
     */
    public Owner_RateCard() {
        initComponents();
        Date1();
        addCombo();
        time1(); AutoCompleteDecorator.decorate(cb1);
       fetch();
       Total_Items();
    }
    
     void Total_Items()
        {
        try{
        
        String sql="SELECT count(menu)\n" +
"	FROM public.\"Rate\";";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        if(rs.next()){
            String menu=rs.getString(1);
          t1.setText(""+menu);
        }
        }catch(Exception e){
            
        }
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
    public void fetch()
    {
        try
        {
           
        String q="SELECT \"menu\", \"rate\"\n" +
"	FROM public.\"Rate\"  ORDER BY menu ASC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
        cb1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        b3 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 100, 130, 30);

        jButton3.setBackground(new java.awt.Color(153, 102, 255));
        jButton3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.setToolTipText("Click to Update Rate ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(100, 250, 160, 40);

        jButton5.setBackground(new java.awt.Color(153, 102, 255));
        jButton5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE");
        jButton5.setToolTipText("Delete Prmanantly Item");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(100, 300, 160, 40);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("New_Rate");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 180, 130, 30);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jPanel1.add(jButton2);
        jButton2.setBounds(760, 410, 160, 30);

        t2.setBackground(new java.awt.Color(153, 255, 255));
        t2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t2.setForeground(new java.awt.Color(153, 0, 153));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setToolTipText("Menu Prise");
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
        t2.setBounds(150, 140, 130, 32);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rate Card :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 310, 40);

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
        jPanel2.setBounds(-10, 0, 980, 60);

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
        jScrollPane1.setBounds(0, 0, 580, 250);

        tbb.addTab("Menu List", jPanel4);

        jPanel1.add(tbb);
        tbb.setBounds(350, 100, 580, 290);

        cb1.setBackground(new java.awt.Color(153, 255, 255));
        cb1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb1.setToolTipText("Search Menu ");
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
        cb1.setBounds(90, 100, 190, 30);

        jLabel5.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Items");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(720, 70, 90, 16);

        t1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setText("0");
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(t1);
        t1.setBounds(830, 70, 70, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Items");
        jLabel4.setToolTipText("Add  Menus In List");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 153, 153)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 60, 70, 20);

        t3.setBackground(new java.awt.Color(153, 255, 255));
        t3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t3.setForeground(new java.awt.Color(153, 0, 153));
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setToolTipText("Menu Prise");
        t3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t3KeyTyped(evt);
            }
        });
        jPanel1.add(t3);
        t3.setBounds(150, 180, 130, 32);

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Current_Rate");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 140, 130, 30);

        b3.setBackground(new java.awt.Color(153, 102, 255));
        b3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Print");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel1.add(b3);
        b3.setBounds(350, 400, 110, 30);

        dp1.add(jPanel1);
        jPanel1.setBounds(10, 10, 970, 460);

        getContentPane().add(dp1);
        dp1.setBounds(-10, -10, 990, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String d=l1.getText();
        String  t=l2.getText();
        String n=cb1.getSelectedItem().toString();
        int a=Integer.parseInt(t2.getText());
        int b=Integer.parseInt(t3.getText());

       

            try{

                String a1=t2.getText();

               

                String sql=" UPDATE public.\"Rate\"\n" +
                "	SET \"menu\"='"+n+"', rate='"+b+"'\n" +
                "	WHERE menu='"+n +"'    ;";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, n+"  Updated as  "+b);
               r. fetch();
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);};

            try{
                String query="INSERT INTO public.\"UpdateInfo\"(\n" +
"	\"timeT\", date, itemname, \"OLD_rate\", \"NEW_rate\")\n" +
"	VALUES (?, ?, ?, ?, ?);";
                PreparedStatement pst;
                pst = conn.prepareStatement(query);
                pst.setString(1,d);
                pst.setString(2,t);
                pst.setString(3,n);
                pst.setInt(4,a);
                pst.setInt(5,b);
                
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null,"\t Item Added");
                t2.setText("");
                cb1.setSelectedIndex(0);
                    fetch();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
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
            r.fetch();
            cb1.setSelectedIndex(0);
            t2.setText("");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
    }//GEN-LAST:event_jButton5ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

        int i=tbl1.getSelectedRow();
        TableModel model=tbl1.getModel();

        cb1.setSelectedItem(model.getValueAt(i, 0).toString());
        t2.setText(model.getValueAt(i, 1).toString());

    }//GEN-LAST:event_tbl1MouseClicked

    private void tbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbMouseClicked

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

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
 Add_Menu_O la=new Add_Menu_O();
       dp1.add(la);
       la.show();
       la.setSize(972, 460);      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyTyped

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed

    private void t3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t3KeyTyped

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed

        
        MessageFormat header=new MessageFormat("Report Print");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b3;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JDesktopPane dp1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel l1;
    public javax.swing.JLabel l2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTabbedPane tbb;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
