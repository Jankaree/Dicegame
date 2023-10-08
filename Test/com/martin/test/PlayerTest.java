package com.martin.test;

import com.martin.dicegame.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void myTest2(){
        Player testPlayer = new Player("Benny");


        assertNotNull(testPlayer.score);
        assertNotNull(testPlayer.name);
    }

}