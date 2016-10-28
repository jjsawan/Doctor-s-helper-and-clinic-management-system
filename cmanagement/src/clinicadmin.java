/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * clinicadmin.java
 *
 * Created on May 28, 2015, 9:54:00 PM
 */
//package cmanagement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class clinicadmin extends javax.swing.JFrame {

    /** Creates new form clinicadmin */
    
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/clinic_management_system";
    Connection connection = null;
    Statement statement = null;
    
    public clinicadmin() {
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");            
            statement = (Statement) connection.createStatement();            
        } catch (Exception e) {
            e.printStackTrace();            
        }
        
        initComponents();
        
        dynamictime();
        
        try {
             Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("dname");
                      docComboBox.addItem(dname);
                
            }
        } catch (Exception e) {
        }
        
        
         try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                             "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor ");
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
                    table1.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
         
         try {
             Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor");
                    while (resultSet.next()) {
                      String cata=resultSet.getString("catagory");
                      jComboBox2.addItem(cata);
                
            }
        } catch (Exception e) {
        }
         
         
         
        
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tsearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        patient = new javax.swing.JRadioButton();
        doctor = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tserial_no = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tdisease = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tdoctor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tcontact = new javax.swing.JTextField();
        docComboBox = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        tbill = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        insert = new javax.swing.JButton();
        pupdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        linsert = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        itdoc = new javax.swing.JTextField();
        avaiable = new javax.swing.JRadioButton();
        unav = new javax.swing.JRadioButton();
        ltime = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        mdate = new javax.swing.JMenu();
        mtime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Search Here :");

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search-marketing.jpg"))); // NOI18N
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        patient.setText("Patient");
        patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientActionPerformed(evt);
            }
        });

        doctor.setText("Doctor");
        doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(patient)
                        .addGap(18, 18, 18)
                        .addComponent(doctor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patient)
                    .addComponent(doctor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Name :");

        jLabel3.setText("Serial_No :");

        jLabel4.setText("Disease :");

        jLabel5.setText("Date :");

        jLabel6.setText("Doctor :");

        jLabel7.setText("Contact :");

        docComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                docComboBoxItemStateChanged(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Bill");

        tbill.setText("500tk");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(38, 38, 38))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(51, 51, 51)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tname, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(tserial_no, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(tdisease, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(tdoctor, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(tcontact, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(docComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(30, 30, 30)))
                            .addComponent(tbill, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tserial_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tdisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(docComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        insert.setBackground(new java.awt.Color(204, 204, 204));
        insert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        insert.setForeground(new java.awt.Color(0, 255, 0));
        insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg"))); // NOI18N
        insert.setText("ADD");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        pupdate.setBackground(new java.awt.Color(204, 204, 204));
        pupdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pupdate.setForeground(new java.awt.Color(255, 153, 153));
        pupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-tomboy-icon.png"))); // NOI18N
        pupdate.setText("UPDATE");
        pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pupdateActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Delete-icon.png"))); // NOI18N
        jButton3.setText("DELETE");

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.PNG"))); // NOI18N
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(51, 0, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back-Icon-new.png"))); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(insert, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(pupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pupdate)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table1.setBackground(new java.awt.Color(204, 204, 204));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "name", "catagory", "specification", "app_date", "app_time", "contact", "status"
            }
        ));
        jScrollPane1.setViewportView(table1);

        linsert.setText("Patient");
        linsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linsertActionPerformed(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        avaiable.setText("Avaiable");
        avaiable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaiableActionPerformed(evt);
            }
        });

        unav.setText("Unavailable");
        unav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unavActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(272, Short.MAX_VALUE)
                        .addComponent(linsert, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(avaiable)
                                .addGap(18, 18, 18)
                                .addComponent(unav))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ltime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(itdoc, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ltime, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itdoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avaiable)
                    .addComponent(unav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(linsert)
                .addGap(52, 52, 52))
        );

        jMenu1.setForeground(new java.awt.Color(0, 255, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-icon.png"))); // NOI18N
        jMenu1.setText("Home");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/People-Doctor-Male-icon.png"))); // NOI18N
        jMenuItem1.setText("Doctors");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Patients-icon.png"))); // NOI18N
        jMenuItem2.setText("Patient");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setForeground(new java.awt.Color(255, 0, 0));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin-icon.png"))); // NOI18N
        jMenu4.setText("Admin");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/administrator-icon.png"))); // NOI18N
        jMenuItem4.setText("Admin profile");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        mdate.setForeground(new java.awt.Color(0, 0, 204));
        jMenuBar1.add(mdate);

        mtime.setForeground(new java.awt.Color(255, 0, 0));
        jMenuBar1.add(mtime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-881)/2, (screenSize.height-570)/2, 881, 570);
    }// </editor-fold>//GEN-END:initComponents

private void docComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_docComboBoxItemStateChanged
// TODO add your handling code here:
    String a=(String) docComboBox.getSelectedItem();
                  tdoctor.setText(a);
}//GEN-LAST:event_docComboBoxItemStateChanged

