package model;

import dao.PatientDAO;
import dao.PatientDAO_IF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author joosiika
 */
public class ClientResources implements ClientResources_IF {
    private PatientDAO_IF db;
    private PatientBuilder_IF pBuilder;
    private DiagnoseBuilder_IF dBuilder;
    private PrescriptionBuilder_IF presBuilder;
    private DoubleStringConverter dsc;
    
    private Map<String, Patient> patients;
    
    public ClientResources() {
        this.db = new PatientDAO();
        this.pBuilder = new PatientBuilder();
        this.dBuilder = new DiagnoseBuilder();
        this.presBuilder = new PrescriptionBuilder();
        this.dsc = new DoubleStringConverter();
        this.patients = new HashMap();
        this.db.readPatients().forEach((patient) -> {
            this.patients.put(patient.getSSN(), patient);
        });
    }

    public List<Patient> getPatients() {
        return db.readPatients();
    }
    
    @Override
    public List<String> getPatientDetails(Patient patient) {
        List<String> list = new ArrayList();
        list.add("Sosiaaliturvatunnus: " + patient.getSSN());
        list.add("Etunimi: " + patient.getFirstName());
        list.add("Sukunimi: " + patient.getLastName());
        list.add("Sukupuoli: " + patient.getGender());
        list.add("Pituus: " + dsc.toString(patient.getHeight()) + " cm");
        list.add("Paino: " + dsc.toString(patient.getWeight()) + " kg");
        return list;
    }
    
    @Override
    public List<Diagnose> getPatientDiagnoses(Patient patient) {
        List<Diagnose> diagnoses = this.pBuilder.getPatientDiagnoses(patient);
        diagnoses.forEach(this.dBuilder::buildDiagnose);
        return diagnoses;
    }

    @Override
    public List<Prescription> getPatientPrescriptions(Patient patient) {
        List<Prescription> prescriptions = this.pBuilder.getPatientPrescriptions(patient);
        prescriptions.forEach(this.presBuilder::buildPrescription);
        return prescriptions;
    }

    @Override
    public List<String> getEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmployeeDetails(String SSN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
