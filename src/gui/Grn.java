/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import models.MySql;
import SubUI.GrnPymentSectionDialogBox;
import SubUI.SelectSupplier;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utils.CreateID;

public class Grn extends javax.swing.JPanel {

    private LinkedHashMap<String, models.Grn> grnTableHashMap = new LinkedHashMap<>();
    private HashMap<String, String> punitMap = new HashMap<>();

    private int supplierID = 1;
    boolean dataUpdate = false;
    public int amount = 0;
    public int balance = 0;
    public static int total = 0;
    public String grnId;

    public Grn() {
        initComponents();
        loadUnit();
        jButton5.setEnabled(false);
    }

    private void loadUnit() {
        try {
            ResultSet results = MySql.execute("SELECT * FROM `product_unit`");

            Vector<String> v = new Vector<>();
            v.add("Select");
            while (results.next()) {
                punitMap.put(results.getString("unit"), results.getString("id"));
                v.add(results.getString("unit"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }
    }

    private void littleClear() {
        try {

            jTextField3.setText("");
            jTextField4.setText("");
            loadUnit();
            jFormattedTextField3.setText("");
            jFormattedTextField1.setText("");
            jFormattedTextField2.setText("");
            jDateChooser2.setDate(null);
            jDateChooser3.setDate(null);

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }

    }

    private void fullclearFileds() {

        try {
            grnTableHashMap.clear();
            total = 0;
            amount = 0;
            balance = 0;
            loadGrnTable();

            supplierID = 0;
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jFormattedTextField3.setText("");
            jFormattedTextField1.setText("");
            jFormattedTextField2.setText("");
            jDateChooser2.setDate(null);
            jDateChooser3.setDate(null);
        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }

    }

    public boolean filedsValidation() {

        boolean valid = false;
        try {

            String barcode = jTextField3.getText();
            String productName = jTextField4.getText();

            String qty = jFormattedTextField3.getText();
            String buyyingPrice = jFormattedTextField1.getText();
            String sellingPrice = jFormattedTextField2.getText();
            Date mfd = jDateChooser2.getDate();
            Date exp = jDateChooser3.getDate();

             if (barcode.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Enter Barcode ", "Entry Error", JOptionPane.WARNING_MESSAGE);

            } else if (productName.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Enter Product Name ", "Entry Error", JOptionPane.WARNING_MESSAGE);

            
            } else if (qty.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Enter Qty ", "Entry Error", JOptionPane.WARNING_MESSAGE);

            } else if (buyyingPrice.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Buying Price ", "Entry Error", JOptionPane.WARNING_MESSAGE);

            } else if (sellingPrice.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Selling Price ", "Entry Error", JOptionPane.WARNING_MESSAGE);

            } else if (mfd == null) {
                JOptionPane.showMessageDialog(this, "Please Select Manufuctrng Date", "Entry Error", JOptionPane.WARNING_MESSAGE);

            } else if (exp == null) {
                JOptionPane.showMessageDialog(this, "Please Select Expire Date ", "Entry Error", JOptionPane.WARNING_MESSAGE);

            } else {
                valid = true;
            }

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }
        return valid;
    }

    private void loadGrnHashMap() {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            models.Grn grn = new models.Grn();
            grn.setBarcode(jTextField3.getText());
            grn.setproductName(jTextField4.getText());
            grn.setunitPrice(jFormattedTextField1.getText());
            grn.setsellingPrice(jFormattedTextField2.getText());
            grn.setmfDate(dateFormat.format(jDateChooser2.getDate()));
            grn.setexpDate(dateFormat.format(jDateChooser3.getDate()));

            models.Grn found = grnTableHashMap.get(jTextField3.getText());

            grn.setqty(String.valueOf(Integer.parseInt(jFormattedTextField3.getText())));

            if (found != null) {
                if (!dataUpdate) {
                    int newQty = Integer.parseInt(found.getqty()) + Integer.valueOf(jFormattedTextField3.getText());
                    grn.setqty(String.valueOf(newQty));
                    dataUpdate = false;
                }
            }

            grnTableHashMap.put(jTextField3.getText(), grn);

            loadGrnTable();

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }

    }

    private void loadGrnTable() {
        try {
            if (grnTableHashMap.isEmpty()) {
                jButton5.setEnabled(false);

            } else {
                jButton5.setEnabled(true);

            }

            total = 0;

            int count = 0;

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            model.setRowCount(0);
            for (Map.Entry<String, models.Grn> entry : grnTableHashMap.entrySet()) {

                count++;
                entry.getValue().setindex(String.valueOf(count));

                Vector<String> v = new Vector<>();
                v.add(entry.getValue().getindex());
                v.add(entry.getValue().getBarcode());
                v.add(entry.getValue().getproductName());
                v.add(entry.getValue().getunit());
                v.add(entry.getValue().getqty());
                v.add(entry.getValue().getunitPrice());
                v.add(entry.getValue().getsellingPrice());
                v.add(entry.getValue().getmfDate());
                v.add(entry.getValue().getexpDate());
          
                System.out.println(entry.getValue().getunitPrice());  
                    
                

                v.add(String.valueOf(Integer.parseInt(entry.getValue().getqty()) * Integer.parseInt(entry.getValue().getunitPrice())));

                model.addRow(v);

                total += Integer.parseInt(entry.getValue().getqty()) * Integer.parseInt(entry.getValue().getunitPrice());
                jLabel26.setText("Rs " + total + ".00");

            }

            littleClear();

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);
        }

    }

    public void setFiledData(String barcode) {
        try {

            dataUpdate = true;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
            models.Grn grntable = grnTableHashMap.get(barcode);
            jTextField3.setText(grntable.getBarcode());
            jTextField4.setText(grntable.getproductName());
            jFormattedTextField1.setText(grntable.getunitPrice());
            jFormattedTextField3.setText(grntable.getqty());
            jFormattedTextField2.setText(grntable.getsellingPrice());
            jDateChooser2.setDate(dateFormat.parse(grntable.getmfDate()));
            jDateChooser3.setDate(dateFormat.parse(grntable.getexpDate()));

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }

    }

    public void setSupplier(String name, String company, int sId) {

        supplierID = sId;
        jTextField1.setText(name);
        jTextField2.setText(company);
    }

    private void openPymentBox() {
        try {
            if (grnTableHashMap.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please Enter Product to Grn Table", "Warrnig", JOptionPane.WARNING_MESSAGE);
            } else {
                int response = JOptionPane.showConfirmDialog(this, "Do you pay now");

                if (response == 0) {
                    GrnPymentSectionDialogBox payment = new GrnPymentSectionDialogBox(new RootLayout(), true);
                    payment.supID = supplierID;
                    payment.setParent(this);
                    payment.setVisible(true);
                } else if (response == 1) {
                    insertGRN();
                }
            }

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }

    }

    public void insertGRN() {

        try {

            System.out.println("amount :" + amount);
            System.out.println("total :" + total);
            if (amount >= 0) {
                balance = total - amount;
            }

            grnId = "GRN-" + new CreateID().idSecond();

            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//   

            MySql.execute("INSERT INTO `grn` (`grn_id`,`date_time`,`paid_amount`,`balance`,`supplier_id`) "
                    + "VALUES('" + grnId + "','" + dateTime + "','" + amount + "','" + balance + "','" + supplierID + "')");

            for (models.Grn value : grnTableHashMap.values()) {

                boolean run = true;

                ResultSet result;

                result = MySql.execute("SELECT * FROM `product` WHERE   `p_name`='" + value.getproductName() + "'");

                if (result.next()) {
                    run = true;

                } else {
                    run = false;

                    String uid = punitMap.get(value.getunit());

                    MySql.execute("INSERT INTO `product` (`p_name`) VALUES('" + value.getproductName() + "')");
                    result = MySql.execute("SELECT * FROM `product` WHERE   `p_name`='" + value.getproductName() + "'");

                    if (result.first()) {
                        run = true;
                    }

                }

                if (run) {

                    ResultSet result2 = MySql.execute("SELECT * FROM `stock` WHERE `barcode`='" + value.getBarcode() + "'");

                    if (result2.next()) {
                        MySql.execute("UPDATE `stock` SET `qty`=`qty`+'" + Integer.parseInt(value.getqty()) + "'  WHERE `barcode`='" + value.getBarcode() + "'");
                    } else {

                        MySql.execute("INSERT INTO `stock` (`barcode`,`selling_price`,`qty`,`mfg`,`exp`,`product_id`,`status_id`) "
                                + "VALUES('" + value.getBarcode() + "','" + value.getsellingPrice() + "','" + value.getqty() + "','" + value.getmfDate() + "',"
                                + "'" + value.getexpDate() + "','" + result.getString("id") + "','1')");

                    }

                    MySql.execute("INSERT INTO `grn_items` (`grn_grn_id`,`qty`,`buying_price`,`stock_barcode`) VALUES('" + grnId + "','" + value.getqty() + "','" + value.getunitPrice() + "','" + value.getBarcode() + "')");
                }

            }

            JOptionPane.showMessageDialog(this, "GRN successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);

            fullclearFileds();

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "GRN loadUnit", e);

        }

    }

    public void loadPopup(String value, JPopupMenu popupMenu, JTextField textField) {
        popupMenu.setVisible(false);
        popupMenu.removeAll();

        try {

            ResultSet r = MySql.execute("SELECT * FROM `product` WHERE  `p_name` LIKE '%" + value + "%'  ");

            JPanel jpanel = new javax.swing.JPanel();
            jpanel.setLayout(new javax.swing.BoxLayout(jpanel, javax.swing.BoxLayout.PAGE_AXIS));

            while (r.next()) {
                int id = r.getInt("product_unit_id");

                JPanel newjpanel2 = new javax.swing.JPanel();
                JLabel newjlabel = new javax.swing.JLabel();
                newjlabel.setText(r.getString("p_name"));
                newjlabel.setFont(new java.awt.Font("Segoe UI ", 0, 16));
                newjlabel.setPreferredSize(new Dimension(200, 30));

                newjpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {

                        jTextField4.setText(newjlabel.getText());
                        popupMenu.setVisible(false);

                    }

                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        newjpanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));

                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        newjpanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 242, 247), 1, true));

                    }
                });

                newjpanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                newjpanel2.setBackground(new java.awt.Color(255, 255, 255));
                newjpanel2.add(newjlabel);
                newjpanel2.revalidate();
                newjpanel2.repaint();

                jpanel.add(newjpanel2);
                jpanel.revalidate();
                jpanel.repaint();
            }

            popupMenu.add(jpanel);
            popupMenu.show(textField, 0, textField.getHeight());
            textField.grabFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void barcodewithGetProduct() {

        try {

            ResultSet result = MySql.execute("SELECT DISTINCT  `stock`.`barcode` , `product`.`p_name` ,"
                    + "`stock`.`selling_price` ,`grn_items`.`buying_price`,"
                    + "`stock`.`mfg`,`stock`.`exp`"
                    + "FROM `stock` "
                    + "INNER JOIN `product` ON `stock`.`product_id`=`product`.`id`"
                    + "INNER JOIN  `grn_items`  ON  `stock`.`barcode`=`grn_items`.`stock_barcode` WHERE `barcode`='" + jTextField3.getText() + "'");

            if (result.next()) {
                jTextField4.setText(result.getString("p_name"));

                jTextField4.setEditable(false);
                jFormattedTextField1.setText(result.getString("stock.selling_price"));
                jFormattedTextField2.setText(result.getString("grn_items.buying_price"));
                jFormattedTextField1.setEditable(false);
                jFormattedTextField2.setEditable(false);

                jDateChooser2.setDate(result.getDate("stock.mfg"));
                jDateChooser3.setDate(result.getDate("stock.exp"));
                jDateChooser2.setEnabled(false);
                jDateChooser3.setEnabled(false);

            } else {
                jDateChooser2.setEnabled(true);
                jDateChooser3.setEnabled(true);
                jTextField4.setEditable(true);
                jFormattedTextField1.setEditable(true);
                jFormattedTextField2.setEditable(true);
                jFormattedTextField3.setEditable(true);
                jTextField4.setText("");
                jFormattedTextField3.setText("");
                jFormattedTextField1.setText("");
                jFormattedTextField2.setText("");
                jDateChooser2.setDate(null);
                jDateChooser3.setDate(null);
                loadUnit();

            }

        } catch (Exception e) {
            utils.Logger.logger.log(Level.WARNING, "Grn barcodewithGetProduct", e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1086, 812));
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Add GRN :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(830, 300));

        jButton1.setBackground(new java.awt.Color(209, 217, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(61, 92, 255));
        jButton1.setText("Select Supplier");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(230, 50));
        jTextField1.setPreferredSize(new java.awt.Dimension(230, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(135, 137, 153));
        jLabel2.setText("Supplier");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField2.setMinimumSize(new java.awt.Dimension(230, 50));
        jTextField2.setPreferredSize(new java.awt.Dimension(230, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(135, 137, 153));
        jLabel3.setText("Company");

        jTextField3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField3.setMinimumSize(new java.awt.Dimension(230, 50));
        jTextField3.setPreferredSize(new java.awt.Dimension(230, 50));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(135, 137, 153));
        jLabel4.setText("Barcode");

        jTextField4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField4.setMinimumSize(new java.awt.Dimension(230, 50));
        jTextField4.setPreferredSize(new java.awt.Dimension(230, 50));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(135, 137, 153));
        jLabel5.setText("Product Name");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(135, 137, 153));
        jLabel7.setText("Product Qty");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(135, 137, 153));
        jLabel8.setText("Product Unit Buying Price");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(135, 137, 153));
        jLabel9.setText("Product Unit Selling Price");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Rs");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jFormattedTextField1.setMinimumSize(new java.awt.Dimension(126, 50));
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(126, 50));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jFormattedTextField2.setMinimumSize(new java.awt.Dimension(126, 50));
        jFormattedTextField2.setPreferredSize(new java.awt.Dimension(126, 50));
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Rs");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(135, 137, 153));
        jLabel12.setText("Product M.F.D");

        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jDateChooser3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(135, 137, 153));
        jLabel13.setText("Product E.X.P");

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jFormattedTextField3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jFormattedTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField3KeyReleased(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(209, 217, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(61, 92, 255));
        jButton2.setText("Add to GRN Table");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addGap(190, 190, 190))
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addGap(150, 150, 150))
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addComponent(jFormattedTextField3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(192, 192, 192))
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(183, 183, 183))
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(21, 21, 21)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(21, 21, 21))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(50, 50, 50))
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(50, 50, 50))
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextField3))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(3, 1, 0, 50));

        jButton3.setBackground(new java.awt.Color(255, 198, 87));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(118, 78, 1));
        jButton3.setText("Clear Field");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 134, 134));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 0, 0));
        jButton4.setText("Clear Grn Table");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        jButton5.setBackground(new java.awt.Color(122, 255, 135));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 88, 9));
        jButton5.setText("Save GRN");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 40));
        jPanel5.setPreferredSize(new java.awt.Dimension(248, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("GRN Table");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("items ( 0 )");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setText("Total Amount ");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel26.setText("Rs 0.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel14)
                .addGap(44, 44, 44)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.CardLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Barcode", "Product Name", "Unit", "qty", "Unit Price", "Selling Price", "M.F.D", "E.X.P", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel7.add(jScrollPane1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        openPymentBox();


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean v = filedsValidation();
        if (v) {
            loadGrnHashMap();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        littleClear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed

    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jFormattedTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField3KeyReleased


    }//GEN-LAST:event_jFormattedTextField3KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        SelectSupplier suplier = new SelectSupplier(new RootLayout(), true);
        suplier.setGrn(this);
        suplier.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        fullclearFileds();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        loadPopup(jTextField4.getText(), jPopupMenu1, jTextField4);
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        barcodewithGetProduct();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        barcodewithGetProduct();

//        int key = evt.getKeyCode();
//        keyEvents(evt);
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