private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
// TODO add your handling code here:
   
    
    try {
                    // TODO add your handling code here:
                    
                    String query = "INSERT INTO `patient`(`name`, `serial_no`, `disease`, `doctor`, `date`, `contact_no`,`status`,`bill`) values('" + tname.getText().toString() + "','" + tserial_no.getText().toString() + "','"
                            + tdisease.getText().toString() + "','" + tdoctor.getText().toString() + "','" + ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().toString() + "','" + tcontact.getText().toString() +"','not_visited','"+tbill.getText().toString()+"')";                    
                    
                    statement.execute(query);
                    tname.setText(null);
                    tserial_no.setText(null);
                    tdisease.setText(null);
                    //tdate.setText(null);
                    tdoctor.setText(null);
                    tcontact.setText(null);
                    
                    JOptionPane.showMessageDialog(null, "data inserted!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(clinicadmin.class.getName()).log(Level.SEVERE, null, ex);
                }
}//GEN-LAST:event_insertActionPerformed

private void linsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linsertActionPerformed
// TODO add your handling code here:
    try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT name,serial_no,contact_no from patient where date=CURDATE()");
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
                    table1.setModel(dtm);
                    tsearch.setText(null);
                } catch (Exception x) {
                    //x.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
    
}//GEN-LAST:event_linsertActionPerformed

private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
// TODO add your handling code here:
   /* String c=(String) jComboBox2.getSelectedItem();
                  //itdoc.setText(c);
                
                
                 
                
                 try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            " SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor where dname='"+jComboBox2.getSelectedItem()+"'");
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
                    table1.setModel(dtm);
                   itdoc.setText("");
                } catch (Exception x) {
                    x.printStackTrace();                    
                }*/
    
    jComboBox2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                
                try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            " SELECT dname,specification,app_day,app_time,status from doctor where catagory='"+jComboBox2.getSelectedItem()+"'");
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
                    table1.setModel(dtm);
                   itdoc.setText("");
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
            }
        });
    
    
}//GEN-LAST:event_jComboBox2ItemStateChanged

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
    try {
        connection.close();
    
    df obj=new df();
    obj.setTitle("CLINIC MANAGEMENT SYSTEM");
       // ob.setBounds(200, 26, 1000, 550);
        //ob.setLayout(null);
        obj.setVisible(true);
        obj.getContentPane().setBackground(Color.white);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
    catch (Exception e) {
    }
        
    dispose();
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_jMenu4ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
// TODO add your handling code here:
    admin obb=new admin();
    obb.setVisible(true);
    obb.setLayout(null);
    dispose();
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
// TODO add your handling code here:
    try {
        connection.close();
    cmanagementsystem ob=new cmanagementsystem();
    ob.setVisible(true);
    } catch (Exception e) {
    }
    dispose();
}//GEN-LAST:event_backActionPerformed

