package com.rummikubphase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    @FXML
    public void switchToMenuScene(ActionEvent event) throws IOException {
        initializeScene(event, "start-page.fxml");
    }
    @FXML
    public void switchToChooseOpponentScene(ActionEvent event) throws IOException {
        initializeScene(event, "choose-opponent.fxml");
    }
    @FXML
    public void switchToBoardScene(ActionEvent event) throws IOException{
        initializeScene(event, "game-board-copy.fxml");
    }

            /*public void switchToMakeNewPlayersScene(ActionEvent event) throws IOException{
                initializeScene(event, "make-new-players.fxml");
            }*/


    public void initializeScene(ActionEvent event, String sceneName) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(sceneName));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}


