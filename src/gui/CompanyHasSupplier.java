/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import SubUI.SelectCompany;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.MySql;

/**
 *
 * @author Rashan
 */
public class CompanyHasSupplier extends javax.swing.JPanel {

    private int companyId = 0;

    public CompanyHasSupplier() {
        initComponents();

        loadCompanyTable();
        jButton2.setEnabled(false);

        loadSupplierTable();
        jButton6.setEnabled(false);
        jTextField3.setEditable(false);

    }

    private boolean companyValidate() {

        boolean valide = false;

        String companyName = jTextField1.getText();
        String companyHotLine = jTextField5.getText();

        if (companyName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Company Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (companyHotLine.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!companyHotLine.matches("^0[1,7][1,2,4,5,6,7,8,0][0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalide Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            valide = true;

        }

        return valide;

    }

    private void loadCompanyTable() {

        try {
            String text = jTextField1.getText();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            model.setRowCount(0);
            ResultSet resultSet = MySql.execute("SELECT * FROM `company` WHERE `company_name` LIKE '" + text + "%' ORDER BY `id` DESC");
            int count = 0;
            while (resultSet.next()) {
                Vector<String> v = new Vector<>();

                v.add(String.valueOf(count));
                v.add(resultSet.getString("company_name"));
                v.add(resultSet.getString("hotline"));
                count++;
                model.addRow(v);

            }
            jLabel3.setText("Companies (" + String.valueOf(count) + ")");

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "CompnayHasSupplier loaCompanyTable", e);
        }

    }

    private void updateCompany() {
        boolean v = companyValidate();

        if (v) {

            String companyName = jTextField1.getText();
            String companyHotLine = jTextField5.getText();

            try {
                ResultSet rs = MySql.execute("SELECT * FROM `company` WHERE `company_name`='" + companyName + "' AND `hotline`='" + companyHotLine + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Company or Hotline Number already registered");

                } else {

                    MySql.execute("UPDATE `company` SET `hotline`='" + companyHotLine + "' WHERE `company_name`= '" + companyName + "'");

                    resetCompany();
                    loadCompanyTable();
                }

            } catch (Exception e) {
                utils.Logger.logger.log(Level.WARNING, "CompnayHasSupplier updateCompany", e);
            }

        }

    }

    private void createCompany() {
        boolean v = companyValidate();

        if (v) {

            String companyName = jTextField1.getText();
            String companyHotLine = jTextField5.getText();

            try {
                ResultSet resultSet = MySql.execute("SELECT * FROM `company` WHERE `company_name`='" + companyName + "' OR `hotline`='" + companyHotLine + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Company already registered", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    MySql.execute("INSERT INTO `company` (`company_name`,`hotline`) VALUES ('" + companyName + "','" + companyHotLine + "')");

                    JOptionPane.showMessageDialog(this, "Registered Success", "Success", JOptionPane.OK_OPTION);

                    resetCompany();
                    loadCompanyTable();
                }
            } catch (Exception e) {
                utils.Logger.logger.log(Level.WARNING, "CompnayHasSupplier createCompany", e);

            }

        }
    }

    private boolean suplierValidate() {

        boolean value = false;

        String supplierName = jTextField2.getText();
        String suppliermobile = jTextField4.getText();
        String supplierCompany = jTextField3.getText();

        if (companyId == 0) {
            JOptionPane.showMessageDialog(this, "Please Select Company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (supplierName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (suppliermobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!suppliermobile.matches("^0[1,7][1,2,4,5,6,7,8,0][0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalide Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            value = true;

        }

        return value;

    }

    private void loadSupplierTable() {

        try {
            String text = jTextField2.getText();
            ResultSet resultSet = MySql.execute("SELECT * FROM `supplier` INNER JOIN `company` ON `supplier`.`company_id`=`company`.`id` WHERE `supplier_name` LIKE '" + text + "%' ORDER BY `supplier`.`id` DESC");
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            int count = 0;
            while (resultSet.next()) {
                count++;

                Vector<String> v = new Vector<>();

                v.add(String.valueOf(count));
                v.add(resultSet.getString("supplier_name"));
                v.add(resultSet.getString("supplier.mobile"));
                v.add(resultSet.getString("company.company_name"));
                count++;
                model.addRow(v);

            }

            jLabel10.setText("Suppliers (" + String.valueOf(count) + ")");

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "CompnayHasSupplier loadSupplierTable", e);

        }

    }

    private void createSupplier() {
        boolean v = suplierValidate();

        if (v) {

            String supplierName = jTextField2.getText();
            String suppliermobile = jTextField4.getText();

            try {

                ResultSet resultSet = MySql.execute("SELECT * FROM `supplier` WHERE `mobile`='" + suppliermobile + "'");

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(this, "Supplier already registered", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    MySql.execute("INSERT INTO `supplier` (`supplier_name`,`mobile`,`company_id`) VALUES ('" + supplierName + "','" + suppliermobile + "','" + companyId + "')");

                    resetsSupplier();
                    loadSupplierTable();
                }

            } catch (Exception e) {
                utils.Logger.logger.log(Level.WARNING, "CompnayHasSupplier createSupplier", e);

            }

        }
    }

    private void updateSupplier() {
        boolean v = suplierValidate();

        if (v) {

            String supplierName = jTextField2.getText();
            String suppliermobile = jTextField4.getText();

            try {

                ResultSet resultSet = MySql.execute("SELECT * FROM `supplier` WHERE `supplier_name`='" + supplierName + "' AND `mobile`='" + suppliermobile + "' AND `company_id`='" + companyId + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Supplier already registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySql.execute("UPDATE `supplier` SET `supplier_name`='" + supplierName + "', `mobile`='" + suppliermobile + "',`company_id`='" + companyId + "'");

                    resetsSupplier();
                    loadSupplierTable();
                }
            } catch (Exception e) {
                utils.Logger.logger.log(Level.WARNING, "CompnayHasSupplier updateSupplier", e);

            }

        }

    }

    private void openSelectCompany() {
        SelectCompany selectCompany = new SelectCompany(new RootLayout(), true);
        selectCompany.setParent(this);

        selectCompany.setVisible(true);
    }

    public void setCompanyFields(String coName, String coHotLine) {

        jTextField1.setText(coName);
        jTextField5.setText(coHotLine);
        jButton2.setEnabled(true);
        jButton1.setEnabled(false);
        jTextField1.setEditable(false);

    }

    public void setCoNames(String cname, int cId) {

        companyId = cId;
        jTextField3.setText(cname);
         jButton6.setEnabled(false);
                jButton5.setEnabled(true);

    }

    public void setSuppliertFields(String suppliername, String mobile, String company) {

        jButton6.setEnabled(true);
        jButton5.setEnabled(false);
        jTextField2.setText(suppliername);
        jTextField4.setText(mobile);
        jTextField3.setText(company);

    }

    private void resetCompany() {
        jTextField1.setText("");
        jTextField5.setText("");
        jButton2.setEnabled(false);
        jButton1.setEnabled(true);

    }

    private void resetsSupplier() {

        jButton6.setEnabled(false);
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField3.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compnyRedistrionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        supplierRegistrationPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(1086, 812));
        setOpaque(false);

        compnyRedistrionPanel.setBackground(new java.awt.Color(255, 255, 255));
        compnyRedistrionPanel.setMinimumSize(new java.awt.Dimension(450, 230));
        compnyRedistrionPanel.setPreferredSize(new java.awt.Dimension(450, 230));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Company Registarion");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(230, 50));
        jTextField1.setPreferredSize(new java.awt.Dimension(230, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(135, 137, 153));
        jLabel2.setText("Company Name");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(110, 170));
        jPanel2.setPreferredSize(new java.awt.Dimension(110, 170));
        jPanel2.setLayout(new java.awt.GridLayout(3, 1, 0, 15));

        jButton1.setBackground(new java.awt.Color(209, 217, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(61, 92, 255));
        jButton1.setText("Add");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setBackground(new java.awt.Color(209, 217, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(61, 92, 255));
        jButton2.setText("Update");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 210, 123));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(118, 78, 1));
        jButton3.setText("Clear");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(135, 137, 153));
        jLabel9.setText("Hotline");

