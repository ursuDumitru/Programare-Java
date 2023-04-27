package ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {

    @Test
    void isConsecutiveFibbonaci1() {
        PerecheNumere pn = new PerecheNumere(3, 5);
        assertTrue(pn.isConsecutiveFibbonaci());
    }
    @Test
    void isConsecutiveFibbonaci2() {
        PerecheNumere pn = new PerecheNumere(2, 5);
        assertFalse(pn.isConsecutiveFibbonaci());
    }
    @Test
    void isConsecutiveFibbonaci3() {
        PerecheNumere pn = new PerecheNumere(21, 34);
        assertTrue(pn.isConsecutiveFibbonaci());
    }

    @Test
    void lcm1() {
        PerecheNumere pn = new PerecheNumere(5, 2);
        assertEquals(10, pn.lcm());
    }
    @Test
    void lcm2() {
        PerecheNumere pn = new PerecheNumere(100, 42);
        assertTrue(2100 == pn.lcm());
    }
    @Test
    void lcm3() {
        PerecheNumere pn = new PerecheNumere(5, 2);
        assertFalse(1 == pn.lcm());
    }
    @Test
    void sumaCifrelorEgala1() {
        PerecheNumere pn = new PerecheNumere(31, 22);
        assertTrue(pn.sumaCifrelorEgala());
    }
    @Test
    void sumaCifrelorEgala2() {
        PerecheNumere pn = new PerecheNumere(52, 2);
        assertFalse(pn.sumaCifrelorEgala());
    }


    @Test
    void nrCifrePare() {
    }
}