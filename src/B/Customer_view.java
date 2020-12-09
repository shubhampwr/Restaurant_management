/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LENOVO
 */
public class Customer_view extends javax.swing.JInternalFrame {

     ConnectDB c=new ConnectDB();
     Bill b=new Bill();
     public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    public Customer_view() {
        initComponents();
        fetch();
        b.time1();
        b.Date1();
    }

    public void fetch()
    {
         String dt=l2.getText();
          String[] part=dt.split("-");
          String p1=part[0];
          String p2=part[2];
          String p3=part[3];
          
        try
        {
          
        String q="SELECT name, location, contact, birthdate\n" +
"	FROM public.\"Customers_List\" WHERE birthdate LIKE '%"+p1+"%';";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 255));
        setClosable(true);
        getContentPane().setLayout(null);

        tbl1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 102, 255)));
        tbl1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
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
                "Name", "Addres", "Contact No", "Birthday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
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
        if (tbl1.getColumnModel().getColumnCount() > 0) {
            tbl1.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl1.getColumnModel().getColumn(2).setPreferredWidth(35);
            tbl1.getColumnModel().getColumn(3).setPreferredWidth(35);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 650, 280);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Todays birthday's");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 200, 50);

        l1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("jLabel5");
        jPanel2.add(l1);
        l1.setBounds(340, 20, 160, 20);

        l2.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("jLabel5");
        jPanel2.add(l2);
        l2.setBounds(520, 20, 160, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 940, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

        
    }//GEN-LAST:event_tbl1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
