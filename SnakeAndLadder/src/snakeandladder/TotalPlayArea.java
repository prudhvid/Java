/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.DefaultMenuLayout;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Prudhvi
 */
public class TotalPlayArea extends javax.swing.JPanel {

    
    public TotalPlayArea() {
        initComponents();
        setLayout(new BorderLayout());
        setSize(new Dimension(1000, 1000));
        add(new PlayPanel(),BorderLayout.WEST);
        add(new PlaySpace(),BorderLayout.EAST);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       
        setLayout(new BorderLayout());
        setSize(new Dimension(1000, 1000));
        add(new PlayPanel(),BorderLayout.WEST);
        add(new PlaySpace(),BorderLayout.EAST);
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
