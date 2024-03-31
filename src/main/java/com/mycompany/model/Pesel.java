package com.mycompany.model;

import java.util.ArrayList;

/**
 * The Pesel class provides methods to validate and decode PESEL numbers. It
 * also allows extracting information such as birthdate and gender from a valid
 * PESEL number.
 *
 * @author jfalkowski
 * @version 3.0
 */
public class Pesel {

    /**
     * The array containing the Pesel number.
     */
    private ArrayList<Integer> pesel = new ArrayList<>();

    /**
     * Constructs a Pesel object with the specified PESEL number.
     *
     * @param pesel The PESEL number to be validated and decoded.
     */
    public Pesel(ArrayList<Integer> pesel) {
        this.pesel = pesel;
    }

    /**
     * Checks if the provided PESEL number is valid.
     *
     * @return true if the PESEL is valid, false otherwise.
     */
    public boolean isValid() {
        if (pesel.size() != 11) {
            return false;
        }

        int[] validWeights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (validWeights[i] * pesel.get(i)) % 10;

        }
        sum = 10 - sum % 10;
        return sum == pesel.get(10);
    }

    /**
     * Gets the birth year from a valid PESEL number.
     *
     * @return The birth year.
     */
    public int getBirthYear() {
        int year;
        int month;

        year = 10 * pesel.get(0) + pesel.get(1);
        month = 10 * pesel.get(2) + pesel.get(3);

        if (month > 80 && month < 93) {
            year += 1800;
        } else if (month > 0 && month < 13) {
            year += 1900;
        } else if (month > 20 && month < 33) {
            year += 2000;
        } else if (month > 40 && month < 53) {
            year += 2100;
        } else if (month > 60 && month < 73) {
            year += 2200;
        }

        return year;
    }

    /**
     * Gets the birth month from a valid PESEL number.
     *
     * @return The birth month.
     */
    public int getBirthMonth() {
        int month;

        month = 10 * pesel.get(2) + pesel.get(3);
        if (month > 80 && month < 93) {
            month -= 80;
        } else if (month > 20 && month < 33) {
            month -= 20;
        } else if (month > 40 && month < 53) {
            month -= 40;
        } else if (month > 60 && month < 73) {
            month -= 60;
        }

        return month;
    }

    /**
     * Gets the birthday from a valid PESEL number.
     *
     * @return The birthday.
     */
    public int getBirthDay() {
        int day;

        day = 10 * pesel.get(4) + pesel.get(5);

        return day;
    }

    /**
     * Gets the gender from a valid PESEL number.
     *
     * @return The gender ("Male" or "Female").
     */
    public String getGender() {
        if (pesel.get(9) % 2 == 1) {
            return "Male";
        } else {
            return "Female";
        }

    }

    /**
     * Returns the list of PESEL numbers stored in this object.
     *
     * @return An ArrayList containing PESEL numbers.
     */
    public ArrayList<Integer> getPesel() {
        return pesel;
    }

    /**
     * Generates a string representation of the Pesel object, including
     * information about the validity of PESEL numbers, gender, and birthdate.
     *
     * @return A string representation of the Pesel object.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Pesel numbers: ");
        this.getPesel().forEach(string::append);
        string.append(" are valid decoded data.");
        string.append(" Gender: " + this.getGender());
        string.append(" Birth date: " + this.getBirthDay() + "." + this.getBirthMonth() + "." + this.getBirthYear());
        return string.toString();
    }
}
