package junit4;

import org.example.Tuple;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SzachownicaTest {
    @Test
    public void rownaTuple() {
        Tuple tp = new Tuple(3, 4);
        Tuple td = new Tuple (3, 4);
        assertEquals(tp, td);
    }
}
// przypisanie figury do pola działa
//