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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class Daily_Report extends javax.swing.JInternalFrame {
ConnectDB c=new ConnectDB();
     public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    
    
    public Daily_Report() {
        initComponents();
        fetch();
        countItems();
    }
     public void countItems()
     {
          try{
                String sql1="SELECT count(date)\n" +
"	FROM public.\"EveryDay_Total\";";
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
        String q="SELECT date, total\n" +
"	FROM public.\"EveryDay_Total\"ORDER BY date ASC;";
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
        l2 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tbb = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b4 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/B/report1.jpg"))); // NOI18N

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
        jLabel3.setText("DailY ReporT");
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
        jScrollPane1.setBounds(0, 0, 690, 250);

        tbb.addTab("REPORT Day_By_Day", jPanel4);

        jPanel1.add(tbb);
        tbb.setBounds(120, 90, 700, 290);

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

        b4.setBackground(new java.awt.Color(153, 102, 255));
        b4.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("Print");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel1.add(b4);
        b4.setBounds(120, 390, 110, 30);

        dp1.add(jPanel1);
        jPanel1.setBounds(0, 0, 970, 460);

        b3.setBackground(new java.awt.Color(153, 102, 255));
        b3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Print");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dp1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dp1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

       
    }//GEN-LAST:event_tbl1MouseClicked

    private void tbbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbMouseClicked

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

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed

        MessageFormat header=new MessageFormat("Report Print\n");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JDesktopPane dp1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel l1;
    public javax.swing.JLabel l2;
    private javax.swing.JTextField t1;
    private javax.swing.JTabbedPane tbb;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
