package org.example;


import java.util.ArrayList;


public class Goniec implements IFigura{
    Szachownica szachownica;
    int posX;
    int posY;


    public Goniec(int posX, int posY, Szachownica szachownica) {
        this.szachownica = szachownica;
        if (posX >= szachownica.getN() || posY >= szachownica.getN()) throw new java.lang.IllegalArgumentException();
        szachownica.miejsce[posX][posY] = (IFigura) this;
        this.posX = posX;
        this.posY = posY;
    }


    public ArrayList<Tuple<Integer, Integer>> atak() {
        ArrayList<Tuple<Integer, Integer>> Pos = new ArrayList<>();
        for(int i = this.posX, j = this.posY; i >= 0 && j >= 0; i--, j--) {
            // jezeli miejsce nie jest zajete
            if (szachownica.wolneMiejsce(i, j)) {
                Pos.add(new Tuple(i, j));
            }
        }
        for(int i = this.posX, j = this.posY; i >= 0 && j < szachownica.getN(); i--, j++) {
            if (szachownica.wolneMiejsce(i, j)) {
                Pos.add(new Tuple(i, j));
            }
        }
        for(int i = this.posX, j = this.posY; i < szachownica.getN() && j < szachownica.getN(); i++, j++) {
            if (szachownica.wolneMiejsce(i, j)) {
                Pos.add(new Tuple(i, j));
            }
        }
        for(int i = this.posX, j = this.posY; i < szachownica.getN() && j >= 0; i++, j--) {
            if (szachownica.wolneMiejsce(i, j)) {
                Pos.add(new Tuple(i, j));
            }
        }
        System.out.println(Pos);
        return Pos;
    }

    public void ruch(int x, int y) {
        if (x >= szachownica.getN() || y >= szachownica.getN()) throw new java.lang.IllegalArgumentException();
        System.out.println(this.atak());
        Tuple tp = new Tuple( (Integer) x, (Integer) y);
        if (!this.atak().contains(tp)) throw new java.lang.IllegalArgumentException();
        this.posX = x;
        this.posY = y;
    }

    public String pozycja() {
        return String.format("Goniec na polu (%d, %d)", posX, posY);
    }

}
