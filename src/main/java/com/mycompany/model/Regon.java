package com.mycompany.model;

import java.util.ArrayList;

/**
 * The Regon class provides methods to validate and extract information from
 * REGON numbers.
 *
 * @author jfalkowski
 * @version 3.0
 */
public class Regon {

    /**
     * The array containing the Regon number.
     */
    private ArrayList<Integer> regon = new ArrayList<>();

    /**
     * Constructs a Regon object with the specified REGON number.
     *
     * @param regon The REGON number to be validated and decoded.
     */
    public Regon(ArrayList<Integer> regon) {
        this.regon = regon;
    }

    /**
     * Checks if the provided REGON number is valid.
     *
     * @return true if the REGON is valid, false otherwise.
     */
    public boolean isValid() {
        if ((!(regon.size() == 9)) && !(regon.size() == 14)) {
            return false;
        }

        if (regon.size() == 9) {
            int sum = 8 * regon.get(0)
                    + 9 * regon.get(1)
                    + 2 * regon.get(2)
                    + 3 * regon.get(3)
                    + 4 * regon.get(4)
                    + 5 * regon.get(5)
                    + 6 * regon.get(6)
                    + 7 * regon.get(7);
            sum %= 11;
            if (sum == 10) {
                sum = 0;
            }
            return sum == regon.get(8);
        }

        if (regon.size() == 14) {
            int sum = 2 * regon.get(0)
                    + 4 * regon.get(1)
                    + 8 * regon.get(2)
                    + 5 * regon.get(3)
                    + 0 * regon.get(4)
                    + 9 * regon.get(5)
                    + 7 * regon.get(6)
                    + 3 * regon.get(7)
                    + 6 * regon.get(8)
                    + 1 * regon.get(9)
                    + 2 * regon.get(10)
                    + 4 * regon.get(11)
                    + 8 * regon.get(12);
            sum %= 11;
            if (sum == 10) {
                sum = 0;
            }
            return sum == regon.get(13);
        }

        return false;
    }

    /**
     * Gets the province number from a valid REGON number.
     *
     * @return The province number.
     */
    public int getProvinceNumber() {
        int provinceNumber;
        provinceNumber = 10 * regon.get(0) + regon.get(1);
        return provinceNumber;
    }

    /**
     * Returns the list of REGON numbers stored in this object.
     *
     * @return An ArrayList containing REGON numbers.
     */
    public ArrayList<Integer> getRegon() {
        return regon;
    }

    /**
     * Generates a string representation of the Regon object, including
     * information about the validity of REGON numbers and the province number.
     *
     * @return A string representation of the Regon object.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Regon numbers: ");
        this.getRegon().forEach(string::append);
        string.append(" are valid decoded data.");
        string.append(" Province number: " + this.getProvinceNumber());
        return string.toString();
    }
}
