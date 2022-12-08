package controlleur;

import modele.Board;

public class Joueur {
    String nom;
    int id_Point;
    protected Board matrice;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_Point() {
        return id_Point;
    }

    public void setId_Point(int id_Point) {
        this.id_Point = id_Point;
    }

    public boolean place_point(int x, int y){
        if(matrice.verif_Point(x,y)) {
            matrice.getMatricePoint()[y][x] = id_Point;
            return true;
        }
        return false;
    }

    public Joueur(String nom, int id_Point,Board m) {
        this.nom = nom;
        this.id_Point = id_Point;
        this.matrice = m;
    }
}