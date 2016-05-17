/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.media.Time;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author jhon
 */
public class runGame extends javax.swing.JFrame implements ActionListener {

    Timer tanim = new Timer(50, this);
    Timer r = new Timer(3000, this);
    Timer r1 = new Timer(3000, this);
    Timer r2 = new Timer(3000, this), r3 = new Timer(3000, this);
    Timer r4 = new Timer(6000, this);
    Timer shufll = new Timer(25, this);
    AudioClip df[] = new AudioClip[3];
    Icon temp;
    int ran;
    int track1 = 0, track = 0, count = 4, ii = 0, x = 0, y = 0, xx = 0, yy = 0, intx = 0, inty = 0, xxx = 0, yyy = 0;
    String soundurl[] = {"2.wav", "6.wav", "5.wav"};
    JLabel enm[] = new JLabel[5];
    Card emp = new Card(3);
    Card cit = new Card(2);
    Card sla = new Card(1);
    boolean move = false, isrunning = false, draw = false, kill = false, nor = false, card1 = false, card2 = false, card3 = false, card4 = false, card5 = false;
    TrackGame Traker = new TrackGame();
    int i = 1;
    String tempnum="";

    /**
     * Creates new form runGame
     */
    public runGame() {
        System.out.println("Creating.....");
        initComponents();
         loadSounds();
//   setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setBackground(java.awt.Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //jLabel1.setIcon(emp.getimage());
        initGame();
        addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    run1 t = new run1();
                    t.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    t.setVisible(true);
                    df[0].stop();
                    df[1].stop();
                    df[2].stop();
                    setVisible(false);

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
//Traker.setemp(nor);

    }

    public void loadSounds()//loading souds into the AudioClip array
    {
        for (int i = 0; i <= 2; i++) {
            URL ur = runGame.class.getResource(soundurl[i]);
            //Loading all the sound clips
            df[i] = Applet.newAudioClip(ur);
        }
    System.out.println("Loading the Sounds");
    }

    public void initGame() {
     

        if (Traker.getlevel() == 13) {
            endGame();
        }
        if (track != 6) {
            jLabel2.setIcon(null);
            jLabel1.setIcon(null);
            jLabel3.setIcon(null);
            jLabel4.setIcon(null);
            jLabel5.setIcon(null);
            jLabel8.setIcon(null);
            jLabel9.setIcon(null);
            jLabel10.setIcon(null);
            jLabel11.setIcon(null);
            jLabel12.setIcon(null);
            jLabel6.setIcon(null);
            jLabel7.setIcon(null);
            jLabel13.setIcon(null);
            jLabel14.setIcon(null);

            df[0].play();
            shufllrun();
        }
        if (!shufll.isRunning()) {
            Traker.setlevel(i);
            if (Traker.levelemp()) {
                jLabel1.setIcon(emp.getimage());
            }
            if (!Traker.levelemp()) {
                jLabel1.setIcon(sla.getimage());
            }
            track1 = 0;
            Traker.settrack(track1);
            track = 0;
            jLabel2.setIcon(cit.getimage());
            jLabel3.setIcon(cit.getimage());
            jLabel4.setIcon(cit.getimage());
            jLabel5.setIcon(cit.getimage());
            jLabel8.setIcon(new ImageIcon("images\\3.png"));
            jLabel9.setIcon(new ImageIcon("images\\3.png"));
            jLabel10.setIcon(new ImageIcon("images\\3.png"));
            jLabel11.setIcon(new ImageIcon("images\\3.png"));
            jLabel12.setIcon(new ImageIcon("images\\3.png"));
            jLabel6.setIcon(null);
            jLabel7.setIcon(null);
            jLabel13.setIcon(null);
            jLabel14.setIcon(null);
            jLabel18.setIcon(new ImageIcon("images\\17.png"));

            enm[3] = jLabel8;
            enm[1] = jLabel9;
            enm[4] = jLabel10;
            enm[0] = jLabel11;
            enm[2] = jLabel12;
            card1 = false;
            card2 = false;
            card3 = false;
            card4 = false;
            r1.setInitialDelay(3000);
            r.setInitialDelay(3000);
            r2.setInitialDelay(3000);
            r3.setInitialDelay(3000);
            nor = false;
            kill = false;
            i++;
            ii = 0;
            draw = false;
            x = 0;
            y = 0;
            xx = 0;
            xxx = 0;
            yy = 0;
            yyy = 0;
            intx = 0;
            inty = 0;
            count = 4;
            tempnum="";
            ScoreView.setText(tempnum+Traker.getplayer2score());
            tempnum="";
            RoundView.setText(tempnum+Traker.getlevel());
        
        }
   System.out.println("Starting The Game");
    }

    public void shufllrun() {
System.out.println("Shuflling The Cards");
        draw = true;

        inty = jLabel6.getY();
        intx = jLabel6.getX();
        yyy = 35;
        xx = 35;
        jLabel18.setIcon(new ImageIcon("images\\17.png"));
        shufll.start();
    }

