package aufgaben.auf01_junit_sv01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Aufgabe1_sv01Test {

    @Test
    void testQuersumme() {
        assertEquals(0, Aufgabe1_sv01.quersumme(0));
        assertEquals(1, Aufgabe1_sv01.quersumme(1));
        assertEquals(6, Aufgabe1_sv01.quersumme(123));
        assertEquals(28, Aufgabe1_sv01.quersumme(1234567));
    }
}