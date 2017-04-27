/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.Localisation.getInstance;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Timo Lehtola, Paula Rinta-Harri, Joonas Siikavirta, Johanna Tani
 */
public class ApplicationMain extends Application {
    
    Parent root;
    Parent login;
    Localisation local = getInstance();
    ResourceBundle text;
    Scene scene;
    
  //  @FXML
  //  private ChoiceBox<String> languageChoice;
    @FXML
    private ObservableList<String> languageList;
       
    @Override
    public void start(Stage primaryStage) throws Exception {
        local.chooseLanguage("sve");
        text = local.language();
        this.root = FXMLLoader.load(getClass().getResource("MainRoot_1.fxml"), text);
        primaryStage.setTitle(text.getString("appLabel"));
        ChoiceBox languageChoice = new ChoiceBox(FXCollections.observableArrayList(local.getLanguageList()));
        languageChoice.setTooltip(new Tooltip(text.getString("selectLanguage")));
        AnchorPane.setTopAnchor(languageChoice, 2.0);
        AnchorPane.setRightAnchor(languageChoice, 15.0);
        //root.getChildren().add(languageChoice);
        languageChoice.setOnAction((Event e) -> {
                this.local.chooseLanguage((String) languageChoice.getSelectionModel().getSelectedItem());
                text = local.language();
        });     
        scene = new Scene(root);        
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight()-50);
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth()-50);
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void addSidebar() {
        //this.root.getChildren().add(new SideBarGUI());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
    
}