    public void paint(Graphics g) {
        super.paintComponents(g);
        if (draw) {
            Image em = new ImageIcon("images\\3.png").getImage();
            g.drawImage(em, intx, inty + x, this);
            g.drawImage(em, intx, inty + y, this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ScoreView = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        RoundView = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(750, 730));
        setMinimumSize(new java.awt.Dimension(750, 730));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(750, 730));
        getContentPane().setLayout(null);

        jLabel1.setPreferredSize(new java.awt.Dimension(100, 129));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(67, 561, 100, 129);

        jLabel2.setPreferredSize(new java.awt.Dimension(100, 129));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(173, 561, 100, 129);

        jLabel3.setPreferredSize(new java.awt.Dimension(100, 129));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(279, 561, 100, 129);

        jLabel4.setPreferredSize(new java.awt.Dimension(100, 129));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(385, 561, 100, 129);

        jLabel5.setPreferredSize(new java.awt.Dimension(100, 129));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(491, 561, 100, 129);

        jLabel6.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(291, 344, 100, 129);

        jLabel7.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(291, 197, 100, 129);

        jLabel8.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(56, 0, 100, 129);

        jLabel9.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(162, 0, 100, 129);

        jLabel10.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(268, 0, 100, 129);

        jLabel11.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel11);
        jLabel11.setBounds(374, 0, 100, 129);

