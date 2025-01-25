/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Rashan
 */
public class Dashbord extends javax.swing.JPanel {

    public Dashbord() {
        initComponents();
        lineBar1.changeColor("#4300B1", "#4300B1");
        lineBar2.changeColor("#CA0000", "#CA0000");
        lineBar3.changeColor("#005809", "#005809");
        menu1.changeColor("#CC00FF", "#460FA0");
        menu2.changeColor("#FFA800", "#FF1818");
        menu3.changeColor("#BDFF00", "#00A611");

        chart();
        chart3();

    }

    public void chart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(50, "Marks", "Sahan");
        dataset.setValue(80, "Marks", "kasun");
        dataset.setValue(68, "Marks", "Nimal");
        dataset.setValue(30, "Marks", "Sadun");
        dataset.setValue(20, "Marks", "Kosala");

        JFreeChart chart1 = ChartFactory.createBarChart("Student Marks", "Student", "Marks", dataset);
        chart1.setBackgroundPaint(new Color(225, 225, 225));
        chart1.getCategoryPlot().setBackgroundPaint(new Color(225, 225, 225));

        ChartPanel chartPanel = new ChartPanel(chart1);

        jPanel5.add(chartPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel5);

    }

    public void chart3() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(50, "Marks", "Sahan");
        dataset.setValue(80, "Marks", "kasun");
        dataset.setValue(68, "Marks", "Nimal");
        dataset.setValue(30, "Marks", "Sadun");
        dataset.setValue(20, "Marks", "Kosala");

        JFreeChart chart1 = ChartFactory.createLineChart("Student Marks", "Student", "Marks", dataset);
        chart1.setBackgroundPaint(new Color(225, 225, 225));
        chart1.getCategoryPlot().setBackgroundPaint(new Color(225, 225, 225));

        ChartPanel chartPanel = new ChartPanel(chart1);

        jPanel7.add(chartPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel7);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu1 = new ThemeComponents.Menu();
        lineBar1 = new ThemeComponents.LineBar();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator31 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        menu2 = new ThemeComponents.Menu();
        lineBar2 = new ThemeComponents.LineBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator33 = new javax.swing.JSeparator();
        jSeparator34 = new javax.swing.JSeparator();
        jSeparator35 = new javax.swing.JSeparator();
        jSeparator36 = new javax.swing.JSeparator();
        jSeparator37 = new javax.swing.JSeparator();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jSeparator40 = new javax.swing.JSeparator();
        jSeparator41 = new javax.swing.JSeparator();
        jSeparator42 = new javax.swing.JSeparator();
        jSeparator43 = new javax.swing.JSeparator();
        jSeparator44 = new javax.swing.JSeparator();
        menu3 = new ThemeComponents.Menu();
        lineBar3 = new ThemeComponents.LineBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator45 = new javax.swing.JSeparator();
        jSeparator46 = new javax.swing.JSeparator();
        jSeparator47 = new javax.swing.JSeparator();
        jSeparator48 = new javax.swing.JSeparator();
        jSeparator49 = new javax.swing.JSeparator();
        jSeparator50 = new javax.swing.JSeparator();
        jSeparator51 = new javax.swing.JSeparator();
        jSeparator52 = new javax.swing.JSeparator();
        jSeparator53 = new javax.swing.JSeparator();
        jSeparator54 = new javax.swing.JSeparator();
        jSeparator55 = new javax.swing.JSeparator();
        jSeparator56 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 102, 255));
        setMinimumSize(new java.awt.Dimension(1086, 812));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1086, 812));

        menu1.setMinimumSize(new java.awt.Dimension(350, 160));
        menu1.setPreferredSize(new java.awt.Dimension(350, 160));

        javax.swing.GroupLayout lineBar1Layout = new javax.swing.GroupLayout(lineBar1);
        lineBar1.setLayout(lineBar1Layout);
        lineBar1Layout.setHorizontalGroup(
            lineBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        lineBar1Layout.setVerticalGroup(
            lineBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Rs 15000.00");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 15, 10, 0));

        jSeparator21.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator21.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator21.setOpaque(true);
        jSeparator21.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator21.setRequestFocusEnabled(false);
        jSeparator21.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator21);

        jSeparator22.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator22.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator22.setOpaque(true);
        jSeparator22.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator22.setRequestFocusEnabled(false);
        jSeparator22.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator22);

        jSeparator23.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator23.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator23.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator23.setOpaque(true);
        jSeparator23.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator23.setRequestFocusEnabled(false);
        jSeparator23.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator23);

        jSeparator24.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator24.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator24.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator24.setOpaque(true);
        jSeparator24.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator24.setRequestFocusEnabled(false);
        jSeparator24.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator24);

        jSeparator25.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator25.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator25.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator25.setOpaque(true);
        jSeparator25.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator25.setRequestFocusEnabled(false);
        jSeparator25.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator25);

        jSeparator26.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator26.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator26.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator26.setOpaque(true);
        jSeparator26.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator26.setRequestFocusEnabled(false);
        jSeparator26.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator26);

        jSeparator27.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator27.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator27.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator27.setOpaque(true);
        jSeparator27.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator27.setRequestFocusEnabled(false);
        jSeparator27.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator27);

        jSeparator28.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator28.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator28.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator28.setOpaque(true);
        jSeparator28.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator28.setRequestFocusEnabled(false);
        jSeparator28.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator28);

        jSeparator29.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator29.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator29.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator29.setOpaque(true);
        jSeparator29.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator29.setRequestFocusEnabled(false);
        jSeparator29.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator29);

        jSeparator30.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator30.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator30.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator30.setOpaque(true);
        jSeparator30.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator30.setRequestFocusEnabled(false);
        jSeparator30.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator30);

        jSeparator31.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator31.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator31.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator31.setOpaque(true);
        jSeparator31.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator31.setRequestFocusEnabled(false);
        jSeparator31.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator31);

        jSeparator32.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator32.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator32.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator32.setOpaque(true);
        jSeparator32.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator32.setRequestFocusEnabled(false);
        jSeparator32.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jSeparator32);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Amount");

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addComponent(lineBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menu1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        menu2.setMinimumSize(new java.awt.Dimension(350, 160));
        menu2.setPreferredSize(new java.awt.Dimension(350, 160));

        javax.swing.GroupLayout lineBar2Layout = new javax.swing.GroupLayout(lineBar2);
        lineBar2.setLayout(lineBar2Layout);
        lineBar2Layout.setHorizontalGroup(
            lineBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        lineBar2Layout.setVerticalGroup(
            lineBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Profit");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Rs 15000.00");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 15, 10, 0));

        jSeparator33.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator33.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator33.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator33.setOpaque(true);
        jSeparator33.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator33.setRequestFocusEnabled(false);
        jSeparator33.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator33);

        jSeparator34.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator34.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator34.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator34.setOpaque(true);
        jSeparator34.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator34.setRequestFocusEnabled(false);
        jSeparator34.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator34);

        jSeparator35.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator35.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator35.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator35.setOpaque(true);
        jSeparator35.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator35.setRequestFocusEnabled(false);
        jSeparator35.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator35);

        jSeparator36.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator36.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator36.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator36.setOpaque(true);
        jSeparator36.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator36.setRequestFocusEnabled(false);
        jSeparator36.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator36);

        jSeparator37.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator37.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator37.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator37.setOpaque(true);
        jSeparator37.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator37.setRequestFocusEnabled(false);
        jSeparator37.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator37);

        jSeparator38.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator38.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator38.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator38.setOpaque(true);
        jSeparator38.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator38.setRequestFocusEnabled(false);
        jSeparator38.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator38);

        jSeparator39.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator39.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator39.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator39.setOpaque(true);
        jSeparator39.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator39.setRequestFocusEnabled(false);
        jSeparator39.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator39);

        jSeparator40.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator40.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator40.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator40.setOpaque(true);
        jSeparator40.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator40.setRequestFocusEnabled(false);
        jSeparator40.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator40);

        jSeparator41.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator41.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator41.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator41.setOpaque(true);
        jSeparator41.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator41.setRequestFocusEnabled(false);
        jSeparator41.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator41);

        jSeparator42.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator42.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator42.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator42.setOpaque(true);
        jSeparator42.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator42.setRequestFocusEnabled(false);
        jSeparator42.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator42);

        jSeparator43.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator43.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator43.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator43.setOpaque(true);
        jSeparator43.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator43.setRequestFocusEnabled(false);
        jSeparator43.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator43);

        jSeparator44.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator44.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator44.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator44.setOpaque(true);
        jSeparator44.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator44.setRequestFocusEnabled(false);
        jSeparator44.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jSeparator44);

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addComponent(lineBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(menu2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(jLabel4))))
                .addGap(36, 36, 36))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        menu3.setMinimumSize(new java.awt.Dimension(350, 160));
        menu3.setName(""); // NOI18N
        menu3.setPreferredSize(new java.awt.Dimension(350, 160));
        menu3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout lineBar3Layout = new javax.swing.GroupLayout(lineBar3);
        lineBar3.setLayout(lineBar3Layout);
        lineBar3Layout.setHorizontalGroup(
            lineBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        lineBar3Layout.setVerticalGroup(
            lineBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Customer Balance ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Rs 15000.00");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 15, 10, 0));

        jSeparator45.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator45.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator45.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator45.setOpaque(true);
        jSeparator45.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator45.setRequestFocusEnabled(false);
        jSeparator45.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator45);

        jSeparator46.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator46.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator46.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator46.setOpaque(true);
        jSeparator46.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator46.setRequestFocusEnabled(false);
        jSeparator46.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator46);

        jSeparator47.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator47.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator47.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator47.setOpaque(true);
        jSeparator47.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator47.setRequestFocusEnabled(false);
        jSeparator47.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator47);

        jSeparator48.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator48.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator48.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator48.setOpaque(true);
        jSeparator48.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator48.setRequestFocusEnabled(false);
        jSeparator48.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator48);

        jSeparator49.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator49.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator49.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator49.setOpaque(true);
        jSeparator49.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator49.setRequestFocusEnabled(false);
        jSeparator49.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator49);

        jSeparator50.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator50.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator50.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator50.setOpaque(true);
        jSeparator50.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator50.setRequestFocusEnabled(false);
        jSeparator50.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator50);

        jSeparator51.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator51.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator51.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator51.setOpaque(true);
        jSeparator51.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator51.setRequestFocusEnabled(false);
        jSeparator51.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator51);

        jSeparator52.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator52.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator52.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator52.setOpaque(true);
        jSeparator52.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator52.setRequestFocusEnabled(false);
        jSeparator52.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator52);

        jSeparator53.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator53.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator53.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator53.setOpaque(true);
        jSeparator53.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator53.setRequestFocusEnabled(false);
        jSeparator53.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator53);

        jSeparator54.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator54.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator54.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator54.setOpaque(true);
        jSeparator54.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator54.setRequestFocusEnabled(false);
        jSeparator54.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator54);

        jSeparator55.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator55.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator55.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator55.setOpaque(true);
        jSeparator55.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator55.setRequestFocusEnabled(false);
        jSeparator55.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator55);

        jSeparator56.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator56.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator56.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator56.setOpaque(true);
        jSeparator56.setPreferredSize(new java.awt.Dimension(50, 5));
        jSeparator56.setRequestFocusEnabled(false);
        jSeparator56.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jSeparator56);

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addComponent(lineBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(menu3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel6))))
                .addGap(15, 15, 15))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(986, 1030, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JSeparator jSeparator52;
    private javax.swing.JSeparator jSeparator53;
    private javax.swing.JSeparator jSeparator54;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private ThemeComponents.LineBar lineBar1;
    private ThemeComponents.LineBar lineBar2;
    private ThemeComponents.LineBar lineBar3;
    private ThemeComponents.Menu menu1;
    private ThemeComponents.Menu menu2;
    private ThemeComponents.Menu menu3;
    // End of variables declaration//GEN-END:variables
}
