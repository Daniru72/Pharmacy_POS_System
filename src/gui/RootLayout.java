package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



public class RootLayout extends javax.swing.JFrame {

    private static HashMap<String, JButton> buttonMap = new HashMap<>();
    Color defaultButtonColor, defaultTextColor;
    private static boolean open = false;
    private int accessEmploye;

    public RootLayout() {
        initComponents();
//         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        defaultTextColor = jButton9.getForeground();
        mainLayout.setOpaque(false);
        loadSidebarButtonMap();

        runClock();

    }


    
    public void setAccess(int accessEmploye) {
        this.accessEmploye = accessEmploye;
        if (accessEmploye == 2) {
            changeUI(new Invoice());
            changeBtnTheam(2);
           
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            jButton8.setEnabled(false);
            jButton9.setEnabled(false);
        } else {
            changeUI(new Invoice());
            changeBtnTheam(2);
        }

    }

    private void loadSidebarButtonMap() {

        
        buttonMap.put("btn2", jButton2);
        buttonMap.put("btn3", jButton3);
        buttonMap.put("btn4", jButton4);
        buttonMap.put("btn5", jButton5);
        buttonMap.put("btn6", jButton6);
        buttonMap.put("btn7", jButton7);
        buttonMap.put("btn8", jButton8);
        buttonMap.put("btn9", jButton9);
    }

     void changeBtnTheam(int button) {

       
        if (accessEmploye == 1) {

            for (int i = 2; i < 10; i++) {

                String key = "btn" + i;
                if (i == button) {
                   
                    buttonMap.get(key).setBackground(new Color(209, 217, 255));
                    buttonMap.get(key).setForeground(new Color(61, 92, 255));
                    buttonMap.get(key).setIcon(new ImageIcon("src/resources/" + i + i + ".png"));
   
              

                } else {
                    buttonMap.get(key).setIcon(new ImageIcon("src/resources/" + i + ".png"));

                    buttonMap.get(key).setBackground(defaultButtonColor);
                    buttonMap.get(key).setForeground(defaultTextColor);
                }
               

            }
         
        } else {

            jButton2.setBackground(new Color(209, 217, 255));
            jButton2.setForeground(new Color(61, 92, 255));
            jButton2.setIcon(new ImageIcon("src/resources/22.png"));
        }
        

    }

