package com.rummikubphase2.Model;

import com.rummikubphase2.FXTile;

import java.util.ArrayList;
import java.util.Random;

public class GameSetup {

    private ArrayList<Tile> tiles;

    private ArrayList<FXTile> fxTiles;


    private ArrayList<Tile> allTiles = new ArrayList<>();

    private ArrayList<FXTile> allFXTiles = new ArrayList<>();

    private ArrayList<Player> players = new ArrayList<>();

    Board board;



    public GameSetup () {
        generateTiles();
        generateBoard();
        for (int i = 0; i < 5; i++) {
            players.add(new Player(generateHand()));
        }
        for (Player player : players) {
            player.sortByColour(player.hand);
        }
    }


    public static void main(String[] args) {
        GameSetup game = new GameSetup();
        game.generateTiles();
        for (int i = 0; i < 4; i++) {
            game.players.add(new Player(game.generateHand()));
        }
        for (Player player : game.players) {
            player.sortByColour(player.hand);
            System.out.println(player.getHand());
        }
        System.out.println(game.getTiles());


        Board board = new Board();
        BoardOverhead overHead = new BoardOverhead(board,game.players);


    }

    private void generateBoard () {
        ArrayList<ArrayList<Tile>> newGameBoard = new ArrayList<>();

        for (int i = 0; i < 13; i++){
            newGameBoard.add(new ArrayList());
            newGameBoard.get(i).add(null);
            newGameBoard.get(i).add(null);
        }
        board = new Board(newGameBoard);
    }

    private ArrayList<Tile> generateHand(){
        Random rand = new Random();
        int size = tiles.size();
        ArrayList<Tile> hand = new ArrayList<>();

        for (int i = 0; i <  14; i++) {
            int index = rand.nextInt(size - i);
            hand.add(tiles.get(index));
            tiles.remove(index);
        }
        return hand;
    }


    private void generateTiles () {
        tiles = new ArrayList<>();

        for (Value v : Value.values()) {
            for (Colour c: Colour.values()){
                tiles.add(new Tile(c,v));
            }
        }

        for (int i = tiles.size()-4; i < tiles.size(); i++){
            tiles.remove(i);
        }


        for (Value v : Value.values()) {
            for (Colour c: Colour.values()){
                tiles.add(new Tile(c,v));
            }
        }

        // Delete 6 Jokers
        for (int i = 0; i < 4; i ++) {
            tiles.remove(tiles.size()-1);
        }
        for (Tile tile : tiles) {
            allTiles.add(tile);
        }


    }


    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public Board getBoard() {
        return board;
    }
    public ArrayList<Tile> getAllTiles() {
        return allTiles;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }
}
