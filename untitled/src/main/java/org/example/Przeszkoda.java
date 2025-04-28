package org.example;

public class Przeszkoda implements IFigura{
    Szachownica szachownica;
    int posX;
    int posY;

    public Przeszkoda(int posX, int posY, Szachownica szachownica) {
        this.szachownica = szachownica;
        if (posX >= szachownica.getN() || posY >= szachownica.getN()) throw new java.lang.IllegalArgumentException();
        if (posX < 0 || posY < 0 ) throw new java.lang.IllegalArgumentException();
        szachownica.miejsce[posX][posY] = (IFigura) this;
        this.posX = posX;
        this.posY = posY;
    }

    public String pozycja() {
        return String.format("Goniec na polu (%d, %d)", posX, posY);
    }
}
