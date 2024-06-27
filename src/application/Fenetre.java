package application;

import models.Balle;
import models.Barre;
import models.Brique;
import models.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Fenetre extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 700;


    protected boolean toucheEspace = false;

    ArrayList<Balle> listeBalles = new ArrayList<>();
    ArrayList<Sprite> listeSprites = new ArrayList<>();
    Barre barre;

    Fenetre()  throws InterruptedException {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0, 0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR + fenetre.getInsets().left + fenetre.getInsets().right, HAUTEUR + fenetre.getInsets().top + fenetre.getInsets().bottom);

        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);


        Container panneau = fenetre.getContentPane();
        panneau.add(this);

        fenetre.setVisible(true);
        this.createBufferStrategy(2);



        this.demarrer();
    }

    public void demarrer() throws InterruptedException {

        barre = new Barre();
        listeSprites.add(barre);

        Balle balle = new Balle(100, 200 , Color.GREEN, 30);

        ArrayList<Brique> briques = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                briques.add(new Brique(j * (Brique.LARGEUR + 2), i * (Brique.HAUTEUR + 2)));
            }
        }

        listeBalles.add(balle);
        listeSprites.add(balle);
        listeSprites.addAll(briques);

        while(true) {
            for (Balle b : listeBalles) {
                if(b.verifieSiBallePerdue()) {
                    listeBalles.remove(b);
                    listeSprites.remove(b);
                    break;
                }
            }

            if(listeBalles.isEmpty()) {
                afficherMessageDeFin("Tu as perdu !");
                return;
            }

            if (briques.isEmpty()) {
                afficherMessageDeFin("Tu as gagné !");
                return;
            }

            Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0,LARGEUR,HAUTEUR);

            //----- app -----
            for(Balle b : listeBalles) {
                if(b.collision(barre)) {
                    b.deplacement(true);
                } else {
                    b.deplacement(false);
                }

                for(Brique br : briques) {
                    if(b.collision(br)) {
                        b.deplacement(true);
                        briques.remove(br);
                        listeSprites.remove(br);
                        break;
                    }
                }
            }

            for(Sprite s : listeSprites) {
                s.dessiner(dessin);
            }

            if(toucheEspace) {
                listeBalles.add( new Balle(200, 400 , Color.BLUE, 50));
            }
            //---------------

            dessin.dispose();
            this.getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public void afficherMessageDeFin(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            toucheEspace = true;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            barre.deplacement(1);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            barre.deplacement(2);
        }
    }

    @Override
    public void  keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            toucheEspace = false;
        }
    }
}
