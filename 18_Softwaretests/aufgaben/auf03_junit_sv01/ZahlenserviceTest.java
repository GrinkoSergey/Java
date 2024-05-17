package aufgaben.auf03_junit_sv01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenserviceTest {

    private Zahlenservice service;
    private List<Integer> zahlen = new ArrayList<>();

    @BeforeEach
    void vorbereitung() {
        service = new Zahlenservice(
            zahlen = Arrays.asList(5,5,5,6,3,7,8,44,2,3,4)
        );
    }

    @Test
    void testFindeZahl() {
        List<Integer> erg = service.findeZahl(5);
        assertEquals(3, erg.size());
        assertEquals(5, erg.get(0));

        for(Integer i : erg) {
            assertEquals(5, i);
        }
    }
}