private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
// TODO add your handling code here:
    if(srch.equals("patient")){
    try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT name,serial_no,contact_no,date from patient where pid='"+tsearch.getText().toString()+"'AND date BETWEEN CURDATE() - INTERVAL 30 DAY AND CURDATE()");
                  
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
                        rc=rc+1;
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);                                            
                    }
                    table1.setModel(dtm);
                    
                } catch (Exception x) {
                    //x.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
        try {
            Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from patient where pid='"+tsearch.getText().toString()+"' AND date BETWEEN CURDATE() - INTERVAL 30 DAY AND CURDATE()");
                  
              while(resultSet.next()){
                        String pname=resultSet.getString("name");
                      tname.setText(pname);
                      String serialno=resultSet.getString("serial_no");
                      tserial_no.setText(serialno);
                      String disease=resultSet.getString("disease");
                      tdisease.setText(disease);
                      String doctor=resultSet.getString("doctor");
                      tdoctor.setText(doctor);
                      String date=resultSet.getString("date");
                      ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(date);
                      String contact=resultSet.getString("contact_no");
                      tcontact.setText(contact);
                      tbill.setText("300tk");
                    }
             // tsearch.setText(null);
        } catch (Exception e) {
        }
    
    }
    if(srch.equals("doctor")){
        try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            " SELECT dname,specification,app_day,app_time,status from doctor where dname='"+tsearch.getText().toString()+"'");
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
                        rc=rc+1;
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    table1.setModel(dtm);
                   tsearch.setText("");
                } catch (Exception x) {
                   // x.printStackTrace();   
                    JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
                }
    }
    if(srch.equals("")){
        JOptionPane.showMessageDialog(null, "Not Found!!!Please select doctor or patient!!");
    }
    if(rc==0){
        JOptionPane.showMessageDialog(null, "Not Found!!!Please search with exact match!!");
    }
}//GEN-LAST:event_searchActionPerformed

private void avaiableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaiableActionPerformed
// TODO add your handling code here:
    available="available";
     try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                             "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor where status='available'");
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
                    table1.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
}//GEN-LAST:event_avaiableActionPerformed

private void unavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unavActionPerformed
// TODO add your handling code here:
    available="unavailable";
     try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                             "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor where status='not available'");
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
                    table1.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
}//GEN-LAST:event_unavActionPerformed

private void patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientActionPerformed
// TODO add your handling code here:
    srch="patient";
}//GEN-LAST:event_patientActionPerformed

private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed
// TODO add your handling code here:
    srch="doctor";
}//GEN-LAST:event_doctorActionPerformed

private void pupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pupdateActionPerformed
// TODO add your handling code here:
    try {
        String query=" UPDATE `patient` SET `name`='" + tname.getText().toString() + "',`serial_no`='" + tserial_no.getText().toString() + "',"
                            + "`disease`='" + tdisease.getText().toString() + "',`doctor`='" + tdoctor.getText().toString() + "',"
                            + "`date`='" + ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().toString() + "',`contact_no`='" + tcontact.getText().toString() +"',"
                            + "`status`='not_visited',bill='"+tbill.getText().toString()+"' WHERE pid='" + tsearch.getText().toString() +"' ";
                          
                    statement.execute(query);
                    tname.setText(null);
                    tserial_no.setText(null);
                    tdisease.setText(null);
                    //tdate.setText(null);
                    tdoctor.setText(null);
                    tcontact.setText(null);
                    tbill.setText("500tk");
                    tsearch.setText(null);
                    JOptionPane.showMessageDialog(null,"update completed");
                    
    } catch (Exception e) {
    }
}//GEN-LAST:event_pupdateActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
    patient obb=new patient();
    obb.setVisible(true);
    obb.setTitle("Patient Statistics");
    obb.setLayout(null);
    dispose();
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
    System.exit(0);
}//GEN-LAST:event_jButton4ActionPerformed



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
            java.util.logging.Logger.getLogger(clinicadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clinicadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clinicadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clinicadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new clinicadmin().setVisible(true);
            }
        });
    }
    private String available="",srch="";
    private int rc=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton avaiable;
    private javax.swing.JButton back;
    private javax.swing.JComboBox docComboBox;
    private javax.swing.JRadioButton doctor;
    private javax.swing.JButton insert;
    private javax.swing.JTextField itdoc;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton linsert;
    private javax.swing.JLabel ltime;
    private javax.swing.JMenu mdate;
    private javax.swing.JMenu mtime;
    private javax.swing.JRadioButton patient;
    private javax.swing.JButton pupdate;
    private javax.swing.JButton search;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tbill;
    private javax.swing.JTextField tcontact;
    private javax.swing.JTextField tdisease;
    private javax.swing.JTextField tdoctor;
    private javax.swing.JTextField tname;
    private javax.swing.JTextField tsearch;
    private javax.swing.JTextField tserial_no;
    private javax.swing.JRadioButton unav;
    // End of variables declaration//GEN-END:variables
}
