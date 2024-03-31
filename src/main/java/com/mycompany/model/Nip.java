package com.mycompany.model;

import java.util.ArrayList;


/**
 * The Nip class provides methods to validate and extract information from NIP numbers.
 * 
 * @author jfalkowski
 * @version 3.0
 */
public class Nip {
    /**
     * The array containing the Nip number.
     */
    private ArrayList<Integer> nip = new ArrayList<>();
    
    /**
     * Constructs a Nip object with the specified NIP number.
     * 
     * @param nip The NIP number to be validated and decoded.
     */
    public Nip(ArrayList<Integer> nip) {
        this.nip = nip;
    }
    
    /**
     * Checks if the provided NIP number is valid.
     * 
     * @return true if the NIP is valid, false otherwise.
     */
    public boolean isValid() {
        if (nip.size() != 10) {
            return false;
        }
        
        int sum;
        sum = 6 * nip.get(0) +
                5 * nip.get(1) +
                7 * nip.get(2) +
                2 * nip.get(3) +
                3 * nip.get(4) +
                4 * nip.get(5) +
                5 * nip.get(6) +
                6 * nip.get(7) +
                7 * nip.get(8);
        sum %= 11;

        return sum == nip.get(9);
    }
    
    /**
     * Gets the tax office code from a valid NIP number.
     * 
     * @return The tax office code.
     */
    public int getTaxOfficeCode() {
        int taxofficecode = 100 * nip.get(0) + 10 * nip.get(1) + nip.get(2);
        return taxofficecode;
    }

    /**
     * Returns the list of NIP numbers stored in this object.
     *
     * @return An ArrayList containing NIP numbers.
     */
    public ArrayList<Integer> getNip(){
        return nip;
    }

    /**
     * Generates a string of the Nip object, including information
     * about the validity of NIP and the Tax Office code.
     *
     * @return A string representation of the Nip object.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nip numbers: ");
        this.getNip().forEach(string::append);
        string.append(" are valid decoded data.");
        string.append("Tax Office code: ").append(this.getTaxOfficeCode());
        return string.toString();
    }
}
