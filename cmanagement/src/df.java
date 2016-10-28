/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * df.java
 *
 * Created on May 29, 2015, 12:00:09 AM
 */
//package cmanagement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class df extends javax.swing.JFrame {

    /** Creates new form df */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/clinic_management_system";
    Connection connection = null;
    Statement statement = null;
    
    public df() {
        
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
                            "SELECT * from doctor");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("dname");
                      docpanelComboBox.addItem(dname);
                 }
                    
        } catch (Exception e) {
        }
        
        
        try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor");
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
                    table2.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
        
        
        
        try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dname from doctor");
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
                    table3.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
        
        
        docpanelComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                
                try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor where dname='" + docpanelComboBox.getSelectedItem().toString() + "'");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("dname");
                      tdname.setText(dname);
                      String catagory=resultSet.getString("catagory");
                      tcatagory.setText(catagory);
                      String specification=resultSet.getString("specification");
                      tspecification.setText(specification);
                      String app_date=resultSet.getString("app_day");
                      tapp_date.setText(app_date);
                      String app_time=resultSet.getString("app_time");
                      tapp_time.setText(app_time);
                      String contact=resultSet.getString("dcontact");
                      tcontactno.setText(contact);
                      String status=resultSet.getString("status");
                      tstatus.setText(status);
                 }
                    
                } catch (Exception evt) {
                } 
            }
        });
        
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
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tdname = new javax.swing.JTextField();
        tcatagory = new javax.swing.JTextField();
        tspecification = new javax.swing.JTextField();
        tapp_date = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tapp_time = new javax.swing.JTextField();
        tcontactno = new javax.swing.JTextField();
        tstatus = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        EDIT = new javax.swing.JButton();
        avv = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        docpanelComboBox = new javax.swing.JComboBox();
        Exit = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        d_name = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        d_catagory = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        a_date = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        a_time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/People-Doctor-Male-icon.png"))); // NOI18N
        jLabel8.setText("Doctor's List");

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Ctagory", "Specification", "A_Date", "A_Time", "Contact", "Status"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Name");

        jLabel2.setText("Catagory");

        jLabel3.setText("Specification");

        jLabel4.setText("A_Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(65, 65, 65)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tdname, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(tspecification, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(tcatagory, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(tapp_date, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tdname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tcatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tspecification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tapp_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("A_Time");

        jLabel6.setText("Contact");

        jLabel7.setText("Status");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Information-icon.png"))); // NOI18N
        jLabel16.setText("Information");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(52, 52, 52)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addComponent(tcontactno)
                        .addComponent(tapp_time)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tapp_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tcontactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add.setForeground(new java.awt.Color(0, 204, 0));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Upload-icon.png"))); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        EDIT.setBackground(new java.awt.Color(204, 204, 204));
        EDIT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EDIT.setForeground(new java.awt.Color(255, 153, 0));
        EDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-tomboy-icon.png"))); // NOI18N
        EDIT.setText("EDIT");
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });

        avv.setBackground(new java.awt.Color(204, 204, 204));
        avv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        avv.setForeground(new java.awt.Color(0, 102, 0));
        avv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg"))); // NOI18N
        avv.setText("AVAILABLE");
        avv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avvActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(204, 204, 204));
        delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 0, 0));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.PNG"))); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        docpanelComboBox.setBackground(new java.awt.Color(0, 153, 153));
        docpanelComboBox.setFont(new java.awt.Font("Tahoma", 1, 11));
        docpanelComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                docpanelComboBoxItemStateChanged(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(204, 204, 204));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 11));
        Exit.setForeground(new java.awt.Color(0, 0, 204));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back-Icon-new.png"))); // NOI18N
        Exit.setText("BACK");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/People-Doctor-Male-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(docpanelComboBox, 0, 127, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(avv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(59, 59, 59))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docpanelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(avv, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Doctor", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/People-Doctor-Male-icon.png"))); // NOI18N
        jLabel9.setText("Doctors List");

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Doctor's Name"
            }
        ));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("SPECIFICATION");

        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane3.setViewportView(textarea);

        jLabel11.setText("NAME ");

        jLabel12.setText("CATAGORY");

        jLabel13.setText("APP_DATE");

        jLabel14.setText("APP_TIME");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(d_name, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(d_catagory, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(a_date, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(10, 10, 10)
                        .addComponent(a_time, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(d_name, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(d_catagory, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel10))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(a_time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doctor's info", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-843)/2, (screenSize.height-553)/2, 843, 553);
    }// </editor-fold>//GEN-END:initComponents

private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
// TODO add your handling code here:
    if(tdname.getText().toString().equals("") || tcatagory.getText().toString().equals("") || tspecification.getText().toString().equals("") || 
                tapp_date.getText().toString().equals("") || tapp_time.getText().toString().equals("") || tcontactno.getText().toString().equals("") || 
                tstatus.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "please fill the field!!");
        } 
    else{
    try {
    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            " SELECT dname from doctor where dname='"+tdname.getText().toString()+"'");
                    while(resultSet.next()){
                        rc=rc+1;
                       // String name=resultSet.getString("dname");
                    }
                        //tdname.setText(null);
    } catch (Exception e) {
    }
    
    if(rc>=1){
        JOptionPane.showMessageDialog(null, "The name has already exist!!");
    }
    else{
        
    try {
                    // TODO add your handling code here:
                    
                    String query = "INSERT INTO `doctor`(`dname`, `catagory`, `specification`, `app_day`, `app_time`, `dcontact`,`status`) values('" + tdname.getText().toString() + "','" + tcatagory.getText().toString() + "','"
                            + tspecification.getText().toString() + "','" + tapp_date.getText().toString() + "','" + tapp_time.getText().toString() + "','" + tcontactno.getText().toString() +"','" + tstatus.getText().toString() +"')";                    
                    
                    statement.execute(query);
                    tdname.setText(null);
                    tcatagory.setText(null);
                    tspecification.setText(null);
                    //tapp_date.setText(null);
                    tapp_time.setText(null);
                    tcontactno.setText(null);
                    tstatus.setText(null);
                    
                    JOptionPane.showMessageDialog(null, "data inserted");
                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor");
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
                    table2.setModel(dtm);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(clinicadmin.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    }
}//GEN-LAST:event_addActionPerformed

private void docpanelComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_docpanelComboBoxItemStateChanged
// TODO add your handling code here:
    
}//GEN-LAST:event_docpanelComboBoxItemStateChanged

private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
// TODO add your handling code here:
    if(tdname.getText().toString().equals("") || tcatagory.getText().toString().equals("") || tspecification.getText().toString().equals("") || 
                tapp_date.getText().toString().equals("") || tapp_time.getText().toString().equals("") || tcontactno.getText().toString().equals("") || 
                tstatus.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "please fill the field!!");
        }
    
    
    
    else{
     try {
                    // TODO add your handling code here:
                    String query=" UPDATE `doctor` SET `dname`='" + tdname.getText().toString() + "',`catagory`='" + tcatagory.getText().toString() + "',"
                            + "`specification`='" + tspecification.getText().toString() + "',`app_day`='" + tapp_date.getText().toString() + "',"
                            + "`app_time`='" + tapp_time.getText().toString() + "',`dcontact`='" + tcontactno.getText().toString() +"',"
                            + "`status`='" + tstatus.getText().toString() +"' WHERE dname='" + tdname.getText().toString() +"' ";
                  
                    statement.execute(query);
                    tdname.setText(null);
                    tcatagory.setText(null);
                    tspecification.setText(null);
                    tapp_date.setText(null);
                    tapp_time.setText(null);
                    tcontactno.setText(null);
                    tstatus.setText(null);
                    JOptionPane.showMessageDialog(null,"update completed");
                      tcatagory.setText(null);
                  
                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor");
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
                    table2.setModel(dtm);
                 
                } catch (SQLException ex) {
                    Logger.getLogger(clinicadmin.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
}//GEN-LAST:event_EDITActionPerformed

private void avvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avvActionPerformed
// TODO add your handling code here:
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
                    table2.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
}//GEN-LAST:event_avvActionPerformed

private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
// TODO add your handling code here:
    if(tdname.getText().toString().equals("") || tcatagory.getText().toString().equals("") || tspecification.getText().toString().equals("") || 
                tapp_date.getText().toString().equals("") || tapp_time.getText().toString().equals("") || tcontactno.getText().toString().equals("") || 
                tstatus.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "please fill the field or select a info of the table!!");
        }
    else{
        try {
                    String query = "DELETE FROM `doctor` WHERE dname='"+ tdname.getText().toString() +"'";                    
                    
                    statement.execute(query);
                    
                    tdname.setText(null);
                    tcatagory.setText(null);
                    tspecification.setText(null);
                    tapp_date.setText(null);
                    tapp_time.setText(null);
                    tcontactno.setText(null);
                    tstatus.setText(null);
                    
                    JOptionPane.showMessageDialog(null, "delete completed");
                    
                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT dname,catagory,specification,app_day,app_time,dcontact,status from doctor");
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
                    table2.setModel(dtm);
                    
                    
                } catch (Exception ev) {
                }
    }
}//GEN-LAST:event_deleteActionPerformed

private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
// TODO add your handling code here:
    try {
                   
                   
                    int row=table2.getSelectedRow();
                    final String table_click=(String) table2.getModel().getValueAt(row, 0);
                    //tdname.setText(table_click);                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor where dname='" + table_click + "'");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("dname");
                      tdname.setText(dname);
                      String catagory=resultSet.getString("catagory");
                      tcatagory.setText(catagory);
                      String specification=resultSet.getString("specification");
                      tspecification.setText(specification);
                      String app_date=resultSet.getString("app_day");
                      tapp_date.setText(app_date);
                      String app_time=resultSet.getString("app_time");
                      tapp_time.setText(app_time);
                      String contact=resultSet.getString("dcontact");
                      tcontactno.setText(contact);
                      String status=resultSet.getString("status");
                      tstatus.setText(status);
                    }
                    
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, evt);
                }
}//GEN-LAST:event_table2MouseClicked

