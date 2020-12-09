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
public class Owner_Modified_Record extends javax.swing.JInternalFrame {

  ConnectDB c=new ConnectDB();
     public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    
    
    public Owner_Modified_Record() {
        initComponents();
        fetch();
        countItems();
        time1(); AutoCompleteDecorator.decorate(cb1);
        Date1(); addCombo();
    }

    public void countItems()
     {
          try{
                String sql1="SELECT count(itemname)\n" +
"	FROM public.\"UpdateInfo\";";
        pst=conn.prepareStatement(sql1);
        rs=pst.executeQuery();
        
        while(rs.next())
        {
            String menu=rs.getString(1);
            t1.setText(menu);
        }
              
          }catch(Exception e)
          {
              
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

   public void fetch()
    {
        try
        {
           ConnectDB cn=new ConnectDB();
           cn.getConn();
        String q="SELECT \"time\", date, itemname, \"OLD_rate\", \"NEW_rate\"\n" +
"	FROM public.\"UpdateInfo\"  ORDER BY date DESC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
        
    }
    @SuppressWarnings("unchecked")
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
        t3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        b3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

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
        jLabel1.setBounds(10, 80, 80, 30);

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
        jButton3.setBounds(20, 300, 120, 30);

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
        jButton5.setBounds(20, 340, 120, 30);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Rate to EDit");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 210, 160, 30);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jPanel1.add(jButton2);
        jButton2.setBounds(760, 410, 110, 30);

        t2.setEditable(false);
        t2.setBackground(new java.awt.Color(153, 255, 255));
        t2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t2.setForeground(new java.awt.Color(153, 0, 153));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setToolTipText("Menu Prise");
        t2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t2.setEnabled(false);
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
        t2.setBounds(10, 180, 140, 32);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Update LisT :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 10, 310, 40);

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
        jPanel2.setBounds(-10, 0, 990, 60);

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
        tbl1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        tbl1.setForeground(new java.awt.Color(153, 0, 153));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Time", "Menu", "Rs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setRowHeight(30);
        tbl1.setShowHorizontalLines(false);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);
        if (tbl1.getColumnModel().getColumnCount() > 0) {
            tbl1.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 720, 250);

        tbb.addTab("Menu List", jPanel4);

        jPanel1.add(tbb);
        tbb.setBounds(200, 100, 730, 290);

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
        cb1.setBounds(10, 120, 140, 30);

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
        t3.setBounds(10, 240, 140, 32);

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current_Rate");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 150, 140, 30);

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
        b3.setBounds(640, 410, 110, 30);

        dp1.add(jPanel1);
        jPanel1.setBounds(10, 10, 980, 460);

        jPanel5.setBackground(new java.awt.Color(153, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 978, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        dp1.add(jPanel5);
        jPanel5.setBounds(10, 470, 980, 20);

        getContentPane().add(dp1);
        dp1.setBounds(-10, -10, 990, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String t=l1.getText();
        String  d=l2.getText();
        String n=cb1.getSelectedItem().toString();
        int a=Integer.parseInt(t2.getText());
         int b=Integer.parseInt(t3.getText());
        

        if(tbb.getSelectedIndex()==0){

            try{

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
"	\"time\", date, itemname, \"OLD_rate\", \"NEW_rate\")\n" +
"	VALUES (?, ?, ?, ?, ?);";
                PreparedStatement pst;
                pst = conn.prepareStatement(query);
                pst.setString(1,t);
                pst.setString(2,d);
                pst.setString(3,n);
                pst.setInt(4,a);
                 pst.setInt(5,b);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"\t Item Added");
                t2.setText(""); t2.setText("");
                cb1.setSelectedIndex(0);
                fetch();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }

        }

        if(tbb.getSelectedIndex()==1)
        {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

  int i=tbl1.getSelectedRow();
        TableModel m=tbl1.getModel();

       

        try{
            String a=cb1.getSelectedItem().toString();
            String b=t2.getText();

//            String sql="DELETE FROM public.\"UpdateInfo\"\n" +
//            "	WHERE timeT='"+m.getValueAt(i,1).toString()+"' AND date='"+m.getValueAt(i,2).toString()+"' AND itemname='"+m.getValueAt(i,3).toString()+"'    ;";
            String sql="DELETE FROM public.\"UpdateInfo\"\n" +
"	WHERE  time='"+m.getValueAt(i,0).toString()+"' AND date='"+m.getValueAt(i,1).toString()+"'   ;";
        
    pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted");
            fetch();
            cb1.setSelectedIndex(0);
            t2.setText(""); t3.setText("");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
    }//GEN-LAST:event_jButton5ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyTyped

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

        int i=tbl1.getSelectedRow();
        TableModel model=tbl1.getModel();

        cb1.setSelectedItem(model.getValueAt(i, 2).toString());
        t2.setText(model.getValueAt(i, 3).toString());
        t3.setText(model.getValueAt(i, 4).toString());
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
