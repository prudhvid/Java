/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Prudhvi
 */
public class SnakeAndLadder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f=new JFrame();
        
        AppletStart ap=new AppletStart();
        ap.init();
//        f.add(ap);
        
        
        
        
        
        
        f.add(ap);
        f.pack();
        f.setPreferredSize(new Dimension(1000, 1000));
        f.setLayout(new FlowLayout());
        f.setLocationByPlatform(true);
        f.setVisible(true);
        
        f.setGlassPane(new MyGlassPane());
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
