package com.rummikubphase2;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PaneManager {
    private static PaneManager instance;
    @FXML
    private Pane pane;

    private PaneManager() {
        // Private constructor to enforce singleton pattern
    }

    public static PaneManager getInstance() {
        if (instance == null) {
            instance = new PaneManager();
        }
        return instance;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }
}
