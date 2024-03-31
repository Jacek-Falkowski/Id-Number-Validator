package com.mycompany.model;

import java.util.ArrayList;

/**
 * The Validator class handles various types of identification numbers,
 * including Regon, Nip, and Pesel. It provides methods to validate and process
 * these numbers.
 *
 * @author jfalkowski
 * @version 3.0
 */
public class Validator {

    /**
     * The array containing the data of the id number.
     */
    private final ArrayList<Integer> number2 = new ArrayList<>();

    /**
     * Enumeration representing the types of identification numbers handled by
     * the Validator class.
     *
     * @author jfalkowski
     * @version 3.0
     */
    public enum IdType {

        /**
         * Represents the Regon type.
         */
        REGON,
        /**
         * Represents the Nip type.
         */
        NIP,
        /**
         * Represents the Pesel type.
         */
        PESEL,
        /**
         * Represents an invalid or unknown identification number type.
         */
        INVALID
    }

    /**
     * Constructs a new Validator object with the specified identification
     * number.
     *
     * @param number The identification number to be validated.
     */
    public Validator(String number) {
        String[] number1 = number.split("");
        for (String digit : number1) {
            this.number2.add(Integer.valueOf(digit));
        }
    }

    /**
     * Gets the type of identification number based on its length.
     *
     * @return The IdType representing the type of identification number.
     */
    public IdType getIdType() {
        if ((number2.size() == 9) || (number2.size() == 14)) {
            return IdType.REGON;
        } else if (number2.size() == 10) {
            return IdType.NIP;
        } else if (number2.size() == 11) {
            return IdType.PESEL;
        } else {
            return IdType.INVALID;
        }
    }

    /**
     * Handles the identification number based on its format.
     *
     * @return An object representing the decoded information of the
     * identification number.
     * @throws ValidatorException if the number format is invalid.
     */
    public Object numberHandler() throws ValidatorException {
        Object result;
        switch (getIdType()) {
            case REGON:
                result = handleRegon();
                break;
            case NIP:
                result = handleNip();
                break;
            case PESEL:
                result = handlePesel();
                break;
            default:
                throw new ValidatorException("Invalid number format");
        }
        return result;
    }

    /**
     * Handles a Regon number. Creates a new Regon object and prints its data if
     * it's valid. Otherwise, it prints that the Regon is not valid.
     */
    private Regon handleRegon() throws ValidatorException {
        Regon regon = new Regon(number2);
        if (regon.isValid()) {
            return regon;
        } else {
            throw new ValidatorException("Regon is not valid");
        }
    }

    /**
     * Handles a Nip number. Creates a new Nip object and prints its data if
     * it's valid. Otherwise, it prints that the Nip is not valid.
     */
    private Nip handleNip() throws ValidatorException {
        Nip nip = new Nip(number2);
        if (nip.isValid()) {
            return nip;
        } else {
            throw new ValidatorException("Nip is not valid");

        }
    }

    /**
     * Handles a Pesel number. Creates a new Pesel object and prints its data if
     * it's valid. Otherwise, it prints that the Pesel is not valid.
     */
    private Pesel handlePesel() throws ValidatorException {
        Pesel pesel = new Pesel(number2);
        if (pesel.isValid()) {
            return pesel;
        } else {
            throw new ValidatorException("Pesel is not valid");
        }
    }
}
