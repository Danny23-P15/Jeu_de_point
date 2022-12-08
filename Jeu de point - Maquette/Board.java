package modele;

import java.util.Arrays;

public class Board {
    int[][] matricePoint = new int[15][15];

    public int[][] getMatricePoint() {
        return matricePoint;
    }

    public void setMatricePoint(int[][] matricePoint) {
        this.matricePoint = matricePoint;
    }

    public boolean verif_Point(int x, int y) {
        return (getMatricePoint()[y][x] == 0);
    }

    public void initGame(){
        for (int[] ints : getMatricePoint()) {
            //Initialisena 0 valeur anatin'ilay matrice
            Arrays.fill(ints, 0);
        }
    }

    public Board(){
        initGame();
    }

    public int verif_point(int j , int x, int y) {
        int mandresy = 5;
        //Verification hozizontale
        int i = x+1;
        int count = 0;

        while(i <= this.getMatricePoint()[y].length-1 && this.getMatricePoint()[y][i] == j ){
            count++;
            i++;
        }

        int in = x-1;

        while(in>=0 && this.getMatricePoint()[y][in] == j){
            count++;
            in--;
        }

        if(count+1 >= mandresy) {
            return 1;
        }

        //verification varticale
        int yh = y+1;
        int county = 0;

        while(yh <= this.getMatricePoint().length-1 && this.getMatricePoint()[yh][x] == j ){
            county++;
            yh++;
        }

        int yn = y-1;

        while(yn>=0 && this.getMatricePoint()[yn][x] == j){
            county++;
            yn--;
        }

        if(county+1 >= mandresy) {
            return 2;
        }

        //verification oblique gauche->droite
        int yo = y+1;
        int xo = x+1;
        int counto = 0;

        while(yo <= this.getMatricePoint().length-1 && xo <= this.getMatricePoint()[y].length-1 && this.getMatricePoint()[yo][xo] == j ){
            counto++;
            yo++;
            xo++;
        }

        int yon = y-1;
        int xon = x-1;

        while(yon >= 0 && xon >= 0 && this.getMatricePoint()[yon][xon] == j){
            counto++;
            yon--;
            xon--;
        }

        if(counto+1 >= mandresy) {
            return 3;
        }

        //verification oblique droite->gauche
        int yo1 = y-1;
        int xo1 = x+1;
        int counto1 = 0;

        while(yo1 >= 0 && xo1 <= this.getMatricePoint()[y].length-1 && this.getMatricePoint()[yo1][xo1] == j ){
            counto1++;
            yo1--;
            xo1++;
        }

        int yon1 = y+1;
        int xon1 = x-1;

        while(yon1 <= this.getMatricePoint().length-1 && xon1 >=0 && this.getMatricePoint()[yon1][xon1] == j){
            counto1++;
            yon1++;
            xon1--;
        }

        if(counto1+1 >= mandresy) {
            return 4;
        }

        return 0;
    }

    public int[][] trace(int j,int x,int y){
        int[][]rep = new int[2][2];

        if(this.verif_point(j,x,y)==1){
            int nb_point=0;

            int xh = x+1;
            while(xh<this.getMatricePoint().length && nb_point<5 && this.getMatricePoint()[y][xh]==j){
                nb_point++;
                xh++;
            }
            if(nb_point==0){
                rep[0][0]=y;
                rep[0][1]=x;
            }else {
                rep[0][0]=y;
                rep[0][1]=xh-1;
            }

            xh = x-1;
            int i=0;
            while(xh>=0 && nb_point<5 && this.getMatricePoint()[y][xh]==j){
                nb_point++;
                xh--;
                i++;
            }
            if(i==0){
                rep[1][0]=y;
                rep[1][1]=x;
            }else {
                rep[1][0]=y;
                rep[1][1]=xh+1;
            }
        }

        if(this.verif_point(j,x,y)==2){
            int nb_point=0;

            int yh = y+1;
            while(yh<this.getMatricePoint().length && nb_point<5 && this.getMatricePoint()[yh][x]==j){
                nb_point++;
                yh++;
            }
            if(nb_point==0){
                rep[0][0]=y;
                rep[0][1]=x;
            }else {
                rep[0][0]=yh-1;
                rep[0][1]=x;
            }

            yh = y-1;
            int i=0;
            while(yh>=0 && nb_point<5 && this.getMatricePoint()[yh][x]==j){
                nb_point++;
                yh--;
                i++;
            }
            if(i==0){
                rep[1][0]=y;
                rep[1][1]=x;
            }else {
                rep[1][0]=yh+1;
                rep[1][1]=x;
            }
        }

        if(this.verif_point(j,x,y)==3){
            int nb_point=0;

            int yo = y+1;
            int xo = x+1;

            while(yo<this.getMatricePoint().length && xo<this.getMatricePoint().length && nb_point<5 && this.getMatricePoint()[yo][xo]==j){
                nb_point++;
                yo++;
                xo++;
            }
            if(nb_point==0){
                rep[0][0]=y;
                rep[0][1]=x;
            }else {
                rep[0][0]=yo-1;
                rep[0][1]=xo-1;
            }

            yo = y-1;
            xo = x-1;
            int i=0;
            while(yo>=0 && xo>=0 && nb_point<5 && this.getMatricePoint()[yo][xo]==j){
                nb_point++;
                yo--;
                xo--;
                i++;
            }
            if(i==0){
                rep[1][0]=y;
                rep[1][1]=x;
            }else {
                rep[1][0]=yo+1;
                rep[1][1]=xo+1;
            }
        }

        if(this.verif_point(j,x,y)==4){
            int nb_point=0;

            int yo = y+1;
            int xo = x-1;

            while(yo<this.getMatricePoint().length && xo>=0 && nb_point<5 && this.getMatricePoint()[yo][xo]==j){
                nb_point++;
                yo++;
                xo--;
            }
            if(nb_point==0){
                rep[0][0]=y;
                rep[0][1]=x;
            }else {
                rep[0][0]=yo-1;
                rep[0][1]=xo+1;
            }

            yo = y-1;
            xo = x+1;
            int i=0;
            while(yo<this.getMatricePoint().length && xo>=0 && nb_point<5 && this.getMatricePoint()[yo][xo]==j){
                nb_point++;
                yo--;
                xo++;
                i++;
            }
            if(i==0){
                rep[1][0]=y;
                rep[1][1]=x;
            }else {
                rep[1][0]=yo+1;
                rep[1][1]=xo-1;
            }
        }

        return  rep;
    }
}