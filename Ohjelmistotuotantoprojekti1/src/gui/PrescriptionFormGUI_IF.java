/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import model.Diagnose;
import model.Prescription;

/**
 *
 * @author joosiika
 */
public interface PrescriptionFormGUI_IF {

    /**
     *
     * @return
     */
    public abstract Button getCancelButton();

    /**
     *
     * @return
     */
    public abstract Button getSaveButton();

    /**
     *
     * @return
     */
    public abstract ChoiceBox<Diagnose> getDiagnoseSelector();

    /**
     *
     * @return
     */
    public abstract Text getPatientField();

    /**
     *
     * @return
     */
    public abstract Prescription getPrescription();

    /**
     *
     * @param diagnose
     */
    public abstract void setDiagnose(Diagnose diagnose);

    /**
     *
     */
    public abstract void setNullDoseMessage();

    /**
     *
     */
    public abstract void setInsuffucientDoseMessage();

    /**
     *
     */
    public abstract void setOptimalDoseMessage();

    /**
     *
     */
    public abstract void setOverOptimalDoseMessage();

    /**
     *
     */
    public abstract void setRiskLimitDoseMessage();

    /**
     *
     */
    public abstract void setOverdoseMessage();

    /**
     *
     */
    public abstract void setCumulativeOverdoseMessage();
    public abstract void setIsAllergicMessage(List<String> allergens);
    public abstract void markUpdate();
}
