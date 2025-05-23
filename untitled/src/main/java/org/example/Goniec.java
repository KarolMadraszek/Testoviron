package org.example;

import java.util.ArrayList;

public class Goniec implements IFigura{
    Szachownica szachownica;
    int posX;
    int posY;

    public Goniec(int posX, int posY, Szachownica szachownica) {
        this.szachownica = szachownica;
        if (posX > szachownica.getN() && posY > szachownica.getN()) throw new java.lang.IllegalArgumentException("Goniec poza mapą.");
        else if( posX == szachownica.getN() || posY == szachownica.getN()) throw new
                java.lang.IllegalArgumentException("Goniec lekko poza mapą. (Pozycje są liczone od 0 do n-1)");
        else if (posX < 0 && posY < 0 ) throw new java.lang.IllegalArgumentException("Goniec na ujemnych polach");
        else if (posX < 0 ) throw new java.lang.IllegalArgumentException("Goniec na ujemnym polu PosX.");
        else if (posY < 0 ) throw new java.lang.IllegalArgumentException("Goniec na ujemnym polu PosY.");
        szachownica.miejsce[posX][posY] = (IFigura) this;
        this.posX = posX;
        this.posY = posY;
    }

    public ArrayList<Tuple<Integer, Integer>> atak() {
        ArrayList<Tuple<Integer, Integer>> Pos = new ArrayList<>();
        int[][] kierunki = { {-1, -1}, {-1, 1}, {1, 1}, {1, -1} };

        for (int[] kierunek : kierunki) {
            int i = this.posX + kierunek[0];
            int j = this.posY + kierunek[1];
            while (i >= 0 && i < szachownica.getN() && j >= 0 && j < szachownica.getN()) {
                if (szachownica.wolneMiejsce(i, j)) {
                    Pos.add(new Tuple<>(i, j));
                } else {
                    break;
                }
                i += kierunek[0];
                j += kierunek[1];
            }
        }
        return Pos;
    }

    public String ruch(int x, int y) {
        //if (x >= szachownica.getN() || y >= szachownica.getN()) throw new java.lang.IllegalArgumentException("Ruch gońca poza mapę");
        System.out.println(this.atak());
        Tuple tp = new Tuple( (Integer) x, (Integer) y);
        if (!this.atak().contains(tp)) throw new java.lang.IllegalArgumentException();
        this.posX = x;
        this.posY = y;
        return String.format("Goniec ruszył się na pole (%d, %d)", posX, posY);
    }

    public String pozycja() {
        return String.format("Goniec na polu (%d, %d)", posX, posY);
    }
}
