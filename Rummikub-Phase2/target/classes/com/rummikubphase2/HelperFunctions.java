package com.rummikubphase2;

import com.rummikubphase2.Model.Colour;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class HelperFunctions {


    public static Paint colourToPaint(Colour colour) {
        return switch (colour) {
            case RED -> Color.CRIMSON;
            case BLUE -> Color.DARKCYAN;
            case BLACK -> Color.BLACK;
            case YELLOW -> Color.ORANGE;
        };
    }
}

