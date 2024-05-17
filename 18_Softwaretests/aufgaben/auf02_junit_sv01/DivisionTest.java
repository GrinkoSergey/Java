package aufgaben.auf02_junit_sv01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    private Division division;

    @BeforeEach
    public void vorbereitung() {
        division = new Division();
    }

    @Test
    public void testDividiereZahlen() {
        assertThrows(IllegalArgumentException.class, () -> division.dividiereZahlen(7, 0));

        assertEquals(2.5, division.dividiereZahlen(5.0, 2), 0.0);
        assertEquals(0, division.dividiereZahlen(0, 2), 0.0);
        assertEquals(3.3, division.dividiereZahlen(9.9, 3), 0.3000000000000003);
        assertEquals(-5, division.dividiereZahlen(-15, 3), 0.0);
    }


}