private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
// TODO add your handling code here:
    try {
        connection.close();
    clinicadmin ob=new clinicadmin();
    ob.setVisible(true);
    } catch (Exception e) {
    }
    dispose();
}//GEN-LAST:event_ExitActionPerformed

private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
// TODO add your handling code here:
     try {
                   
                   
                    int row=table3.getSelectedRow();
                    final String table_click=(String) table3.getModel().getValueAt(row, 0);
                    //tdname.setText(table_click);                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT * from doctor where dname='" + table_click + "'");
                    while (resultSet.next()) {
                      String dname=resultSet.getString("dname");
                      d_name.setText(dname);
                      String catagory=resultSet.getString("catagory");
                      d_catagory.setText(catagory);
                      String specification=resultSet.getString("specification");
                      textarea.setText(specification);
                      String app_date=resultSet.getString("app_day");
                      a_date.setText(app_date);
                      String app_time=resultSet.getString("app_time");
                      a_time.setText(app_time);
                      //String contact=resultSet.getString("dcontact");
                      //tcontactno.setText(contact);
                      //String status=resultSet.getString("status");
                      //tstatus.setText(status);
                    }
                    
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, evt);
                }
    
}//GEN-LAST:event_table3MouseClicked

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
            java.util.logging.Logger.getLogger(df.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(df.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(df.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(df.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new df().setVisible(true);
            }
        });
    }
    private int rc=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EDIT;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField a_date;
    private javax.swing.JTextField a_time;
    private javax.swing.JButton add;
    private javax.swing.JButton avv;
    private javax.swing.JTextField d_catagory;
    private javax.swing.JTextField d_name;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox docpanelComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTextField tapp_date;
    private javax.swing.JTextField tapp_time;
    private javax.swing.JTextField tcatagory;
    private javax.swing.JTextField tcontactno;
    private javax.swing.JTextField tdname;
    private javax.swing.JTextArea textarea;
    private javax.swing.JTextField tspecification;
    private javax.swing.JTextField tstatus;
    // End of variables declaration//GEN-END:variables
}
