/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.awt.CardLayout;
import java.awt.List;
import java.util.Iterator;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Prudhvi
 */
public class PlaySpace extends javax.swing.JPanel {

    public static int randomNumber;
    
    int totalplayers;
    int playerturn=1;
    int []playerpos={1,1,1,1};
    int []steps={0,0,0,0};
    boolean start=false;
    public PlaySpace() {
        initComponents();
        totalplayers=StartPanel.numberOfPlayers;
        StatusBar.setText("Press start to begin");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NumberDisplay = new javax.swing.JLabel();
        StartButton = new javax.swing.JButton();
        PlayerNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatusBar = new javax.swing.JTextArea();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/snakeandladder/images.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        NumberDisplay.setBackground(new java.awt.Color(204, 204, 255));
        NumberDisplay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        NumberDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberDisplay.setOpaque(true);

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        PlayerNameLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 51));

        StatusBar.setEditable(false);
        StatusBar.setBackground(new java.awt.Color(255, 204, 102));
        StatusBar.setColumns(20);
        StatusBar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        StatusBar.setLineWrap(true);
        StatusBar.setRows(5);
        jScrollPane1.setViewportView(StatusBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NumberDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(StartButton)
                                            .addGap(10, 10, 10)))))
                            .addComponent(PlayerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(PlayerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(NumberDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(StartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       if(start==true)
       {
            StatusBar.setText("");
            steps[playerturn]++;

            Random num=new Random();
            randomNumber=num.nextInt(5)+1;
            NumberDisplay.setText(randomNumber+"");

            int pos=playerpos[playerturn];
            
            if(randomNumber +pos<=SettingsPanel.boardDimesion*SettingsPanel.boardDimesion){ 
                
                 PlayPanel.labelArray[pos].delPlayer(playerturn);
                 (PlayPanel.labelArray[pos+randomNumber]).addPlayer(playerturn);
                 playerpos[playerturn]=pos+randomNumber;


                //check if new position has ladder or snake or is actually a win
                int new_pos=randomNumber+pos;
                int dimension=SettingsPanel.boardDimesion*SettingsPanel.boardDimesion;
                if(new_pos==dimension)
                {
                    start=false;
                    JOptionPane.showMessageDialog(this, StartPanel.Player[playerturn]+"has won!! \n Total steps taken ="+steps[playerturn]);
                    check_and_add();
                }
                else{
                    for(int i=0;i<4;i++)
                    {
                        if(SettingsPanel.ladders[i][0]==new_pos)
                        {
                            StatusBar.setText(" You are up through the ladder at Positon"+new_pos);
                            PlayPanel.labelArray[new_pos].delPlayer(playerturn);
                            PlayPanel.labelArray[SettingsPanel.ladders[i][1]].addPlayer(playerturn);
                            playerpos[playerturn]=SettingsPanel.ladders[i][1];
                            break;
                        }
                        if(SettingsPanel.snakes[i][0]==new_pos)
                        {
                            StatusBar.setText("You are down by snake at"+new_pos);
                            PlayPanel.labelArray[new_pos].delPlayer(playerturn);
                            PlayPanel.labelArray[SettingsPanel.snakes[i][1]].addPlayer(playerturn);
                            playerpos[playerturn]=SettingsPanel.snakes[i][1];
                            break;
                        }
                    }
                }
               
            }
            playerturn=(playerturn)%(totalplayers)+1;
            PlayerNameLabel.setText(StartPanel.Player[playerturn]);
       }

        
        
        
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        start=true;
        StartButton.setVisible(false);
        
        PlayerNameLabel.setText(StartPanel.Player[playerturn]);
        steps[playerturn]++;
        
        
        StatusBar.setText("");
            

            Random num=new Random();
            randomNumber=num.nextInt(5)+1;
            NumberDisplay.setText(randomNumber+"");

            int pos=playerpos[playerturn];
            
            if(randomNumber +pos<=SettingsPanel.boardDimesion*SettingsPanel.boardDimesion){ 
                
                 PlayPanel.labelArray[pos].delPlayer(playerturn);
                 (PlayPanel.labelArray[pos+randomNumber]).addPlayer(playerturn);
                 playerpos[playerturn]=pos+randomNumber;


                //check if new position has ladder or snake or is actually a win
                int new_pos=randomNumber+pos;
                int dimension=SettingsPanel.boardDimesion*SettingsPanel.boardDimesion;
                if(new_pos==dimension)
                {
                    JOptionPane.showMessageDialog(this, StartPanel.Player[playerturn]+"has won!!");

                }
                else{
                    for(int i=0;i<4;i++)
                    {
                        if(SettingsPanel.ladders[i][0]==new_pos)
                        {
                            StatusBar.setText("Congratulations!! You are up through the ladder at Positon"+new_pos);
                            PlayPanel.labelArray[new_pos].delPlayer(playerturn);
                            PlayPanel.labelArray[SettingsPanel.ladders[i][1]].addPlayer(playerturn);
                            playerpos[playerturn]=SettingsPanel.ladders[i][1];
                            break;
                        }
                        if(SettingsPanel.snakes[i][0]==new_pos)
                        {
                            StatusBar.setText("You are down by snake at"+new_pos);
                            PlayPanel.labelArray[new_pos].delPlayer(playerturn);
                            PlayPanel.labelArray[SettingsPanel.snakes[i][1]].addPlayer(playerturn);
                            playerpos[playerturn]=SettingsPanel.snakes[i][1];
                            break;
                        }
                    }
                }
               
            }
            playerturn=(playerturn)%(totalplayers)+1;
            PlayerNameLabel.setText(StartPanel.Player[playerturn]);
    }//GEN-LAST:event_StartButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NumberDisplay;
    private javax.swing.JLabel PlayerNameLabel;
    private javax.swing.JButton StartButton;
    private javax.swing.JTextArea StatusBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void check_and_add() {
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("SnakeAndLadderPU");
        EntityManager em=emf.createEntityManager();
        String name=StartPanel.Player[playerturn];
        em.getTransaction().begin();
        java.util.List list=em.createNamedQuery("Gamers.findByName").setParameter("name", name).getResultList();
        if(list.isEmpty())
        {
            Gamers g=new Gamers(name);
            g.setScore(steps[playerturn]);
            em.persist(g);
        }
        else
        {
            Iterator iter=list.iterator();
            Gamers g=(Gamers) iter.next();
            if(g.getScore()>steps[playerturn])
            {
                JOptionPane.showMessageDialog(this, "COngratulations!!You have beaten your previous high score\n"
                        + "Previous Score is "+g.getScore());
                g.setScore(steps[playerturn]);
                em.persist(g);
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
