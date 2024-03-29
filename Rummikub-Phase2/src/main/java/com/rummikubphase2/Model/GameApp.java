package com.rummikubphase2.Model;

import java.util.ArrayList;
import java.util.Random;

public class GameApp {

    GameSetup gs;
    BoardOverhead bohe;
    ArrayList<Player> plrs;
    private Player curPlr;
    public ArrayList<Tile> tiles;

    public GameApp() {
        gs = new GameSetup();
        bohe = new BoardOverhead(gs.getBoard(), gs.getPlayers());
        plrs = bohe.getPlayers();
        curPlr = plrs.get(0);
        tiles = gs.getTiles();
    }

    public boolean isWinner(){
        return curPlr.getHand().isEmpty();
    }

    public void nextPlayer () {
        int i = plrs.indexOf(curPlr);
        curPlr = plrs.get((i+1)%(plrs.size()-1));
    }

    public Tile draw(){
        Random rand = new Random();
        int i = rand.nextInt(tiles.size()-1);
        Tile tile = tiles.get(i);
        curPlr.addTile(tile);
        tiles.remove(i);
        return tile;
    }

    public Player getCurPlr() {
        return curPlr;
    }

    public GameSetup getGs() {
        return gs;
    }

    public BoardOverhead getBohe() {
        return bohe;
    }

}
