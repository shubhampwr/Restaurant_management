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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author LENOVO
 */
public class User_view_Total extends javax.swing.JInternalFrame {
ConnectDB c=new ConnectDB();
    public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    Report r=new Report();
    RateNV rnv=new RateNV();
    Owner_Area oa=new Owner_Area();
    /**
     * Creates new form User_view_Total
     */
    public User_view_Total() {
        initComponents();
        r.fetch();
        
      Date1(); Today();
      month();fetch1();
    }
    
      public void fetch1()
    {
        try
        {
           ConnectDB cn=new ConnectDB();
           cn.getConn();
        String q="SELECT cno, date, total\n" +
"	FROM public.\"Total\" ORDER BY date ASC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl3.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
        
        
        
    
        try
        {
           ConnectDB cn=new ConnectDB();
           cn.getConn();
        String q="SELECT date, total\n" +
"	FROM public.\"EveryDay_Total\"ORDER BY date ASC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl4.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
        
    
        
        try{
                
          
         String q="SELECT sum(total)\n" +
"	FROM public.\"EveryDay_Total\";";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        while(rs.next())
        {
            t16.setText(""+rs.getString(1));
        }
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
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
              
         
               
              // l3.setText(dtt);
               
               }
            
       }).start();
   }
    
   void  Today(){
        Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dt=s.format(date);
              t2.setText(dt);
              t6.setText(dt);
              
         try{
           
            
            String query="SELECT  sum(total)\n" +
            "	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString(1);
                t7.setText(sum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
{
        try
    {
         
       String q="SELECT  cno, date, total\n" +
            "	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        };
         }
{
    try
    {
      
        
         
//       String q="SELECT  cno, date, total\n" +
//            "	FROM public.\"Total\" WHERE  date LIKE ?";
//        pst=conn.prepareStatement(q);
//        pst.setString(1,"%%"+dt1 );
//        rs=pst.executeQuery();
//        
//        tbl2.setModel(DbUtils.resultSetToTableModel(rs));
//        
    }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        };
         }

    }
    void month()
    {
        
        String dt=t6.getText();
         String dt1=dt.substring(3, 10);
        t6.setText(dt1);
        String q="SELECT date, total\n" +
"	FROM public.\"EveryDay_Total\";";
        
        try
    {
          pst=conn.prepareStatement(q);
      
        rs=pst.executeQuery();
        
        tbl2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        };
        
        try{
           
            
            String query="SELECT   sum(total)\n" +
   "	FROM public.\"Total\" WHERE  date LIKE ?;";
             pst=conn.prepareStatement(query);
        pst.setString(1,"%%"+dt1+"%");
        rs=pst.executeQuery();
        
            if(rs.next()){
                String sum=rs.getString(1);
                t8.setText(sum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
           
            
            String query="SELECT   count(total)\n" +
   "	FROM public.\"Total\" WHERE  date LIKE ?;";
             pst=conn.prepareStatement(query);
        pst.setString(1,"%%"+dt1+"%");
        rs=pst.executeQuery();
        
            if(rs.next()){
                String sum=rs.getString(1);
                t9.setText(sum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    
         
    }
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pp1 = new javax.swing.JPopupMenu();
        today = new javax.swing.JMenuItem();
        selected = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        b5 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        t13 = new javax.swing.JTextField();
        t11 = new javax.swing.JTextField();
        t12 = new javax.swing.JTextField();
        t14 = new javax.swing.JTextField();
        b8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        t17 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        t3 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        b6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        b11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl4 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        t16 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        b9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        t8 = new javax.swing.JTextField();
        g2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        b12 = new javax.swing.JButton();
        l2 = new javax.swing.JLabel();

        today.setText("today");
        today.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayActionPerformed(evt);
            }
        });
        pp1.add(today);

        selected.setText("  ");
        pp1.add(selected);

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(958, 481));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));
        jTabbedPane1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(153, 150, 255));
        jPanel7.setLayout(null);

