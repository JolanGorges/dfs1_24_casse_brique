package models;

import application.Fenetre;

import java.awt.*;

public class Barre extends Sprite{

    protected int largeur;
    protected int hauteur;

    public Barre(int x, int y, int largeur, int hauteur, Color couleur) {
        super(x, y, couleur);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public Barre() {
        super(Fenetre.LARGEUR / 2 - 75, Fenetre.HAUTEUR - 100, Color.BLUE);
        this.largeur = 150;
        this.hauteur = 20;
    }

    public void deplacement(int direction) {
        if(direction == 1) {
            if(x > 0) {
                x -= 10;
            }
        } else if(direction == 2) {
            if(x < Fenetre.LARGEUR - largeur) {
                x += 10;
            }
        }
    }
    public Rectangle getRectangle() {
        return new Rectangle(x, y, largeur, hauteur);
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(x,y,largeur,hauteur);
    }
}
