package org.example;

import java.util.Arrays;

public class Szachownica {
    private int n;
    IFigura[][] miejsce; // Zajęte miejsca
    public Szachownica(int n) {
        if (n>0) this.n = n; else throw new IllegalArgumentException();
        miejsce = new IFigura[n][n];
    }

    public int getN() {
        return this.n;
    }

    public boolean wolneMiejsce(int x, int y){
        if (miejsce[x][y] == null) return true;
        else return false;
        /*for (int i=0; i<this.n; i++) {
            for (int j=0; j<this.n; j++) {
                if (miejsce[x][y]==false) {
                    miejsce[x][y]=true;
                }
            }
        }*/
    }

    public void setMiejsce(IFigura[][] miejsce, int x, int y) {
        if (wolneMiejsce(x, y)) {

            return; // Ustaw figurę na wolnym miejscu
        }

    }
}
