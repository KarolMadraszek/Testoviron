package org.example;

import java.util.ArrayList;

public interface IFigura {
    int posX = -1;
    int posY = -1;
    public abstract void ruch(int x, int y);
    public default String pozycja() {
        return String.format("%d, %d", posX, posY);
    }
    public abstract ArrayList<Tuple<Integer, Integer>> atak();


}
