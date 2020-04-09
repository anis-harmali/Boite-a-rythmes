package com.example.rythmik;

/*
    SOURCE : https://github.com/AndroidAalto/SoundFuse/tree/master/src/org/androidaalto/soundfuse/sequencer
 */

public class Cell {
    private int value = 0;

    public Cell() {
        value = 0;

    }

    public boolean isEnabled() {
        if (value > 0)
            return true;

        return false;
    }


    public void enable() {
        value = 1;
    }


    public void disable() {
        value = 0;
    }


    public void setValue(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
