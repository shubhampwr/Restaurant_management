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

/**
 *
 * @author LENOVO
 */
public class Add_Menu_O extends javax.swing.JInternalFrame {

    /**
     * Creates new form Add_Menu_O
     */  ConnectDB c=new ConnectDB();
     public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    
    
    public Add_Menu_O() {
        initComponents();
         fetch();
         addCombo();time1();Date1();
       countItems();
       Total_Items();
    }
     
    public void time1()
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
    
     
     
    public void Date1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
               
               l1.setText(s.format(dt));
               }
            
       }).start();
     
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

     public void addCombo()
     {
        try{
        
        String sql="SELECT menu, rate\n" +
"	FROM public.\"Rate\";";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next())
        {
            String menu=rs.getString(1);
            cb1.addItem(menu);
        }
        }catch(Exception e){
            
        }
     }   
     
     public void countItems()
     {
          try{
               String sql1="SELECT count(menu)\n" +
"	FROM public.\"Rate\";\n" +
"    ";
        pst=conn.prepareStatement(sql1);
        rs=pst.executeQuery();
        
        while(rs.next())
        {
            String menu=rs.getString(1);
            t4.setText(menu);
        }
              
          }catch(Exception e)
          {
              
          }
     }
       
    public void fetch()
    {
        try
        {
           ConnectDB cn=new ConnectDB();
           cn.getConn();
        String q="SELECT menu,rate \n" +
"	FROM public.\"Rate\" ORDER BY menu ASC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        t2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tbb = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        t3 = new javax.swing.JTextField();
        cb1 = new javax.swing.JComboBox<>();
        t4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(980, 440));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setText("Total Items");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 90, 110, 30);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rate  :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 230, 90, 30);

        jButton4.setBackground(new java.awt.Color(153, 102, 255));
        jButton4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(110, 280, 110, 30);

        jButton5.setBackground(new java.awt.Color(153, 102, 255));
        jButton5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(110, 320, 110, 30);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(820, 400, 100, 30);

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t2KeyTyped(evt);
            }
        });
        jPanel3.add(t2);
        t2.setBounds(130, 230, 150, 32);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Item");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 10, 360, 50);

        l1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("jLabel5");
        jPanel2.add(l1);
        l1.setBounds(790, 6, 160, 20);

        l2.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("jLabel5");
        jPanel2.add(l2);
        l2.setBounds(790, 36, 160, 20);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 0, 980, 70);

        jPanel4.setBackground(new java.awt.Color(153, 102, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 470, 980, 20);

        tbb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbb.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        tbb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbMouseClicked(evt);
            }
        });

        jPanel5.setLayout(null);

        tbl1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 102, 255)));
        tbl1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        tbl1.setForeground(new java.awt.Color(153, 0, 153));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sr.No", "Menu", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setColumnSelectionAllowed(true);
        tbl1.setRowHeight(25);
        tbl1.setShowHorizontalLines(false);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 570, 220);

        tbb.addTab("List ", jPanel5);

        jPanel3.add(tbb);
        tbb.setBounds(320, 120, 600, 270);

        t3.setBackground(new java.awt.Color(153, 255, 255));
        t3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t3.setForeground(new java.awt.Color(153, 0, 153));
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t3KeyPressed(evt);
            }
        });
        jPanel3.add(t3);
        t3.setBounds(130, 190, 150, 32);

        cb1.setBackground(new java.awt.Color(153, 255, 255));
        cb1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb1.setForeground(new java.awt.Color(102, 51, 255));
        cb1.setMaximumRowCount(10);
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search Item" }));
        cb1.setToolTipText("Search Item Added Or Not");
        cb1.setName("Search "); // NOI18N
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
        jPanel3.add(cb1);
        cb1.setBounds(40, 140, 240, 30);

        t4.setBackground(new java.awt.Color(153, 255, 255));
        t4.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t4.setForeground(new java.awt.Color(153, 0, 153));
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t4.setFocusable(false);
        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t4ActionPerformed(evt);
            }
        });
        jPanel3.add(t4);
        t4.setBounds(130, 90, 130, 30);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menu :");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 190, 100, 30);

        jLabel6.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Items");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(730, 80, 90, 20);

        t1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setText("0");
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(t1);
        t1.setBounds(840, 80, 70, 20);

        b3.setBackground(new java.awt.Color(153, 102, 255));
        b3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Print");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel3.add(b3);
        b3.setBounds(700, 400, 110, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 980, 440);

        jPanel7.setBackground(new java.awt.Color(153, 102, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel7.setLayout(null);
        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 440, 990, 20);

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        {
            try{
                String m=t3.getText();
                int r=Integer.parseInt(t2.getText());
                int n=Integer.parseInt(t1.getText());

                //                String n=t4.getText();
                //                int a=Integer.valueOf(n)+1;
                //
                String query="INSERT INTO public.\"Rate\"(\n" +
                "	menu, rate, srno)\n" +
                "	VALUES (?, ?, ?);";
                PreparedStatement pst;
                pst = conn.prepareStatement(query);
                pst.setString(1,m);
                pst.setInt(2,r);
                pst.setInt(3,n);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"\t Item Added");

                t2.setText("");
                t3.setText("");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            fetch();
            countItems();
            Total_Items();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
            String a=t3.getText();
            String b=t2.getText();

            String sql="DELETE FROM public.\"Rate\"\n" +
            "	WHERE menu='"+a +"'    ;";

            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted");
            fetch();
            t3.setText("");
            t2.setText("");

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            {
                try{
                    String m=t3.getText();
                    int r=Integer.parseInt(t2.getText());
                    int n=Integer.parseInt(t1.getText());

                    //                String n=t4.getText();
                    //                int a=Integer.valueOf(n)+1;
                    //
                    String query="INSERT INTO public.\"Rate\"(\n" +
                    "	menu, rate, srno)\n" +
                    "	VALUES (?, ?, ?);";
                    PreparedStatement pst;
                    pst = conn.prepareStatement(query);
                    pst.setString(1,m);
                    pst.setInt(2,r);
                    pst.setInt(3,n);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"\t Item Added");

                    t2.setText("");
                    t3.setText("");

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                fetch();
                countItems();
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyPressed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

        int i=tbl1.getSelectedRow();
        TableModel model=tbl1.getModel();

        t3.setText(model.getValueAt(i, 0).toString());
        t2.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tbl1MouseClicked

    private void tbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbMouseClicked

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed

    private void t3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t2.requestFocus();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t3KeyPressed

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t4ActionPerformed

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyTyped

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

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed

    }//GEN-LAST:event_cb1ActionPerformed

    private void cb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb1MouseClicked
        addCombo();
        /*try{
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
        };   */     // TODO add your handling code here:
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
                t3.setText(rs.getString(1));
                t2.setText(rs.getString(2));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        };

        t2.requestFocus();
        // TODO add your handling code here:
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1PopupMenuWillBecomeInvisible

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel l1;
    public javax.swing.JLabel l2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTabbedPane tbb;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
