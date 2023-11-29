package com.rummikubphase2;
import com.rummikubphase2.HelperFunctions;
import com.rummikubphase2.Model.Tile;
import com.rummikubphase2.Model.Value;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

public class FXTile extends Button{

    private Tile tile;
    private final Paint COLOR;
    private final Value VALUE;
    private final String STRVALUE;

    public FXTile (Tile tile){
        COLOR = HelperFunctions.colourToPaint(tile.getColour());
        VALUE = tile.getValue();
        STRVALUE = VALUE.getValueSymbol();
    }

    public Paint getColor(){
        return COLOR;
    }

    public Value getValue(){
        return VALUE;
    }

    public String getStringValue(){
        return STRVALUE;
    }



}
