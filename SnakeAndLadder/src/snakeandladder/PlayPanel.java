/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Prudhvi
 */
public class PlayPanel extends javax.swing.JPanel {
    public static MyLabel []labelArray;
    public static int p1,p2,p3;
    Timer timer;
    public PlayPanel() {
        initComponents();
        this.removeAll();
        setMinimumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(700, 600));
        setMaximumSize(new Dimension(1000, 1000));
        labelArray=new MyLabel[200];
        
        this.setVisible(true);
        for(int i=0;i<200;i++)
        { 
           labelArray[i]=new MyLabel(i+"");
            
        }
        setBackground(Color.black);
        paintthem();

        
    }
    
 
    
    
    
    
    
   public void paintthem() 
   {
        this.setVisible(true);
        int rows=SettingsPanel.boardDimesion;
        setLayout(new GridLayout(0,rows,3,3));
        
        int count=rows*rows;
        for(int i=0;i<rows;i++)
        {
            if(i%2==0)
            {
                for(int j=count;j>count-rows;j--)
                    add(labelArray[j]);
                count-=rows;
            }
            else
            {
                
                for(int j=count-rows+1;j<=count;j++){
                    
                    add(labelArray[j]);
                }
                count-=rows;
            }
        }
        for(int i=0;i<4;i++)
        {
            int ls=SettingsPanel.ladders[i][0];
            int le=SettingsPanel.ladders[i][1];
            labelArray[ls].setText("L"+(i+1)+"start");
            labelArray[le].setText("L"+(i+1)+"end");
            int ss=SettingsPanel.snakes[i][0];
            int se=SettingsPanel.snakes[i][1];
            labelArray[ss].setText("S"+(i+1)+"start");
            labelArray[se].setText("S"+(i+1)+"end");
            
        }
        labelArray[1].addPlayer(1);
        labelArray[1].addPlayer(2);
        labelArray[1].addPlayer(3);
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
            .addGap(0, 1151, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
        
        this.setVisible(true);
        int rows=SettingsPanel.boardDimesion;
        setLayout(new GridLayout(0,rows,3,3));
        
        int count=rows*rows;
        for(int i=0;i<rows;i++)
        {
            if(i%2==0)
            {
                for(int j=count;j>count-rows;j--)
                    add(labelArray[j]);
                count-=rows;
            }
            else
            {
                
                for(int j=count-rows+1;j<=count;j++){
                    
                    add(labelArray[j]);
                }
                count-=rows;
            }
        }
//        repaint();
        
    }//GEN-LAST:event_formComponentShown

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
