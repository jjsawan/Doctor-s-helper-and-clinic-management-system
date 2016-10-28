/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * doctor.java
 *
 * Created on Jun 11, 2015, 3:09:14 PM
 */
//package cmanagement;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Font;
//import com.sun.corba.se.impl.encoding.BufferManagerRead;
//import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class doctor extends javax.swing.JFrame {

    /** Creates new form doctor */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/clinic_management_system";
    Connection connection = null;
    Statement statement = null;
    
    public doctor() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");            
            statement = (Statement) connection.createStatement();            
        } catch (Exception e) {
            e.printStackTrace();            
        }
        
        initComponents();
        
         try {
             Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from fileup");
                    while (resultSet.next()) {
                      String file=resultSet.getString("doc_name");
                      doctorcombo.addItem(file);
                 }
                    
        } catch (Exception e) {
        }
         
          try {
             Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("dname");
                      prscombobox.addItem(dname);
                 }
                    
        } catch (Exception e) {
        }
          
           try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT name from patient where date=CURDATE()");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    ptable.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
           
            try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT name from patient where status='visited' order by date DESC");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    ptable1.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
            
            try {
             Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dname from doctor");
                    while (resultSet.next()) {
                      String name=resultSet.getString("dname");
                      jComboBox1.addItem(name);
                 }
                    
        } catch (Exception e) {
        }
            
            try {
             Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT distinct decatagory from diseases");
                    while (resultSet.next()) {
                      String name=resultSet.getString("decatagory");
                      jComboBox2.addItem(name);
                 }
                    
        } catch (Exception e) {
        }
            
             try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT name from patient where date=CURDATE()");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    jTable1.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                     }
             
             try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dename from diseases");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    jTable2.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
             
             try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT drname from drugs ");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    jTable3.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
            
           dynamictime();
    }

     public void dynamictime(){
        
        Thread clock=new Thread(){
            public void run(){
                for(;;){
                    Calendar cal=new GregorianCalendar();
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
                    int day=cal.get(Calendar.DAY_OF_MONTH);
                    mdate.setText("Date :"+year+"/"+(month+1)+"/"+day);
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);
                     mtime.setText("Time :"+hour+":"+minute+":"+second);
        
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        };
        clock.start();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        doctorcombo = new javax.swing.JComboBox();
        writeFille = new javax.swing.JButton();
        print = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ptable = new javax.swing.JTable();
        tpatient = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        available = new javax.swing.JRadioButton();
        unavailable = new javax.swing.JRadioButton();
        log_out = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lpid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lpbil = new javax.swing.JLabel();
        mdate = new javax.swing.JLabel();
        mtime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        read = new javax.swing.JButton();
        print1 = new javax.swing.JButton();
        prsupload = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        pres_update = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        prscombobox = new javax.swing.JComboBox();
        prstxtfield = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        ptable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cpname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cpage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cpid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        cpbill = new javax.swing.JTextField();
        doctortextfield = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        dcatagory = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ddescription = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Doctors");

        doctorcombo.setBackground(new java.awt.Color(0, 102, 255));
        doctorcombo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        doctorcombo.setForeground(new java.awt.Color(0, 51, 255));
        doctorcombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                doctorcomboItemStateChanged(evt);
            }
        });
        doctorcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorcomboActionPerformed(evt);
            }
        });

        writeFille.setBackground(new java.awt.Color(255, 255, 255));
        writeFille.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        writeFille.setForeground(new java.awt.Color(0, 204, 51));
        writeFille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Upload-icon.png"))); // NOI18N
        writeFille.setText("Upload");
        writeFille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeFilleActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(255, 255, 255));
        print.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        print.setForeground(new java.awt.Color(0, 153, 255));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Print-icon.png"))); // NOI18N
        print.setText("Print");
        print.setMaximumSize(new java.awt.Dimension(89, 39));
        print.setMinimumSize(new java.awt.Dimension(89, 39));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(255, 0, 0));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back-Icon-new.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        ptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Patient_name"
            }
        ));
        ptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ptableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ptable);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(writeFille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(doctorcombo, 0, 115, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(refresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(tpatient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(doctorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(writeFille, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tpatient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\t\t\tPIJION CLINIC MANAGEMENT SYSTEM\t\tDATE:\nEye Specialist\t\t\t\tRAJSAHI,BAJAR\nFCPS,Japan\n\n\n\t\t\t********************************\n\nName:            \t\t\tAge:                \t\t\tGender:\n\n\nDate:            \t\t\tNext Date:            \t\tContact:\n\n\n\t\t\t*********************************\n\nProblem:\n\n\n\n\n\n\n\n\t\t\t*********************************\n\n\nDrugs:\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t*********************************");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        available.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        available.setForeground(new java.awt.Color(51, 153, 0));
        available.setText("avaiable");
        available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableActionPerformed(evt);
            }
        });

        unavailable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        unavailable.setForeground(new java.awt.Color(255, 0, 0));
        unavailable.setText("unavailable");
        unavailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unavailableActionPerformed(evt);
            }
        });

        log_out.setText("Log out");
        log_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_outActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Patient id:");

        lpid.setForeground(new java.awt.Color(0, 0, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Bill:");

        lpbil.setForeground(new java.awt.Color(0, 153, 0));

        mdate.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        mdate.setForeground(new java.awt.Color(0, 0, 255));

        mtime.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        mtime.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(mdate, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mtime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(unavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lpid, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lpbil, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log_out, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lpid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lpbil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(log_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mtime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(unavailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(available, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(452, 452, 452)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(530, 530, 530))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("prescription", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        read.setBackground(new java.awt.Color(255, 255, 255));
        read.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        read.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Folder-Upload-icon.png"))); // NOI18N
        read.setText("Read");
        read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readActionPerformed(evt);
            }
        });

        print1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        print1.setForeground(new java.awt.Color(0, 153, 255));
        print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back-Icon-new.png"))); // NOI18N
        print1.setText("Print");
        print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print1ActionPerformed(evt);
            }
        });

        prsupload.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        prsupload.setForeground(new java.awt.Color(0, 255, 51));
        prsupload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Upload-icon.png"))); // NOI18N
        prsupload.setText("upload");
        prsupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prsuploadActionPerformed(evt);
            }
        });

        Home.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Home.setForeground(new java.awt.Color(51, 204, 0));
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-icon.png"))); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        pres_update.setText("pres_update");
        pres_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pres_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Home)
                .addGap(59, 59, 59)
                .addComponent(read, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(print1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(prsupload)
                .addGap(31, 31, 31)
                .addComponent(pres_update, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(598, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pres_update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(read, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(print1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prsupload, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        prscombobox.setBackground(new java.awt.Color(51, 204, 0));
        prscombobox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        prscombobox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        prscombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prscomboboxItemStateChanged(evt);
            }
        });

        prstxtfield.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        ptable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Patient_name"
            }
        ));
        ptable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ptable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ptable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prstxtfield, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(prscombobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 111, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, 0, 0, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(prscombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(prstxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jScrollPane2)
                            .addContainerGap())
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("printed file", jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Doctors");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Patients");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jLabel6.setText("Name:");

        jLabel7.setText("Age:");

        jLabel8.setText("Patient id:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Gender:");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Bill:");

        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel4))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel5)))
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cpname)
                                            .addComponent(cpage, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cpid)
                                            .addComponent(cpbill, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(doctortextfield)))))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctortextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cpbill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(26, 26, 26))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Diseases catagory");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Diseases Description:");

        ddescription.setColumns(20);
        ddescription.setLineWrap(true);
        ddescription.setRows(5);
        jScrollPane8.setViewportView(ddescription);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Name:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(dcatagory, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTable3);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Drags Name");

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder("Drug Taking Time"));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "B-L-D", "B-L-0", "B-0-D", "B-0-0", "0-L-D", "0-L-0", "0-0-D" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(jList1);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Drags Name");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Time");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Drags Name");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Time");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 0));
        jButton1.setText("Prescription");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Next appointment");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel15))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jTextField12)
                            .addComponent(jTextField13)
                            .addComponent(jTextField14)
                            .addComponent(jTextField15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap(396, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)))))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))))
                .addGap(20, 20, 20))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane9))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("alternarive prescription", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(942, 571));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ptable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptable1MouseClicked
        // TODO add your handling code here:
        int row=ptable1.getSelectedRow();
        click=(String) ptable1.getModel().getValueAt(row, 0);
        try {
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = (Statement) connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                "SELECT prescription FROM patient where name='" +click +"'");
            while (resultSet.next()) {

                String blob = resultSet.getString("prescription");
                jTextArea2.setText(blob);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ptable1MouseClicked

    private void prscomboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prscomboboxItemStateChanged
        // TODO add your handling code here:
        String a=(String) prscombobox.getSelectedItem();
        prstxtfield.setText(a);
    }//GEN-LAST:event_prscomboboxItemStateChanged

    private void pres_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pres_updateActionPerformed
        // TODO add your handling code here:
        if(jTextArea2.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Please slect patent from table!!");
        }
        else{
            try {
                String query="UPDATE `patient` SET `prescription`='"+jTextArea2.getText().toString()+"' WHERE name='"+click+"'";
                statement.execute(query);
                JOptionPane.showMessageDialog(null, "File updated!!");
                jTextArea2.setText("");
                //jTextArea2.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_pres_updateActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        try {
        connection.close();
    cmanagementsystem ob=new cmanagementsystem();
    ob.setVisible(true);
    } catch (Exception e) {
    }
    dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void prsuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prsuploadActionPerformed
        // TODO add your handling code here:
        if(jTextArea2.getText().toString().equals("") || prstxtfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Please slect doctor name and fill the prescription!!");
        }
        else{
            try {
                String b=prstxtfield.getText();

                // FileWriter writer=new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\cmanagement\\src\\b.txt");
                //BufferedWriter bw=new BufferedWriter(writer);
                //jTextArea2.write(bw);
                //bw.close();
                String query="INSERT INTO `fileup`(`doc_name`, `file`) VALUES ('" + prstxtfield.getText().toString() + "','" + jTextArea2.getText().toString() + "')";
                statement.execute(query);
                jTextArea2.setText("");
                //jTextArea2.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_prsuploadActionPerformed

    private void print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print1ActionPerformed
        // TODO add your handling code here:
        try {
            boolean complete=jTextArea2.print();
            if(complete){
                JOptionPane.showMessageDialog(null, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            JOptionPane.showMessageDialog(null, "Printing", "Printer", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_print1ActionPerformed

    private void readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser=new JFileChooser("C:\\Users\\User\\Documents\\NetBeansProjects\\cmanagement\\src\\");
            chooser.showOpenDialog(null);
            File f=chooser.getSelectedFile();
            String filename=f.getAbsolutePath();

            try {
                FileReader reader=new FileReader(filename);
                BufferedReader br=new BufferedReader(reader);
                jTextArea2.read(br, null);
                br.close();
                jTextArea2.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_readActionPerformed

    private void log_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_outActionPerformed
        // TODO add your handling code here:
        try {

            String query="UPDATE `doctor` SET `status`='not available' WHERE dname='"+doctorcombo.getSelectedItem()+"'";
            statement.execute(query);
        } catch (Exception e) {
        }
        System.exit(0);
    }//GEN-LAST:event_log_outActionPerformed

    private void unavailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unavailableActionPerformed
        // TODO add your handling code here:
        try {

            String query="UPDATE `doctor` SET `status`='not available' WHERE dname='"+doctorcombo.getSelectedItem()+"'";
            statement.execute(query);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_unavailableActionPerformed

    private void availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableActionPerformed
        // TODO add your handling code here:
        try {

            String query="UPDATE `doctor` SET `status`='available' WHERE dname='"+doctorcombo.getSelectedItem()+"'";
            statement.execute(query);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_availableActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = (Statement) connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                "SELECT name from patient where doctor ='"+doctorcombo.getSelectedItem()+"' AND status ='not_visited' AND date=CURDATE() order by date DESC");
            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            DefaultTableModel dtm = new DefaultTableModel();
            Vector column_name = new Vector();
            Vector data_rows = new Vector();
            for (int i = 1; i <= numberOfColumns; i++) {
                column_name.addElement(metaData.getColumnName(i));
            }
            dtm.setColumnIdentifiers(column_name);
            while (resultSet.next()) {
                data_rows = new Vector();
                for (int j = 1; j <= numberOfColumns; j++) {
                    data_rows.addElement(resultSet.getString(j));
                }
                dtm.addRow(data_rows);
            }
            ptable.setModel(dtm);
            //tsearch.setText(null);
        } catch (Exception x) {
            //x.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void ptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptableMouseClicked
        // TODO add your handling code here:
        int row=ptable.getSelectedRow();
        final String table_click=(String) ptable.getModel().getValueAt(row, 0);
        tpatient.setText(table_click);

        try {
            ResultSet resultSet = statement.executeQuery(
                "SELECT * from patient where name='"+table_click+"'");

            while(resultSet.next()){
                String pid=resultSet.getString("pid");
                lpid.setText(pid);
                String bill=resultSet.getString("bill");
                lpbil.setText(bill);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_ptableMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        cmanagementsystem ob=new cmanagementsystem();
        ob.setVisible(true);
        try {
            connection.close();
            String query="UPDATE `doctor` SET `status`='not available' WHERE dname='"+doctorcombo.getSelectedItem()+"'";
            statement.execute(query);
        } catch (Exception e) {
        }
        
        dispose();

    }//GEN-LAST:event_backActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try {
            boolean complete=jTextArea1.print();
            if(complete){
                JOptionPane.showMessageDialog(null, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            JOptionPane.showMessageDialog(null, "Printing", "Printer", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_printActionPerformed

    private void writeFilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeFilleActionPerformed
        // TODO add your handling code here:
        /* try {
            FileWriter writer=new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\cmanagement\\src\\print1.txt");
            BufferedWriter bw=new BufferedWriter(writer);
            jTextArea1.write(bw);
            bw.close();
            //jTextArea1.setText("");
            jTextArea1.requestFocus();
        } catch (Exception e) {
        }*/
        if(tpatient.getText().toString().equals("") || jTextArea1.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Please select patient name!!");
        }
        else{
            try {

                // FileWriter writer=new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\cmanagement\\src\\b.txt");
                //BufferedWriter bw=new BufferedWriter(writer);
                //jTextArea2.write(bw);
                //bw.close();
                String query="UPDATE `patient` SET `prescription`='"+jTextArea1.getText().toString()+"' WHERE name='"+tpatient.getText().toString()+"'";
                statement.execute(query);
                JOptionPane.showMessageDialog(null, "File uploaded!!");
                // jTextArea2.setText("");
                //jTextArea2.requestFocus();
            } catch (Exception e) {
            }

            try {

                // FileWriter writer=new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\cmanagement\\src\\b.txt");
                //BufferedWriter bw=new BufferedWriter(writer);
                //jTextArea2.write(bw);
                //bw.close();
                String query="UPDATE `patient` SET `status`='visited' WHERE name='"+tpatient.getText().toString()+"'";
                statement.execute(query);
                //JOptionPane.showMessageDialog(null, "File uploaded!!");
                // jTextArea2.setText("");
                //jTextArea2.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_writeFilleActionPerformed

    private void doctorcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorcomboActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_doctorcomboActionPerformed

    private void doctorcomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_doctorcomboItemStateChanged
        // TODO add your handling code here:
        String a=(String) doctorcombo.getSelectedItem();
        try {
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = (Statement) connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                "SELECT file FROM fileup where doc_name='" +doctorcombo.getSelectedItem() +"'");
            while (resultSet.next()) {

                String blob = resultSet.getString("file");
                jTextArea1.setText(blob);
            }
        } catch (Exception e) {
        }

        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");
            statement = (Statement) connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                "SELECT name from patient where doctor ='"+doctorcombo.getSelectedItem()+"' AND status ='not_visited' AND date=CURDATE() order by date DESC");
            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            DefaultTableModel dtm = new DefaultTableModel();
            Vector column_name = new Vector();
            Vector data_rows = new Vector();
            for (int i = 1; i <= numberOfColumns; i++) {
                column_name.addElement(metaData.getColumnName(i));
            }
            dtm.setColumnIdentifiers(column_name);
            while (resultSet.next()) {
                data_rows = new Vector();
                for (int j = 1; j <= numberOfColumns; j++) {
                    data_rows.addElement(resultSet.getString(j));
                }
                dtm.addRow(data_rows);
            }
            ptable.setModel(dtm);
            tpatient.setText(null);
        } catch (Exception x) {
            //x.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
        }

    }//GEN-LAST:event_doctorcomboItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
        final String table_click=(String) jTable1.getModel().getValueAt(row, 0);
        //tpatient.setText(table_click);

        try {
            ResultSet resultSet = statement.executeQuery(
                "SELECT * from patient where name='"+table_click+"'");

            while(resultSet.next()){
                String name=resultSet.getString("name");
                cpname.setText(name);
                String pid=resultSet.getString("pid");
                cpid.setText(pid);
                String bill=resultSet.getString("bill");
                cpbill.setText(bill);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        gender="Male";
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        gender="Female";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String specification="",app_date="",app_time="",contact="";
        String name=doctortextfield.getText().toString();
        String pname=cpname.getText().toString();
        String page=cpage.getText().toString();
         String patientid=cpid.getText().toString();
         String diseasesname=dcatagory.getText().toString();
         String diseasesdescription=ddescription.getText().toString();
        try {
            ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor where dname='" + name + "'");
                    while (resultSet.next()) {
                       specification=resultSet.getString("specification");  
                       app_date=resultSet.getString("app_day");
                       app_time=resultSet.getString("app_time");
                       contact=resultSet.getString("dcontact");     
                    }
            
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, new FileOutputStream("Prescription.pdf"));
            document.open();
            Image image = Image.getInstance("mayo13.jpg");
            document.add(image);
            document.add(new Paragraph(name, FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Font.BOLD, BaseColor.RED)));
            document.add(new Paragraph(specification, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, Font.ROMAN_BASELINE, BaseColor.BLUE)));
            document.add(new Paragraph("Contact Date:"+app_date, FontFactory.getFont(FontFactory.TIMES_ITALIC, 12, Font.ROMAN_BASELINE, BaseColor.GREEN)));
            document.add(new Paragraph("Contact Time:"+app_time, FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.ROMAN_BASELINE, BaseColor.GREEN)));
            document.add(new Paragraph("Contact Number:"+contact, FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.ROMAN_BASELINE, BaseColor.GRAY)));
            document.add(new Paragraph(new Date().toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD, BaseColor.ORANGE)));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("Name:"+pname+ "                                  "+"Age:" + page + "                     " + "Gender:"+gender+"                       "+"Id:"+patientid));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("Diseases Name:", FontFactory.getFont(FontFactory.TIMES_ITALIC, 14, Font.ROMAN_BASELINE, BaseColor.GREEN)));
            document.add(new Paragraph("      "+diseasesname, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("Diseases Description:", FontFactory.getFont(FontFactory.TIMES_ITALIC, 14, Font.ROMAN_BASELINE, BaseColor.GREEN)));
            document.add(new Paragraph("      "+diseasesdescription, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Prescribed Medicine Name:", FontFactory.getFont(FontFactory.TIMES_ITALIC, 14, Font.ROMAN_BASELINE, BaseColor.GREEN)));
            document.add(new Paragraph("      1."+jTextField1.getText().toString()+","+jTextField6.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      2."+jTextField2.getText().toString()+","+jTextField7.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      3."+jTextField3.getText().toString()+","+jTextField8.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      4."+jTextField4.getText().toString()+","+jTextField9.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      5."+jTextField5.getText().toString()+","+jTextField10.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      6."+jTextField11.getText().toString()+","+jTextField16.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      7."+jTextField12.getText().toString()+","+jTextField17.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      8."+jTextField13.getText().toString()+","+jTextField18.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      9."+jTextField14.getText().toString()+","+jTextField19.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph("      10."+jTextField15.getText().toString()+","+jTextField20.getText().toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ROMAN_BASELINE, BaseColor.BLACK)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Next Appointment Date:"+((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().toString(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 14, Font.ROMAN_BASELINE, BaseColor.RED))); 
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("MAYO Clinic Management System,Prescribed By "+name));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
           
            
            document.close();
            JOptionPane.showMessageDialog(null, "report saved...");
            
            dcatagory.setText(null);
            ddescription.setText(null);
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextField4.setText(null);
            jTextField5.setText(null);
            jTextField6.setText(null);
            jTextField7.setText(null);
            jTextField8.setText(null);
            jTextField9.setText(null);
            jTextField10.setText(null);
            jTextField11.setText(null);
            jTextField12.setText(null);
            jTextField13.setText(null);
            jTextField14.setText(null);
            jTextField15.setText(null);
            jTextField16.setText(null);
            jTextField17.setText(null);
            jTextField18.setText(null);
            jTextField19.setText(null);
            jTextField20.setText(null);
            c=0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
         String b=(String) jComboBox1.getSelectedItem();
                  doctortextfield.setText(b);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String b=(String) jComboBox2.getSelectedItem();
                  //dcatagory.setText(b);
                  
                  try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dename from diseases where decatagory='" +jComboBox2.getSelectedItem().toString()+"'");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    jTable2.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row=jTable2.getSelectedRow();
        final String table_click=(String) jTable2.getModel().getValueAt(row, 0);
        //tpatient.setText(table_click);

        try {
            ResultSet resultSet = statement.executeQuery(
                "SELECT * from diseases where dename='"+table_click+"'");

            while(resultSet.next()){
                String name=resultSet.getString("dename");
                dcatagory.setText(name);
                String des=resultSet.getString("dedescription");
               ddescription.setText(des);
                
            }
        } catch (Exception e) {
        }
        
        try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT drname from drugs where desname='"+dcatagory.getText().toString()+"'");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    jTable3.setModel(dtm);
                    //tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
         /*try {
                   
                   
                    int row=jTable3.getSelectedRow();
                    final String table_click=(String) jTable3.getModel().getValueAt(row, 0);
                    
                    //tdname.setText(table_click);                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from drugs where drname='" + table_click + "'");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("drname");   
                      c=c+1;
                      if(jTextField1.getText().toString().equals("")){
                        jTextField1.setText(dname);
                        break;
                    }
                      if(jTextField2.getText().toString().equals("")){
                        jTextField2.setText(dname);
                        break;
                    }
                      if(jTextField3.getText().toString().equals("")){
                        jTextField3.setText(dname);
                        break;
                    }
                     if(jTextField4.getText().toString().equals("")){
                        jTextField4.setText(dname);
                    }
                      if(jTextField5.getText().toString().equals("")){
                        jTextField5.setText(dname);
                    }
                    }
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, evt);
                }*/
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        try {                      
                    int row=jTable3.getSelectedRow();
                    final String table_click=(String) jTable3.getModel().getValueAt(row, 0);
                    
                    //tdname.setText(table_click);                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from drugs where drname='" + table_click + "'");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("drname");   
                      //c=c+1;
                      if(jTextField1.getText().toString().equals("")){
                        jTextField1.setText(dname);
                        break;
                    }
                      if(jTextField2.getText().toString().equals("")){
                        jTextField2.setText(dname);
                        break;
                    }
                      if(jTextField3.getText().toString().equals("")){
                        jTextField3.setText(dname);
                        break;
                    }
                     if(jTextField4.getText().toString().equals("")){
                        jTextField4.setText(dname);
                        break;
                    }
                      if(jTextField5.getText().toString().equals("")){
                        jTextField5.setText(dname);
                        break;
                    }
                      if(jTextField11.getText().toString().equals("")){
                        jTextField11.setText(dname);
                        break;
                    }
                      if(jTextField12.getText().toString().equals("")){
                        jTextField12.setText(dname);
                        break;
                    }
                      if(jTextField13.getText().toString().equals("")){
                        jTextField13.setText(dname);
                        break;
                    }
                     if(jTextField14.getText().toString().equals("")){
                        jTextField14.setText(dname);
                        break;
                    }
                      if(jTextField15.getText().toString().equals("")){
                        jTextField15.setText(dname);
                        break;
                    }
                    }
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, evt);
                }
        
    }//GEN-LAST:event_jTable3MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {

            ResultSet resultSet = statement.executeQuery(
                "SELECT name from patient where doctor ='"+jComboBox1.getSelectedItem()+"' AND status ='not_visited' AND date=CURDATE() order by date DESC");
            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            DefaultTableModel dtm = new DefaultTableModel();
            Vector column_name = new Vector();
            Vector data_rows = new Vector();
            for (int i = 1; i <= numberOfColumns; i++) {
                column_name.addElement(metaData.getColumnName(i));
            }
            dtm.setColumnIdentifiers(column_name);
            while (resultSet.next()) {
                data_rows = new Vector();
                for (int j = 1; j <= numberOfColumns; j++) {
                    data_rows.addElement(resultSet.getString(j));
                }
                dtm.addRow(data_rows);
            }
            jTable1.setModel(dtm);
            //tsearch.setText(null);
        } catch (Exception x) {
            //x.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextField4.setText(null);
            jTextField5.setText(null);
            jTextField6.setText(null);
            jTextField7.setText(null);
            jTextField8.setText(null);
            jTextField9.setText(null);
            jTextField10.setText(null);
            jTextField11.setText(null);
            jTextField12.setText(null);
            jTextField13.setText(null);
            jTextField14.setText(null);
            jTextField15.setText(null);
            jTextField16.setText(null);
            jTextField17.setText(null);
            jTextField18.setText(null);
            jTextField19.setText(null);
            jTextField20.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new doctor().setVisible(true);
            }
        });
    }
    private String click="";
    private String gender="";
    public int c=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JRadioButton available;
    private javax.swing.JButton back;
    private javax.swing.JTextField cpage;
    private javax.swing.JTextField cpbill;
    private javax.swing.JTextField cpid;
    private javax.swing.JTextField cpname;
    private javax.swing.JTextField dcatagory;
    private javax.swing.JTextArea ddescription;
    private javax.swing.JComboBox doctorcombo;
    private javax.swing.JTextField doctortextfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton log_out;
    private javax.swing.JLabel lpbil;
    private javax.swing.JLabel lpid;
    private javax.swing.JLabel mdate;
    private javax.swing.JLabel mtime;
    private javax.swing.JButton pres_update;
    private javax.swing.JButton print;
    private javax.swing.JButton print1;
    private javax.swing.JComboBox prscombobox;
    private javax.swing.JTextField prstxtfield;
    private javax.swing.JButton prsupload;
    private javax.swing.JTable ptable;
    private javax.swing.JTable ptable1;
    private javax.swing.JButton read;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField tpatient;
    private javax.swing.JRadioButton unavailable;
    private javax.swing.JButton writeFille;
    // End of variables declaration//GEN-END:variables
}