        jLabel12.setPreferredSize(new java.awt.Dimension(100, 129));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(480, 0, 100, 129);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 120, 242, 430);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));

        jLabel21.setFont(new java.awt.Font("Telephasic BRK", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("SCORE");
        jPanel3.add(jLabel21);

        ScoreView.setFont(new java.awt.Font("Telephasic BRK", 1, 14)); // NOI18N
        ScoreView.setForeground(new java.awt.Color(255, 255, 255));
        ScoreView.setText("0");
        ScoreView.setPreferredSize(new java.awt.Dimension(41, 15));
        jPanel3.add(ScoreView);

        jLabel19.setFont(new java.awt.Font("Technique BRK", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Round");
        jPanel3.add(jLabel19);

        RoundView.setFont(new java.awt.Font("Telephasic BRK", 1, 14)); // NOI18N
        RoundView.setForeground(new java.awt.Color(255, 255, 255));
        RoundView.setText("0");
        RoundView.setPreferredSize(new java.awt.Dimension(41, 15));
        jPanel3.add(RoundView);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(600, 0, 150, 50);

        jPanel2.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Technique BRK", 3, 18)); // NOI18N
        jLabel14.setText("SCORE:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 11, 86, 19);

        jLabel15.setFont(new java.awt.Font("Telephasic BRK", 3, 18)); // NOI18N
        jLabel15.setText("0.00");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel15);
        jLabel15.setBounds(20, 36, 76, 29);

        jLabel16.setFont(new java.awt.Font("Technique BRK", 3, 18)); // NOI18N
        jLabel16.setText("LEVEL");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 76, 86, 33);

        jLabel17.setFont(new java.awt.Font("Telephasic BRK", 3, 18)); // NOI18N
        jLabel17.setText("1");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.setPreferredSize(new java.awt.Dimension(46, 22));
        jPanel2.add(jLabel17);
        jLabel17.setBounds(22, 115, 74, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(749, 484, 0, 0);

        jLabel18.setText("jLabel18");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 0, 750, 760);

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (!isrunning) {
            jLabel6.setIcon(new ImageIcon("images\\3.png"));

            jLabel1.setIcon(null);
            card5 = true;
            kill = true;
            r.start();
            isrunning = true;
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (!isrunning) {
            jLabel6.setIcon(new ImageIcon("images\\3.png"));
            card1 = true;

            jLabel2.setIcon(null);
            nor = true;
            r.start();
            isrunning = true;
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (!isrunning) {
            jLabel6.setIcon(new ImageIcon("images\\3.png"));
            card2 = true;

            jLabel3.setIcon(null);
            nor = true;
            r.start();
            isrunning = true;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        if (!isrunning) {
            jLabel4.setIcon(null);
            jLabel6.setIcon(new ImageIcon("images\\3.png"));
            card3 = true;
            nor = true;
            r.start();
            isrunning = true;
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (!isrunning) {
            jLabel6.setIcon(new ImageIcon("images\\3.png"));
            card4 = true;

            jLabel5.setIcon(null);
            nor = true;
            r.start();
            isrunning = true;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    //}move=false;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shufll) {
            if (y == 350 || y == -300) {
                track++;
                inty = jLabel6.getY();
                intx = jLabel6.getX();
                x = 0;
                y = 0;
            }

            if (track == 6) {
                shufll.stop();
                df[0].stop();
                initGame();

            }
            x -= xx;
            x += xxx;
            y -= yy;
            y += yyy;
            repaint();

        }

        if (e.getSource() == r) {

            enm[ii].setIcon(null);
            ii++;
            jLabel7.setIcon(new ImageIcon("images\\3.png"));
            r2.start();
            r.stop();
        }
        if (e.getSource() == r2) {
            pickCard();
            if (kill) {
                if (Traker.levelemp()) {
                    jLabel6.setIcon(emp.getimage());
                }
                if (!Traker.levelemp()) {
                    jLabel6.setIcon(sla.getimage());
                }
            }
            if (nor) {
                jLabel6.setIcon(cit.getimage());
            }
            r2.stop();
        }
        if (e.getSource() == r1) {
            jLabel7.setIcon(null);
            jLabel6.setIcon(null);
            jLabel13.setIcon(null);
            jLabel14.setIcon(null);
            r1.stop();
            count--;
            isrunning = false;
            nor = false;
            kill = false;
        }
        if (e.getSource() == r3) {
            r4.start();
            r3.stop();
        }
        if (e.getSource() == r4) {
            initGame();
            nor = false;
            kill = false;
            r4.stop();
            isrunning = false;

        }
    }

    public void pickCard() {
        track1++;
        Traker.settrack(track1);
        System.out.println("Picking a Card "+Traker.getplayer1score());
        if (card1 && card2 && card3 && card4 && card5) {
            ran = 2;
        } if(Traker.gettrack()==1){
        if(Traker.levelemp())
            ran=1;
        if(!Traker.levelemp())
            ran=1;
        }
            
        ChikeGame();
    }

    public void ChikeGame() {
        System.out.println("Cheaking Game");
        System.out.println("Trake number"+ " "+Traker.gettrack());
        if (Traker.levelemp()) {
            if (ran == 2) {
                jLabel7.setIcon(sla.getimage());
                if (kill) {
                    jLabel13.setIcon(new ImageIcon("images\\6.png"));
                    df[1].play();
                    Traker.setplayer1score(10, ran);
                    //jLabel14.setIcon(new ImageIcon("images\\6.png"));
                    r3.start();

                }
                if (nor) {
                    jLabel13.setIcon(new ImageIcon("images\\5.png"));

                    df[2].play();
                    Traker.setplayer2score(10, ran);
//jLabel14.setIcon(new ImageIcon("images\\5.png"));
                    r3.start();
                }
            }
            if (ran == 0 || ran == 1 || ran == 3 || ran == 4) {
                jLabel7.setIcon(cit.getimage());
                if (kill) {
                    jLabel13.setIcon(new ImageIcon("images\\5.png"));
                    Traker.setplayer2score(10, ran);

                    df[2].play();
//jLabel14.setIcon(new ImageIcon("images\\5.png"));
                    r3.start();
                }
                if (nor) {
                    r1.start();
                }

            }
        }
        if (!Traker.levelemp()) {

            if (ran == 2) {
                jLabel7.setIcon(emp.getimage());
                if (kill) {
                    jLabel13.setIcon(new ImageIcon("images\\5.png"));

                    df[2].play();
                    Traker.setplayer2score(10, ran);
                    //jLabel14.setIcon(new ImageIcon("images\\5.png"));
                    r3.start();

                }
                if (nor) {
                    jLabel13.setIcon(new ImageIcon("images\\6.png"));
                    df[1].play();
                    Traker.setplayer1score(10, ran);
                    //jLabel14.setIcon(new ImageIcon("images\\6.png"));
                    r3.start();
                }
            }
            if (ran == 0 || ran == 1 || ran == 3 || ran == 4) {
                jLabel7.setIcon(cit.getimage());
                if (kill) {
                    jLabel13.setIcon(new ImageIcon("images\\6.png"));
                    df[1].play();
                    Traker.setplayer1score(10, ran);
//jLabel14.setIcon(new ImageIcon("images\\6.png"));
                    r3.start();
                }
                if (nor) {
                    r1.start();
                }

            }
        }
    }

    public void endGame() {
        System.out.println("Ending Game");
        jLabel1.setIcon(null);
        jLabel2.setIcon(null);
        jLabel3.setIcon(null);
        jLabel4.setIcon(null);
        jLabel5.setIcon(null);
        jLabel8.setIcon(null);
        jLabel9.setIcon(null);
        jLabel10.setIcon(null);
        jLabel11.setIcon(null);
        jLabel12.setIcon(null);
        jLabel6.setIcon(null);
        jLabel7.setIcon(null);
        jLabel13.setIcon(null);
        jLabel14.setIcon(null);

        if (Traker.getplayer1score() < Traker.getplayer2score()) {

        }
        JOptionPane.showMessageDialog(null, "PLAYER1 SCORE              PLAYER2 SCORE\n" + "                   " + Traker.getplayer1score() + "                                           " + Traker.getplayer2score());

        i = 1;

        Traker.setplayer1score(0, 0);
        Traker.setplayer2score(0, 0);

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(runGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(runGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(runGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(runGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new runGame().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RoundView;
    private javax.swing.JLabel ScoreView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
