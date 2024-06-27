package models;

import java.awt.*;

public class Brique extends Rectangle {
    public static final int LARGEUR = 48;
    public static final int HAUTEUR = 20;

    public Brique(int x, int y) {
        super(x, y, LARGEUR, HAUTEUR, Color.orange);
    }
}
