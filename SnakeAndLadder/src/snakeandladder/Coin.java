/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Prudhvi
 */
public class Coin extends JLabel implements ActionListener{
    Color c1,c2,c3;
    int player;
    int position;
    int x,y,x1,y1,x2,y2;
    Timer timer;
    public Coin(int pI)
    {
        c1=Color.red;
        c2=Color.green;
        c3=Color.BLUE;
        player=pI;
        position=0;
        timer=new Timer(20,  this);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        if(player==1)
            g.setColor(c1);
        else if(player==2)
            g.setColor(c2);
        else
            g.setColor(c3);
        
        g.drawOval(100 , y1, 30, 30);
        g.fillOval(100, y1, 30, 30);
    }
    
    public int getposition(int p)
    {
        return position;
    }
    public void setPosition(int p)
    {
        position=p;
    }
    int max(int x,int y)
    {
        if(x>y)
            return x;
        return y;
    }
    int min(int x,int y)
    {
        return max(x, y);
    }
    public void moveCoin(int pos2)
    {
        x1=getX();
        x2=getY();
//        x2=PlayPanel.labelArray[pos2].getX();
//        y2=PlayPanel.labelArray[pos2].getY();
        System.out.println("x1="+x1+"y1="+y1+"x2="+x2+"y2="+y2);
        if(x1>x2)
        {
            int t=x1;x1=x2;x2=t;
        }
        if(y1>y2)
        {
            int t=y1;y1=y2;y2=t;
        }
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         //To change body of generated methods, choose Tools | Templates.
        System.out.println(x1);
        
        System.out.println(y1);
        if(x1<x2)
            x1++;
        else if(y1<y2)
            y1++;
        else
            timer.stop();
        repaint();
    }
    
    
}
