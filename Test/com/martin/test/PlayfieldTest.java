package com.martin.test;

import com.martin.dicegame.Dice;
import com.martin.dicegame.Player;
import com.martin.dicegame.Playfield;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayfieldTest {

    @Test
    public void myTest1(){

        Player[] playerList = new Player[0];
        Dice[] dicelist = new Dice[0];

        Playfield playfield = new Playfield(playerList,dicelist, 5 );

        assertNotNull(playfield.playerlist);
        assertNotNull(playfield.dicelist);
        assertNotNull(playfield.turns);


    }

}