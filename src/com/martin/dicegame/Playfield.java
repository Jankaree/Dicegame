package com.martin.dicegame;

public class Playfield {
    public int players;
    public int dices;

    public Player[] playerlist;
    public Dice[] dicelist;

    public int turns;

    public Playfield(Player[] players, Dice[] dice, int turns){
        this.playerlist = players;
        this.dicelist = dice;
        this.turns = turns;
    }


    public static Player[] returnPlayers(Playfield playfield){

        return playfield.playerlist;
    }

    public static Dice[] returnDice(Playfield playfield){

        return playfield.dicelist;
    }

}

