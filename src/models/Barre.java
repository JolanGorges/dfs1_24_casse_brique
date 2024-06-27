package models;

import application.Fenetre;

import java.awt.*;

public class Barre extends Rectangle {
    public Barre() {
        super(Fenetre.LARGEUR / 2 - 75, Fenetre.HAUTEUR - 100, 150, 20, Color.BLUE);
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
}
