package com.mycompany.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class contains tests for Pesel Class
 *
 * @author jfalkowski
 * @version 2.0
 */
class PeselTest {
    /**
     * Tests the isValid method of the Pesel class with a valid PESEL of 11 digits.
     */
    @Test
    void testIsValidPesel() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(8,2,0,7,1,1,7,4,9,3,6));
        Pesel pesel = new Pesel(numbers);
        assertTrue(pesel.isValid());
    }

    /**
     * Tests the isValid method of the Pesel class with an invalid PESEL of 11 digits.
     */
    @Test
    void testIsInvalidPesel() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(8,2,0,7,1,1,7,4,9,3,7));
        Pesel pesel = new Pesel(numbers);
        assertFalse(pesel.isValid());
    }



}
