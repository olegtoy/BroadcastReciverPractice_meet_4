package com.practice.olegtojgildin.broadcastreciverpractice_meet_4;

/**
 * Created by olegtojgildin on 22/03/2019.
 */

public enum State {
    A, B, C, D, E;

    public State next() {
        return State.values()[(this.ordinal() + 1) % State.values().length];
    }
}