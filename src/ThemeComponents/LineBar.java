
package ThemeComponents;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class LineBar extends javax.swing.JPanel {

    private  String topColor="#780206";
    private  String bottomColor="#780206";
    
    public LineBar() {
        initComponents();
        setOpaque(false);
    }
    
    public  void changeColor(String topColor , String bottomColor){
        this.topColor=topColor;
        this.bottomColor=bottomColor;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
         Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode(topColor), 0, getHeight(), Color.decode(bottomColor));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40,40);
        g2.fillRect(getWidth()-15, 0, getWidth(), getHeight());
        super.paintChildren(grphcs); 
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
