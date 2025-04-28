package org.example;

public interface IFigura {
    int posX = -1;
    int posY = -1;
    default String pozycja() {
        return String.format("%d, %d", posX, posY);
    }
}
