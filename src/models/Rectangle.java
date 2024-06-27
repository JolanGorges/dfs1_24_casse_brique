package models;

import java.awt.*;

public class Rectangle extends Sprite {
    public int largeur;
    public int hauteur;

    public Rectangle(int x, int y, int largeur, int hauteur, Color couleur) {
        super(x, y, couleur);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(x,y,largeur,hauteur);
    }

    public boolean collision(Rectangle r) {
        return (x < r.x + r.largeur && x + largeur > r.x && y < r.y + r.hauteur && y + hauteur > r.y);
    }
}
