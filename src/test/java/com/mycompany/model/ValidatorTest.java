package com.mycompany.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class contains tests for Validator Class
 *
 * @author jfalkowski
 * @version 2.0
 */
class ValidatorTest {

    /**
     * Tests the numberHandler method of the Validator class with a valid identification number.
     *
     * @throws ValidatorException if an unexpected exception occurs during number handling.
     */
    @Test
    void testNumberHandlerValidFormat() throws ValidatorException {
        Validator validator = new Validator("11387252823664");
        assertNotNull(validator.numberHandler());
    }

    /**
     * Tests the numberHandler method of the Validator class with various invalid id.
     *
     * @param numbers Invalid identification numbers.
     */
    @ParameterizedTest
    @ValueSource(strings = {"133333", "25555", "3", "40"})
    void testNumberHandlerInvalidFormat(String numbers) {
        Validator validator = new Validator(numbers);
        ValidatorException exception = assertThrows(ValidatorException.class, () -> validator.numberHandler());
        assertEquals("Invalid number format", exception.getMessage());
    }

    /**
     * Tests the getIdType method of the Validator class with a valid REGON.
     */
    @Test
    void testGetIdTypeREGON() {
        Validator validator = new Validator("11387252823664");
        assertEquals(Validator.IdType.REGON, validator.getIdType());
    }

    /**
     * Tests the getIdType method of the Validator class with an invalid id.
     */
    @Test
    void testGetIdTypeINVALID() {
        Validator validator = new Validator("2");
        assertEquals(Validator.IdType.INVALID, validator.getIdType());
    }
}
