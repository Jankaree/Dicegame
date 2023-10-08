package com.martin.test;

import com.martin.dicegame.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    public void myTest3(){
        Dice testDice = new Dice(6);

        assertEquals(testDice.sides, 6);
    }

}