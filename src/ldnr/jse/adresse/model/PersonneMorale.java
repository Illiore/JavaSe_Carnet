/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldnr.jse.adresse.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Tian
 */
public class PersonneMorale extends Personne {
    protected final StringProperty fax;
    /**
     * Default constructor.
     * @param nom
     */
    public PersonneMorale(String nom) {
        super(nom);
        this.fax = new SimpleStringProperty("05050505");
    }
    
    public String getFax() {
        return fax.get();
    }

    public void setFax(String fax) {
        this.fax.set(fax);
    }
    
    public StringProperty faxProperty() {
        return fax;
    }
    
}
