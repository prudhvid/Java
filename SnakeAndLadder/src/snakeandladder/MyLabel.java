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
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Prudhvi
 */
public class MyLabel extends JLabel implements ActionListener{
    boolean p1,p2,p3;
    
    Color c1,c2,c3;
    Timer timer;
    int x1,y1;
    
    public MyLabel(String x)
    {
        super(x,SwingConstants.LEADING);
        setFont(getFont().deriveFont(18.0f));
        
        setMinimumSize(new Dimension(50, 60));
        setVisible(true);
        setOpaque(true);
        setBackground(Color.WHITE);
        c1=Color.RED;
        c2=Color.GREEN;
        c3=Color.BLUE;
        timer=new Timer(20, this);
        x1=0;y1=0;
        
        
    }
    public void addPlayer(int i)
    {
        if(i==1)
            p1=true;
        else if(i==2)
            p2=true;
        else
            p3=true;
        repaint();
    }
    public void delPlayer(int i)
    {
        if(i==1)
            p1=false;
        else if(i==2)
            p2=false;
        else
            p3=false;
         repaint();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        int status=1;
        super.paintComponent(g);
        if(p1)
            g.setColor(c1);
        else if(p2)
            g.setColor(c2);
        else if(p3)
            g.setColor(c3);
        else
            status=0;
        if(status==1)
            g.fillOval(30-SettingsPanel.boardDimesion, 30-SettingsPanel.boardDimesion, 30+SettingsPanel.boardDimesion,30+SettingsPanel.boardDimesion );

        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        x1++;
        y1++;
        repaint();
    }
}
