/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.patient;

import java.util.List;

/**
 * Interface that defines methods for getting info on patients and diagnoses
 * from database 
 * @author Timo Lehtola, Paula Rinta-Harri, Joonas Siikavirta, Johanna Tani
 */
public interface PatientDAO_IF {

    /**
     * Gets patient by social security number
     * @param SSN patient's social security number
     * @return patient object
     */
    public abstract Patient readPatient(String SSN);


    /**
     * Gets a list of all patients
     * @return list of patient objects
     */
    public abstract List<Patient> readPatients();

}
