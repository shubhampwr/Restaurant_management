/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LENOVO
 */
public class Deleted_Bills extends javax.swing.JInternalFrame {

    ConnectDB c=new ConnectDB();
     public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    Owner_Area oa=new Owner_Area();
    
    public Deleted_Bills()
    {
        initComponents();
        fetch();
        countItems();
      
    }

     public void countItems()
     {
          try{
                String sql1="SELECT count(date)\n" +
"	FROM public.\"deleted_Bills\" ORDER BY date DESC;";
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
    
  public void fetch()
    {
        try
        {
           ConnectDB cn=new ConnectDB();
           cn.getConn();
        String q="SELECT date, \"time\", bill_no, amount\n" +
"	FROM public.\"deleted_Bills\" ORDER BY date DESC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tbb = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b3 = new javax.swing.JButton();
        t10 = new com.toedter.calendar.JDateChooser();
        b6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jPanel1.add(jButton2);
        jButton2.setBounds(760, 410, 160, 30);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Deleted Bills");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 10, 310, 50);

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
        jScrollPane1.setBounds(0, 0, 720, 250);

        tbb.addTab("deleted Bills", jPanel4);

        jPanel1.add(tbb);
        tbb.setBounds(190, 100, 730, 290);

        jLabel5.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Search Date :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 116, 150, 20);

        t1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setText("0");
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(t1);
        t1.setBounds(830, 70, 70, 20);

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
        b3.setBounds(190, 400, 110, 30);

        t10.setBackground(new java.awt.Color(204, 255, 255));
        t10.setToolTipText("please Select Date Here");
        t10.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(t10);
        t10.setBounds(10, 150, 170, 30);

        b6.setBackground(new java.awt.Color(153, 102, 255));
        b6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        b6.setForeground(new java.awt.Color(51, 0, 0));
        b6.setText("Show");
        b6.setToolTipText("view Total ");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        jPanel1.add(b6);
        b6.setBounds(60, 190, 70, 30);

        jLabel6.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Items");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(720, 70, 90, 16);

        dp1.add(jPanel1);
        jPanel1.setBounds(0, -10, 970, 470);

        getContentPane().add(dp1);
        dp1.setBounds(0, 0, 970, 460);

        jPanel5.setBackground(new java.awt.Color(153, 102, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel5.setLayout(null);
        getContentPane().add(jPanel5);
        jPanel5.setBounds(-10, 460, 980, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

    }//GEN-LAST:event_tbl1MouseClicked

    private void tbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbMouseClicked

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed

        
        MessageFormat header=new MessageFormat("Report Print\n");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b3ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed

        SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");

        String dtt=s.format(t10.getDate());
        String dt=String.valueOf(dtt);

        
        {
            try
            {

                String q="SELECT date, \"time\", bill_no, amount\n" +
"	FROM public.\"deleted_Bills\" WHERE  date='"+dt+"'   ;";
                
                 String q1="SELECT count(date)\n" +
"	FROM public.\"deleted_Bills\" WHERE  date='"+dt+"'   ;";
                pst=conn.prepareStatement(q);
                rs=pst.executeQuery();

                tbl1.setModel(DbUtils.resultSetToTableModel(rs));
                 pst=conn.prepareStatement(q1);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    t1.setText(""+rs.getString(1));
                }

                
                
            }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
        }  // TODO add your handling code here:
    }//GEN-LAST:event_b6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b3;
    private javax.swing.JButton b6;
    private javax.swing.JDesktopPane dp1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t1;
    private com.toedter.calendar.JDateChooser t10;
    private javax.swing.JTabbedPane tbb;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
