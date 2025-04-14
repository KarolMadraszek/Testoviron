package org.example;

public class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if ( obj.getClass() == Tuple.class) {
            if (((Tuple) obj).x == this.x && ((Tuple) obj).y == this.y) return true;
        };
        return false;
    }
}


