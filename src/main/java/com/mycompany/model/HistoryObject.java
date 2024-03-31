package com.mycompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 * HistoryObject class represents an entity that stores information related to
 * historical operations. It is used for persisting and retrieving data in the
 * database.
 *
 * @author jfalkowski
 * @version 5.0
 */
@Entity
public class HistoryObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inputNumber;
    private String decodedData;

    /**
     * Default constructor for creating a HistoryObject.
     */
    public HistoryObject() {
    }

    /**
     * Parameterized constructor for creating a HistoryObject with specified
     * inputNumber and decodedData.
     *
     * @param inputNumber the input number of validation
     * @param decodedData the decoded data resulting from the validation
     */
    public HistoryObject(String inputNumber, String decodedData) {
        this.inputNumber = inputNumber;
        this.decodedData = decodedData;
    }

    /**
     * Gets the id of the HistoryObject.
     *
     * @return the id of the history object
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the HistoryObject.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the input number of the HistoryObject.
     *
     * @return the input number
     */
    public String getInputNumber() {
        return inputNumber;
    }

    /**
     * Sets the input number of the HistoryObject.
     *
     * @param inputNumber the input number to set
     */
    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    /**
     * Gets the decoded data from validation.
     *
     * @return the decoded data
     */
    public String getDecodedData() {
        return decodedData;
    }

    /**
     * Sets the decoded data from validation.
     *
     * @param decodedData the decoded data
     */
    public void setDecodedData(String decodedData) {
        this.decodedData = decodedData;
    }

    /**
     * Returns a string representation of HistoryObject.
     *
     * @return a string representation of history object
     */
    @Override
    public String toString() {
        return "OperationHistory{"
                + "id=" + id
                + ", inputNumber='" + inputNumber + '\''
                + ", decodedData='" + decodedData + '\''
                + '}';
    }

}
