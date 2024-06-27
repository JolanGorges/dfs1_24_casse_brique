package models;

import application.Fenetre;

import java.awt.*;

public class Balle extends Sprite{

    protected int vitesseX = 10;
    protected int vitesseY = 10;
    protected int diametre = 50;

    public Balle(int x, int y, Color couleur, int diametre) {
        super(x, y , couleur);
        this.diametre = diametre;
    }

    public Balle(int x, int y, int vitesseX, int vitesseY) {
        super(x,y,Color.RED);
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
    }

    public Balle(int x, int y) {
        super(x,y,Color.RED);
        this.vitesseX = 5;
        this.vitesseY = 5;
    }

    public void deplacement(boolean collision) {

        if(x > Fenetre.LARGEUR - diametre || x < 0) {
            vitesseX = - vitesseX;
        }

        if(y > Fenetre.HAUTEUR - diametre || y < 0) {
            vitesseY = - vitesseY;
        }

        if(collision) {
            vitesseY = -vitesseY;
        }

        x += vitesseX;
        y += vitesseY;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);

    }

    public boolean verifieSiBallePerdue() {
        return y + diametre >= Fenetre.HAUTEUR;
    }

    public boolean collision(Rectangle r) {
        return (x < r.x + r.largeur && x + diametre > r.x && y < r.y + r.hauteur && y + diametre > r.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }
}
