package junit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import org.example.Goniec;
import org.example.Szachownica;
import org.junit.Test;

public class HamcrestTest {
    @Test
    public void StworzSzachownice(){
        Szachownica sz = new Szachownica(8);
        assertThat(sz.getN(), equalTo(8));
    }

    @Test (expected = IllegalArgumentException.class)
    public void PustaSzachownica(){
        Szachownica sz = new Szachownica(0);
    }

    @Test
    public void stworzGonca() {
        Szachownica sz = new Szachownica(8);
        Goniec goniec = new Goniec(1, 1, sz);
        assertThat(goniec.pozycja(), equalTo("Goniec na polu (1, 1)"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void stworzGoncaPozaMapa() {
        Szachownica sz = new Szachownica(1);
        Goniec goniec = new Goniec(3, 3, sz);
    }


    @Test
    public void ruchGonca() {
        Szachownica sz = new Szachownica(8);
        Goniec goniec = new Goniec(3, 3, sz);
        goniec.ruch(4, 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void zlyruchGonca() {
        Szachownica sz = new Szachownica(8);
        Goniec goniec = new Goniec(3, 3, sz);
        goniec.ruch(2, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ruchGoncaPozaMapa() {
        Szachownica sz = new Szachownica(8);
        Goniec goniec = new Goniec(3, 3, sz);
        goniec.ruch(100, 100);

    }

    // atak
    @Test
    public void AtakGonca() {
        Szachownica sz = new Szachownica(8);
        Goniec goniec = new Goniec(2, 2, sz);
        // n + 1, n + 1 +inf
        // n - 1, n - 1 -inf
        // n - 1, n + 1
        // n + 1, n - 1
        goniec.atak();
        assertThat(goniec.atak().toString(), equalTo("[(1,1), (0,0), (1,3), (0,4), (3,3), (4,4), (5,5), (6,6), (7,7), (3,1), (4,0)]"));
    }


}
