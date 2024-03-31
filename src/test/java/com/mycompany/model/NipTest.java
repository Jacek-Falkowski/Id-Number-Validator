package com.mycompany.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class contains tests for Nip Class
 *
 * @author jfalkowski
 * @version 2.0
 */
class NipTest {
    /**
     * Tests the isValid method of the Nip class with a valid NIP of 10 digits.
     */
    @Test
    void testIsValidNip() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 5, 6, 5, 5, 4, 9, 4, 8));
        Nip nip = new Nip(numbers);
        assertTrue(nip.isValid());
    }

    /**
     * Tests the isValid method of the Nip class with an invalid NIP of 10 digits.
     */
    @Test
    void testIsInvalidNip() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 5, 6, 5, 5, 4, 9, 4, 3));
        Nip nip = new Nip(numbers);
        assertFalse(nip.isValid());
    }

}
