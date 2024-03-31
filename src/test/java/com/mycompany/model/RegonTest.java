package com.mycompany.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class contains tests for Regon Class
 *
 * @author jfalkowski
 * @version 2.0
 */
class RegonTest {

    /**
     * Tests the isValid method of the Regon class with a valid REGON of 9 digits.
     */
    @Test
    void testIsValidRegon9Digits() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5,1,0,6,3,1,2,0,8));
        Regon regon = new Regon(numbers);
        assertTrue(regon.isValid());
    }

    /**
     * Tests the isValid method of the Regon class with a valid REGON of 14 digits.
     */
    @Test
    void testIsValidRegon14Digits() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,1,3,8,7,2,5,2,8,2,3,6,6,4));
        Regon regon = new Regon(numbers);
        assertTrue(regon.isValid());
    }

    /**
     * Tests the isValid method of the Regon class with an invalid REGON of 9 digits.
     */
    @Test
    void testIsInvalidRegon9Digits() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5,1,0,6,3,1,2,0,2));
        Regon regon = new Regon(numbers);
        assertFalse(regon.isValid());
    }

    /**
     * Tests the isValid method of the Regon class with an invalid REGON of 14 digits.
     */
    @Test
    void testIsInvalidRegon14Digits() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,1,3,8,7,2,5,2,8,2,3,6,6,2));
        Regon regon = new Regon(numbers);
        assertFalse(regon.isValid());
    }


}
