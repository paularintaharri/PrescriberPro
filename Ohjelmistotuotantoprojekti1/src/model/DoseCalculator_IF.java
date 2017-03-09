package model;

/**
 *
 * @author joosiika
 * 
 * Drug dosage calculator
 */
public interface DoseCalculator_IF {
    public abstract double getOptimalDose(Patient patient, Drug drug);
    public abstract double getMaxDose(Patient patient, Drug drug);
}
