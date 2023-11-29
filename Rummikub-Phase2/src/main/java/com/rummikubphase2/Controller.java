package com.rummikubphase2;

import com.rummikubphase2.Model.GameApp;
import com.rummikubphase2.Model.Tile;
import com.rummikubphase2.FXCommands;
import com.rummikubphase2.FXTile;

import java.util.ArrayList;

public class Controller {
    GameApp gameApp;

    ArrayList<Tile> tiles = new ArrayList<Tile>();

    ArrayList<FXTile> fxTiles;



private void initPlayer(GameApp gameApp){
    tiles = gameApp.getCurPlr().getHand();
    fxTiles = new ArrayList<>(tiles.size());

    for (int i = 0; i < tiles.size(); i++){
        fxTiles.add(new FXTile(tiles.get(i)));
        FXCommands.placeFXTileAsButton(fxTiles.get(i));

    }

}

public void startGame(){
    gameApp = new GameApp();
    initPlayer(gameApp);

}


public void changePlayer(){
    gameApp.nextPlayer();
    initPlayer(gameApp);
}


public void drawTile(){
    Tile tile = gameApp.draw();
    FXTile fxTile = new FXTile(tile);
    FXCommands.placeFXTileAsButton(fxTile);
}


}