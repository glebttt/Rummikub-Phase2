package com.rummikubphase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class FXCommands {

    //@FXML
    //public Pane pane;

    private Controller controller;

    public FXCommands() {
    }

    public FXCommands(Controller controller) {
        this.controller = controller;
    }

    @FXML
    private void startButton() {
        Controller controller = new Controller();
        this.controller = controller;
        this.controller.startGame();
    }

    @FXML
    private void changePlayerButton() {
        controller.changePlayer();
    }

    @FXML
    private void drawButton() {
        controller.drawTile();
    }

    @FXML
    private void handlePaneClick(MouseEvent event, FXTile fxTile) {
        if (fxTile != null) {
            fxTile.setLayoutX(event.getSceneX());
            fxTile.setLayoutY(event.getSceneY());
        }
    }

    @FXML
    private void handleButtonClick(ActionEvent event, FXTile fxTile) {
        Button fxButton = (Button) fxTile;
        fxButton = (Button) event.getSource();
    }

    public static void placeFXTileAsButton(FXTile fxTile) {
        double initialX = 20;
        double initialY = 350;
        Paint buttonColor = fxTile.getColor();
        String buttonText = fxTile.getStringValue();

        while (isButtonOccupyingCoordinates(initialX, initialY)) {
            if (initialX < 270) {
                initialX += 45;
            } else {
                initialX = 20;
                initialY = 395;
            }
        }

        fxTile.setLayoutX(initialX);
        fxTile.setLayoutY(initialY);

        fxTile.setPrefWidth(33);
        fxTile.setPrefHeight(41);

        fxTile.setText(buttonText);
        fxTile.setTextFill(buttonColor);

        Pane pane = PaneManager.getInstance().getPane();
        pane.getChildren().add(fxTile);
    }

    private static boolean isButtonOccupyingCoordinates(double x, double y) {
        Pane pane = PaneManager.getInstance().getPane();
        for (Node node : pane.getChildren()) {
            if (node instanceof FXTile fxTile) {
                System.out.println("Tile at X: " + fxTile.getLayoutX() + ", Y: " + fxTile.getLayoutY());
                if (fxTile.getLayoutX() == x && fxTile.getLayoutY() == y) {
                    return true;
                }
            }
        }
        return false;
    }


}