    private void runClock() {
        Thread thred1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        jLabel2.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));
                        Thread.sleep(1000);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thred1.start();
    }

    private void changeUI(JPanel panel) {

        children.removeAll();
        children.add(panel);
        SwingUtilities.updateComponentTreeUI(children);
    }

    private void navigation() {

        if (!open) {

            Thread t = new Thread(
                    () -> {
                        for (int i = 200; i >= 80; i -= 15) {

//                            menubtn.setLocation(new Point(10, 10));
                            leftPanel.setPreferredSize(new Dimension(i, leftPanel.getHeight())); //set Width and Hight
                            SwingUtilities.updateComponentTreeUI(leftPanel);  //reload jPanel

                            try {
                                Thread.sleep(10);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            open = true;
            t.start();
        } else {

            Thread t = new Thread(
                    () -> {
                        for (int i = 80; i <= 290; i += 15) {
                            leftPanel.setPreferredSize(new Dimension(i, leftPanel.getHeight())); //set Width and Hight
                            SwingUtilities.updateComponentTreeUI(leftPanel);  //reload jPanel

                            try {
                                Thread.sleep(10);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

            open = false;
            t.start();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        menubtn = new javax.swing.JButton();
        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mainLayout = new javax.swing.JPanel();
        children = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1400, 900));
        getContentPane().setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(229, 231, 255));
        mainPanel.setForeground(new java.awt.Color(153, 153, 153));

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setMaximumSize(new java.awt.Dimension(290, 32767));
        leftPanel.setMinimumSize(new java.awt.Dimension(290, 0));
        leftPanel.setPreferredSize(new java.awt.Dimension(290, 900));
        leftPanel.setVerifyInputWhenFocusTarget(false);

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 600));
        jPanel4.setMinimumSize(new java.awt.Dimension(132, 600));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(9, 1, 0, 15));

        jButton2.setBackground(new java.awt.Color(209, 217, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(61, 92, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/22.png"))); // NOI18N
        jButton2.setText("Invoice");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setIconTextGap(15);
        jButton2.setMargin(new java.awt.Insets(2, 15, 2, 2));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(158, 162, 183));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/3.png"))); // NOI18N
        jButton3.setText("GRN");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHideActionText(true);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setIconTextGap(28);
        jButton3.setMargin(new java.awt.Insets(2, 18, 3, 14));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(158, 162, 183));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/4.png"))); // NOI18N
        jButton4.setText("Stock");
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setIconTextGap(35);
        jButton4.setMargin(new java.awt.Insets(2, 20, 3, 14));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(158, 162, 183));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/5.png"))); // NOI18N
        jButton5.setText("Customer");
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setIconTextGap(25);
        jButton5.setInheritsPopupMenu(true);
        jButton5.setMargin(new java.awt.Insets(2, 20, 3, 14));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);

        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(158, 162, 183));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/6.png"))); // NOI18N
        jButton6.setText("Employee");
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setIconTextGap(23);
        jButton6.setMargin(new java.awt.Insets(2, 20, 3, 14));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);

        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(158, 162, 183));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/7.png"))); // NOI18N
        jButton7.setText("Cumpany & Supplier");
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setIconTextGap(25);
        jButton7.setMargin(new java.awt.Insets(2, 20, 3, 14));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);

        jButton8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(158, 162, 183));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/8.png"))); // NOI18N
        jButton8.setText("GRN History");
        jButton8.setBorderPainted(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setIconTextGap(25);
        jButton8.setMargin(new java.awt.Insets(2, 18, 3, 14));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);

        jButton9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(158, 162, 183));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/9.png"))); // NOI18N
        jButton9.setText("Invoice History");
        jButton9.setBorderPainted(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusable(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(25);
        jButton9.setMargin(new java.awt.Insets(2, 25, 3, 14));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9);

        menubtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu.png"))); // NOI18N
        menubtn.setBorder(null);
        menubtn.setBorderPainted(false);
        menubtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menubtn.setHideActionText(true);
        menubtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menubtn.setIconTextGap(0);
        menubtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        menubtn.setMinimumSize(new java.awt.Dimension(0, 0));
        menubtn.setOpaque(true);
        menubtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menubtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menubtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setMaximumSize(new java.awt.Dimension(70, 32767));
        topPanel.setMinimumSize(new java.awt.Dimension(70, 100));
        topPanel.setPreferredSize(new java.awt.Dimension(70, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("2024-05-20 1:50:50 PM");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mainLayout.setBackground(new java.awt.Color(204, 153, 255));
        mainLayout.setOpaque(false);

        children.setBackground(new java.awt.Color(153, 255, 255));
        children.setOpaque(false);
        children.setPreferredSize(new java.awt.Dimension(1086, 812));
        children.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mainLayoutLayout = new javax.swing.GroupLayout(mainLayout);
        mainLayout.setLayout(mainLayoutLayout);
        mainLayoutLayout.setHorizontalGroup(
            mainLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(children, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainLayoutLayout.setVerticalGroup(
            mainLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(children, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        getContentPane().add(mainPanel, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        changeUI(new Customer());
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        changeUI(new CompanyHasSupplier());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        changeUI(new Invoice());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        changeUI(new Grn());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        changeUI(new Stock());

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        changeUI(new Employee());

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        changeUI(new GrnHsitory());

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        changeUI(new InvoieHistory());

    }//GEN-LAST:event_jButton9ActionPerformed

    private void menubtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtnActionPerformed

        navigation();

    }//GEN-LAST:event_menubtnActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        changeBtnTheam(2);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        changeBtnTheam(3);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        changeBtnTheam(4);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       changeBtnTheam(5);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        changeBtnTheam(6);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        changeBtnTheam(7);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        changeBtnTheam(8);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        changeBtnTheam(9);
    }//GEN-LAST:event_jButton9MouseClicked

    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RootLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel children;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainLayout;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton menubtn;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