        tbl3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        tbl3.setForeground(new java.awt.Color(153, 0, 153));
        tbl3.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Sr.No", "Date", "Total Rupees"
            }
        ));
        tbl3.setRowHeight(25);
        tbl3.setShowHorizontalLines(false);
        tbl3.getTableHeader().setResizingAllowed(false);
        tbl3.getTableHeader().setReorderingAllowed(false);
        tbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl3);

        jPanel7.add(jScrollPane4);
        jScrollPane4.setBounds(170, 40, 790, 280);

        b5.setBackground(new java.awt.Color(153, 102, 255));
        b5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b5.setForeground(new java.awt.Color(255, 255, 255));
        b5.setText("Update ");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        jPanel7.add(b5);
        b5.setBounds(100, 680, 100, 30);

        b7.setBackground(new java.awt.Color(153, 102, 255));
        b7.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b7.setForeground(new java.awt.Color(255, 255, 255));
        b7.setText("Delete");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });
        jPanel7.add(b7);
        b7.setBounds(20, 190, 110, 30);

        t13.setEditable(false);
        t13.setBackground(new java.awt.Color(204, 255, 255));
        t13.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t13.setText("Total RS.");
        t13.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel7.add(t13);
        t13.setBounds(20, 110, 110, 30);

        t11.setEditable(false);
        t11.setBackground(new java.awt.Color(204, 255, 255));
        t11.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t11.setText("Sr.No");
        t11.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        t11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t11KeyTyped(evt);
            }
        });
        jPanel7.add(t11);
        t11.setBounds(20, 30, 110, 30);

        t12.setEditable(false);
        t12.setBackground(new java.awt.Color(204, 255, 255));
        t12.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t12.setText("Date");
        t12.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel7.add(t12);
        t12.setBounds(20, 70, 110, 30);

        t14.setBackground(new java.awt.Color(204, 255, 255));
        t14.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        t14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t14.setText("0");
        t14.setToolTipText("total Rupees");
        t14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        t14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });
        jPanel7.add(t14);
        t14.setBounds(740, 330, 150, 40);

        b8.setBackground(new java.awt.Color(153, 102, 255));
        b8.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        b8.setForeground(new java.awt.Color(51, 0, 0));
        b8.setText("View ");
        b8.setToolTipText("view Total ");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        jPanel7.add(b8);
        b8.setBounds(580, 330, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Total :");
        jPanel7.add(jLabel4);
        jLabel4.setBounds(670, 330, 80, 40);

        l7.setBackground(new java.awt.Color(255, 255, 102));
        l7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel7.add(l7);
        l7.setBounds(400, 360, 170, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/report1.jpg"))); // NOI18N
        jLabel8.setText("jLabel1");
        jLabel8.setToolTipText("View Report Chart");
        jLabel8.setComponentPopupMenu(pp1);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jPanel7.add(jLabel8);
        jLabel8.setBounds(910, 330, 50, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Show Other Day Earning ");
        jPanel7.add(jLabel12);
        jLabel12.setBounds(230, 330, 150, 30);

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
        jPanel7.add(jButton3);
        jButton3.setBounds(20, 230, 110, 30);

        b10.setBackground(new java.awt.Color(51, 255, 51));
        b10.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b10.setForeground(new java.awt.Color(255, 255, 255));
        b10.setText("Print");
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });
        jPanel7.add(b10);
        b10.setBounds(30, 320, 130, 40);

        t17.setBackground(new java.awt.Color(204, 255, 255));
        t17.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t17.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel7.add(t17);
        t17.setBounds(20, 150, 110, 30);

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("SimSun", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);
        jButton1.setBounds(180, 10, 63, 23);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1018, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("All", jPanel5);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(null);

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
                {null, null, null}
            },
            new String [] {
                "Sr.No", "Date", "Total Rupees"
            }
        ));
        tbl1.setRowHeight(25);
        tbl1.setShowHorizontalLines(false);
        tbl1.getTableHeader().setResizingAllowed(false);
        tbl1.getTableHeader().setReorderingAllowed(false);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(170, 10, 790, 240);

        b1.setBackground(new java.awt.Color(153, 102, 255));
        b1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.setText("Update ");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel3.add(b1);
        b1.setBounds(100, 680, 100, 30);

        b2.setBackground(new java.awt.Color(153, 102, 255));
        b2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 255, 255));
        b2.setText("Delete");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel3.add(b2);
        b2.setBounds(20, 180, 110, 30);

        t3.setBackground(new java.awt.Color(204, 255, 255));
        t3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setText("Total RS.");
        t3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel3.add(t3);
        t3.setBounds(20, 130, 110, 30);

        t1.setBackground(new java.awt.Color(204, 255, 255));
        t1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setText("Sr.No");
        t1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });
        jPanel3.add(t1);
        t1.setBounds(20, 30, 110, 30);

        t2.setBackground(new java.awt.Color(204, 255, 255));
        t2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setText("Date");
        t2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel3.add(t2);
        t2.setBounds(20, 80, 110, 30);

        t7.setBackground(new java.awt.Color(204, 255, 255));
        t7.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        t7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t7.setText("0");
        t7.setToolTipText("total Rupees");
        t7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t7ActionPerformed(evt);
            }
        });
        jPanel3.add(t7);
        t7.setBounds(740, 260, 150, 40);

        b6.setBackground(new java.awt.Color(153, 102, 255));
        b6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        b6.setForeground(new java.awt.Color(51, 0, 0));
        b6.setText("View ");
        b6.setToolTipText("view Total ");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        jPanel3.add(b6);
        b6.setBounds(580, 260, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(670, 260, 80, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Show Other Day Earning ");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(230, 260, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/report1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("View Report Chart");
        jLabel1.setComponentPopupMenu(pp1);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel3.add(jLabel1);
        jLabel1.setBounds(910, 260, 50, 40);

        b11.setBackground(new java.awt.Color(51, 255, 51));
        b11.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b11.setForeground(new java.awt.Color(255, 255, 255));
        b11.setText("Print");
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });
        jPanel3.add(b11);
        b11.setBounds(20, 220, 130, 40);

        jTabbedPane1.addTab("TOday", jPanel3);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);

        tbl4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 102, 255)));
        tbl4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        tbl4.setForeground(new java.awt.Color(153, 0, 153));
        tbl4.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl4.setRowHeight(25);
        tbl4.setShowHorizontalLines(false);
        tbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl4);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(270, 20, 690, 250);

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel9.setText("to");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(140, 120, 20, 17);

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel10.setText("View Record ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 50, 110, 17);

        jButton4.setBackground(new java.awt.Color(153, 102, 255));
        jButton4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ShoW");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(90, 200, 110, 30);

        t16.setBackground(new java.awt.Color(204, 255, 255));
        t16.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        t16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t16.setText("0");
        t16.setToolTipText("total Rupees");
        t16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        t16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t16ActionPerformed(evt);
            }
        });
        jPanel1.add(t16);
        t16.setBounds(750, 280, 150, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Total :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(680, 280, 80, 40);

        b9.setBackground(new java.awt.Color(153, 102, 255));
        b9.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b9.setForeground(new java.awt.Color(255, 255, 255));
        b9.setText("Print");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });
        jPanel1.add(b9);
        b9.setBounds(290, 280, 110, 30);

        jTabbedPane1.addTab("Date", jPanel1);

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setLayout(null);

        tbl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                {null, null}
            },
            new String [] {
                "Date", "Total Rupees"
            }
        ));
        tbl2.setRowHeight(25);
        tbl2.setShowHorizontalLines(false);
        tbl2.getTableHeader().setResizingAllowed(false);
        tbl2.getTableHeader().setReorderingAllowed(false);
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl2);

        jPanel6.add(jScrollPane3);
        jScrollPane3.setBounds(170, 20, 800, 230);

        jButton2.setBackground(new java.awt.Color(153, 102, 255));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("view Report Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);
        jButton2.setBounds(420, 390, 300, 30);

        b3.setBackground(new java.awt.Color(153, 102, 255));
        b3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Update ");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel6.add(b3);
        b3.setBounds(30, 210, 100, 30);

        b4.setBackground(new java.awt.Color(153, 102, 255));
        b4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("Delete");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel6.add(b4);
        b4.setBounds(30, 250, 100, 30);

        t4.setBackground(new java.awt.Color(204, 255, 255));
        t4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setText("Total RS.");
        t4.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t4KeyTyped(evt);
            }
        });
        jPanel6.add(t4);
        t4.setBounds(20, 160, 130, 40);

        t5.setBackground(new java.awt.Color(204, 255, 255));
        t5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t5.setText("Sr.No");
        t5.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        t5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t5KeyTyped(evt);
            }
        });
        jPanel6.add(t5);
        t5.setBounds(20, 60, 130, 40);

        t6.setBackground(new java.awt.Color(204, 255, 255));
        t6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t6.setText("Date");
        t6.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel6.add(t6);
        t6.setBounds(20, 110, 130, 40);

        t8.setBackground(new java.awt.Color(204, 255, 255));
        t8.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        t8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t8.setText("0");
        t8.setToolTipText("total Rupees");
        t8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });
        jPanel6.add(t8);
        t8.setBounds(710, 270, 150, 40);

        g2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/report1.jpg"))); // NOI18N
        g2.setText("jLabel1");
        g2.setToolTipText("View Report Chart");
        g2.setComponentPopupMenu(pp1);
        g2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                g2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                g2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                g2MousePressed(evt);
            }
        });
        jPanel6.add(g2);
        g2.setBounds(880, 270, 50, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Total Entries");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(320, 270, 90, 40);

        t9.setBackground(new java.awt.Color(204, 255, 255));
        t9.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        t9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t9.setText("0");
        t9.setToolTipText("total Rupees");
        t9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        t9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t9ActionPerformed(evt);
            }
        });
        jPanel6.add(t9);
        t9.setBounds(420, 270, 150, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total Amount");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(610, 270, 110, 40);

        b12.setBackground(new java.awt.Color(51, 255, 51));
        b12.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b12.setForeground(new java.awt.Color(255, 255, 255));
        b12.setText("Print");
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });
        jPanel6.add(b12);
        b12.setBounds(140, 300, 130, 40);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("month", jPanel4);

        l2.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1000, 473);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        int i=tbl1.getSelectedRow();
        TableModel model=tbl1.getModel();
        t1.setText(model.getValueAt(i, 0).toString());
        t2.setText(model.getValueAt(i, 1).toString());
        t3.setText(model.getValueAt(i, 2).toString());        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseClicked

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        try{
            String a1=t1.getText();
            int a=Integer.valueOf(a1);
            String b=String.valueOf(t2.getText());
            String c1=t3.getText();
            int c=Integer.valueOf(c1);
            int b1 =Integer.valueOf(b);

            String sql=" UPDATE public.\"Total\"\n" +
            "	SET cno='"+a+"', date='"+b+"',total='"+c+"'\n" +
            "	WHERE cno='"+a +"',date='"+b +"'    ;";

            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Record Updated");
            r.fetch();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
       
        try{
             String sql="DELETE FROM public.\"Total\"\n" +
"	WHERE date='"+t2.getText()+"'  AND total='"+Integer.parseInt(t3.getText())+"' AND cno='"+Integer.parseInt(t1.getText())+"';";
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted");
            r.fetch();
            
           

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
        
         try{
            String query="INSERT INTO public.\"deleted_Bills\"(\n" +
"	date, \"time\", bill_no, amount)\n" +
"	VALUES (?, ?, ?, ?);";
            PreparedStatement pst;
            pst = conn.prepareStatement(query);
            pst.setString(1,oa.l2.getText().toString());
            pst.setString(2,oa.l1.getText().toString());
            pst.setInt(3,Integer.parseInt(t1.getText()));
            pst.setInt(4,Integer.parseInt(t3.getText()));
            

            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null,"\t Item Added");
            t1.setText("Sr_no");
            t3.setText("Total_rs");
            t2.setText("Date");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_b2ActionPerformed

    private void t7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t7ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
         SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               
         String dtt=s.format(t10.getDate());
            String dt=String.valueOf(dtt);t2.setText(dt);
        
        try{
            billing b=new billing();

           
            String query="SELECT  sum(total)\n" +
            "	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString(1);
                t7.setText(sum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }     
        
        {
        try
        {
         
       String q="SELECT  cno, date, total\n" +
            "	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
    }  // TODO add your handling code here:
    }//GEN-LAST:event_b6ActionPerformed

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
  try{
             String sql="DELETE FROM public.\"Total\"\n" +
"	WHERE date='"+t6.getText()+"'  AND total='"+Integer.parseInt(t4.getText())+"' AND cno='"+Integer.parseInt(t5.getText())+"';";
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted");
            r.fetch();
            
           

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
        
         try{
            String query="INSERT INTO public.\"deleted_Bills\"(\n" +
"	date, \"time\", bill_no, amount)\n" +
"	VALUES (?, ?, ?, ?);";
            PreparedStatement pst;
            pst = conn.prepareStatement(query);
            pst.setString(1,oa.l2.getText().toString());
            pst.setString(2,oa.l1.getText().toString());
            pst.setInt(3,Integer.parseInt(t5.getText()));
            pst.setInt(4,Integer.parseInt(t4.getText()));
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"\t Item Added");
            t5.setText("Sr_no");
            t4.setText("Total_rs");
            t6.setText("Date");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
              // TODO add your handling code here:
    }//GEN-LAST:event_b4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         try{
     String dt=t2.getText().toString();
     String query="SELECT cno, date, total\n" +
"	FROM public.\"Total\" WHERE date='"+dt+"';";
      JDBCCategoryDataset dataset=new JDBCCategoryDataset(c.getConn(),query);
      
      JFreeChart jc= ChartFactory.createLineChart("Report Chart", "rs", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
      BarRenderer renderer=null;
      CategoryPlot plot=null;
      renderer=new BarRenderer();
      
//      DefaultCategoryDataset dod= new DefaultCategoryDataset();
//        dod.setValue(400,"customer","total");
//        dod.setValue(300,"c1","t1");
//        
//        CategoryPlot plot=jc.getCategoryPlot();
//        plot.setRangeGridlinePaint(Color.pink);
        ChartFrame cf= new ChartFrame("record Report",jc,true);
        cf.setVisible(true);
        cf.setSize(1300,600);   
        cf.setLocation(40,70);
  }catch(Exception e)
  {
JOptionPane.showMessageDialog(null, e);
  }
    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void todayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_todayActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
      pp1.show();
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
     pp1.show();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t8ActionPerformed

    private void g2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g2MouseClicked

   

//       String dt1=dt.substring(3, 10);
////        
//        
//             
//        try{
//     
//     String q="SELECT  cno, date, total\n" +
//   "	FROM public.\"Total\" WHERE  date LIKE '"+dt+"' ;";
//      JDBCCategoryDataset dataset=new JDBCCategoryDataset(c.getConn(),q);
//      
//      JFreeChart jc= ChartFactory.createLineChart("Report Chart", "date", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
//      BarRenderer renderer=null;
//      CategoryPlot plot=null;
//      renderer=new BarRenderer();
//      
//      ChartFrame cf= new ChartFrame("record Report",jc,true);
//        cf.setVisible(true);
//        cf.setSize(1300,600);   
//        cf.setLocation(40,70);
//  }catch(Exception e)
//  {
//JOptionPane.showMessageDialog(null, e);
//  }   t6.setText(dt1);
       
        try{
            String q="SELECT date, total\n" +
"	FROM public.\"EveryDay_Total\";"; 
             pst=conn.prepareStatement(q);
      
               JDBCCategoryDataset dataset=new JDBCCategoryDataset(c.getConn(),q);
      JFreeChart jc= ChartFactory.createBarChart("Report Chart", "date", "total",  dataset, PlotOrientation.VERTICAL, false, true, true);
      BarRenderer renderer=null;
      CategoryPlot plot=null;
      renderer=new BarRenderer();
      
      ChartFrame cf= new ChartFrame("record Report",jc,true);
        cf.setVisible(true);
        cf.setSize(1300,600);   
        cf.setLocation(40,70);
                
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }//GEN-LAST:event_g2MouseClicked

    private void g2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_g2MouseEntered

    private void g2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_g2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_g2MousePressed

    private void t9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t9ActionPerformed

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t1KeyTyped

    private void t5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t5KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t5KeyTyped

    private void t4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t4KeyTyped

    private void tbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl3MouseClicked
int i=tbl3.getSelectedRow();
        TableModel model=tbl3.getModel();
        t11.setText(model.getValueAt(i, 0).toString());
        t12.setText(model.getValueAt(i, 1).toString());
        t13.setText(model.getValueAt(i, 2).toString());            // TODO add your handling code here:
    }//GEN-LAST:event_tbl3MouseClicked

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b5ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed

        try{
             String sql="DELETE FROM public.\"Total\"\n" +
"	WHERE date='"+t12.getText()+"'  AND total='"+Integer.parseInt(t13.getText())+"' AND cno='"+Integer.parseInt(t11.getText())+"';";
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted");
            fetch1();
            
           

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
        
         try{
            String query="INSERT INTO public.\"deleted_Bills\"(\n" +
"	date, \"time\", bill_no, amount)\n" +
"	VALUES (?, ?, ?, ?);";
            PreparedStatement pst;
            pst = conn.prepareStatement(query);
            pst.setString(1,oa.l2.getText().toString());
            pst.setString(2,oa.l1.getText().toString());
            pst.setInt(3,Integer.parseInt(t11.getText()));
            pst.setInt(4,Integer.parseInt(t13.getText()));
            

            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null,"\t Item Added");
            t11.setText("Sr_no");
            t13.setText("Total_rs");
            t12.setText("Date");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_b7ActionPerformed

    private void t11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t11KeyTyped

    private void t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t14ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
           
    
        try{
             String dt;
         SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");

         String dtt=s.format(t15.getDate());
                 dt=String.valueOf(dtt);
            String query="SELECT  sum(total)\n" +
            "	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String sum=rs.getString(1);
                t14.setText(sum);
                l7.setText("");
            }
            
            String q="SELECT  cno, date, total\n" +
            "	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
             
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl3.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
           
            
            l7.setText("Select Date First");
            t15.requestFocus();
        }      
 

// TODO add your handling code here:
    }//GEN-LAST:event_b8ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
  try{
     String dt=t2.getText().toString();
     String query="SELECT cno, date, total\n" +
"	FROM public.\"Total\";";
      JDBCCategoryDataset dataset=new JDBCCategoryDataset(c.getConn(),query);
      
      JFreeChart jc= ChartFactory.createLineChart("Report Chart", "rs", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
      BarRenderer renderer=null;
      CategoryPlot plot=null;
      renderer=new BarRenderer();
      
//      DefaultCategoryDataset dod= new DefaultCategoryDataset();
//        dod.setValue(400,"customer","total");
//        dod.setValue(300,"c1","t1");
//        
//        CategoryPlot plot=jc.getCategoryPlot();
//        plot.setRangeGridlinePaint(Color.pink);
        ChartFrame cf= new ChartFrame("record Report",jc,true);
        cf.setVisible(true);
        cf.setSize(1300,600);   
        cf.setLocation(40,70);
  }catch(Exception e)
  {
JOptionPane.showMessageDialog(null, e);
  }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void tbl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl4MouseClicked

    }//GEN-LAST:event_tbl4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");

         String dtt=s.format(d1.getDate());
                String dt1=String.valueOf(dtt);
                String dttt=s.format(d2.getDate());
                String dt2=String.valueOf(dttt);
         ConnectDB cn=new ConnectDB();
            try{
                
           cn.getConn();
        String q="SELECT date, total\n" +
"	FROM public.\"EveryDay_Total\"  WHERE date BETWEEN '"+dt1+"' AND  '"+dt2+"'         ;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl4.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
             
            
            try{
                
           cn.getConn();
        String q="SELECT  sum(total)\n" +
"	FROM public.\"EveryDay_Total\"  WHERE date BETWEEN '"+dt1+"' AND  '"+dt2+"'         ;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        while(rs.next())
        {
            t16.setText(""+rs.getString(1));
        }
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
           
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t16ActionPerformed

    private void t15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t15MouseClicked
t15.setEnabled(true);       // TODO add your handling code here:
    }//GEN-LAST:event_t15MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
     try{
     String sql="UPDATE public.\"Total\"\n" +
"	SET  total='"+Integer.parseInt(t17.getText())+"'\n" +
"	WHERE cno='"+Integer.parseInt(t11.getText())+"' AND date='"+t12.getText().toString()+"'  ;";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "  Updated as  ");
            r. fetch();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};

        try{
            String query="INSERT INTO public.\"UpdateInfo\"(\n" +
            "	\"timeT\", date, itemname, \"OLD_rate\", \"NEW_rate\")\n" +
            "	VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst;
            pst = conn.prepareStatement(query);
            pst.setString(1,oa.l1.getText().toString());
            pst.setString(2,oa.l2.getText().toString());
             pst.setString(3,t11.getText().toString());
            pst.setInt(4,Integer.parseInt(t13.getText()));
            pst.setInt(5,Integer.parseInt(t17.getText()));

            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null,"\t Item Added");
            t11.setText("");
            t12.setText("");t13.setText("");t17.setText("");
            
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed

        MessageFormat header=new MessageFormat("Report Print");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl4.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b9ActionPerformed

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b10ActionPerformed

        MessageFormat header=new MessageFormat("Report Print");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b10ActionPerformed

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11ActionPerformed
  MessageFormat header=new MessageFormat("Report Print");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_b11ActionPerformed

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try
        {
           ConnectDB cn=new ConnectDB();
           cn.getConn();
        String q="SELECT cno, date, total\n" +
"	FROM public.\"Total\" ORDER BY date ASC;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl3.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
            }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b11;
    private javax.swing.JButton b12;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JLabel g2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l7;
    private javax.swing.JPopupMenu pp1;
    private javax.swing.JMenuItem selected;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t11;
    private javax.swing.JTextField t12;
    private javax.swing.JTextField t13;
    private javax.swing.JTextField t14;
    private javax.swing.JTextField t16;
    private javax.swing.JTextField t17;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTable tbl3;
    private javax.swing.JTable tbl4;
    private javax.swing.JMenuItem today;
    // End of variables declaration//GEN-END:variables
}