        jTextField5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField5.setMinimumSize(new java.awt.Dimension(228, 48));
        jTextField5.setPreferredSize(new java.awt.Dimension(228, 48));

        javax.swing.GroupLayout compnyRedistrionPanelLayout = new javax.swing.GroupLayout(compnyRedistrionPanel);
        compnyRedistrionPanel.setLayout(compnyRedistrionPanelLayout);
        compnyRedistrionPanelLayout.setHorizontalGroup(
            compnyRedistrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compnyRedistrionPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(compnyRedistrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compnyRedistrionPanelLayout.createSequentialGroup()
                        .addGroup(compnyRedistrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55))
                    .addGroup(compnyRedistrionPanelLayout.createSequentialGroup()
                        .addGroup(compnyRedistrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                        .addGap(58, 58, 58)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        compnyRedistrionPanelLayout.setVerticalGroup(
            compnyRedistrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compnyRedistrionPanelLayout.createSequentialGroup()
                .addGroup(compnyRedistrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compnyRedistrionPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(compnyRedistrionPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        supplierRegistrationPanel.setBackground(new java.awt.Color(255, 255, 255));
        supplierRegistrationPanel.setMinimumSize(new java.awt.Dimension(576, 240));
        supplierRegistrationPanel.setPreferredSize(new java.awt.Dimension(576, 240));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Supplier Registration");

        jButton4.setBackground(new java.awt.Color(209, 217, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(61, 92, 255));
        jButton4.setText("Select Company");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setMaximumSize(new java.awt.Dimension(221, 41));
        jButton4.setMinimumSize(new java.awt.Dimension(221, 41));
        jButton4.setPreferredSize(new java.awt.Dimension(221, 41));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(135, 137, 153));
        jLabel6.setText("Supplier Name");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField2.setMinimumSize(new java.awt.Dimension(228, 48));
        jTextField2.setPreferredSize(new java.awt.Dimension(228, 48));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(135, 137, 153));
        jLabel7.setText("Company");

        jTextField3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField3.setPreferredSize(new java.awt.Dimension(228, 48));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(135, 137, 153));
        jLabel8.setText("Mobile");

        jTextField4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(228, 48));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(209, 217, 255));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(61, 92, 255));
        jButton5.setText("Add");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setMinimumSize(new java.awt.Dimension(107, 41));
        jButton5.setPreferredSize(new java.awt.Dimension(107, 41));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(209, 217, 255));
        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(61, 92, 255));
        jButton6.setText("Update");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setPreferredSize(new java.awt.Dimension(107, 41));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 210, 123));
        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(118, 78, 1));
        jButton7.setText("Clear");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setPreferredSize(new java.awt.Dimension(107, 41));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout supplierRegistrationPanelLayout = new javax.swing.GroupLayout(supplierRegistrationPanel);
        supplierRegistrationPanel.setLayout(supplierRegistrationPanelLayout);
        supplierRegistrationPanelLayout.setHorizontalGroup(
            supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierRegistrationPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(supplierRegistrationPanelLayout.createSequentialGroup()
                        .addGroup(supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierRegistrationPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        supplierRegistrationPanelLayout.setVerticalGroup(
            supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplierRegistrationPanelLayout.createSequentialGroup()
                .addGroup(supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(supplierRegistrationPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(supplierRegistrationPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(supplierRegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(575, 35));
        jPanel8.setLayout(new java.awt.CardLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("   Supplier (12)");
        jPanel8.add(jLabel10, "card2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 70));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("   Companies (12)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Company Name", "Hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Supplier Name", "Mobile", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(compnyRedistrionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierRegistrationPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplierRegistrationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compnyRedistrionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateCompany();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createCompany();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        loadCompanyTable();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        resetCompany();
        loadCompanyTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        openSelectCompany();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        createSupplier();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        updateSupplier();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        resetsSupplier();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        loadSupplierTable();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        loadSupplierTable();
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
        if (evt.getClickCount()>=1) {
            int row = jTable1.getSelectedRow();
            
            setCompanyFields(String.valueOf(jTable1.getValueAt(row,2)), String.valueOf(jTable1.getValueAt(row,2)));
            
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
      if (evt.getClickCount()>=1) {
            int row = jTable2.getSelectedRow();
            
            setSuppliertFields(String.valueOf(jTable2.getValueAt(row,1)), String.valueOf(jTable2.getValueAt(row,2)), String.valueOf(jTable2.getValueAt(row,3)));
            
        }
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel compnyRedistrionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel supplierRegistrationPanel;
    // End of variables declaration//GEN-END:variables
}
