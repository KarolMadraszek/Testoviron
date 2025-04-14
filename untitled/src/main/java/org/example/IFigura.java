package org.example;

import java.util.ArrayList;

public interface IFigura {
    int posX = -1;
    int posY = -1;
    String ruch(int x, int y);
    default String pozycja() {
        return String.format("%d, %d", posX, posY);
    }
    ArrayList<Tuple<Integer, Integer>> atak();
}
