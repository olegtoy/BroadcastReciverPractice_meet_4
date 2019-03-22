package com.practice.olegtojgildin.broadcastreciverpractice_meet_4;

/**
 * Created by olegtojgildin on 22/03/2019.
 */

class StateManager {
    private static StateManager sInstance;
    private State mState;

    private StateManager() {
        mState = State.A;
    }

    State getState() {
        return mState;
    }

    void updateState() {
        mState = mState.next();
    }

    static {
        sInstance = new StateManager();
    }

    static StateManager getInstance() {
        return sInstance;
    }
}