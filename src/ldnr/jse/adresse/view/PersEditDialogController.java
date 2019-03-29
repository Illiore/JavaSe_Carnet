package ldnr.jse.adresse.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ldnr.jse.adresse.model.Person;

/**
 * Fenetre d'édition d'une personne physique
 *
 * @author Bastien
 */
public class PersEditDialogController {

    @FXML
    private TextField champNom;
    @FXML
    private TextField champPrenom;
    @FXML
    private TextField champAdresse;
    @FXML
    private TextField champCodePostal;
    @FXML
    private TextField champVille;
    @FXML
    private TextField champTelP;
    @FXML
    private TextField champTelF;
    @FXML
    private TextField champEmail;
    @FXML
    private TextField champCommercial;
    


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initialise le controlle, dès que le fxml a été chargé
     * 
     */
    @FXML
    private void initialize() {
    }

    /**
     * Définit le stage de cette fenetre
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Définit la personne éditée dans cette fenetre
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        champNom.setText(person.getNom());
        champPrenom.setText(person.getPrenom());
        champAdresse.setText(person.getAdresse());
        champCodePostal.setText(Integer.toString(person.getCodePostal()));
        champVille.setText(person.getVille());
        champTelP.setText(person.getVille());
        champTelF.setText(person.getVille());
        champEmail.setText(person.getVille());
        champCommercial.setText(person.getVille());
        
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setStreet(streetField.getText());
            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            person.setCity(cityField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Entrées incorrectes");
            alert.setHeaderText("Merci de corriger les champs erronés");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}