/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javafxgestioninscription.controleur;

import com.example.javafxgestioninscription.HelloApplication;
import com.example.javafxgestioninscription.modele.GestionSql;
import com.example.javafxgestioninscription.modele.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Philippe
 */
public class FenFXML_ConfirmationInscriptionControleur implements Initializable
{
    @FXML
    TextField txtNom, txtSession, txtDate, txtNbInscrits, txtNbPlaces;
    
    Session maSession;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        txtNom.setText(HelloApplication.getMonClientSelectionne().getNom());
        txtDate.setText(String.valueOf(HelloApplication.getMaSessionSelectionnee().getDate_debut()));
        txtSession.setText(HelloApplication.getMaSessionSelectionnee().getLibFormation());
        txtNbInscrits.setText(String.valueOf(HelloApplication.getMaSessionSelectionnee().getNb_inscrits()));
        txtNbPlaces.setText(String.valueOf(HelloApplication.getMaSessionSelectionnee().getNb_places()));
    }
    
    @FXML
    public void handleInscription()
    {
        GestionSql.insereInscription(HelloApplication.getMonClientSelectionne().getId(), HelloApplication.getMaSessionSelectionnee().getId());
        //Affichage d'une boite de dialogue de confirmation
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("INSERTION REUSSIE");
        al.setHeaderText("une insertion et deux maj effectuées");
        al.setContentText("table insertion, session_formation et plan_formation mises à jour");
        al.showAndWait();
        // récupération du stage courant pour fermeture
        Stage stage = (Stage) txtNom.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void handleAnnulation()
    {
        // récupération du stage courant pour fermeture
        Stage stage = (Stage) txtNom.getScene().getWindow();
        stage.close();
    }
}
