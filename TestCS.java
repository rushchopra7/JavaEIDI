package tests;

import org.junit.jupiter.api.Test;
import pgdp.math.ControlStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCS {
    @Test
    void testingSumOfDigits() {
        assertEquals(-1, ControlStructures.sumOfDigits(-5), "sumOfDigits should return -1 for negative inputs!");
    }
}
