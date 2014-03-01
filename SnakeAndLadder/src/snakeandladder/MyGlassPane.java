/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Prudhvi
 */
//public final class MyGlassPane extends JComponent {
//
//    public MyGlassPane()
//    {
//        
//        super();
//        
//        this.setPreferredSize(new Dimension(600, 600));
//        this.setVisible(true);
//        
////        timer.start();
//        repaint();
//        setBackground(Color.yellow);
//    }
//    
//    @Override
//    protected void paintComponent(Graphics g)
//    {
//        
//        super.paintComponent(g);
//        g.setColor(Color.yellow);
//        g.fillOval(20, 30, 50, 50);
//        System.out.println("wow");
//    }
//    
// 
//   
//}
public class MyGlassPane extends JPanel {

    public MyGlassPane() {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setVisible(true);
        setPreferredSize(new Dimension(500, 500));
    }

    
     @Override
     public void paintComponent(Graphics g) {
//        super.paintComponent(g);
        System.out.println("hahah");
        g.setColor(Color.red);

        g.drawOval(10, 10, getWidth() - 20, getHeight() - 20); 
    }
}